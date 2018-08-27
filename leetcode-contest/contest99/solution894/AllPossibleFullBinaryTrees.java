/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class AllPossibleFullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int N) {
        if(N % 2 == 0){
            return new ArrayList<TreeNode>();            
        }
        return searchBinaryTree(N);
    }
    public List<TreeNode> searchBinaryTree(int countNumber){
        if(countNumber == 1){
            List<TreeNode> result = new ArrayList<>();
            result.add(new TreeNode(0));
            return result;
        }
        countNumber--;
        List<TreeNode> returnedList = new ArrayList<>();
        for(int i = 1; i<countNumber; i++){
            int leftCount = 0;
            int rightCount = 0;
            if(i%2!=0){
                leftCount = i;
                rightCount = countNumber - i;
            }
            List<TreeNode> leftList = searchBinaryTree(leftCount);
            List<TreeNode> rightList = searchBinaryTree(rightCount);
            for(int j = 0; j<leftList.size(); j++){
                for(int k = 0; k<rightList.size(); k++){
                    TreeNode root = new TreeNode(0);
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                    returnedList.add(root);
                }
            }
        }
        return returnedList;
    }
}