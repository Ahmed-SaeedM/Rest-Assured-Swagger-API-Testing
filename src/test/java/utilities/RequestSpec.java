package utilities;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

public class RequestSpec {
    private static ResponseSpecification responseSpec ;
    @BeforeClass
    public static ResponseSpecification create(){
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectStatusLine("HTTP/1.1 200 OK")
                .build();
        return responseSpec;
    }
}
