# RomanNumerals Converter Web Service 
web service which can be used to represent a given number into roman numeral


## To build the appplication
`mvn clean install`

## To run the application locally
`mvn spring-boot:run`

## To access the service locally on the browser . use the examples below

`http://localhost:8080/romannumeral/v2?min=50&max=50`

`http://localhost:8080/romannumeral/v1?query=50`

## To access the list of metrics through actuator
`http://localhost:8080/actuator/prometheus`

## In case we have so many results data , then we can implement Pagination which will retreive by passing page and size 
`page=0&size=2`

which can reducing the amount of data loaded at once. It allows pages to load faster, ensuring smoother navigation through the webservice.

## Exception Handling

`
http://localhost:8080/romannumeral/v1?query=4000
http://localhost:8080/romannumeral/v1?query=-1
`

Output:

`query parameter needs to be in the range between 1 and 3999`


