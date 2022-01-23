# Impact-Assessment

This is a repository for a java Assessment from Impact where the aim is to produce a comma delimited list of numbers and grouping the numbers into a range when they are sequential. <br />Example: <br />

Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31 <br />
Result: "1, 3, 6-8, 12-15, 21-24, 31" <br />
The following classes were used: <br />

interface NumberRangeSummarizer : interface was given and these methods have to be implemented<br />
Main: implemented NumberRangeSummarizer to produce the lists <br />
TestClass: class that used JUnit to test the Main class to ensure the program is working correctly <br />
The following assumptions were made: <br />

The input given must be numbers separated by commas and with no spaces (eg. 1,5,6,7,8)
The input can consist of both negative and non-negative values
The input given is not always in ascending order (i.e not always sorted)
The input can consist of duplicate values
Values are sequential if at least 2 values follows (eg. 1,3,4 ---> 1, 3-4)
The following Testing was completed using Junit:

Collect method (collect()): This tests the collect method and checks if the correct input is given it will return the correct list
summarize method (summarize()): This tests the summarizeCollection method and check if a valid list is passed in the method it will return the correct string as a summarized sequential list
sequential (sequential()): This test if values are grouped accordingly if it is sequential
Acceptance of duplicate values (duplicate()): This tests if the program will accept duplicate values and still produce the correct summarized sequential list
Values entered are not in ascending order (order()): This tests if the program will work if values entered are not sorted in ascending order
No input given (NoInput()): This test checks if error handling is produced when provided with an empty string
Acceptance of negative values (negative()): This test the acceptance of negative values as input and that it produces the correct result
Letters as input (letters()): This test checks if error handling is produced when provided with letters and not numbers string
