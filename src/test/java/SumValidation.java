import files.Payload;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Test;

public class SumValidation {

    @Test
    public void sumOfCourse() {

        JsonPath jsonPath = new JsonPath(Payload.coursePrice());

        int count = jsonPath.getInt("courses.size");
        int sum = 0;
        for (int i = 0; i < count; i++) {

          int price = jsonPath.get("courses["+i+"].price");
          int copies = jsonPath.get("courses["+i+"].copies");
          int amount = price * copies;
          sum = sum + amount;
          System.out.println(sum);

        }
        int purchaseAmount = jsonPath.get("dashboard.purchaseAmount");
        Assert.assertEquals(purchaseAmount, sum, 1);

    }
}
