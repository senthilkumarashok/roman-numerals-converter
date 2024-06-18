# RomanNumerals Converter Web Service 
web service which can be used to represent a given number into roman numeral


## To build the appplication
`mvn clean install`

## To run the application locally
`mvn spring-boot:run`

## To access the service locally on the browser . use the examples below

`http://localhost:8080/romannumeral/v2?min=50&max=50`

`http://localhost:8080/romannumeral/v1?query=50`

## To access the list of metrics available through actuator
`http://localhost:8080/actuator/prometheus`

## In case we have so many results data , then we can implement Pagination which will retreive by passing page and size 
`page=0&size=2`

which can reducing the amount of data loaded at once. It allows pages to load faster, ensuring smoother navigation through the webservice.

## Exception Handling

`http://localhost:8080/romannumeral/v1?query=4000`

`http://localhost:8080/romannumeral/v1?query=-1\`

`http://localhost:8080/romannumeral/v2?min=21&max=11`

Output:

`query parameter needs to be in the range between 1 and 3999`
`minValue must be less than maxValue`

## Testing methodology

we can test from all the following layers
1. Application   
2. Controller 
3. Service

## Build the application using docker

`docker build -t roman-numerals-converter .`

```
[+] Building 0.6s (7/7) FINISHED                                                                                                                                                                                                docker:desktop-linux
=> [internal] load build definition from Dockerfile                                                                                                                                                                                            0.0s
=> => transferring dockerfile: 177B                                                                                                                                                                                                            0.0s
=> [internal] load .dockerignore                                                                                                                                                                                                               0.0s
=> => transferring context: 2B                                                                                                                                                                                                                 0.0s
=> [internal] load metadata for docker.io/library/openjdk:17-jdk-slim                                                                                                                                                                          0.4s
=> [internal] load build context                                                                                                                                                                                                               0.0s
=> => transferring context: 98B                                                                                                                                                                                                                0.0s
=> [1/2] FROM docker.io/library/openjdk:17-jdk-slim@sha256:aaa3b3cb27e3e520b8f116863d0580c438ed55ecfa0bc126b41f68c3f62f9774                                                                                                                    0.0s
=> CACHED [2/2] COPY target/roman-numerals-converter-*.jar app.jar                                                                                                                                                                             0.0s
=> exporting to image                                                                                                                                                                                                                          0.0s
=> => exporting layers                                                                                                                                                                                                                         0.0s
=> => writing image sha256:a1ce381ca88db2613e294bdfe64ca1a1b68c5b1b68f38814df6cc35879b66d48                                                                                                                                                    0.0s
=> => naming to docker.io/library/roman-numerals-converter
```


## Run the application using docker run
`
docker run -p 8080:8080 roman-numerals-converter
`

```
.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/

:: Spring Boot ::                (v3.3.0)

2024-06-18T04:45:55.743Z  INFO 1 --- [roman-numerals-converter] [           main] com.adobe.romannumeral.Application       : Starting Application using Java 17.0.2 with PID 1 (/app.jar started by root in /)
2024-06-18T04:45:55.747Z  INFO 1 --- [roman-numerals-converter] [           main] com.adobe.romannumeral.Application       : No active profile set, falling back to 1 default profile: "default"
2024-06-18T04:45:56.477Z  INFO 1 --- [roman-numerals-converter] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-06-18T04:45:56.489Z  INFO 1 --- [roman-numerals-converter] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-06-18T04:45:56.489Z  INFO 1 --- [roman-numerals-converter] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.24]
2024-06-18T04:45:56.511Z  INFO 1 --- [roman-numerals-converter] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-06-18T04:45:56.511Z  INFO 1 --- [roman-numerals-converter] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 701 ms
2024-06-18T04:45:56.849Z  INFO 1 --- [roman-numerals-converter] [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 3 endpoints beneath base path '/actuator'
2024-06-18T04:45:56.893Z  INFO 1 --- [roman-numerals-converter] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2024-06-18T04:45:56.926Z  INFO 1 --- [roman-numerals-converter] [           main] com.adobe.romannumeral.Application       : Started Application in 1.47 seconds (process running for 1.736)
```

we can collect metrics by Configureing OpenTelemetry Collector and view through grafana


