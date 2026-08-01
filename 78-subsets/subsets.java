class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        helper(nums,res,ans,0);
        return res;
        
    }
    void helper(int[] nums,List<List<Integer>>res,List<Integer>ans,int idx){
        if(idx==nums.length){
            res.add(new ArrayList<>(ans));
            return ;
        }
        
            ans.add(nums[idx]);
            helper(nums,res,ans,idx+1);
            ans.remove(ans.size()-1);
       
         helper(nums,res,ans,idx+1);
    }
}