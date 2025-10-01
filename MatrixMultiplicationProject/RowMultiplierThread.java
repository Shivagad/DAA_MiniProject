class RowMultiplierThread extends Thread {
    private int row;
    private int[][] A, B, C;

    public RowMultiplierThread(int row, int[][] A, int[][] B, int[][] C) {
        this.row = row;
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    public void run() {
        int cols = B[0].length;
        int p = B.length;

        for (int j = 0; j < cols; j++) {
            for (int k = 0; k < p; k++) {
                C[row][j] += A[row][k] * B[k][j];
            }
        }
    }

    // Static method to use row-based multithreading
    public static int[][] multiplyThreadPerRow(int[][] A, int[][] B) throws InterruptedException {
        int n = A.length;
        int m = B[0].length;
        int[][] C = new int[n][m];

        Thread[] threads = new Thread[n];
        for (int i = 0; i < n; i++) {
            threads[i] = new RowMultiplierThread(i, A, B, C);
            threads[i].start();
        }

        for (int i = 0; i < n; i++) {
            threads[i].join();
        }

        return C;
    }
}
