class 3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> positionMap = new HashMap<>();
        boolean flag = false;
        List<List<Integer>> resultList = new ArrayList<>();
        Set<List<Integer>> removeRepeatSet = new HashSet<>();
        if(nums.length < 3){
            return resultList;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i < 2){
                // if have multiple same element, put the most first element in the map
                if(!positionMap.containsKey(nums[i])){
                    positionMap.put(nums[i],i);
                }
            }else{
                int thirdElem = nums[i];
                for(int j = i-1; j >= 0; j--){
                    int secondElem = nums[j];
                    int firstElem = -thirdElem - secondElem;
                    if(positionMap.containsKey(firstElem)&&positionMap.get(firstElem) < j){
                        List<Integer> item = new ArrayList<>();
                        item.add(firstElem);
                        item.add(secondElem);
                        item.add(thirdElem);
                        //Collections.sort(item);
                        removeRepeatSet.add(item);
                    }else{
                        continue;
                    }
                }
                if(!positionMap.containsKey(nums[i])){
                    positionMap.put(nums[i],i);
                } 
            }
        }
        
        return new ArrayList<>(removeRepeatSet);
    }
}