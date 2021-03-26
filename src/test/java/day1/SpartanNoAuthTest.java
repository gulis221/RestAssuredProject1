package day1;

import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_Util.SpartanNoAuthBaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;



@DisplayName("Spartan app get request")
public class SpartanNoAuthTest extends SpartanNoAuthBaseTest {



    @Test
    public void sayHello(){
        //baseURI+basePath+"/hello"
        get("/hello").prettyPeek();
    }


    @Test
    public void getAllSpartans(){
        //baseURI+basePath+"/spartans"
        get("/spartans").prettyPeek();

    }
}
