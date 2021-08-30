package constans;

import static constans.Constans.Servers.JSON_PLACEHOLDER_URL;
import static constans.Constans.Servers.JSON_PLACEHOLDER_URL;

public class Constans {

    public static class RunVariable {

        public static String server = JSON_PLACEHOLDER_URL;
        public static String path = "";
    }

    public static class Servers {

        public static String SWAPI_URL = "https://swapi.dev/";
        public static String GOOGLE_PLACES_URL;
        public static String JSON_PLACEHOLDER_URL = "https://jsonplaceholder.typicode.com/";
        public static String XML_REQUESTBIN_URL = "https://enxi970yzil6gc8.m.pipedream.net";
    }

    public static class Path {

        public static String SWAPI_PATH = "api/";
        public static String GOOGLE_PLACES_PATH;
    }

    public static class Actions {

        public static String SWAPI_GET_PEOPLE = "people/";
        public static String GOOGLE_PLACES_URL;
        public static String JSON_PLACE_HOLDER_GET = "comments";
        public static String JSON_PLACE_HOLDER_PUT = "posts/1/";
        public static String JSON_PLACE_HOLDER_DELETE = "posts/1/";
        public static String JSON_PLACE_HOLDER_POST = "posts/";

    }
}
