public class solution110{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(4);
        root.left = left;
        root.right = right;
        left.right = new TreeNode(3);
        left.left = new TreeNode(6);
        right.right = new TreeNode(2);
        right.left = new TreeNode(9);
        solution110 s110 = new solution110();
        System.out.println("Tree1's height"+ s110.height(root));
        System.out.println("Tree1 is a height-balanced tree? "+ s110.isBalanced(root));


        TreeNode root2 = new TreeNode(6);
        TreeNode left2 = new TreeNode(2);
        root2.left = left2;
        TreeNode leftleft = new TreeNode(1);
        TreeNode leftright = new TreeNode(5);
        left2.left = leftleft;
        left2.right = leftright;
         System.out.println("Tree2's height"+ s110.height(root2));
        System.out.println("Tree2 is a height-balanced tree? "+ s110.isBalanced(root2));


    }
    //recurisively determine whether the tree is a height-balanced binary tree
    public boolean isBalanced(TreeNode root){
        if(root!=null){
            if(Math.abs(treeHeight(root.right)-treeHeight(root.left))>1){
                return false;
            }else{
                if(root.left == null && root.right !=null){
                    return isBalanced(root.right);
                }else if(root.left != null && root.right ==null){
                    return isBalanced(root.left);
                }else if(root.left != null && root.right !=null){
                    return isBalanced(root.left) && isBalanced(root.right);
                }else{
                    return true;
                }
            }
        }else{
            return true;
        }
        
    }
    //given the tree's root get the height of the tree
    public int treeHeight(TreeNode root){
        if(root == null){
            return -1;
        }else{
            return 1+Math.max(treeHeight(root.left),treeHeight(root.right));
        }
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x){
        val = x;
    }
}