class Solution {
    List<List<Integer>> globalList = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int[] marked = new int[nums.length];
        Arrays.fill(marked,-1);
        addToList(marked,0,nums);
        return globalList;
    }
    public void addToList(int[] marked, int order, int[] nums){
        if(order == nums.length){
            List<Integer> itemList = new ArrayList<>();
            for(int i=0; i<marked.length; i++){
                itemList.add(nums[marked[i]]);
            }
            globalList.add(itemList);
            return;
        }
        for(int i=0; i<marked.length; i++){
            if(marked[i] == -1){
                marked[i] = order;
                addToList(marked, order+1, nums);
                marked[i] = -1;
            }
        }
    }
}