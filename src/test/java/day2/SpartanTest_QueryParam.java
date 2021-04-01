package day2;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_Util.SpartanNoAuthBaseTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class SpartanTest_QueryParam extends SpartanNoAuthBaseTest {

    @DisplayName("Test GET /spartans/search Endpoint")
    @Test
    public void testSearch(){
        Response response =
                given()
                        .log().all()//this will log everything about request
                        .queryParam("nameContains","Princess Diana")
                        .queryParam("gender","Male").
                  when()
                        .get("spartan/search")
                        .prettyPeek()
                    ;
        // print the totalElement field value from the response
        System.out.println("response.path(\"totalElement\") = "
                + response.path("totalElement"));
    }

}
