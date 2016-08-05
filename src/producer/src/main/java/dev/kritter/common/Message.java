package dev.kritter.common;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder={"id","parameters"})
public class Message {
	
	@XmlElement(name="id")
	public int id;
	@XmlElement(name="parameters")
	public ArrayList<String> parameters;
	
	public Message() {}
	
	public Message(int id) {
		this.id = id;
		this.parameters = null;
	}
	
	public Message(int id, String... parameters) {
		this.id = id;
		this.parameters = new ArrayList<String>();
		for (String parameter : parameters) this.parameters.add(parameter);
	}
	
	
	public void addParameter(String parameter) {
		if (this.parameters == null) this.parameters = new ArrayList<String>();
		this.parameters.add(parameter);
	}
	
	public int getId() { return this.id; }
	public void setId(int id) { this.id = id; }
	
	public ArrayList<String> getParameters() { return this.parameters; }
	public void setParameters(ArrayList<String> parameters) { this.parameters = parameters; }
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("AdvancedMessage[id=")
				.append(this.id)
				.append(",parameters=");
		if (this.parameters != null)
				for (int i = 0; i < this.parameters.size(); i++) {
					buffer.append(this.parameters.get(i));
					if (i != this.parameters.size()-1) buffer.append("&");
				}
		buffer.append("]");
		return buffer.toString();
	}
	
}
