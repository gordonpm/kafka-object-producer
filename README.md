## Project Overview
This project demonstrates how to send objects over Kafka. It is implemented using Spring Boot. 
The producer config is created programmatically using ProducerFactory.

### How to Run
1. Start Zookeper with this command:  
   <em>bin/windows/zookeeper-server-start.bat config/zookeeper.properties</em>  


2. Start Kafka server with this command:  
   <em>bin/windows/kafka-server-start.bat config/server.properties</em>


3. Curl to send customer object to Kafka:  
<em>curl --location --request POST 'http://localhost:9191/producer-app/publish' \
--header 'Content-Type: application/json' \
--data-raw '{
"id": "927834",
"name": "John",
"email": "john@email.com",
"phone": "645365445"
}'</em>