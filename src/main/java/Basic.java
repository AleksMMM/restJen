import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.File;

import static io.restassured.RestAssured. *;
import static org.hamcrest.Matchers.equalTo;

public class Basic {

    public String add() {



        RestAssured.baseURI = BaseConfig.URL.url;

        String response = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
        .body(Payload.addPlace()).when().post("/maps/api/place/add/json")
        .then().assertThat().statusCode(200).body("scope",equalTo("APP") )
                .header("Server", equalTo("Apache/2.4.18 (Ubuntu)")).extract().response().asString();


        JsonPath js = new JsonPath(response); // использую jsonPath для преобразования строки в json объект
        String placeId = js.getString("place_id"); // получаю значение place_id
        return placeId;
    }
}
