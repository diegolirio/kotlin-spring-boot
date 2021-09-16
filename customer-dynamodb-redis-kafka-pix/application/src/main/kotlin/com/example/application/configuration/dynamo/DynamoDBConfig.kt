package com.example.application.configuration.dynamo

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.model.ProjectionType
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput
import com.amazonaws.services.dynamodbv2.util.TableUtils
import com.example.application.customer.out.dataprovider.repository.entity.CustomerEntity
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.reflect.KClass

@Configuration
class DynamoDBConfig {

    @Value("\${amazon.dynamodb.endpoint}")
    private val dynamoDbEndpoint: String? = null

    @Value("\${amazon.aws.accessKey}")
    private val awsAccessKey: String? = null

    @Value("\${amazon.aws.secretKey}")
    private val awsSecretKey: String? = null

    @Value("\${amazon.aws.region}")
    private val awsRegion: String? = null


    @Bean
    fun amazonDynamoDB(): AmazonDynamoDB {

        val region = getAWSRegion()
        val client = AmazonDynamoDBClientBuilder
                .standard()
                .withCredentials(AWSStaticCredentialsProvider(amazonAWSCredentials()))
                .withEndpointConfiguration(
                        AwsClientBuilder
                                .EndpointConfiguration(dynamoDbEndpoint, region.getName())
                )
                .build()
        createTableForEntity(client, CustomerEntity::class)
        return client
    }

    @Bean
    fun dynamoDBMapper() = DynamoDBMapper(amazonDynamoDB())

    private fun amazonAWSCredentials(): AWSCredentials {
        return BasicAWSCredentials(awsAccessKey, awsSecretKey)
    }

    private fun createTableForEntity(amazonDynamoDB: AmazonDynamoDB, entity: KClass<*>) {
        val provisionedThroughput = ProvisionedThroughput(1L, 1L)
        val tableRequest = DynamoDBMapper(amazonDynamoDB)
                .generateCreateTableRequest(entity.java)
                .withProvisionedThroughput(provisionedThroughput)
        tableRequest.globalSecondaryIndexes?.forEach {
            it.provisionedThroughput = provisionedThroughput
            it.projection.withProjectionType(ProjectionType.ALL)
        }
        TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest)
    }

    private fun getAWSRegion(): Regions {
        try {
            return Regions.fromName(this.awsRegion)
        } catch (e: Exception) {
            //log.error("M=getAWSRegion, E=unknown_error, awsRegion={}, msg={}", this.awsRegion, e.message, e)
        }
        return Regions.DEFAULT_REGION
    }
}