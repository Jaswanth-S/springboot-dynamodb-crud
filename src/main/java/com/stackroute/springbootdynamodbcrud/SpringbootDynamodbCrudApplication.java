package com.stackroute.springbootdynamodbcrud;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.stackroute.springbootdynamodbcrud.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDynamodbCrudApplication implements CommandLineRunner {
	private DynamoDBMapper dynamoDBMapper;

	@Autowired
	private AmazonDynamoDB amazonDynamoDB;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDynamodbCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

		CreateTableRequest tableRequest = dynamoDBMapper
				.generateCreateTableRequest(Person.class);

		tableRequest.setProvisionedThroughput(
				new ProvisionedThroughput(1L, 1L));

		TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
	}
}
