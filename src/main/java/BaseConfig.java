public enum BaseConfig {

    URL("https://rahulshettyacademy.com"),PATH_PUT("/maps/api/place/update/json");

    String url;

    BaseConfig(String url) {
        this.url = url;
    }
}
