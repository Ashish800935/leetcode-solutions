class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        boolean[]track=new boolean[nums.length];
        helper(nums,res,ans,track);
        return res;
        
    }
    void helper(int[] nums,List<List<Integer>>res,List<Integer>ans,boolean[]track){
        if(ans.size()==nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!track[i]){
                track[i]=true;
                ans.add(nums[i]);
                helper(nums,res,ans,track);
                ans.remove(ans.size()-1);
                track[i]=false;
            }
        }
    }
}