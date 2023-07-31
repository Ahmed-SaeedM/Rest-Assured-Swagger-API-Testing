package test;
import endpoints.UserEndPoint2;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payload.User;
import utilities.DataProviders;
import utilities.RequestSpec;
public class UpdateUserByUserName
{
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProviderClass = DataProviders.class,dataProvider = "getAllDataForPutReq")
    public void putUser(String oldUsername,String id, String username, String firstName, String lastName, String email, String password,
                        String phone , String userStatus)

    {
        User userPutPayLoad=new User();
        userPutPayLoad.setId(Integer.parseInt(id));
        userPutPayLoad.setUsername(username);
        userPutPayLoad.setFirstName(firstName);
        userPutPayLoad.setLastName(lastName);
        userPutPayLoad.setEmail(email);
        userPutPayLoad.setPassword(password);
        userPutPayLoad.setPhone(phone);
        userPutPayLoad.setUserStatus(Integer.parseInt(userStatus));
        // File updateUserData=new File("src/test/resources/updateUserData.json");
        Response response= UserEndPoint2.updateUser(oldUsername, userPutPayLoad);
        response.then().spec(RequestSpec.create())
                .log().all();

      /* Assert.assertEquals(response.getStatusCode(),200);
       response.then().assertThat().contentType(ContentType.JSON);*/
    }
}
