package dev.kritter.kafka.consumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import dev.kritter.common.Message;


public class MyConsumer {
	
	public static int count = 0;
	
	private static String TOPIC = "topic";
	private Consumer<String, Message> consumer;
	
	public MyConsumer() {
		Properties props = new Properties();
//		props.put("bootstrap.servers", "localhost:9092"); // service hostname:port of kafka
		//props.put("bootstrap.servers", "kafka:9092");
		props.put("bootstrap.servers", System.getenv("KAFKA_SVC_SERVICE_HOST") + ":" + System.getenv("KAFKA_SVC_SERVICE_PORT"));
		props.put("group.id", "the-consumer-group");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
//		props.put("compression.type", "none");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "dev.kritter.common.MessageDeserializer");
		
		//this.consumer = new KafkaConsumer<String, Message>(props);
		//this.consumer.subscribe(Arrays.asList(MyConsumer.TOPIC));
		
		System.out.println("offset,key,value");
		
		//Thread thread = new ConsumerThread(this.consumer);
		//thread.start();
	}
	
	public String getTopic() { return MyConsumer.TOPIC; }
	
	public int getCount() { return MyConsumer.count; }
	
	public Consumer<String, Message> getConsumer() { return this.consumer; }
	
}
