package dev.kritter.kafka.consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import dev.kritter.common.Message;

public class ConsumerThread extends Thread {
	
	public Consumer<String, Message> consumer;
	
	public ConsumerThread(Consumer<String, Message> consumer) {
		this.consumer = consumer;
	}
	
	public void run() {
		while (true) {
			ConsumerRecords<String, Message> records = this.consumer.poll(100);
			for (ConsumerRecord<String, Message> record : records) {
				MyConsumer.count++;
				System.out.printf("%d,%s,%s\n", record.offset(), record.key(), record.value().toString());
			}
		}
	}
	
}
