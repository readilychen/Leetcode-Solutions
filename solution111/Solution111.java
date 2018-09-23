/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        findMin(root, 1);
        return min;
    }
    public void findMin(TreeNode root,int depth){
        if(root.left == null && root.right == null){
            min = min < depth? min : depth;
            return;
        }
        if(root.left != null){
            findMin(root.left, depth+1);
        }
        if(root.right != null){
            findMin(root.right,depth+1);
        }
    }
}