# kafka-tester
![build](https://travis-ci.org/rso-vaje-6315/kafka-tester.svg)

`docker run -d -e KUMULUZEE_STREAMING_KAFKA_PRODUCER_BOOTSTRAP-SERVERS=localhost:9092 -e ENV KUMULUZEE_STREAMING_KAFKA_CONSUMER_BOOTSTRAP-SERVERS=localhost:9092 --name kafka-tester rso6315/kafka-tester`


Send POST request to: `http://{HOST}/v1/kafka/produce/{TOPIC}` (example: `http://localhost:5000/v1/kafka/produce/NOTIFICATIONS`)

with body:
```json
{
	"type": "SEND_NOTIFICATION",
	"data": "{\"email\":{\"email\":\"emailsample@mail.com\",\"subject\":\"Hello world!\",\"htmlContent\":\"<h1>Hello world!</h1><p>Hello world from notification</p>\"}}"
}
```
*Sample to produce message to notification service*
