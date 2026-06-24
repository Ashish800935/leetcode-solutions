class Solution {

    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;
        int S = 2 * m;

        long[][] T = new long[S][S];

        // state:
        // 0..m-1         => UP(v)
        // m..2m-1        => DOWN(v)

        for (int v = 0; v < m; v++) {

            // UP(v) -> DOWN(w), w < v
            for (int w = 0; w < v; w++) {
                T[v][m + w] = 1;
            }

            // DOWN(v) -> UP(w), w > v
            for (int w = v + 1; w < m; w++) {
                T[m + v][w] = 1;
            }
        }

        long[] init = new long[S];
        
        for (int v = 0; v < m; v++) {
            init[v] = v;          
            init[m + v] = m - 1 - v; 
        }

        long[][] P = matrixPower(T, n - 2);

        long[] finalVec = multiplyVector(init, P);

        long ans = 0;

        for (long x : finalVec) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[] multiplyVector(long[] vec, long[][] mat) {

        int n = vec.length;
        long[] res = new long[n];

        for (int j = 0; j < n; j++) {

            long cur = 0;

            for (int k = 0; k < n; k++) {
                cur = (cur + vec[k] * mat[k][j]) % MOD;
            }

            res[j] = cur;
        }

        return res;
    }

    private long[][] matrixPower(long[][] base, long exp) {

        int n = base.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {

            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }

            base = multiply(base, base);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {

        int n = A.length;

        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {

            for (int k = 0; k < n; k++) {

                if (A[i][k] == 0) continue;

                long a = A[i][k];

                for (int j = 0; j < n; j++) {

                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + a * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }
}