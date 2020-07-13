# Springboot-Angular9

Basic settings like ng, npm , node modules,angular latest versions should be installed in the system properly, java version> 8.

It contains 3 folder as follow:
1. Server side: Springboot
2:Client side: Angular
3: Database

Local Configuration
To run Angular App: ng serve
url:http://localhost:4200

To run Springboot:
url: localhost:8080

application.properties file:
spring.datasource.url = jdbc:mysql://localhost:3306/product_database?useSSL=false
spring.datasource.username = root
spring.datasource.password = root

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto = update

profile:
-Dspring.profiles.active=dev

Note: If you need to change the port then it has to be change inside the application in following files:
client-side: product.service.ts
Server Side: Rest controller

