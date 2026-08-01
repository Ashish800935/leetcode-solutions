class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        helper(nums, res, ans, map);
        return res;
    }

    void helper(int[] nums, List<List<Integer>> res, List<Integer> ans, HashMap<Integer, Integer> map) {
        if (ans.size() == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }
       for (Integer key : map.keySet()){
        if(map.get(key)==0){
            continue;
        }
        map.put(key, map.get(key) - 1);
        ans.add(key);
        helper(nums,res,ans,map);
        ans.remove(ans.size()-1);
        map.put(key,map.get(key)+1);
       }

    }
}