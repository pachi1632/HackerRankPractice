package oneweekpreparation.minmaxsum;

/*
Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.
Example

The minimum sum is  and the maximum sum is . The function prints
16 24
Function Description
Complete the miniMaxSum function in the editor below.
miniMaxSum has the following parameter(s):
arr: an array of  integers
Print
Print two space-separated integers on one line: the minimum sum and the maximum sum of  of  elements.
Input Format
A single line of five space-separated integers.
Constraints

Output Format
Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit integer.)
Sample Input
1 2 3 4 5
Sample Output
10 14
Explanation
The numbers are , , , , and . Calculate the following sums using four of the five integers:
Sum everything except , the sum is .
Sum everything except , the sum is .
Sum everything except , the sum is .
Sum everything except , the sum is .
Sum everything except , the sum is .
Hints: Beware of integer overflow! Use 64-bit Integer.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        Integer minSum = arr.stream().limit(4).mapToInt(Integer::intValue).sum();
        Integer maxSum = arr.stream().skip(arr.size()-4).mapToInt(Integer::intValue).sum();
        System.out.println(minSum+" "+maxSum);
    }

}

public class MinMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}

