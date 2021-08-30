package config;

import constans.Constans;
import constans.SWAPI_URL;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class TestConfig {

    protected RequestSpecification requestSpecificationSwapi = new RequestSpecBuilder()
            .setBaseUri(Constans.Servers.SWAPI_URL)
            .build();

   protected static RequestSpecification requestSpecification = new RequestSpecBuilder() // чтобы создавать общие свойства для запросов и дополнительные поля
           .setBaseUri(Constans.Servers.JSON_PLACEHOLDER_URL)
           .addHeader("Content-type", "application/json")
            .addCookie("testCookie")
            .build();

   protected static RequestSpecification requestSpecificationXML = new RequestSpecBuilder() // чтобы создавать общие свойства для запросов и дополнительные поля
            .setBaseUri("https://enxi970yzil6gc8.m.pipedream.net")
            .addHeader("Content-type", "application/xml")
            .addCookie("testCookieXML")
            .build();

   protected static ResponseSpecification responseSpecificationGet = new ResponseSpecBuilder()
           .expectStatusCode(200)
           .build();

    protected static ResponseSpecification responseSpecificationPost = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();


    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = Constans.RunVariable.server;
        RestAssured.basePath = Constans.RunVariable.path;
        RestAssured.requestSpecification = requestSpecification;



    }
}
