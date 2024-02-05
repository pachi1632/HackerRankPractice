package oneweekpreparation.squaregridstring;
/*
Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically, ascending. Determine if the columns are also in ascending alphabetical order, top to bottom. Return YES if they are or NO if they are not.
Example

The grid is illustrated below.
a b c
a d e
e f g
The rows are already in alphabetical order. The columns a a e, b d f and c e g are also in alphabetical order, so the answer would be YES. Only elements within the same row can be rearranged. They cannot be moved to a different row.
Function Description
Complete the gridChallenge function in the editor below.
gridChallenge has the following parameter(s):
string grid[n]: an array of strings
Returns
string: either YES or NO
Input Format
The first line contains , the number of testcases.
Each of the next  sets of lines are described as follows:
- The first line contains , the number of rows and columns in the grid.
- The next  lines contains a string of length
Constraints


Each string consists of lowercase letters in the range ascii[a-z]
Output Format
For each test case, on a separate line print YES if it is possible to rearrange the grid alphabetically ascending in both its rows and columns, or NO otherwise.
Sample Input
STDIN   Function
-----   --------
1       t = 1
5       n = 5
ebacd   grid = ['ebacd', 'fghij', 'olmkn', 'trpqs', 'xywuv']
fghij
olmkn
trpqs
xywuv
Sample Output
YES
Explanation
The x grid in the  test case can be reordered to
abcde
fghij
klmno
pqrst
uvwxy
* */

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        char[][] charArrayGrid = new char[grid.size()][grid.size()];
        for(int i=0; i< charArrayGrid.length; i++){
            charArrayGrid[i] = grid.get(i).toCharArray();
        }
        for(char[] gridElement : charArrayGrid){
            Arrays.sort(gridElement);
            System.out.println(String.valueOf(gridElement));
        }
        Boolean isAlphabeticalOrder = true;
        for(int j=0; j< charArrayGrid[0].length; j++){
            char[] verticalString = new char[charArrayGrid.length];
            for(int i=0; i<charArrayGrid.length; i++){
                verticalString[i] = charArrayGrid[i][j];
            }
            /*Method 1*/
            /*String str = String.valueOf(verticalString);
            char[] strSortedArr = Arrays.copyOf(verticalString, verticalString.length);
            Arrays.sort(strSortedArr);
            String strSorted = String.valueOf(strSortedArr);
            if(!str.equals(strSorted)){
                isAlphabeticalOrder = false;
                break;
            }*/
            /*Method 2*/
            for(int i=0; i< verticalString.length-1; i++){
                if(verticalString[i] > verticalString[i+1]){
                    isAlphabeticalOrder = false;
                    break;
                }
            }
        }
        return isAlphabeticalOrder ? "YES" : "NO";
    }

}

public class SquareGridString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

