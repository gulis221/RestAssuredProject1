package day2;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_Util.SpartanNoAuthBaseTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class SpartanTest_PathVariableQueryParam extends SpartanNoAuthBaseTest {

@DisplayName("Spartan test with path variable and query param")
    @Test
    public void getOneSpartan(){
    //get("/spartans/16").prettyPeek();

    // I want to provide 16 as path variable | parameter
    // I want to provide accept header
    Response r1=
    given()
            .header("Accept","application/json")
            .pathParam("blabla",16).
    when()
            .get("/spartans/{blabla}")
            .prettyPeek()
    ;

    Response r2=
    given()
            //This is same as .header("Accept","application/json")
            .accept("application/json").
    when()
            //this is alternative way of providing path variable
            //and value directly in get method
            .get("/spartans/{spartan_id}",16)
            .prettyPeek()
    ;




}





}
