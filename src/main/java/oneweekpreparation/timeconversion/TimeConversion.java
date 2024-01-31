package oneweekpreparation.timeconversion;

/*
Given a time in -hour AM/PM format, convert it to military (24-hour) time.
Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
Example

Return '12:01:00'.

Return '00:01:00'.
Function Description
Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.
timeConversion has the following parameter(s):
string s: a time in  hour format
Returns
string: the time in  hour format
Input Format
A single string  that represents a time in -hour clock format (i.e.:  or ).
Constraints
All input times are valid
Sample Input
07:05:45PM
Sample Output
19:05:45
* */

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("hh:mm:ssa");
        LocalTime inputTime = LocalTime.parse(s, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return inputTime.format(outputFormatter);
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

