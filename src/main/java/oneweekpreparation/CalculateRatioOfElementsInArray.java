package oneweekpreparation;

/*
Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the decimal value of each fraction on a new line with  places after the decimal.
Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to  are acceptable.
Example

There are  elements, two positive, two negative and one zero. Their ratios are ,  and . Results are printed as:
0.400000
0.400000
0.200000
Function Description
Complete the plusMinus function in the editor below.
plusMinus has the following parameter(s):
int arr[n]: an array of integers
Print
Print the ratios of positive, negative and zero values in the array. Each value should be printed on a separate line with  digits after the decimal. The function should not return a value.
Input Format
The first line contains an integer, , the size of the array.
The second line contains  space-separated integers that describe .
Constraints


Output Format
Print the following  lines, each to  decimals:
proportion of positive values
proportion of negative values
proportion of zeros
Sample Input
STDIN           Function
-----           --------
6               arr[] size n = 6
-4 3 -9 0 4 1   arr = [-4, 3, -9, 0, 4, 1]
Sample Output
0.500000
0.333333
0.166667
Explanation
There are  positive numbers,  negative numbers, and  zero in the array.
The proportions of occurrence are positive:  , negative:  and zeros:  .


Input (stdin)
5
0 0 -1 1 1

Expected Output
0.400000
0.200000
0.400000
* * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        Integer positiveNumbers = 0;
        Integer negetiveNumbers = 0;
        Integer zeroNumbers = 0;
        for(Integer element : arr){
            if(element > 0 ){
                positiveNumbers++;
            } else if(element < 0){
                negetiveNumbers++;
            }
            else{
                zeroNumbers++;
            }
        }
        BigDecimal positivePercentage = new BigDecimal(positiveNumbers).divide(new BigDecimal(arr.size()), 6, RoundingMode.HALF_UP);
        BigDecimal negetivePercentage = new BigDecimal(negetiveNumbers).divide(new BigDecimal(arr.size()), 6, RoundingMode.HALF_UP);
        BigDecimal zeroPercentage = new BigDecimal(zeroNumbers).divide(new BigDecimal(arr.size()), 6, RoundingMode.HALF_UP);
        System.out.println(positivePercentage);
        System.out.println(negetivePercentage);
        System.out.println(zeroPercentage);
    }

}

public class CalculateRatioOfElementsInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

