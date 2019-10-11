package Basic;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequestDemo {
	
	public void setUp() {
		RestAssured.baseURI="http://api.zippopotam.us";
//		RestAssured.basePath="/IN/560001";
	}
	
	@Test(enabled=false)
	public void statusCodeValidation() {
		given().
        log().all()
        .when().get("http://api.zippopotam.us/IN/560001").
        then().
        log().body()
        .assertThat().
        contentType(ContentType.JSON).statusCode(200)
        .and()
        .assertThat()
        .body("places[0].'place name'", equalTo("Rajbhavan"));
        System.out.print("Tested for Rajbhavan");
	}

	@Test
	public void statusCodeValidationIntoJSON() {
		Response resp = given().
        log().all()
        .when().get("http://api.zippopotam.us/IN/560001").
        then().
        log().body()
        .assertThat().
        contentType(ContentType.JSON).statusCode(200)
        .and()
        .assertThat()
        .body("places[0].'place name'", equalTo("Rajbhavan")).extract().response();
        System.out.println("Tested for Rajbhavan");
        
        String strResp = resp.asString();
        JsonPath jsPath = new JsonPath(strResp);
        String strPOCode = jsPath.get("'post code'");
        System.out.println(strPOCode);
        String strValue = jsPath.get("places[0].'place name'");
        System.out.println(strValue);
	}

}
