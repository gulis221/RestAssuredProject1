package test_Util;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class LibraryAppBaseTest {

    public static String librarianToken ;

    @BeforeAll
    public static void init(){
        baseURI  = "http://library1.cybertekschool.com" ;
        basePath = "/rest/v1" ;
        librarianToken =
                getToken("Librarian69@Library","KNPXrm3S");
    }

    public static String getToken(String username , String password){
        return given()
                    .contentType(ContentType.URLENC)
                    .formParam("email",username)
                    .formParam("password",password).
                 when()
                    .post("/login")
                    .path("token")
                     ;
    }

    public static Map<String,Object> getRandomBook(){
        Faker faker = new Faker();
        Map<String,Object> myBookMap = new HashMap<>();
        myBookMap.put("name", faker.book().title()      );
        myBookMap.put("isbn", faker.number().digits(8) );
        myBookMap.put("year", faker.number().numberBetween(1600, 2021));
        myBookMap.put("author",faker.book().author() );
        myBookMap.put("book_category_id", faker.number().numberBetween(1,20)  );
        myBookMap.put("description",faker.chuckNorris().fact()  );
        return myBookMap ;
    }


    @AfterAll
    public static void cleanUp(){
        reset();
    }

}
