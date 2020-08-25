# telenor-products
Due to time constraint and busy schedule :) Current version of project only support search based on below optional params !!!!

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

## How to run ##

# Docker pull to get the image from docker-hub
docker pull pratikthakare/testproject

# Docker run
docker run -p 8085:8085 telenor-product

# git clone
https://github.com/pratikthakare3512/telenor-products.git

# Test using swagger-ui
http://localhost:8085/swagger-ui.html

# Test GET Operation using Postman
http://localhost:8085/api/product?type=subscription&city=Stockholm

