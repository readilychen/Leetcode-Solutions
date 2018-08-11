class LCA{
    boolean hasP = false;
    boolean hasQ = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return getLCA(root,p,q);
    }
    public TreeNode getLCA(TreeNode root,TreeNode p, TreeNode q){
        while(root!= null){
            containsNode1(root.left,p,q);
            boolean rootleftContainsq = hasQ;
            boolean rootleftContainsp = hasP; 
            hasP = false;
            hasQ = false;
            containsNode1(root.right,p,q);
            boolean rootrightContainsq = hasQ;
            boolean rootrightContainsp = hasP;
            hasP =false;
            hasQ = false;
            if(root.val == p.val || root.val == q.val){
                if(rootleftContainsp||rootleftContainsq||rootrightContainsp||rootrightContainsq){
                    return root;
                }
            }
            if((rootrightContainsp&& rootleftContainsq)||(rootrightContainsq&&rootleftContainsp)){
                if(rootleftContainsp&& rootleftContainsq){
                    root = root.left;
                    continue;
                }else if(rootrightContainsp&& rootrightContainsq){
                    root = root.right;
                    continue;
                }
                return root;
            }else if(rootleftContainsp&& rootleftContainsq){
                root = root.left;
                continue;
            }else if(rootrightContainsp&& rootrightContainsq){
                root = root.right;
                continue;
            }
           
        }
        return null;
    }
    public void containsNode1(TreeNode root,TreeNode p,TreeNode q){
        if(root!=null){
            if(root.val==p.val){
                hasP = true;
            }
            if(root.val == q.val){
                hasQ = true;
            }
            containsNode1(root.left,p,q);
            containsNode1(root.right,p,q);
        }
    }
    public boolean containsNode(TreeNode root, TreeNode p){
        if(root!=null){
            if(root.val == p.val){
                return true;
            }else{
                return containsNode(root.right,p)||containsNode(root.left,p);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.right = new TreeNode(1);
        t.left = new TreeNode(5);
        t.right.right = new TreeNode(8);
        t.right.left = new TreeNode(0);
        t.left.left = new TreeNode(6);
        t.left.right = new TreeNode(2);
        t.left.right.left = new TreeNode(7);
        t.left.right.right = new TreeNode(4);

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);

        TreeNode p1= new TreeNode(0);
        TreeNode q1 = new TreeNode(8);

        LCA lca = new LCA();
        System.out.println(lca.lowestCommonAncestor(t,p1,q1).val);
        //System.out.println(lca.);
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