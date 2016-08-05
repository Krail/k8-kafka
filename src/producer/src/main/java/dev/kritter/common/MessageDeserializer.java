package dev.kritter.common;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;


public class MessageDeserializer implements Deserializer<Message> {
	private String encoding = "UTF8";

	public void configure(Map<String, ?> configs, boolean isKey) {
		String propertyName = isKey ? "key.deserializer.encoding" : "value.deserializer.encoding";
		Object encodingValue = configs.get(propertyName);
		if (encodingValue == null)
				encodingValue = configs.get("deserializer.encoding");
		if (encodingValue != null && encodingValue instanceof String)
				encoding = (String) encodingValue;
	}

	public Message deserialize(String topic, byte[] data) {
        try {
            if (data == null)
                return null;
            else {
            	String d = new String(data, encoding);
            	String array[] = d.split("|");
            	if (array == null || array.length == 0) return null;
            	else {
            		Message msg = new Message(Integer.parseInt(array[0]));
            		for (int i = 1; i < array.length; i++) msg.addParameter(array[i]);
            		return msg;
            	}
            	
            }
        } catch (UnsupportedEncodingException e) {
            throw new SerializationException("Error when deserializing byte[] to string due to unsupported encoding " + encoding);
        } catch (PatternSyntaxException e) {
        	throw new SerializationException("Error when spliting sting[] with \"|\"");
        }
	}

	public void close() {
		// nothing to do
	}

}
