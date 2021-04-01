package day5;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test_Util.SpartanNoAuthBaseTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class ParameterizedTestInJunit5 {
    
    @ParameterizedTest
    @ValueSource( ints = {1,2,3,4,5,6,7,8,9,10}   )
    public void testPrintMultipleIteration(int num){
     //   int num = 10;
        System.out.println("num = " + num);
        assertTrue(num>5);

    }

    @ParameterizedTest
    @ValueSource(strings = {"Gulistan","Evren","Ayden","Hairigul"})
    public void testNames( String name){
        //AssertThat all the names has more than 4
        System.out.println("name = " + name);
        assertTrue(name.length()>5);
    }


    // SEND GET REQUEST TO http://api.zippopotam.us/us/{zipcode}
    // with these zipcodes 22030,22031, 22032, 22033 , 22034, 22035, 22036
    //check status code is 200
    
    @ParameterizedTest
    @ValueSource(shorts = {22030,22031, 22032, 22033 , 22034, 22035, 22036})
    
    public void testZipcodes(short zip){
        System.out.println("zipcode = " + zip);

        given()
                .baseUri("http://api.zippopotam.us")
                .log().all()
                .pathParam("zipcode", zip ).
        when()
                .get("us/{zipcode}").
        then()
                .statusCode(200)
                .log().all()
                ;


    }
    
    
    
    
    
}
