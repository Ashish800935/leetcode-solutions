class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(grid,0,0,dp);
        
    }
    int helper(int[][]arr,int cr,int cc,int[][]dp){
        if(cr==arr.length-1 && cc==arr[0].length-1) return arr[cr][cc];
    if(cr>=arr.length || cc>=arr[0].length) return Integer.MAX_VALUE;
    if(dp[cr][cc]!=-1) return dp[cr][cc];

    int right=helper(arr,cr,cc+1,dp);
    int down=helper(arr,cr+1,cc,dp);
    return dp[cr][cc]=Math.min(right,down)+arr[cr][cc];
    }
    

}