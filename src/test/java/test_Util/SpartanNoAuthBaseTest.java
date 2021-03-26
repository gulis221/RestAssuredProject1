package test_Util;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class SpartanNoAuthBaseTest {

    @BeforeAll
    public static void inIt() {
        //this will set the part of url at RestAssured
        RestAssured.baseURI = "http://34.202.173.245";
        RestAssured.port=8000;
        RestAssured.basePath = "/api";
    }

    @AfterAll
    public static void cleanUp(){
        RestAssured.reset();
    }

}
