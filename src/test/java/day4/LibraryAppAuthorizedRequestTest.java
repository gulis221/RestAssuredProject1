package day4;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import pojo.Spartan;
import spartan_util.SpartanUtil;
import test_Util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_Util.SpartanNoAuthBaseTest;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_Util.LibraryAppBaseTest;

public class LibraryAppAuthorizedRequestTest extends LibraryAppBaseTest {



    @DisplayName("Get/get_user_by_id/{user_id}")
    @Test
    public void testOneUser(){


        System.out.println("myToken = " + librarianToken);
        given()
                .header("x-library-token",librarianToken)
                .pathParam("user_id",1).
        when()
                .get("get_user_by_id/{user_id}").
        then()
                .log().all()
                .statusCode(200)
                ;

    }

    @DisplayName("Get/get_all_users")
    @Test
    public void testGetAllUsers(){

        System.out.println("librarianToken = " + librarianToken);

        List<String> allNames =
        given()
                .header("x-library-token",librarianToken).
        when()
                .get("/get_all_users").
        then()
              //  .log().all()
                .statusCode(200).
        extract()
                .jsonPath()
                .getList("name", String.class)
                ;
        //assert the size is 8665
        assertThat(allNames.size(),is(8665));

        //print the unique names count
        Set<String> uniqueNames = new HashSet<>(allNames);
        System.out.println("uniqueNames.size() = " + uniqueNames.size());


    }

    @DisplayName("POST/add_book")
    @Test
    public void testAddOneBook(){

        Map<String, Object> myBookMap = new HashMap<>();
        myBookMap.put("name","Gulis");
        myBookMap.put("isbn","");
        myBookMap.put("year","2020");
        myBookMap.put("author","Gulis");
        myBookMap.put("book_category_id",4);
        myBookMap.put("description","my story");

        given()
                .log().all()
                .header("x-library-token",librarianToken)
                .contentType(ContentType.URLENC)
                //suing formParams with s we can pass multiple param in one shot
                .formParams(myBookMap).
        when()
                .post("/add_book").
        then()
                .log().all()
                .statusCode(200)
                ;



    }






    }
