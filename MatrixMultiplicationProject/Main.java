import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        // Input matrix dimensions
        System.out.print("Enter number of rows for Matrix A: ");
        int r1 = sc.nextInt();
        System.out.print("Enter number of columns for Matrix A: ");
        int c1 = sc.nextInt();

        System.out.print("Enter number of rows for Matrix B: ");
        int r2 = sc.nextInt();
        System.out.print("Enter number of columns for Matrix B: ");
        int c2 = sc.nextInt();

        // Check matrix multiplication condition
        if (c1 != r2) {
            System.out.println("Matrix multiplication not possible! Columns of A must equal rows of B.");
            return;
        }

        int[][] A = new int[r1][c1];
        int[][] B = new int[r2][c2];

        // Input elements for Matrix A
        System.out.println("Enter elements of Matrix A:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // Input elements for Matrix B
        System.out.println("Enter elements of Matrix B:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        long start, end;

        // Normal Multiplication
        start = System.currentTimeMillis();
        int[][] C1 = MatrixMultiplication.multiplyNormal(A, B);
        end = System.currentTimeMillis();
        System.out.println("Normal Multiplication Time: " + (end - start) + " ms");

        // Thread per Row
        start = System.currentTimeMillis();
        int[][] C2 = RowMultiplierThread.multiplyThreadPerRow(A, B);
        end = System.currentTimeMillis();
        System.out.println("Thread per Row Multiplication Time: " + (end - start) + " ms");

        // Thread per Cell
        start = System.currentTimeMillis();
        int[][] C3 = CellMultiplierThread.multiplyThreadPerCell(A, B);
        end = System.currentTimeMillis();
        System.out.println("Thread per Cell Multiplication Time: " + (end - start) + " ms");

        sc.close();
    }

    // Helper function to print matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
