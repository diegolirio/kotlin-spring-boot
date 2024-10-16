package com.example.azure_storage.controller

import com.azure.core.util.BinaryData
import com.azure.storage.blob.BlobClient
import com.azure.storage.blob.BlobContainerClient
import com.azure.storage.blob.BlobServiceClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/storage")
class AzureBlobStorageController(
        private val blobServiceClient: BlobServiceClient,
        @Value("\${spring.cloud.azure.storage.blob.container-name}") private val containerName: String
    ) {

    private val blobContainerClient: BlobContainerClient by lazy {
        blobServiceClient.createBlobContainerIfNotExists(containerName) ?: blobServiceClient.getBlobContainerClient(
            containerName
        )
    }

    private fun getBlobClient(blobName: String): BlobClient {
        return blobContainerClient.getBlobClient(blobName);
    }

    fun updateBlob(blobName: String, byteArray: ByteArray) =
        getBlobClient(blobName).upload(BinaryData.fromBytes(byteArray), true)

    fun downloadBlob(blobName: String): ByteArray =
        getBlobClient(blobName).downloadContent().toBytes()


    @GetMapping("/u")
    fun upload() {
        val blobName = "testblob"
        updateBlob(blobName, "Here we go".toByteArray(Charsets.UTF_8))
    }

    @PostMapping("/uf")
    fun uploadFile(
        @RequestParam file: MultipartFile,
    ) {
        val blobName = "my-file.pdf"
        updateBlob(blobName, file.inputStream.readBytes())
    }

    @GetMapping("/d")
    fun download(
        @RequestParam("name", defaultValue = "my-file.pdf") name: String,
    ): ResponseEntity<InputStreamResource> {
        return downloadBlob(name)
            .inputStream()
            .let {
                ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"$name\"")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(InputStreamResource(it))
            }
    }

    @GetMapping("/g")
    fun get(
        @RequestParam("name", defaultValue = "my-file.pdf") name: String,
    ): String? {
        return getBlobClient(name).blobUrl
    }

}