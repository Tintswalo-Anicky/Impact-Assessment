package numberrangesummarizer;
import java.util.*;
/**
 *
 * @author Anicky Tintswalo Makhubele
 */


public class Main implements NumberRangeSummarizer {

    public static void main (String [] args) {
        boolean summarized = false;

        do{
            try {
                System.out.println("Enter a list of Values separated by comma with no spaces:");
                Scanner scanObj = new Scanner(System.in);
                String input = scanObj.nextLine();

                NumberRangeSummarizer my_method = new Main();
                Collection<Integer> output = my_method.collect(input);
                String Result = my_method.summarizeCollection(output);
                System.out.println(Result);
                summarized=true;
                
            }
            
            /*
             * catch (NumberFormatException ex) { //Handle NumberFormat and NullPointer
             * exceptions here System.out.println("Empty"); }
             */
            catch (Exception e) {
                System.out.println("Incorrect Input. Enter numbers separated by comma with no spaces");
            }
        } while(summarized==false);
    }

    
    // Get input and store in an ArrayList
    @Override
    public Collection<Integer> collect(String input) {
        Collection<Integer> sorted = new ArrayList<>();

        int[] a = Arrays.stream(input.split(",")).map(Integer::parseInt).mapToInt(i->i).toArray(); // split array by comma and convert them to int
        Arrays.sort(a);
        for(int s: a){
            if (!sorted.contains(s))
                sorted.add(s);
        }

        return sorted;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        String finalstring="";  // String to be returned

        // Removes brackets and spaces from Arraylist and converts it to a String
        String new_input= input.toString();
        String str = new_input.replaceAll("\\[(.*?)\\]", "$1");
        str= str.replaceAll("\\s+","");

        // Converts String to an Array by Separating the values by a comma
        int[] a = Arrays.stream(str.split(",")).map(Integer::parseInt).mapToInt(i->i).toArray();

        int count=0;  // counter that keeps track of how many numbers are sequential
        int start=a[0]; // First value of a sequential pattern
        String temp=""+ a[0];  // String that stores the current pattern
        int end=a[0]; // Last value of sequential pattern

        for (int i = 0; i < a.length - 1; i++) {
            // Checks if Value is sequential
            if (a[i + 1] == a[i] + 1) {
                // check if value is start of sequential pattern- then stores its value
                if (count==0){
                    start= a[i];
                }
                end= a[i+1];
                count++;
            }

            // Else Value is not sequential
            else {
                if (count>0){
                    count=0;
                    temp = start+ "-"+ end;
                }
                finalstring= finalstring + temp+ ", ";
                temp= "" +(a[i+1]);
            }
        }
        // Checks if final value is part of a sequential pattern
        if (count>0){
            temp = start+ "-"+ end;
        }

        finalstring= finalstring + temp;
        return finalstring;
    }

}
// End of Class
