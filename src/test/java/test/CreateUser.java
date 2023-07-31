package test;
import endpoints.UserEndPoint2;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payload.User;
import utilities.DataProviders;
import utilities.RequestSpec;
public class CreateUser
{
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProviderClass = DataProviders.class,dataProvider = "getAllData")
    public void createUser(String id, String username, String firstName, String lastName, String email, String password,
                           String phone , String userStatus)
    {
        User userPayload = new User();
        userPayload.setId(Integer.parseInt(id));
        userPayload.setUsername(username);
        userPayload.setFirstName(firstName);
        userPayload.setLastName(lastName);
        userPayload.setEmail(email);
        userPayload.setPassword(password);
        userPayload.setPhone(phone);
        userPayload.setUserStatus(Integer.parseInt(userStatus));

        Response response= UserEndPoint2.createUser(userPayload);
        response.then().spec(RequestSpec.create());
        response.prettyPrint();
        if(response.getStatusCode()==200){
            System.out.println("The User is Created Successfully "+ response.getStatusCode());
        }
        else {
            System.out.println("The User is Not Created Successfully "+ response.getStatusCode());
        }

      /*  Assert.assertEquals(response.getStatusCode(),200); // it should be 201,but it's documented 200 in the website.
        response.then().assertThat().contentType(ContentType.JSON);*/
    }
}
