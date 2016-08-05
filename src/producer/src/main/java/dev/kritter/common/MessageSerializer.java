package dev.kritter.common;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;


public class MessageSerializer implements Serializer<Message> {
	private String encoding = "UTF8";

	public void configure(Map<String, ?> configs, boolean isKey) {
		String propertyName = isKey ? "key.serializer.encoding" : "value.serializer.encoding";
		Object encodingValue = configs.get(propertyName);
		if (encodingValue == null)
				encodingValue = configs.get("serializer.encoding");
        if (encodingValue != null && encodingValue instanceof String)
            	this.encoding = (String) encodingValue;
	}

	public byte[] serialize(String topic, Message data) {
		try {
			if (data == null) return null;
			else {
				ArrayList<String> parameters = data.getParameters();
				String serial = data.getId() + "|";
				if (parameters != null) {
					for (int i = 0; i < parameters.size(); i++) {
						serial += parameters.get(i);
						if (i != parameters.size()-1) serial += "|";
					}
				}
				return serial.getBytes(this.encoding);
			}
		} catch (UnsupportedEncodingException e) {
            throw new SerializationException("Error when serializing string to byte[] due to unsupported encoding " + encoding);
        }
	}

	public void close() {
		// nothing to do
	}

}
