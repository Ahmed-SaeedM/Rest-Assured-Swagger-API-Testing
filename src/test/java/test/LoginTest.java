package test;

import endpoints.UserEndPoint2;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.DataProviders;
import utilities.RequestSpec;

public class LoginTest
{
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProviderClass = DataProviders.class,dataProvider = "getAllCredentials")
    public void login(String username,String password)
    {
        // String userName = userPayload.getUsername();
        //  String password = userPayload.getPassword();
        Response response= UserEndPoint2.loginUser(username,password);
        response.then().spec(RequestSpec.create())
                .log().all();

      /*  Assert.assertEquals(response.getStatusCode(),200);
        response.then().assertThat().contentType(ContentType.JSON);*/
    }
}
