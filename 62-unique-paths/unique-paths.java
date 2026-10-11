class Solution {
    public int uniquePaths(int m, int n) {
        int[][]dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(m,n,0,0,dp);
        
    }
    int helper(int m,int n,int col,int row,int[][]dp){
        if(col==n-1 && row==m-1) return 1;
        if(col>=n || row==m) return 0;
        if(dp[row][col]!=-1) return dp[row][col];
        int right=helper(m,n,col+1,row,dp);
        int down=helper(m,n,col,row+1,dp);
        return dp[row][col]=right+down;
    }
}