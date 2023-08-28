package api.endpoints;

import static io.restassured.RestAssured.given;
import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.payload.User;

public class UserEndPoints2 {
	
	 static ResourceBundle getUrl(){
		ResourceBundle routs = ResourceBundle.getBundle("roots"); //Load the properties
		return routs;
	}
	
	
	public static Response createUser(User payload){
        String postUrl= getUrl().getString("post_url");
		Response response = given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(payload)
		.when()
		   .post(postUrl);
	
		return response;
	}
	
	public static Response readUser(String userName){
		 String getUrl= getUrl().getString("get_url");
		Response response = given().pathParam("username",userName)
		                           .when().get(getUrl);	
		                    return response;
	}
	
	public static Response deleteUser(String userName){
		 String updateUrl= getUrl().getString("update_url");
		Response response = given().pathParam("username",userName)
		                           .when().delete(updateUrl);	
		                    return response;
	}

	public static Response updateUser(User payload,String userName){
		 String deleteUrl= getUrl().getString("delete_url");
		Response response = given().pathParam("username",userName)
		                           .contentType(ContentType.JSON)
		                           .accept(ContentType.JSON)
		                           .body(payload)
		                          .when()
		                           .put(deleteUrl);
		                    return response;
	}
}
