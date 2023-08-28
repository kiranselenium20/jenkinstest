package api.endpoints;

//user end points to perform crud operations
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.payload.User;

public class UserEndPoints {
	
	public static Response createUser(User payload){
		Response response = given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(payload)
		.when()
		   .post(Routes.post_Url);
		
		return response;
	}
	
	public static Response readUser(String userName){
		Response response = given().pathParam("username",userName)
		                           .when().get(Routes.get_Url);	
		                    return response;
	}
	
	public static Response deleteUser(String userName){
		Response response = given().pathParam("username",userName)
		                           .when().delete(Routes.delete_Url);	
		                    return response;
	}

	public static Response updateUser(User payload,String userName){
		Response response = given().pathParam("username",userName)
		                           .contentType(ContentType.JSON)
		                           .accept(ContentType.JSON)
		                           .body(payload)
		                          .when()
		                           .put(Routes.update_Url);
		                    return response;
	}
}
