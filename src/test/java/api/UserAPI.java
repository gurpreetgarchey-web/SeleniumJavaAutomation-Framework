package api;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class UserAPI {

    public static int verifyAPI(String url) {
        
    	//Created a free account on ReqRes to get the apikey
    	Response response =
    		    given()
    		        .header("x-api-key", "free_user_3G6L6MMR85Cd5Nih48xKi3jEYpl")
    		    .when()
    		        .get(url);

    	System.out.println(response.getStatusCode());

    	System.out.println(response.asPrettyString());

        return response.getStatusCode();

    }
    public static Response getUsers(String url) {

        Response response =
                given()
                    .header("x-api-key", "free_user_3G6L6MMR85Cd5Nih48xKi3jEYpl")
                .when()
                    .get(url);

        return response;
    }

}