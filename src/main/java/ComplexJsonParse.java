import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

    public static void main(String[] args) {

        JsonPath jsonPath = new JsonPath(Payload.coursePrice());

        int count = jsonPath.getInt("courses.size()");
        System.out.println(count);

        // вывести purchase Amount
        int totalAmount = jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);

        // получить нулевой элемент массива и получить внутри него title

        String title = jsonPath.get("courses[0].title");
        System.out.println(title);

        for (int i = 0; i < count; i++) {

           String a = jsonPath.getString("courses["+ i + "].title");
            System.out.println(a);

            if (a.equalsIgnoreCase("RPA")) {

                int price = jsonPath.getInt("courses["+ i + "].price");
                System.out.println(price);
                break;
            }

        }
    }
}
