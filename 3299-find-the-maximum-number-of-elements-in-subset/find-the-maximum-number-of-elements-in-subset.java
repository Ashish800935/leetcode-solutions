class Solution {
    public int maximumLength(int[] nums) {

        Map<Long, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put((long) num, map.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        if (map.containsKey(1L)) {
            int cnt = map.get(1L);
            ans = Math.max(ans, cnt % 2 == 0 ? cnt - 1 : cnt);
        }
        
        for (long start : map.keySet()) {

            if (start == 1) continue;

            long curr = start;
            int len = 0;

            while (true) {

                int freq = map.getOrDefault(curr, 0);

                if (freq >= 2) {
                    len += 2;
                    curr = curr * curr;
                }
                else if (freq == 1) {
                    len++;
                    break;
                }
                else {
                    if (len > 0)
                        len--;      
                    break;
                }
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}