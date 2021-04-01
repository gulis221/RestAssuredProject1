package day5;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_Util.SpartanNoAuthBaseTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class MovieAPI_Practice {

    @DisplayName("search movies JsonPath practice")
    @Test
    public void testSearch() {

        //GET http://www.omdbapi.com/?s=Superman&type=series&Your_API_KEY_GOES_HERE

        // if you do not have other place you are using it,
        // you directly provide it in given()

        JsonPath jp =
                given()
                        .baseUri("http://www.omdbapi.com")
                        .log().all()
                        .queryParam("apikey", "8e0505d8")
                        .queryParam("s", "Superman")
                        .queryParam("type", "series").
                        when()
                        .get().
                        then()
                        .log().all()
                        .statusCode(200)
                        //continue from here save Titles as list
                        .extract()
                        .jsonPath();
        List<String> allTitles = jp.getList("Search.Title", String.class);
        System.out.println("allTitles = " + allTitles);

        // assert the size of this list is 10
        // assertThat((allTitles.size()),is(10) );
        assertThat(allTitles, hasSize(10));

        // assert first item contains String Superman
        assertThat(allTitles.get(0), containsString("Superman"));

        // assert it has item "Superman and Lois"
        assertThat(allTitles, hasItem("Superman and Lois"));


        // assert it has items "Superman and Lois" , "The New Adventures of Superman"
        assertThat(allTitles, hasItems("Superman and Lois", "The New Adventures of Superman"));

        // assert all items contains superman
        assertThat(allTitles, everyItem(containsString("superman")));

    }


    @DisplayName("search movies JsonPath practice")
    @Test
    public void testSearch2() {

        //GET http://www.omdbapi.com/?s=Superman&type=series&Your_API_KEY_GOES_HERE

        // if you do not have other place you are using it,
        // you directly provide it in given()


        given()
                .baseUri("http://www.omdbapi.com")
                .log().all()
                .queryParam("apikey", "8e0505d8")
                .queryParam("s", "Superman")
                .queryParam("type", "series").
                when()
                .get().
                then()
                .log().all()
                .statusCode(200)
                .body("Search.Title", hasSize(10))
                .body("Search[0].Title",containsString("Superman"))
                .body("Search.Title",hasItems("Superman and Lois", "The New Adventures of Superman"))
                .body("Search.Title",everyItem(containsString("Superman")))
        ;

    }




}