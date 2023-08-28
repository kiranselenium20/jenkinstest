package api.endpoints;

//https://gorest.co.in/public/v2/users	2903
//https://gorest.co.in/public/v2/posts	2753
//https://gorest.co.in/public/v2/comments	2759
//https://gorest.co.in/public/v2/todos

public class Routes {

	public static String base_url="https://petstore.swagger.io/v2";
	
	//create end points for user model
	public static String post_Url=base_url+"/user";
	public static String get_Url=base_url+"/user/{username}";
	public static String update_Url=base_url+"/user/{username}";
	public static String delete_Url=base_url+"/user/{username}";
	
	//pet model
	
	//store model
	
}
