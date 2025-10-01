class CellMultiplierThread extends Thread {
    private int row, col;
    private int[][] A, B, C;

    public CellMultiplierThread(int row, int col, int[][] A, int[][] B, int[][] C) {
        this.row = row;
        this.col = col;
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int k = 0; k < B.length; k++) {
            sum += A[row][k] * B[k][col];
        }
        C[row][col] = sum;
    }

    // Static method to use cell-based multithreading
    public static int[][] multiplyThreadPerCell(int[][] A, int[][] B) throws InterruptedException {
        int n = A.length;
        int m = B[0].length;
        int[][] C = new int[n][m];

        Thread[][] threads = new Thread[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                threads[i][j] = new CellMultiplierThread(i, j, A, B, C);
                threads[i][j].start();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                threads[i][j].join();
            }
        }

        return C;
    }
}
