
class Solution1 {
    int value;
    public boolean isUnivalTree(TreeNode root) {
        value = root.val;
        return isUnivalPreOrder(root);
        // return isUnivalPostOrder(root);
    }
    public boolean isUnivalPreOrder(TreeNode root){
        boolean b3 = true;
        if(root != null){
            b3 =  root.val == value;
        }else{
            return true;
        }
        boolean b1 = isUnival(root.left);
        boolean b2 = isUnival(root.right);
        return b1 && b2 && b3;
    }
    public boolean isUnivalPostOrder(TreeNode root){
        if(root.left == null && root.right == null){
            if(root.val == value){
                return true;
            }else{
                return false;
            }
        }
        boolean b1 = true;
        if(root.left != null){
           b1 = isUnival(root.left);
        }
        boolean b2 = true;
        if(root.right != null){
            b2 = isUnival(root.right);
        }
        boolean b3 = root.val == value;
        return b1 && b2 && b3;
    }
}
