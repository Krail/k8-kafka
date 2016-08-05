package dev.kritter.kafka.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class MyCallback implements Callback {
	
	public static long correct = 0, error = 0, total = 0;

	//@Overrides
	public void onCompletion(RecordMetadata metadata, Exception exception) {
		MyCallback.total++;
		if (metadata == null)  MyCallback.error++;
		else {
			MyCallback.correct++;
			System.out.println(metadata.toString());
		}
	}
	
	public String getStats() {
		return "# Correct: " + MyCallback.correct
				+ "\n# Errors: " + MyCallback.error
				+ "\n--------------\nTotal: "
				+ MyCallback.total;
	}

}
