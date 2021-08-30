import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.File;

import static io.restassured.RestAssured. *;
import static org.hamcrest.Matchers.equalTo;

public class GetPlace {

    public void getPlace(String place_id, String newAdreess) {

        RestAssured.baseURI = BaseConfig.URL.url;

       String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", place_id)
                .when().get("/maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();

       JsonPath js1 = new JsonPath(getPlaceResponse);
       String newAdress1 = js1.getString("address");
        System.out.println(newAdress1);
    }

}
