class Solution {
    public int splitArray(int[] nums, int k) {
        if (k > nums.length)
            return -1;
        long low = 0;
        long high = 0;
        for (int val : nums) {
            low = Math.max(val, low);
            high += val;
        }
        long ans = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (possible(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)ans;

    }

    boolean possible(int[] nums, int k, long maxsum) {

        int count = 1;
        long sum = 0;

        for (int val : nums) {

            if (sum + val > maxsum) {
                count++;
                sum = 0;
            }

            sum += val;
        }

        return count <= k;
    }
}