public class MainRunner {

    public static void main(String[] args) {

        Update update = new Update();
        Basic basic = new Basic();
        GetPlace getPlace = new GetPlace();
        String bas = basic.add();

        update.update(bas);
        getPlace.getPlace(bas, "Summer Walk, Africa");
    }
}
