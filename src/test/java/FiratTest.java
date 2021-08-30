import config.TestConfig;
import constans.Constans;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class FiratTest extends TestConfig {

    @Test
    public void myFistTest() {
        given().log().ifValidationFails().
        when().get(Constans.Actions.SWAPI_GET_PEOPLE + "1").
                then().statusCode(201).log().body();

    }
    @Test
    public void getSomeFild() {

        given().spec(requestSpecificationSwapi).log().ifValidationFails().
                when().get(Constans.Path.SWAPI_PATH).
                then().body("people", equalTo("https://swapi.dev/api/people/")).log().body();
    }
}
