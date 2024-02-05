# JPA vs R2DBC

> This POC (Proof of Concept) aims to compare two ways of connecting to  Relacional Database. 
> Both we're going to use Spring Framework, the first one is the Spring-Data-JPA and the second one is Spring-Data-R2DBC.   
   
`Spring Data JPA`: Tradicional way to connect to relacional databases, **blocking manner**.
`Spring Data R2DBC`: R2DBC is the acronym which means Reactive Relational Database Connectivity, the name says everything, reactive programming to Realtional DB, i.e. **non-blocking manner**. Suitable for reactive programming and high-performance scenarios.


## R2DBC

![R2DBC Finding 10M on DB](10M-R2DBC.png)

Perfomed a find of `10 milion` on DB in `610.939 miliseconds` (611 sec or approximately 10 minutes). 



Ref.:

[spring-data-jpa](https://spring.io/projects/spring-data-jpa)
[R2DBC](https://r2dbc.io/)
[Spring Data JPA, Spring Data R2DBC & Hibernate Reactive](https://rathoreaparna678.medium.com/spring-data-jpa-spring-data-r2dbc-hibernate-reactive-49e367ab7552#:~:text=%2D%20Spring%20Data%20JPA%20is%20widely,programming%20and%20high%2Dperformance%20scenarios)

