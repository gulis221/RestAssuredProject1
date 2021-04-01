package day5;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import test_Util.SpartanNoAuthBaseTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class CSVFileSourceParametrizedTest {

    //write a parametrized test for this request
    //get the data from csv source
    // SEND GET REQUEST TO http://api.zippopotam.us/us/{state}/{city}



    @ParameterizedTest
    @CsvFileSource(resources = "/state_city_zipCount.csv",numLinesToSkip = 1)
    public void testStateCityToEndPointWithCsvFile(String stateArg, String cityArg , int zipArg) {

        System.out.println("stateArg = " + stateArg);
        System.out.println("cityArg = " + cityArg);
        System.out.println("zipArg = " + zipArg);

        given()
                .baseUri("http://api.zippopotam.us")
                .pathParam("state",stateArg)
                .pathParam("city",cityArg)
                .log().uri().
        when()
                .get("us/{state}/{city}").
        then()
                .statusCode(200)
                .body("places",hasSize(zipArg))
                ;



    }
}