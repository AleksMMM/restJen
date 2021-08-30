import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.File;

import static io.restassured.RestAssured. *;
import static org.hamcrest.Matchers.equalTo;

public class Update {



    public void update(String placeId) {

        baseURI = BaseConfig.URL.url;
        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(Payload.putPlace(new Basic().add(), "Summer Walk, Africa" ))
                .when().put(BaseConfig.PATH_PUT.url)
                .then().assertThat().statusCode(200);
    }

}
