class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
class Solution2{
    //solution1是定义一个递归判断每一颗树有没有满足要求，如果满足就删除，从上往下遍历，缺点是存在重复遍历
    //solution2直接用递归解决所有问题，自底向上pruning
    public TreeNode pruneTree(TreeNode root) {
        return pruned(root);
    }
    public TreeNode pruned(TreeNode root){
        // System.out.println("count " + (count+=1));
        // System.out.println("root" + root.val);
        // System.out.println(root.left);
        // System.out.println(root.right);
        TreeNode prunedLeft = root.left == null? null: pruned(root.left);
        TreeNode prunedRight = root.right == null? null : pruned(root.right);
        // if(prunedLeft!=null){
        //     System.out.println(prunedLeft.val);
        // }else{
        //     System.out.println("left null");
        // }
        // if(prunedRight!=null){
        //     System.out.println(prunedRight.val);
        // }else{
        //     System.out.println("right null");
        // }
        // System.out.println();
        
        root.left = prunedLeft;
        root.right = prunedRight;
        if(prunedLeft == null && prunedRight == null){
            if(root.val == 0 ){
                //System.out.println("return null");
                return null;
            }else{
                return root;
            }
        }
        return root;
    }
    public void printTree(TreeNode root){
        if(root.left!=null){
            printTree(root.left);
        }
        if(root != null){
            System.out.print(root.val+" ");
        }
        if(root.right!=null){
            printTree(root.right);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);

        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);


        // root.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(1);
        // root.left.left.left = new TreeNode(0);
        Solution2 s2 = new Solution2();
        TreeNode result = s2.pruneTree(root);
        s2.printTree(result);

    }
}