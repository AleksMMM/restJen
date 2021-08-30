import files.Payload;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.given;

public class DynamicJson {

    @Test
    public void addBook() {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().log().all().header("Content-Type", "application/json").
                body(Payload.addBook()).
                when()
                .post("Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js = ReUsableMethods.rawToJson(response);
        String id = js.getString("ID");
        System.out.println(id);
    }

    @Test
    public void googleApi() {

       // System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
       // WebDriver driver = new ChromeDriver();
       // driver.get("");

        String response = given()
                        .urlEncodingEnabled(false)

                        .queryParams("code","4%2F0AX4XfWjwvLVajZZT5htTlqmpXzOs5aNlom6mOmgMGfcvPK0SlSE2C4Aa9ucNhZM821YPRw")
                        .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                        .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                        .queryParams("grant_type", "authorization_code")
                        .queryParams("state", "verifyfjdss")
                        .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")

                        // .queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")
                .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                .when().log().all()
                .post("https://www.googleapis.com/oauth2/v4/token").asString();

System.out.println(response);

        JsonPath jsonPath = new JsonPath(response);

        String accessToken = jsonPath.getString("access_token");

        System.out.println(accessToken);
    }
}
