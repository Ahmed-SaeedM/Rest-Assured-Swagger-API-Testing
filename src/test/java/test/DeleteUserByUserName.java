package test;

import endpoints.UserEndPoint2;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.DataProviders;
import utilities.RequestSpec;

public class DeleteUserByUserName
{
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProviderClass = DataProviders.class,dataProvider = "getUsername2")
    public void deleteUser(String userName){
        Response response= UserEndPoint2.deleteUser(userName);
        response.then().spec(RequestSpec.create())
                .log().all();
       /* Assert.assertEquals(response.getStatusCode(),200);
        response.then().assertThat().contentType(ContentType.JSON);*/
    }
}
