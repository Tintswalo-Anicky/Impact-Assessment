package numberrangesummarizer;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
/**
 *
 * @author Anicky Tintswalo Makhubele
 */

public class TestClass {

    @Test// Testing Collect method takes in a String and produces a List
    public void collect() throws Exception{

        NumberRangeSummarizer my_method = new Main();
        Collection<Intege

        NumberRangeSummarizer my_method = new Main();
        String input= "1,3,6,7,8,12,13,14,15,21,22,23,24,31" ;
        String compare= "1, 3, 6-8, 12-15, 21-24, 31"; // The final result
        Collection<Integer> output = my_method.collect(input);
        String Result = my_method.summarizeCollection(output);r> testList = Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31);
        String input= "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> list = my_method.collect(input);
        assertArrayEquals(list.toArray(),testList.toArray());

	}

    @Test// Test summarizeCollection class
    public void summarize() throws Exception{
        assertEquals(compare, Result);
    }

    @Test // Test if sequential values are grouped
    public void sequential() throws Exception{

        NumberRangeSummarizer my_method = new Main();
        String input= "1,3,4,5,5,7,8,9,10,11" ;
        String compare= "1, 3-5, 7-11"; // The final result
        Collection<Integer> output = my_method.collect(input);
        String Result = my_method.summarizeCollection(output);
        assertEquals(Result, compare);

    }


    @Test// Test for allowance of duplicates
    public void duplicate() throws Exception{

        NumberRangeSummarizer my_method = new Main();
        String input= "1,3,3,5,5,7,9,11,12,12,13,14,16" ;
        String compare= "1, 3, 5, 7, 9, 11-14, 16"; // The final result
        Collection<Integer> output = my_method.collect(input);
        String Result = my_method.summarizeCollection(output);
        assertEquals(Result, compare);

    }


    @Test // Test if input given is not in order and still gives the correct output
    public void order() throws Exception{

        NumberRangeSummarizer my_method = new Main();
        String input= "1,11,5,4,5,9,8,7,10,3" ;
        String compare= "1, 3-5, 7-11"; // The final result
        Collection<Integer> output = my_method.collect(input);
        String Result = my_method.summarizeCollection(output);
        assertEquals(Result, compare);

    }

    @Test // Test if given negative values
    public void negative() throws Exception{

        NumberRangeSummarizer my_method = new Main();
        String input= "-8,-6,-1,1,4,5,6,7,8,9,13" ;
        String compare= "-8, -6, -1, 1, 4-9, 13"; // The final result
        Collection<Integer> output = my_method.collect(input);
        String Result = my_method.summarizeCollection(output);
        assertEquals(Result, compare);

    }
    
    
    // Test if letters are given as input
    @Test (expected=Exception.class)
    public void letters() throws Exception{

        String input="1,2,3,5,f,h,8,9";
        NumberRangeSummarizer my_method = new Main();
        Collection<Integer> output = my_method.collect(input);
        my_method.summarizeCollection(output);


    }

    // Test if input is an empty String	
    @Test (expected= Exception.class)  
    public void NoInput() { 
        String input="";
        NumberRangeSummarizer my_method = new Main();
        Collection<Integer> output = my_method.collect(input);
        my_method.summarizeCollection(output);

    }

}
