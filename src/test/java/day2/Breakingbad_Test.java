package day2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_Util.SpartanNoAuthBaseTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Breakingbad_Test {

    //https://www.breakingbadapi.com/api/characters?name=Walter
    @BeforeAll
    public static void inIt(){
        baseURI = "https://www.breakingbadapi.com";
        basePath = "/api";
    }

    @AfterAll
    public static void cleanUp(){
        reset();
    }



    @Test
    public void testFilterCharacterName(){

        given()
                .log().uri()
                .queryParam("name","walter").

        when()
                .get("/characters").

        then()

                .log().all()
                .statusCode(200)
                .header("Content-Type","application/json; charset=utf-8")
                .contentType("application/json; charset=utf-8")
                ;

     }


     @DisplayName("Test/get/characters/{char_id}")
    @Test
    public void test1Character(){
        given()
                .pathParam("char_id",1)
                .log().uri().
        when()
                .get("/characters/{char_id}").
         then()
                .log().all()
                .statusCode(200)
                .header("Content-Type","application/json; charset=utf-8")
                .contentType("application/json; charset=utf-8")
                ;
    }
    //episode/60
    @DisplayName("Test Get/episodes/{episode_id}")
    @Test
    public void test1Episode(){

        given()
                .pathParam("episode_id",60)
                .log().all().
        when()
                .get("episodes/{episode_id}").
        then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                ;


    }




}
