import org.junit.Test;

import config.TestConfig;

import static constans.Constans.Actions.*;
import static io.restassured.RestAssured.*;

public class JsonPlaceHolderTest extends TestConfig {

    @Test
    public void get() {
        given().queryParam("postId", 1).log().uri().
                when().get(JSON_PLACE_HOLDER_GET).
                then().spec(responseSpecificationGet).log().body().statusCode(200);
    }

    @Test
    public void put() {

        String bodyJson = "{\n" +
                "    id: 1,\n" +
                "    title: \"foo\",\n" +
                "    body: \"bar\",\n" +
                "    userId: 1,\n" +
                "  }";
        given().body(bodyJson).log().uri()
                .when().put(JSON_PLACE_HOLDER_PUT)
                .then().log().body().statusCode(200);
    }

    @Test
    public void delete() {
        given().log().uri()
                .when().delete(JSON_PLACE_HOLDER_DELETE)
                .then().log().body().statusCode(200);
    }

    @Test
    public void post() {
        String postBody = "{\n" +
                "   \" title\": \"foo\",\n" +
                "   \" body\": \"bar\",\n" +
                "   \" userId\": 1\n" +
                "}";
        given().body(postBody).log().all()
                .when().post(JSON_PLACE_HOLDER_POST)
                .then().spec(responseSpecificationPost).log().body();
    }

    @Test
    public void postXml() {
        String postXML = "<note>\n" +
                "<to>Вася</to>\n" +
                "<from>Света</from>\n" +
                "<heading>Напоминание</heading>\n" +
                "<body>Позвони мне завтра!</body>\n" +
                "</note>";

        given(). spec(requestSpecificationXML).body(postXML).log().uri()
                .when().post("")
                .then().log().body().statusCode(200);
    }

}

