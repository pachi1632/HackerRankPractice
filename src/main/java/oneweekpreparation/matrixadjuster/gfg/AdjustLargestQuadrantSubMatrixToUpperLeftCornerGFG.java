package oneweekpreparation.matrixadjuster.gfg;

// Java program to find maximum value of top N/2 x N/2
// matrix using row and column reverse operations

class AdjustLargestQuadrantSubMatrixToUpperLeftCornerGFG {

    static int maxSum(int mat[][])
    {
        int sum = 0;
        int maxI = mat.length;
        int maxIPossible = maxI - 1;
        int maxJ = mat[0].length;
        int maxJPossible = maxJ - 1;
        for (int i = 0; i < maxI / 2; i++) {
            for (int j = 0; j < maxJ / 2; j++) {
                // We can replace current cell [i, j]
                // with 4 cells without changing affecting
                // other elements.
                sum += Math.max(
                        Math.max(mat[i][j],
                                mat[maxIPossible - i][j]),
                        Math.max(mat[maxIPossible - i]
                                        [maxJPossible - j],
                                mat[i][maxJPossible - j]));
            }
        }
        return sum;
    }

    // Driven Program
    public static void main(String[] args)
    {
        int mat[][] = { { 112, 42, 83, 119 },
                { 56, 125, 56, 49 },
                { 15, 78, 101, 43 },
                { 62, 98, 114, 108 } };

        System.out.println(maxSum(mat));
    }
}
/* This Java code is contributed by Rajput-Ji*/
