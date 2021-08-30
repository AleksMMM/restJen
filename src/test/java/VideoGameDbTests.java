import config.VideoGame;
import config.VideoGameEndpoints;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class VideoGameDbTests  extends VideoGame {
    @Test
    public void getAllGames() {
        given().
                when().get(VideoGameEndpoints.ALL_VIDEO_GAMES).
                then();
    }
    @Test
    public void createNewGameByJson() {
        String gameJson = "{\n" +
                "  \"id\": 11,\n" +
                "  \"name\": \"NewGame\",\n" +
                "  \"releaseDate\": \"2021-07-10T17:34:13.694Z\",\n" +
                "  \"reviewScore\": 88,\n" +
                "  \"category\": \"Action\",\n" +
                "  \"rating\": \"Mature\"\n" +
                "}";
        given()
                .body(gameJson).
        when()
                        .post(VideoGameEndpoints.ALL_VIDEO_GAMES).
                then();

    }
    @Test
    public void createNewGameXML() {
        String gameBody = "<videoGame category=\"Shooter\" rating=\"Universal\">\n" +
                "    <id>15</id>\n" +
                "    <name>Resident Evil 4</name>\n" +
                "    <releaseDate>2005-10-01T00:00:00+04:00</releaseDate>\n" +
                "    <reviewScore>85</reviewScore>\n" +
                "  </videoGame>";
        given()
                .body(gameBody)
                .header("Accept", "application/xml")
                .header("Content-Type", "application/xml").
        when()
                .post(VideoGameEndpoints.ALL_VIDEO_GAMES).
        then();

    }

}
