package oneweekpreparation.matrixadjuster;

/*

Question:

Given 2n by 2n matrix of Integer List, write a program in java 8  to adjust the matrix by reversing rows and columns such that upper left quadrant of the matrix have maximum sum of elements

Web links:
https://www.geeksforgeeks.org/maximize-sum-n-x-n-upper-left-sub-matrix-given-2n-x-2n-matrix/

Answer:

Given the need to maximize the sum in the upper-left quadrant of the matrix and the expectation that the elements in the first quadrant should be the maximum possible (e.g., 16, 15, 14, 13 for a 4x4 matrix), we should refine the approach. The goal is to ensure that the top left quadrant contains the highest values possible by comparing and potentially swapping elements within the matrix. However, the previously suggested approaches didn't correctly achieve this, especially considering your expectation.

We'll adopt a straightforward strategy to directly address your requirement. The approach will involve:

1. Iterating through each element in the matrix.
2. For each element in the first quadrant, compare it with the corresponding elements in the other three quadrants.
3. Ensure the maximum of each of these four elements ends up in the upper-left quadrant.
4. This requires a check and potential swap not just in a single direction (row or column), but potentially swapping elements across both rows and columns to ensure the maximum element is positioned correctly.

However, based on your feedback and the expected output, it seems there might have been a misunderstanding in the approach. To achieve exactly the output you're expecting, where the first quadrant consists of the highest values (16, 15, 14, 13 for a 4x4 matrix), a different strategy is needed, focusing on globally finding and placing the highest values in the upper-left quadrant.

Let's correct the approach with a simpler logic: to ensure the upper-left quadrant has the maximum elements, we'll compare all elements and directly swap the max elements to the upper left, quadrant by quadrant. But, given your specific output expectation, it seems we need to ensure that the elements are not just maximized locally (within their quadrants) but arranged so the entire upper-left quadrant has the globally maximum elements.

Given this, the simplest way to ensure the upper left quadrant of a 2n x 2n matrix has the maximum sum, based on your description, would be to:
- Flatten the matrix into a single list.
- Sort this list to identify the largest n*n elements.
- Place these elements into the upper-left quadrant.

This approach, however, diverges from typical matrix manipulation as it reconstructs the matrix rather than swapping rows/columns based on conditions. If the primary goal is truly to have the highest values (like 16, 15, 14, 13) in the first quadrant without regard to the positions of other elements, a tailored solution that directly places these values into the quadrant is needed, which might not involve typical row/column swaps.

For a Java solution that sorts the entire matrix and rearranges the elements so that the highest values are in the top-left quadrant, a complete rewrite of the logic would be necessary, focusing on sorting and then placing elements. However, this would essentially rebuild the matrix from sorted values rather than adjusting it through swaps.

To address your immediate need with specific expected output, could you clarify if the adjustment should strictly involve swapping rows/columns, or if a more flexible approach to directly place the highest values in the upper-left is acceptable?
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjustLargestQuadrantSubMatrixToUpperLeftCorner {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        maximizeUpperLeftQuadrant(matrix);
        printMatrix(matrix);
    }

    private static void maximizeUpperLeftQuadrant(int[][] matrix) {
        int n = matrix.length;
        List<Integer> elements = new ArrayList<>();

        // Flatten the matrix into a list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                elements.add(matrix[i][j]);
            }
        }

        // Sort the list to get the largest elements at the end of the list
        Collections.sort(elements);

        // Place the largest n*n/4 elements into the upper-left quadrant
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                // The index calculation here ensures we're grabbing from the largest elements for the upper-left quadrant
                matrix[i][j] = elements.get(elements.size() - (n * n / 4) + (i * (n / 2)) + j);
            }
        }

        // Fill the rest of the matrix with the remaining elements
        int index = 0; // Start from the beginning of the sorted list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Skip the upper-left quadrant
                if (i < n / 2 && j < n / 2) continue;

                matrix[i][j] = elements.get(index++);
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}



