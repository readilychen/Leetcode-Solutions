class solution776{
     public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode smallerEqual = null;
        TreeNode larger = null;
        TreeNode smallerEqualHead=null;
        TreeNode largerHead=null;
        TreeNode currentNode = root;
        while(true){
            if(currentNode == null){
                break;
            }
            if(currentNode.val > V){
                if(larger == null){
                    larger = new TreeNode(currentNode.val);
                    larger.right = currentNode.right;
                    largerHead = larger;
                    currentNode = currentNode.left;
                }else{
                    larger.left = new TreeNode(currentNode.val);
                    larger.left.right = currentNode.right;
                    larger = larger.left;
                    currentNode = currentNode.left;
                }
            }else if(currentNode.val < V){
                if(smallerEqual == null){
                    smallerEqual = new TreeNode(currentNode.val);
                    smallerEqual.left = currentNode.left;
                    smallerEqualHead = smallerEqual;
                    currentNode = currentNode.right;
                }else{
                    smallerEqual.right=new TreeNode(currentNode.val);
                    smallerEqual.right.left = currentNode.left;
                    smallerEqual = smallerEqual.right;
                    currentNode = currentNode.right;
                }
            }else if(currentNode.val == V){
                if(larger == null){
                    larger = currentNode.right;
                    largerHead = larger;
                }else{
                    larger.left = currentNode.right;
                }
                if(smallerEqual == null){
                    smallerEqual = new TreeNode(currentNode.val);
                    smallerEqual.left = currentNode.left;
                    smallerEqualHead = smallerEqual;
                }else{
                    smallerEqual.right=new TreeNode(currentNode.val);
                    smallerEqual.right.left = currentNode.left;
                }
                break;
            }
        }
        TreeNode[] result = {smallerEqualHead,largerHead};
        return result;
    }
    public static void main(String[] args) {
        TreeNode troot = new TreeNode(4);
        troot.left = new TreeNode(2);
        troot.right = new TreeNode(6);
        troot.left.left = new TreeNode(1);
        troot.left.right = new TreeNode(3);
        troot.right.left = new TreeNode(5);
        troot.right.right = new TreeNode(7);
        solution776 s776 =new solution776();
        TreeNode[] result = s776.splitBST(troot,0);
        System.out.println(result[0].val);
    }
}
class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;
    TreeNode(int val){
        this.val = val;
    }
}