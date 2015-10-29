package sample.hello.bean;

import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBNativeBoolean;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.JsonMarshaller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import com.google.gson.Gson;

public class AddressesMarshaller extends JsonMarshaller<List> {

	@Override
    public String marshall(List addresses) {
		Gson gson = new Gson();
		Type listOfAdresses = new TypeToken<List<Address>>(){}.getType();
		String s = gson.toJson(addresses, listOfAdresses);
		
		return s;
    }
 
    @Override
    public List unmarshall(Class<List> clazz, String s) {
    	Type listType = new TypeToken<ArrayList<Address>>() {}.getType();
        List<Address> listOfAddresses = new Gson().fromJson(s, listType);
    	
    	return listOfAddresses;
    }   
}
