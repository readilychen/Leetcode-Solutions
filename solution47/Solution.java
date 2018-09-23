class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] v = new boolean[nums.length];
        findUniqueList(new ArrayList<>(),v,nums);
        return result;
        
    }
    public void findUniqueList(List<Integer> subList, boolean[] v, int[] nums){
        if(subList.size() == nums.length){
            result.add(new ArrayList<>(subList));
            return ;
        }
        for(int i=0; i<v.length; i++){
            if(v[i] || (i-1 >= 0 && nums[i] == nums[i-1]) && !v[i-1]){
                continue;
            }else{
                v[i] = true;
                subList.add(nums[i]);
                findUniqueList(subList,v,nums);
                subList.remove(subList.size() - 1);
                v[i] = false;
            }
        }
    }
}