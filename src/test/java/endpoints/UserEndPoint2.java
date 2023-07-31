package endpoints;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;
import java.util.ResourceBundle;
import static io.restassured.RestAssured.given;

//CRUD
public class UserEndPoint2 {
     static ResourceBundle getUrl(){
        ResourceBundle route = ResourceBundle.getBundle("route");
        return route;
    }
    public static Response createUser(User payload){
         String postUser= getUrl().getString("Post_url");
       Response response= given().filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(postUser);
       return response;
    }
    public static Response loginUser(String userName,String password){
        String loginUser= getUrl().getString("login_url");
        Response response =given().filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParams("username",userName,"password",password)
                .when()
                .get(loginUser);
        return response;
    }
    public static Response getUser(String username){
        String getUser= getUrl().getString("get_url");
        Response response= given().filter(new AllureRestAssured())
                .pathParam("username",username)
                .when()
                .get(getUser);
        return response;
    }
    public static Response updateUser(String userName, User payload){
        String updateUser= getUrl().getString("update_url");
        Response response= given().filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .body(payload)
                .pathParam("username",userName)
                .when()
                .put(updateUser);
        return response;
    }
    public static Response deleteUser(String userName){
        String deleteUser= getUrl().getString("delete_url");
        Response response= given().filter(new AllureRestAssured())
                .pathParam("username",userName)
                .when()
                .delete(deleteUser);
        return response;
    }

}
