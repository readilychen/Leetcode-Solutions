class GlobalAndLocalInversions{
    //First we need to count the number of Global Inversion
    //Second we need to count the number of Local Inversion
    //Then we count these two number
    public boolean isIdealPermutation(int[] A) {

        //This solution will cause time limit error, because when the BST is very unbalanced,
        //the searach time is almost the same as a normal list.(O(n))
        // if(countGlobalInversion2(A) == countLocalInversion(A)){
        //     return true;
        // }else{
        //     return false;
        // }
        //If the number of global inversion is the same as the number of local inversion
        //which means all the global inversion must be the local inversion,so we can't find
        // a A[i] > A[j], where i+2<=j
        int max = A[0];
        for(int i =0;i<A.length-2;i++){
            max = max > A[i] ? max:A[i];
            if(max > A[i+2]){
                return false;
            }
        }
        return true;
    }
    //It will cause time limit error
    public int countGlobalInversion1(int[] A){
        int count = 0;
        for(int i =A.length-1; i >= 0 ;i--){
            int value = A[i];
            for(int j = 0;j < i;j++){
                if(A[j]>value){
                    count++;
                }
            }
        }
        return count;
    }
    //We use binary search tree to implement this
    public int countGlobalInversion2(int[] A){
        //Initialize the tree to null
        int count =0;
        Tree root = null;
        for(int i=0;i<A.length;i++){
            count += search(root,A[i]+1);
            root = recursiveInsert(root,A[i]);
        }
        return count;
    }
    public int search(Tree root,int elem){
        if(root ==null){
            return 0;
        }
        if(root.val == elem){
            return root.larger_equal_count;
        }else if(root.val < elem){
            return search(root.right,elem);
        }else{
            return root.larger_equal_count+search(root.left,elem);
        }
    }
    public Tree recursiveInsert(Tree root,int elem){
        if(root == null){
            root = new Tree(elem);
            return root;
        }
        if(root.val<elem){
            root.larger_equal_count++;
            root.right = recursiveInsert(root.right,elem);
        }else if (root.val>elem){
            root.left = recursiveInsert(root.left,elem);
        }else{
            root.larger_equal_count++;
        }
        return root;
    }
    public Tree insert(Tree root,int elem){
        if(root == null){
            root = new Tree(elem);
            return root;
        }
        Tree prev = root;
        while(true){
            if(root.val>elem){
                if(root.left == null){
                    root.left = new Tree(elem);
                    break;
                }else{
                     root = root.left;
                }
            }else if(root.val<elem){
                root.larger_equal_count++;
                if(root.right==null){
                    root.right = new Tree(elem);
                    break;
                }else{
                    root = root.right;
                }
            }else{
                root.larger_equal_count++;
                return prev;
            }
        }

        return prev;
    }
    public int countLocalInversion(int[] A){
        int count = 0;
        for(int i = 0;i<A.length-1;i++){
            if(A[i] > A[i+1]){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] A ={0,2,1};
        GlobalAndLocalInversions gali=new GlobalAndLocalInversions();
        System.out.println(gali.isIdealPermutation(A));
    }
}
class Tree{
    int val;
    Tree left;
    Tree right;
    int larger_equal_count;
    Tree(int val){
        this.val = val;
        this.larger_equal_count = 1;
    }
}