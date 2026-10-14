/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left,root.right);
    }
    boolean helper(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null|| q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        boolean f1=helper(p.left,q.right);
        boolean f2=helper(p.right,q.left);
        return f1 && f2;
    }
}