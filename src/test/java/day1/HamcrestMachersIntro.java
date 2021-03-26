package day1;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMachersIntro {

    @DisplayName("Matchers related to numbers")
    @Test
    public void simpleTask() {
        //assert 10 equal to 5 + 5
        //this is the syntax for hamcrest way of assertion
        //assertThat(some actual value, some matcher that describe what you are trying to match
        assertThat(5 + 5, is(10));
        assertThat(5 + 5, equalTo(10));
        assertThat(5 + 5, is(equalTo(10)));

        //negative assertion 5+5 is not 11
        assertThat(5 + 5, not(11));
        assertThat(5 + 5, is(not(11)));
        assertThat(5 + 5, is(not(equalTo(11))));

        //number comparision
        //greaterThan()
        assertThat(5 + 5, is(greaterThan(9)));
        //lessThan()
        //greaterThanOrEqualTo()
        //lessThanOrEqualTo()
    }


       @DisplayName("Matchers related to string")
        @Test
        public void stringMatchers(){
            String msg = "B21 is learning Hamcrest";

            //checking for equality is same as above
           assertThat(msg,is("B21 is learning Hamcrest"));
           assertThat(msg,equalTo("B21 is learning Hamcrest"));
           assertThat(msg,is(equalTo("B21 is learning Hamcrest")));

           //check if the msg starts with B21
           assertThat(msg,startsWith("B21"));
           //now do it in case insensitive manner
           assertThat(msg,startsWithIgnoringCase("b21"));

           //check if the msg end with rest
           assertThat(msg,endsWith("rest"));
           //check if string contains string learning
           assertThat(msg,containsString("learning"));
           assertThat(msg,containsStringIgnoringCase("LEARNING"));

           String str = "   ";
           //check if above str is blank
           assertThat(str,blankString());

           //check if trimmed str is empty string
           assertThat(str.trim() , emptyString());
    }

        @DisplayName("Hamcrest Support for Collection")
       @Test
    public void testCollection(){
            List<Integer> lst = Arrays.asList(1,2,34,5,6,7,8,22);

            //checking the side of this list
            assertThat(lst,hasSize(8));
            //check if this list hasItem 7
            assertThat(lst,hasItem(7));
            //check if this list hasItems 7,8,22
            assertThat(lst,hasItems(7,8,22));



        }
}
