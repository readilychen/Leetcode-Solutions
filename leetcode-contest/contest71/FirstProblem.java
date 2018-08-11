class FirstProblem{
    int minDis = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        iterateTree(root);
        return minDis;
    }
    public void iterateTree(TreeNode root){
        if(root!=null){
            int leftV = leftSide(root);
            int rightV = rightSide(root);
            int tempV = leftV <= rightV ? leftV:rightV;
            if(tempV < minDis){
                minDis = tempV;
            }
        }else{
            return;
        }
        iterateTree(root.right);
        iterateTree(root.left);
    }
    public int leftSide(TreeNode t){
        int nodeV = t.val;
        if(t.left!=null){
            t = t.left;
        }else{
            return Integer.MAX_VALUE;
        }
        int finalV = t.val;
        while(t.right!=null){
            t = t.right;
            finalV = t.val;
        }
        return nodeV - finalV;
    }
    public int rightSide(TreeNode t){
        int nodeV = t.val;
        if(t.right!=null){
            t = t.right;
        }else{
            return Integer.MAX_VALUE;
        }
        int finalV = t.val;
        while(t.left !=null){
            t = t.left;
            finalV = t.val;
        }
        return finalV - nodeV;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);

        FirstProblem fp = new FirstProblem();
        System.out.println(fp.minDiffInBST(root));

    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}