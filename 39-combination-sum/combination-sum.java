class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,res,ans,0);
        return res;
        
    }
    void helper(int[] candidates, int target,List<List<Integer>>res,List<Integer>ans,int idx){
        if(target==0){
            res.add(new ArrayList<>(ans));
            return ;
        }
        for(int i=idx;i<candidates.length;i++){
            if(candidates[i]<=target){
                ans.add(candidates[i]);
                helper(candidates,target- candidates[i],res,ans,i);
                ans.remove(ans.size()-1);
            }
        }
    }
}