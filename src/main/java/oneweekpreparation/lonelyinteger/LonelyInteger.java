package oneweekpreparation.lonelyinteger;
/*
Given an array of integers, where all elements but one occur twice, find the unique element.
Example

The unique element is .
Function Description
Complete the lonelyinteger function in the editor below.
lonelyinteger has the following parameter(s):
int a[n]: an array of integers
Returns
int: the element that occurs only once
Input Format
The first line contains a single integer, , the number of integers in the array.
The second line contains  space-separated integers that describe the values in .
Constraints

It is guaranteed that  is an odd number and that there is one unique element.
, where .
* */

import com.sun.xml.internal.rngom.parse.host.Base;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        Integer result = 0;
        for(Integer element: a){
            result ^= element;
        }

        return result;
    }

}

public class LonelyInteger  {
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
        int i=010;
        int j=07;
        System.out.println(i);
        System.out.println(j);
        System.out.println(3&5);
        System.out.println(3|5);
        short a= 1;
        try{
            (new BaseC()).method();
        } catch(Exception e){
            System.out.println("Inside main");
        }

        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = true;
        if(b1 & b2 | b2 & b3 | b2)
            System.out.println("Ok ");
        if(b1 & b2 | b2 & b3 | b2 | b1)
            System.out.println("dokey");

    }
    int add(int i, int j){
        return i+j;
    }
}

interface BaseI {void method();}


class BaseC extends LonelyInteger{
    public BaseC() throws IOException{
        System.out.println("Inside BaseC constructor");
        throw new IOException();
    }
    public void method(){
        System.out.println("Inside BaseC :: method");
    }
}

