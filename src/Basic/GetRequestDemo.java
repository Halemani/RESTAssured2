package Basic;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetRequestDemo {
	
	public void setUp() {
		RestAssured.baseURI="http://api.zippopotam.us";
//		RestAssured.basePath="/IN/560001";
	}
	
	@Test
	public void statusCodeValidation() {
		given().
        log().all()
        .when().get("http://api.zippopotam.us/IN/560001").
        then().
        log().body()
        .assertThat().
        contentType(ContentType.JSON).statusCode(200);
	}

}
