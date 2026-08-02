class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[]used=new boolean[nums.length];
        helper(nums, res, ans, used);
        return res;
    }

    void helper(int[] nums, List<List<Integer>> res, List<Integer> ans,boolean[]used) {
        if (ans.size() == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }
       for(int i=0;i<nums.length;i++){
        if(used[i]) continue;
        if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;

        used[i]=true;
        ans.add(nums[i]);
        helper(nums,res,ans,used);
        ans.remove(ans.size()-1);
        used[i]=false;
       }

    }
}