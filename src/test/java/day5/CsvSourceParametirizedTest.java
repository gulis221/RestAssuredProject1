package day5;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import test_Util.SpartanNoAuthBaseTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class CsvSourceParametirizedTest {

    //test first number + second number = third number
    // i.e : 1,3 ,4

    @ParameterizedTest
    @CsvSource({
            "1, 3 , 4",
            "2, 3 , 5",
            "8, 7 , 15",
            "10, 9 , 19"
    })
    public void testAddition(int num1 , int num2 , int expectedResult ){
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("expectedResult = " + expectedResult);
        assertThat(num1+num2,equalTo(expectedResult));

    }

    //api.zippopotam.us/us/{{state}}/{{city}}
    @ParameterizedTest
    @CsvSource({
            "NY, New York",
            "CO, Denver",
            "VA, Fairfax",
            "VA, Arlington",
            "MA, Boston",
            "NY, New York",
            "MD, Annapolis"
    })
    public void testStateCityToZipEndpoint(String stateArg, String cityArg){

        System.out.println("stateArg = " + stateArg);
        System.out.println("cityArg = " + cityArg);

        int placeCount =
        given()
               .baseUri("https://api.zippopotam.us")
                .pathParam("state",stateArg)
                .pathParam("city",cityArg)
                .log().uri().
        when()
                .get("/us/{state}/{city}").
        then()
                .log().body()
                .statusCode(200)
        .extract()
                .jsonPath()
                .getList("places")
                .size()
                ;
        System.out.println("placeCount = " + placeCount);
        



    }




}
