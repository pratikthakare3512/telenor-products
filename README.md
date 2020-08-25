# telenor-products
Due to time constraint and busy schedule :) Current version of project only support search based on below optional params !!!!

type					The product type. (String. Can be 'phone' or 'subscription')
min_price				The minimum price in SEK. (Number)
max_price				The maximum price in SEK. (Number)
city					The city in which a store is located. (String)

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

