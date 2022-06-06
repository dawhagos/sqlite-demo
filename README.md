# CRUD Application Using SQLite

## Summary:

This application will allow you to use SQLite, an extremely lightweight and self-contained, serverless,
zero-configuration, transactional SQL database engine using Spring Boot and Spring Data JPA.

### Technologies Used

```
- Java
- Spring Boot
- Maven
- SQLite
```

## Getting Started
- Clone this project in the directory of your choice
```
git clone https://github.com/dawhagos/sqlite-demo.git
```
- Use Maven to run the project while within the directory
```
mvn spring-boot:run
```
- Access the Swagger UI on the web browser of your choice (Port number can be changed within application.properties file)
```
http://localhost:9060/swagger-ui/index.html
```
- Make requests to the SQLite database following the schema provided within the Swagger documentation.

Example POST Request to create a new user:
```
{
    "email": "your@email.com",
    "username": "name",
    "password": "password123"
}
```
Note that ID is generated for you, so you shouldn't include an ID in your request.


