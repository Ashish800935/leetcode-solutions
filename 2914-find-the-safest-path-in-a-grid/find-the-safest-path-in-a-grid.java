class Solution {

    int n;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    private boolean check(int[][] dist, int sf) {

        if (dist[0][0] < sf) return false;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        q.offer(new int[]{0,0});
        vis[0][0] = true;

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            if (x == n - 1 && y == n - 1)
                return true;

            for (int[] d : dirs) {

                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;

                if (vis[nx][ny])
                    continue;

                if (dist[nx][ny] < sf)
                    continue;

                vis[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }

        return false;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        n = grid.size();

        int[][] dist = new int[n][n];
        boolean[][] vis = new boolean[n][n];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] curr = q.poll();

                int x = curr[0];
                int y = curr[1];

                dist[x][y] = level;

                for (int[] d : dirs) {

                    int nx = x + d[0];
                    int ny = y + d[1];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                        continue;

                    if (vis[nx][ny])
                        continue;

                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }

            level++;
        }

        int low = 0;
        int high = 2 * n;      
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(dist, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
        