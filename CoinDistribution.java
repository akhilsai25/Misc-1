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
 // This solution uses approach to get the left over coins at every tree.
 // Then we consume one at the level and return left overs to the upper level
 // We calculate this at every level and bubble it up
class Solution {
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        if(root==null) return 0;
        distribute(root);
        return moves;
    }

    public int distribute(TreeNode root) {
        if(root==null) return 0;

        int left = distribute(root.left);
        int right = distribute(root.right);
        int leftOvers = left+right;
        int leftOversAfterUsed = leftOvers+root.val-1;
        moves+=Math.abs(leftOversAfterUsed);
        return leftOversAfterUsed;
    }
}
