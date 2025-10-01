public class MatrixMultiplication {

    // Single-threaded matrix multiplication
    public static int[][] multiplyNormal(int[][] A, int[][] B) {
        int n = A.length;
        int m = B[0].length;
        int p = B.length;
        int[][] C = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}
