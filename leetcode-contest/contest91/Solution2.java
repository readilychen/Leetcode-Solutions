import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
class Solution2{
    List<Integer> returnList = new ArrayList<Integer>();
    int globalK = 0;
    //DFS
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        globalK = K;
        int leftCount  = 0;
        int upCount = 0;
        //List<Integer> existsList = new ArrayList<Integer>();
        leftCount = searchNode(target,K);
        if(target == root){
            return returnList;
        }
        reportToParent(root,target);
        return returnList;
    }
    public int reportToParent(TreeNode parent,TreeNode target){
        if(parent == target){
            return globalK-1;
        }
        int rightTarget = -1;
        int leftTarget = -1;
        if(parent.right != null){
            rightTarget = reportToParent(parent.right,target);
        }
        if(parent.left != null){
            leftTarget = reportToParent(parent.left,target);
        }
        if(rightTarget == 0||leftTarget == 0){
            returnList.add(parent.val);
        }
        System.out.println();
        System.out.println("parent "+parent.val);
        System.out.println("rightTarget "+rightTarget);
        System.out.println("leftTarget "+leftTarget);
        if(rightTarget == -1 && leftTarget == -1){
            return -1;
        }
        if(rightTarget >= 0){
            if(parent.left!= null && rightTarget  > 0){
                searchNode(parent.left,rightTarget-1);
            }
            return rightTarget-1; 
        }else{
            if(parent.right != null && leftTarget  > 0){
                searchNode(parent.right,leftTarget-1);
            }
            return leftTarget-1;
        }
    }
 
    public int searchNode(TreeNode startNode, int K){
        int nodeCount = 0;
        Stack<TreeNode> dfs = new Stack<TreeNode>();
        Stack<Integer> dfsCount = new Stack<Integer>();
        dfs.push(startNode);
        dfsCount.push(0);
        while(!dfs.empty()){
            TreeNode peekNode = dfs.pop();
            int distance = dfsCount.pop();
            if(distance < K){
                distance += 1;
                if(peekNode.left!=null){
                    dfs.push(peekNode.left);
                    dfsCount.push(distance);
                }
                if(peekNode.right!=null){
                    dfs.push(peekNode.right);
                    dfsCount.push(distance);
                }
            }else{
                nodeCount++;
                System.out.println("addin "+peekNode.val);
                returnList.add(peekNode.val);
            }
        }
        return nodeCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right.right = new TreeNode(8);
        root.right.left = new TreeNode(0);
        root.left.right = new TreeNode(7);
        root.left.left = new TreeNode(6);
        // root.left.right.left = new TreeNode(7);
        // root.left.right.right = new TreeNode(4);

        Solution2 s2 = new Solution2();
        s2.distanceK(root,root.left,2);
        for(Integer i : s2.returnList){
            System.out.println(i);
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
