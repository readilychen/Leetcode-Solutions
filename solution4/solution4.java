class solution4{
    public double findMedianSortedArrays(int[] nums1,int[] nums2){
        int index1 = 0;
        int index2 = 0;
        int item = (nums1.length+nums2.length)>>1;
        int []combine = new int[item+1];
        if(nums1.length ==0 && nums2.length != 0){
            combine[0] = nums2[index2];
            index2++;
        }else if(nums1.length !=0 && nums2.length == 0){
            combine[0] = nums1[index1];
            index1++;
        }else{
            if(nums1[0] >= nums2[0]){
                combine[0] = nums2[index2];
                index2++;
            }else{
                combine[0] = nums1[index1];
                index1++;
            }
        }
        
        for(int i =1;i<item+1;i++){
            if(index1 == nums1.length){
                combine[i] = nums2[index2];
                index2 ++;
            }else if(index2 == nums2.length){
                combine[i] = nums1[index1];
                index1++;
            }else{
                if(nums1[index1]>=nums2[index2]){
                    combine[i] = nums2[index2];
                    index2++;
                }else{
                    combine[i] = nums1[index1];
                    index1++;
                }
                System.out.println(i + " : "+combine[i]);
            }   
        }
        if((nums1.length+nums2.length)%2 == 0){
            System.out.println("median is d"+(double)(combine[item]+combine[item-1])/2.0);
            return (double)((combine[item]+combine[item-1])>>1);
        }else{
            System.out.println("median is "+(double)combine[item]);
            return (double)combine[item];
        }
    }
    public static void main(String[] args) {
        int []nums1 = {1,2};
        int []nums2 = {3,4};
        solution4 s4 = new solution4();
        s4.findMedianSortedArrays(nums1,nums2);
    }
}