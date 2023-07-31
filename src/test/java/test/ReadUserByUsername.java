package test;
import endpoints.UserEndPoint2;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload.User;
import utilities.DataProviders;
import utilities.RequestSpec;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ReadUserByUsername
{
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProviderClass = DataProviders.class,dataProvider = "getUsername1")
    public void getUser(String userName)
{
    Response response= UserEndPoint2.getUser(userName);
    response.then().spec(RequestSpec.create())
            .log().all().assertThat().body(
                    (matchesJsonSchemaInClasspath("userResponseSchema.json")));
    User data = response.as(User.class);
    Assert.assertEquals(data.getUsername(),userName);
      /*  Assert.assertEquals(response.getStatusCode(),200);
        response.then().assertThat().contentType(ContentType.JSON);*/
}
}
