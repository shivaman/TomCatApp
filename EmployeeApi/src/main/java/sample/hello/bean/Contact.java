package sample.hello.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBNativeBoolean;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshalling;

@XmlRootElement
@DynamoDBTable(tableName = "contact")
public class Contact {
	@DynamoDBHashKey(attributeName = "id")
	private String id;
	@DynamoDBAttribute(attributeName = "name")
	private String name;
	@DynamoDBMarshalling(marshallerClass = AddressesMarshaller.class)
	private List<Address> addresses;
	
	public Contact() {}
	
	public Contact(String id, String name, List<Address> addresses) {
		this.id = id;
		this.name = name;
		this.addresses=addresses;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name="address")
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses=addresses;
	}
	
}
