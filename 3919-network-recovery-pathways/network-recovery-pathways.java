import java.util.*;

class Solution {

    int n;
    List<int[]>[] graph;
    long k;

    private boolean check(int minEdgeCost) {

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        pq.offer(new long[]{0, 0}); // {distance, node}

        while (!pq.isEmpty()) {

            long[] cur = pq.poll();

            long d = cur[0];
            int u = (int) cur[1];

            if (d != dist[u])
                continue;

            if (d > k)
                continue;

            if (u == n - 1)
                return true;

            for (int[] edge : graph[u]) {

                int v = edge[0];
                int cost = edge[1];

                if (cost < minEdgeCost)
                    continue;

                if (dist[u] + cost < dist[v]) {

                    dist[v] = dist[u] + cost;
                    pq.offer(new long[]{dist[v], v});
                }
            }
        }

        return false;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        this.k = k;
        this.n = online.length;

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int left = Integer.MAX_VALUE;
        int right = 0;

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            if (!online[u] || !online[v])
                continue;

            graph[u].add(new int[]{v, cost});

            left = Math.min(left, cost);
            right = Math.max(right, cost);
        }

        if (left == Integer.MAX_VALUE)
            return -1;

        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (check(mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}