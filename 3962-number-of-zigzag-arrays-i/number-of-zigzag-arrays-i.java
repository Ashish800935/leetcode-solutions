class Solution {
    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        for (int b = 0; b < m; b++) {
            down[b] = b;
            up[b] = m - 1 - b;
        }

        if (n == 2) {
            long ans = 0;
            for (int i = 0; i < m; i++) {
                ans = (ans + up[i] + down[i]) % MOD;
            }
            return (int) ans;
        }

        for (int len = 3; len <= n; len++) {
            long[] prefUp = new long[m];
            long[] prefDown = new long[m];

            prefUp[0] = up[0];
            prefDown[0] = down[0];

            for (int i = 1; i < m; i++) {
                prefUp[i] = (prefUp[i - 1] + up[i]) % MOD;
                prefDown[i] = (prefDown[i - 1] + down[i]) % MOD;
            }

            long totalDown = prefDown[m - 1];

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            for (int y = 0; y < m; y++) {
                if (y > 0) {
                    newDown[y] = prefUp[y - 1];
                }

                newUp[y] = (totalDown - prefDown[y] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}