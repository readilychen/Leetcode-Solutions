public class FindFloorAndCeil{
    public TreeNode floor(TreeNode root, int target){
        if(root == null){
            return null;
        }
        if(target <= root.val){
            root = root.left;
            return floor(root, taßrget);
        }else{
            TreeNode temproot = root.right;
            TreeNode temp = floor(temproot, target);
            return temp == null ? root : temp;
        }
    }
    public TreeNode ceil(TreeNode root, int target){
        if(root == null){
            return null;
        }
        if(target >= root.val){
            root = root.right;
            return ceil(root,target);
        }else{
            TreeNode temproot = root.left;
            TreeNode temp = ceil(temproot, target);
            return temp == null ? root: temp;
        }
    }
    public static void main(String[] args) {
        TreeNode t = new TreeNode(10);
        t.right = new TreeNode(15);
        t.left = new TreeNode(5);
        t.left.right = new TreeNode(7);
        FindFloorAndCeil s = new FindFloorAndCeil();
        System.out.println(s.floor(t,8).val);
        System.out.println(s.ceil(t,13).val);
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}