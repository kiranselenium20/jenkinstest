package api.test;

import static org.testng.Assert.assertEquals;

import java.util.Locale;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endpoints.*;
import com.github.javafaker.Faker;

import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
	
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setupData() {
		
		faker= new Faker(new Locale("en-IND"));
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority = 1)
	public void test_postUser() {
		Response response = UserEndPoints2.createUser(userPayload);
		response.then().log().all();
		assertEquals(response.getStatusCode(),200);
	}
	

	@Test(priority = 3)
	public void test_getUserByName() {
		Response response = UserEndPoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority = 4)
	public void test_updateUserByName() {
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.internet().safeEmailAddress());
		Response response = UserEndPoints2.updateUser(userPayload,this.userPayload.getUsername());
		response.then().log().all();
		assertEquals(response.getStatusCode(),200);
		
		Response responseAfterUpdate = UserEndPoints2.readUser(this.userPayload.getUsername());
		responseAfterUpdate.then().log().all();
		assertEquals(responseAfterUpdate.getStatusCode(),200);
	}
	
	@Test(priority = 6)
	public void test_deleteUserByName() {
		Response response = UserEndPoints2.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		assertEquals(response.getStatusCode(),200);
	}
}
