/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.List;
import java.util.ArrayList;
class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
public class upsidetree {
    
    List<TreeNode> globalTreeNode = new ArrayList<>();
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null){
            return null;
        }
        readTheTree(root);

        TreeNode head = globalTreeNode.get(0);
        TreeNode pre = head;
        boolean isLeft = true;
        for(int i =1; i<globalTreeNode.size(); i++){
            if(isLeft){
                head.left = globalTreeNode.get(i);
                isLeft = false;
            }else{
                head.right = globalTreeNode.get(i);
                head = head.right;
                isLeft = true;
            }
        }
        return pre;
    }
    public void readTheTree(TreeNode node){
        if(node.right == null && node.left == null){
            globalTreeNode.add(node);
            return;
        }
        if(node.left != null){
            readTheTree(node.left);   
        }
        if(node.right != null){
            readTheTree(node.right);
        }
        globalTreeNode.add(node);
        
    }
    public static void main(String[] args){
        upsidetree u = new upsidetree();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        System.out.println(u.upsideDownBinaryTree(t).left.val);
        
    }
   
}