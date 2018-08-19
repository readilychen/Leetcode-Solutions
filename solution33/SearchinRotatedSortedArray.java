class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        // if(nums.length == 2){
        //     if(nums[0] == target){
        //         return 0;
        //     }else if(nums[1] == target){
        //         return 1;
        //     }else{
        //         return -1;
        //     }
        // }
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0] == target? 0 : -1;
        }
        if(target > nums[nums.length-1] && target < nums[0]){
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        if(nums[start] < nums[end]){
            return binarySearch(nums, start, end, target);
        }
        while(start <= end){
            if(start + 1 == end){
                if(nums[start] == target){
                    return start;
                }else if(nums[end] == target){
                    return end;
                }else{
                    return -1;
                }
            }
            int middle = (start + end) / 2;
            if(nums[middle] == target){
                return middle;
            }
            if(nums[middle] > nums[start]){
                if( target >= nums[start] && target <= nums[middle]){
                    return binarySearch(nums, start, middle, target);
                }else{
                    start = middle + 1;
                }
            }else{
                
                if(target >= nums[middle] && target <= nums[end]){
                    return binarySearch(nums, middle, end, target);
                }else{
                    end = middle - 1;
                }
            }
        }   
        return -1;
    }
    public int binarySearch(int[] nums,int start, int end, int target){
        //System.out.println(start);
        //System.out.println(end);
        while(start <= end){
            int middle = (start + end) / 2;
            if(nums[middle] == target){
                return middle;
            }
            if(target < nums[middle]){
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }
        return -1;
    }
}