package sample.hello.storage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sample.hello.bean.Address;
import sample.hello.bean.Contact;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

public class ContactStore {
	private static Map<String,Contact> store;
	private static ContactStore instance = null;
	private AmazonDynamoDBClient dbClient;
	private static DynamoDBMapper mapper;
	
	private ContactStore() {
		Region apSouteast2 = Region.getRegion(Regions.US_EAST_1);
		this.dbClient = new AmazonDynamoDBClient();
		this.dbClient.setRegion(apSouteast2);
		mapper = new DynamoDBMapper(dbClient);
		
		store = new HashMap<String,Contact>();
			
	}
	
	public static Map<String,Contact> getStore() {
		if(instance==null) {
			instance = new ContactStore();		
		}
		instance.populate();
		return store;
	}
	
	public static void addItem(Contact c) {
		store.put(c.getId(), c);
		mapper.save(c);
	}
	
	private static void populate() {
		List<Contact> contactList = mapper.scan(Contact.class, 
				new DynamoDBScanExpression());
		
		if(contactList.size() > 0) {
			store.clear();
			for (Contact thisContact : contactList) {
				store.put(thisContact.getId(),thisContact);
			}
		} {
			initOneContact();
		}
	}
	
	private static void initOneContact() {
		Address[] addrs = {
			new Address("Shanghai", "Long Hua Street"),
			new Address("Shanghai", "Dong Quan Street")
		};
		Contact cHuang = new Contact("huangyim", "Huang Yi Ming", Arrays.asList(addrs));
		store.put(cHuang.getId(), cHuang);

		mapper.save(cHuang);
	}
}
