package Basic;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetRequestDemoWithPOJO {
	
	public void setUp() {
		RestAssured.baseURI="http://api.zippopotam.us";
//		RestAssured.basePath="/IN/560001";
	}
	
	@Test
	public void statusCodeValidation() {
		Map<String, String> myPlaces = new HashMap<String, String>(); 
		//myPlaces.put
		
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

}
