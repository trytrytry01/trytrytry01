# Create DB

```
CREATE DATABASE `emartdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
```
# Create Tables
```
CREATE TABLE `role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buyer_id` int(11) DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) NOT NULL,
  `brief_details` varchar(100) NOT NULL,
  PRIMARY KEY (`category_id`)
);
CREATE TABLE `subcategory` (
  `subcategory_id` int(11) NOT NULL AUTO_INCREMENT,
  `subcategory_name` varchar(50) NOT NULL,
  `category_id` int(11) NOT NULL,
  `brief_details` varchar(100) NOT NULL,
  `gst` int(3) DEFAULT NULL,
  PRIMARY KEY (`subcategory_id`,`category_id`)
);

CREATE TABLE `subcategory` (
  `subcategory_id` int(11) NOT NULL AUTO_INCREMENT,
  `subcategory_name` varchar(50) NOT NULL,
  `category_id` int(11) NOT NULL,
  `brief_details` varchar(100) NOT NULL,
  `gst` int(3) DEFAULT NULL,
  PRIMARY KEY (`subcategory_id`,`category_id`)
);

CREATE TABLE `buyer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` bigint(16) NOT NULL,
  `created_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `buyer_index01` (`username`)
);

CREATE TABLE `seller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `company_name` varchar(100) NOT NULL,
  `GSTIN` varchar(100) NOT NULL,
  `brief` varchar(2000) DEFAULT NULL,
  `postal_address` varchar(255) DEFAULT NULL,
  `website` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contactno` varchar(20) NOT NULL,
  `created_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `seller_index01` (`username`)
);

CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(50) NOT NULL,
  `seller_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `subcategory_id` int(11) NOT NULL,
  `price` decimal(8,2) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `stock_number` bigint(6) NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `items_index01` (`seller_id`)
);

CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buyer_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `created_time` datetime NOT NULL,
  `number_of_items` int(5) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `transactions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buyer_id` int(11) NOT NULL,
  `seller_id` int(11) NOT NULL,
  `transaction_type` int(1) NOT NULL,
  `date_time` datetime NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `purchase_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buyer_id` int(11) NOT NULL,
  `transaction_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `number_of_items` int(6) NOT NULL,
  `purchase_datetime` datetime NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO role (id, name) VALUES (1,'ROLE_BUYER');
INSERT INTO role (id, name) VALUES (2,'ROLE_SELLER');
INSERT INTO role (id, name) VALUES (3,'ROLE_ADMIN');

INSERT INTO `category` (`category_id`,`category_name`,`brief_details`) VALUES (1, 'Electronic', '');
INSERT INTO `subcategory`
(`subcategory_id`,
`subcategory_name`,
`category_id`,
`brief_details`,
`gst`)
VALUES
(1,'',1,'',5);
```

# Build the project
--1.build the angular project(/happy-emart)  
  `NG BUILD`
--2.build each micro service project  
  `mvn package -Dmaven.test.skip=true`
# Run docker-compose
  `docker-compose up`

# confirm the docker host has been added to the hosts file  
(C:\Windows\System32\drivers\etc\hosts)
```
    # Added by Docker Desktop  
    192.168.1.109 host.docker.internal  
    192.168.1.109 gateway.docker.internal  
```

# URL  
## frontend:
       `http://localhost:4200/`
## backend:
### eureka server URL:
	       `http://localhost:8761/`
       ### buyer sign up: 
		   `curl -H "Content-Type: application/json" -X POST  --data "{\"username\":\"buyer1\",\"password\":\"1234567\",\"email\":\"abc@sample.com\",\"mobile\":\"133222333392\"}" http://host.docker.internal:8000/api-user/buyer/signup`
       ### seller sign up: 
	       `curl -H "Content-Type: application/json" -X POST  --data "{\"username\":\"seller123\",\"password\":\"1234567\",\"companyName\":\"company111\",\"gstin\":\"10%\",\"brief\":\"brief111111\",\"postalAddress\":\"address a\",\"website\":\"www.123.sample.com\",\"email\":\"abc@sample.com\",\"contactNo\":\"No.12345678\"}" http://host.docker.internal:8000/api-user/seller/signup`
	   ### buyer/seller login(userType:0(buyer) 1(seller)):
	       `curl -H "Content-Type: application/json" -X POST  --data "{\"username\": \"buyer1\",\"password\": \"1234567\",\"userType\": \"0\"}" http://host.docker.internal:8000/api-user/login`