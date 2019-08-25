# Hotel example

## Getting started

### Creating docker image
`mvn package`

### Running the application against in-memory db
`mvn spring-boot:run`

### Running application against mysql db

Start mysql server in docker:

`docker run -e MYSQL_ALLOW_EMPTY_PASSWORD=true -e MYSQL_ROOT_PASSWORD= -e MYSQL_DATABASE=hotel -p 3306:3306 -d mysql:5`

`mvn spring-boot:run -Pmysql`

### Running application with mysql in docker-compose file

`docker-compose up -d`

## Usage

### Query hotels

`curl -X GET -v http://localhost:8080/hotels`

### Create an hotel

`curl -X POST -v http://localhost:8080/hotels -H "Content-Type:application/json" -d '
 { "name": "test",
   "description": "empty",
   "city": "Antwerp",
   "rating": 4
 }'
`

### Delete an hotel

`curl -X DELETE -v http://localhost:8080/hotels/1`
