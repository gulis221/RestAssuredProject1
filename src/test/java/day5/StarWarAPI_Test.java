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

public class StarWarAPI_Test {

//    Interview Questions :
//    Send request to  GET https://swapi.dev/api/people/
//    Find out average height of all people showed up in the response


    @BeforeAll
    public static void init(){
        baseURI ="https://swapi.dev";
        basePath ="/api";
    }

    @AfterAll
    public static void cleanUp(){
        reset();
    }

    @DisplayName("Get average Hight from GET/ people response")
    @Test
    public void testGetAverageHeight(){

        List<Integer> allHeights = get("/people")
                                    .jsonPath()
                                    .getList("results.height",Integer.class)
                                    ;
        System.out.println("allHeights = " + allHeights);

        int total = 0;
        for (Integer height : allHeights) {
            total+=height;
        }
        int average = total/(allHeights.size());
        System.out.println("average = " + average);

    }

    @DisplayName("Get all the heights from all the pages and find average")
    @Test
    public void testGetAllPagesAverageHeight(){

        List<Integer> allHeights = new ArrayList<>();

        //send initial request, find total count and decied how many pages exist
        JsonPath jp = get("/people").jsonPath();
        int peopleCount = jp.getInt("count"); //82
        //if there is a remainder we want to add 1, if there is not keep it as is
        int pageCount = (peopleCount % 10 == 0)? peopleCount / 10 : (peopleCount /10)+1;

        List<Integer> firstPageHeights = jp.getList("results.height",Integer.class);
        allHeights.addAll(firstPageHeights);

        //now it is time to loop and get the rest of the pages
        for (int pageNum=2; pageNum<=pageCount ; pageNum++){

            List<Integer> heightsOnThisPage = get("/people?page = " +pageNum)
                                                .jsonPath()
                                                .getList("results.height",Integer.class);

            allHeights.addAll(heightsOnThisPage);

        }

        System.out.println("allHeights = " + allHeights);

        int total = 0;
        for (Integer height : allHeights) {
            total+=height;
        }
        int average = total/(allHeights.size());
        System.out.println("average = " + average);



    }


}
