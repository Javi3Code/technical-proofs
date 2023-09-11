## Napptilus Technical Proof - Spring Boot Project

## Prerequisites

To run this project, make sure you have the following software installed on your system:

```
- Java Development Kit (JDK) 17 or later
- Apache Maven
- Spring-boot 3.1.3
- Docker
- IDE (IntelliJ IDEA recommended)
```

## Getting Started

Follow the instructions below to set up and run the project locally:
The project includes a .run (Intellij Idea) to easily compile, package, create the images, and run all the necessary containers, or you can
run the next commands:

```bash
        mvn clean install -DskipTests &&
        docker build -t tech-prf . &&
        docker run -p 8080:8080 tech-prf
```

## H2 Database

[Access to h2-console](http://localhost:8090/api/h2)
database: napptilus_db
user: sa
password:

## Disclaimer

I take the liberty of changing the date format to TIMESTAMP in database and ZonedDateTime or OffsetDateTime in java, it's the most
appropriate, always saving them in UTC.

## Testing the API

The project includes integration tests that meet the following requirements:

```
○ Test 1: request at 10:00 a.m. on the 14th day for product 35455 for brand 1
○ Test 2: request at 16:00 on the 14th of the day of the product 35455 for brand 1
○ Test 3: request at 21:00 on the 14th of the day of the product 35455 for brand 1
○ Test 4: request at 10:00 on the 15th of the day of the product 35455 for brand 1
○ Test 5: request at 21:00 on the 16th of the day of the product 35455 for brand 1
```

To test the API endpoint, you can use the provided Postman collection. Import the collection included in the .postman directory into
Postman, and you will have a collection with the preconfigured request for the endpoint available.
