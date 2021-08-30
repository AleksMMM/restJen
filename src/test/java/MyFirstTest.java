import config.VideoGame;
import config.VideoGameEndpoints;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class MyFirstTest extends VideoGame {

    @Test
    public void myFirsttest() {
        given()
                .log().all().
                when().get("videogames").
                then().log().all();
    }

    @Test
    public void myTwoTest() {
        get(VideoGameEndpoints.ALL_VIDEO_GAMES)
                .then().log().all();
    }
}
