class Node{
    int val;
    Node leftTree;
    Node rightTree;
    int count_equal_larger;
    Node (int val){
        this.val = val;
        this.count_equal_larger=1;
    }
}
public class reversepair{
    public int countReversePair(int []nums){
        //used to count the number of reversepair
        Node root = new Node(0);
        int count = 0;
        for(int i =0;i<nums.length;i++){
            if(i == 0){
                root.val = nums[0];
            }else{
                count += search(root,(long)nums[i]*2+1);

                System.out.println("time" + i +" : " +count +"root value : "+root.val);
                root = insert(root,nums[i]);
            }
        }
        return count;
    }
    //search the tree to find the count of each iteration
    public int search(Node root, long val){
        if(root == null){
            return 0;
        }else if(root.val==val){
            return root.count_equal_larger;
        }else if(root.val>val){
            return root.count_equal_larger + search(root.leftTree,val);
        }else{
            return search(root.rightTree,val);
        }
    }
    //insert the new node to the tree
    public Node insert(Node root, int val){
        Node prev = root;
        while(true){
            if(root.val < val){
                root.count_equal_larger++;
                if(root.rightTree == null){
                    root.rightTree = new Node(val);
                    break;
                }
                root = root.rightTree;
            }else if(root.val == val){
                root.count_equal_larger ++;
                break;
            }else if(root.val > val){
                if(root.leftTree == null){
                    root.leftTree = new Node(val);
                    break;
                }
                root = root.leftTree;
            }
        }
        return prev;
    }
    public static void main(String[] args) {
        int []nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        reversepair rp = new reversepair();
        rp.countReversePair(nums);
    }
}
