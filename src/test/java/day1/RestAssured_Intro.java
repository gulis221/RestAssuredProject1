package day1;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.* ;

@DisplayName("Intro to RestAssure")
public class RestAssured_Intro {

@Test
    public void testHelloEndpoint(){

    //http://18.235.32.166:8000/api/hello
    Response response = get("http://34.202.173.245:8000/api/hello");
    //extracting information from Response object
    //getting status code
    System.out.println("response.statusCode() = " + response.statusCode());
    System.out.println("response.getStatusCode() = " + response.getStatusCode());
    //getting specific header
    System.out.println("response.getHeader(\"Content-Type\") = " +
            response.getHeader("Content-Type"));
    System.out.println("response.getContentType() = " + response.getContentType());

    //getting the time spent for execution
    System.out.println("response.time() = " + response.time());
    System.out.println("response.getTime() = " + response.getTime());


    //getting body as string
    System.out.println("response.asString() = " + response.asString());

    assertThat( response.statusCode(),is(200));
    assertThat(response.getContentType(),is("text/plain;charset=UTF-8"));
    assertThat(response.contentType(),is(startsWith("text/plain")));
    assertThat(response.asString(),is("Hello from Sparta"));


    //printing the result
    //prettyPrint() -->print and return string
    //prettyPeek()-->print and return same Response Object

    System.out.println("response.prettyPrint() = " + response.prettyPrint());
    System.out.println("response.prettyPeek() = " + response.prettyPeek());
}

  @DisplayName("Testing Get/api/spartans/{id} Endpoint")
    @Test
    public void testSingleSpartan(){
    String url = "http://34.202.173.245:8000";
    Response response = get(url+"/api/spartans/10").prettyPeek();
   // response.prettyPrint();

      assertThat(response.statusCode(),is(equalTo(200)));
      assertThat(response.contentType(),is("application/json"));
      assertThat(response.header("Connection"),equalTo("keep-alive"));
     // System.out.println(response.asString());

      //getting the field value of Json body
      //path method
      System.out.println("response.path(\"id\") = " + response.path("id"));
      System.out.println("response.path(\"name\") = " + response.path("name"));
      System.out.println("response.path(\"gender\") = " + response.path("gender"));
      System.out.println("response.path(\"phone\") = " + response.path("phone"));

      //save id and name into specific data type
      int myId = response.path("id");
      String myName = response.path("name");
      Long phoneNumber = response.path("phone");
      String gender = response.path("gender");

      System.out.println("myId = " + myId);
      System.out.println("myName = " + myName);
      System.out.println("phoneNumber = " + phoneNumber);
      System.out.println("gender = " + gender);


  }

}
