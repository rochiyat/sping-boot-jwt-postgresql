# Sping Boot JWT With Postgre SQL and Role
Build Project Sping Boot With JWT and PostgreSQL

User Registration, User Login and Authorization process

Project Requirements
- Maven version 3.xx
- Java 8
- Tools use VSC, STS, Eclipse, or Intellij Idea
- Postman
- PostgreSQL

Stages of Project to Localhost Implementation
- Clone link repo github
- Setting application.properties for database configuration
- Running the project via maven with the command mvn spring-boot:run


Run Postman or command line

- Create user with curl (replaced body part) \
curl --location 'http://localhost:8080/api/auth/signup' \
--header 'Content-Type: application/json' \
--data-raw '{
     "username": "rochiyat",
     "email": "rochiyat@gmail.com",
     "password": "123456789",
     "role": ["admin","mod"]
}'

- Login with user rochiyat \
curl --location 'http://localhost:8080/api/auth/signin' \
--header 'Content-Type: application/json' \
--data '{
     "username": "rochiyat",
     "password": "123456789"
}'

- Get Job List (token is replaced with a new token) \
curl --location 'http://localhost:8080/api/test/job-list' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb2NoaXlhdCIsImlhdCI6MTY4MzI4MDI3MywiZXhwIjoxNjgzMzY2NjczfQ.WfMMQVV1U6fpf23JUfV3Gt1cyQmxKDZqbf w8gVNC07eixGc90To74OdynG5U3tWkq5OTAYeQ5-ELBlz-VdWORw'

- Get Job By Id (token is replaced with a new token) \
curl --location 'http://localhost:8080/api/test/job/7638eee4-4e75-4c06-a920-ea7619a311b5' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb2NoaXlhdCIsImlhdCI6MTY4MzI4MDI3MywiZXhwIjoxNjgzMzY2NjczfQ.WfMMQVV1U6fpf23JUfV3Gt1cyQmxKDZqbf w8gVNC07eixGc90To74OdynG5U3tWkq5OTAYeQ5-ELBlz-VdWORw'
