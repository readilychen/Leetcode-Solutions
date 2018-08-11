import java.util.List;
import java.util.ArrayList;
class Solution295{

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(6);
        
        
        
        List<Integer> sortedList = obj.sortedList;
        for (int i = 0; i<sortedList.size();i++ ) {
            System.out.println(sortedList.get(i));
        }
    }
}
class MedianFinder {
    public List<Integer> sortedList = new ArrayList<>();
    /** initialize your data structure here. */
    public MedianFinder() {
        sortedList.add(2);
        sortedList.add(6);
        sortedList.add(10);
    }
    public void addNum(int num) {
        if(sortedList.size() == 0){
            sortedList.add(num);
        }else{
            int i = sortedList.size()-1;
            for(; i >= 0; i--){
                if(sortedList.get(i) <= num){
                    break;
                }
            }
            System.out.println("i"+i);
            if(i == -1){
                sortedList.add(0,num);
            }else if(i == sortedList.size()-1){
                sortedList.add(num);
            }else{
                sortedList.add(i+1, num);
            }
        }   
        
    }
    // 0 , 1, 2, 3, 4,6, 7
    public double findMedian() {
        int currentCount = sortedList.size();
        // is even
        if(currentCount % 2 == 0){
            int median1 = currentCount / 2;
            int median2 = currentCount / 2 - 1;
            return (double)(sortedList.get(median1) + sortedList.get(median2))/2;
        }else{
            return sortedList.get(currentCount/2);
        }    
    }
}