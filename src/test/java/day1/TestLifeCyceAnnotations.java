package day1;

import org.junit.jupiter.api.*;
//test lifecycle annotations @BeforeAll @AfterAll @BeforeEach @AfterEach

@DisplayName("Learning Test Lifecycle Annotations")
public class TestLifeCyceAnnotations {

   @BeforeAll  //run only once before all the tests
   public static void inIt(){
       System.out.println("Before all is running");
   }

   @AfterAll //run once after all the test
   public static void close(){
       System.out.println("After all is running");
   }

   @BeforeEach
   public void inItEach(){
       System.out.println("Before each is running");
   }

   @AfterEach
   public void tearDownEach(){
       System.out.println("After each is running");
   }

    @Test
    public void test1(){
        System.out.println("Test1 is running");
    }

    @Disabled
    @Test
    public void test2(){
        System.out.println("Test2 is running");
    }

    //@ Disabled ignoring certain output of above test class
}
