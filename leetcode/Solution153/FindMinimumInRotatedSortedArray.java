class FindMinimumInRotatedSortedArray{
    //Binary search to fine the min
    public int findMin(int[] nums) {
        for(int i =0;i<nums.length-1;i++){
            if(nums[i+1] < nums[i]){
                return nums[i+1];
            }
        }
        return nums[0];
    }
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray fira = new FindMinimumInRotatedSortedArray();
        int[] num = {1};
        System.out.println(fira.findMin(num));
    }
}