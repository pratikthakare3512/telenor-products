# telenor-products
Due to time constraint and busy schedule :) Current version of project only support search based on below optional params !!!!
All the params are tightly coupled with Controller. In case we add extra param in Query code change is required.
Its best to make solution dynamic by adding this query param in DATABASE and do some validation against the request So that addition of new param will not have impact on the code.

1. type					    The product type. (String. Can be 'phone' or 'subscription')
2. min_price				The minimum price in SEK. (Number)
3. max_price				The maximum price in SEK. (Number)
4. city					    The city in which a store is located. (String)


# Description
- Spring boot application : Dev-tool , jpa , Web , maven
- Databse                 : H2DB in-memory
- Server                  : Tomcat
- Container               : Docker

# Sample Payload

[ {
  "id" : 1,
  "productType" : "phone",
  "price" : 277,
  "city" : "Blake grnden, Karlskrona",
  "attribute" : "color",
  "value" : "green"
}, {
  "id" : 2,
  "productType" : "subscription",
  "price" : 415,
  "city" : "Odell gatan, Stockholm",
  "attribute" : "gb_limit",
  "value" : "50"
}, {
  "id" : 3,
  "productType" : "subscription",
  "price" : 202,
  "city" : "Fausto vgen, Karlskrona",
  "attribute" : "gb_limit",
  "value" : "10"
}

# How to run using docker

- Docker pull to get the image from docker-hub :
docker pull pratikthakare/testproject

- Docker run : 
docker run -p 8085:8085 <image-id>
  
- When runing using docker image use below command to get the url : 
docker-machine url

- Docker Request URL : 
http://192.168.99.100:8085/api/product

- Docker Swagger UI URL : 
http://192.168.99.100:8085/swagger-ui.html#/controller/showProductsUsingGET

- curl for docker container : 
curl -X GET "http://192.168.99.100:8085/api/product" -H "accept: */*"


# How to run using GIT

- git clone and build run : 
https://github.com/pratikthakare3512/telenor-products.git

- Test using swagger-ui : 
http://localhost:8085/swagger-ui.html

- Test GET Operation using Postman : 
http://localhost:8085/api/product?type=subscription&city=Stockholm

