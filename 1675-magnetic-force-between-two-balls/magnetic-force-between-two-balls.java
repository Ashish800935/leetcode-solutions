class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = 0;

        for (int val : position) {
            high = Math.max(high, val);
        }
        int ans = high;
        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (valid(position, m, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;

    }

    boolean valid(int[] position, int m, int force) {

        int count = 1;
        int last = position[0];

        for (int i = 1; i < position.length; i++) {

            if (position[i] - last >= force) {
                count++;
                last = position[i];
            }

            if (count == m) {
                return true;
            }
        }

        return false;
    }
}