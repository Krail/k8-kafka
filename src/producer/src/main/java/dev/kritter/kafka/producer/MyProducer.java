package dev.kritter.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import dev.kritter.common.Message;


public class MyProducer {
	
	private static String TOPIC = "topic";
	private Producer<String, Message> producer;
	private MyCallback callback;
	
	public MyProducer() {
		Properties props = new Properties();
//		props.put("bootstrap.servers", "localhost:9092"); // service hostname:port of kafka
		props.put("bootstrap.servers", System.getenv("KAFKA_SVC_SERVICE_HOST") + ":" + System.getenv("KAFKA_SVC_SERVICE_PORT"));
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
//		props.put("compression.type", "none");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "dev.kritter.common.MessageSerializer");
		
		this.producer = new KafkaProducer<String, Message>(props);
		this.callback = new MyCallback();
	}
	
	//ProducerRecord(String topic, Integer partition, Long timestamp, K key, V value)
	
	public void publish(String key, Message value) {
		this.producer.send(new ProducerRecord<String, Message>(MyProducer.TOPIC, key, value), this.callback);
	}
	
	public String getTopic() { return MyProducer.TOPIC; }
	
	public String getStats() { return callback.getStats(); }
	
}
