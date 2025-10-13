# Spring Boot with Redis and MySQL

A Spring Boot REST API application demonstrating the integration of Redis caching with MySQL database for managing
country data.

## Features

- RESTful API for Country CRUD operations
- Redis caching to improve read performance
- MySQL database for persistent storage
- Swagger UI for API documentation
- Spring Boot 3.5.6 with Java 21
- Lombok for reducing boilerplate code

## Technology Stack

- Java 21
- Spring Boot 3.5.6
- Spring Data JPA
- Spring Data Redis
- MySQL
- Redis
- Gradle 8.11.1
- Swagger/Springfox 3.0.0
- Lombok

## Prerequisites

Before running this application, make sure you have:

- Java 21 or higher installed
- MySQL Server running on localhost:3306
- Redis Server running on localhost:6379
- Gradle (or use the provided Gradle Wrapper)

## Database Setup

1. Start MySQL server
2. The application will automatically create the `countries` database if it doesn't exist
3. You can manually create the database and table using the provided SQL script:

```bash
mysql -u root -p < src/main/resources/schema.sql
```

Or manually execute:

```sql
CREATE DATABASE IF NOT EXISTS countries;
USE countries;

CREATE TABLE IF NOT EXISTS country (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(10) NOT NULL,
    capital VARCHAR(255) NOT NULL
);
```

## Redis Setup

Make sure Redis is running on localhost:6379. You can start Redis using:

```bash
# Using Homebrew on macOS
brew services start redis

# Or using Docker
docker run -d -p 6379:6379 redis:latest

# Or start Redis directly
redis-server
```

## Configuration

The application configuration can be modified in `src/main/resources/application.yml`:

- Server runs on port: 8080
- Context path: `/country-service`
- MySQL connection: `jdbc:mysql://localhost:3306/countries`
- Redis host: `localhost:6379`
- Cache TTL: 60000ms (60 seconds)

## Building the Application

```bash
# Build without tests
./gradlew clean build -x test

# Build with tests
./gradlew clean build
```

## Running the Application

```bash
# Using Gradle
./gradlew bootRun

# Or run the JAR file
java -jar build/libs/Spring-Redis-Mysql-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080/country-service`

## API Endpoints

### Base URL

```
http://localhost:8080/country-service
```

### Available Endpoints

1. **Get All Countries**
    - Method: GET
    - URL: `/countries`
    - Description: Retrieves all countries from the database

2. **Get Country by ID**
    - Method: GET
    - URL: `/countries/findById?id={id}`
    - Description: Retrieves a specific country by ID (cached in Redis)

3. **Create Country**
    - Method: POST
    - URL: `/countries`
    - Description: Creates a new country
    - Request Body:
   ```json
   {
     "name": "Indonesia",
     "code": "ID",
     "capital": "Jakarta"
   }
   ```

4. **Delete Country**
    - Method: GET
    - URL: `/countries/deleteById?id={id}`
    - Description: Deletes a country by ID and evicts from cache

## Swagger UI

Access the Swagger UI documentation at:

```
http://localhost:8080/country-service/swagger-ui/
```

## Testing the Application

### Using cURL

```bash
# Create a country
curl -X POST http://localhost:8080/country-service/countries \
  -H "Content-Type: application/json" \
  -d '{"name":"Indonesia","code":"ID","capital":"Jakarta"}'

# Get all countries
curl http://localhost:8080/country-service/countries

# Get country by ID
curl http://localhost:8080/country-service/countries/findById?id=1

# Delete country
curl http://localhost:8080/country-service/countries/deleteById?id=1
```

### Using HTTPie

```bash
# Create a country
http POST http://localhost:8080/country-service/countries name="Indonesia" code="ID" capital="Jakarta"

# Get all countries
http GET http://localhost:8080/country-service/countries

# Get country by ID
http GET http://localhost:8080/country-service/countries/findById?id=1
```

## Caching Behavior

- **@CachePut**: When a country is saved, it's immediately cached
- **@Cacheable**: When a country is fetched by ID, it's retrieved from Redis cache if available
- **@CacheEvict**: When a country is deleted, it's removed from the Redis cache
- Cache TTL: 60 seconds (configurable in application.yml)

## Project Structure

```
src/main/java/com/hendisantika/springredismysql/
├── config/
│   └── SwaggerConfig.java          # Swagger configuration
├── controller/
│   └── CountryController.java      # REST API endpoints
├── entity/
│   └── Country.java                # Country entity
├── repository/
│   └── CountryRepository.java      # Data access layer
├── service/
│   └── CountryService.java         # Business logic with caching
└── SpringRedisMysqlApplication.java # Main application class
```

## Troubleshooting

### MySQL Connection Issues

- Ensure MySQL is running on port 3306
- Check username and password in application.yml
- Verify the database 'countries' exists

### Redis Connection Issues

- Ensure Redis is running on port 6379
- Test Redis connection: `redis-cli ping` (should return PONG)

### Build Issues

- Make sure you're using Java 21
- Clear Gradle cache: `./gradlew clean --refresh-dependencies`

## Author

- Name: hendisantika
- Email: hendisantika@gmail.com
- Telegram: @hendisantika34

## License

This project is open source and available for educational purposes.
