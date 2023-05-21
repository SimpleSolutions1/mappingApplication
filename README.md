# Mapping API

> **Note:** **Spring Boot 3.x** requires **Java 17** as a minimum version. Make sure you are using Java 17 or beyond for Spring Boot 3.x projects.

## How to Run Application

**Start the application using any of the commands mentioned below**

- **Using maven** <br/>``` mvn spring-boot:run```

> **Note:** First two commands need to run inside the root folder of this project i.e. inside the **mappingApplication** folder


- **Directly from IDE**
  <br/>```Right click on MappingApplication.java and click on 'Run' option```
  <br/><br/>

> **Note:** By default spring boot application starts on port number 8080. If port 8080 is occupied in your system then you can change the port number by uncommenting and updating the **server.port** property inside the **application.yml** file that is available inside the **src > main > resources** folder.

<br/>

**Send an HTTP GET request to endpoints using any of methods**

- **From Browser or REST client**
  <br/>```http://localhost:8080/```

- **From Swagger-ui**
  <br/>```http://localhost:8080/swagger-ui/index.html```


- **cURL**
  <br/>```curl --request GET 'http://localhost:8080/'```


## How to Run Unit Test Cases

**Run the test cases using any of the commands mentioned below**

> **Note:** These commands need to run inside the root folder of this project i.e. inside the **mappingApplication** folder

- **To run all the test cases**
  <br/>```mvn test```


- **To run a particular test class**