import java.util.List;
import java.util.ArrayList;
class QuickSort{
    public List<Integer> quickSort(List<Integer> unSortedNum){
        return recursivelySort(unSortedNum);
    }
    public List<Integer> recursivelySort(List<Integer> unSortedNum){
        if(unSortedNum.size()==0){
            return new ArrayList<Integer>();
        }
        //Get the first element in that array
        int target = unSortedNum.get(0);
        List<Integer> lowerThan = new ArrayList<>();
        List<Integer> biggerThan = new ArrayList<>();
        for(int i = 1;i<unSortedNum.size();i++){
            int compare = unSortedNum.get(i);
            if(target < compare){
                lowerThan.add(compare);
            }else{
                biggerThan.add(compare);
            }
        }
        System.out.println("Lower");
        for(Integer i : lowerThan){
            System.out.println(i);
        }
        System.out.println("Bigger");
        for(Integer i : biggerThan){
            System.out.println(i);
        }

        List<Integer> resultList = new ArrayList<>();
        resultList.addAll(recursivelySort(lowerThan));
        resultList.add(target);
        resultList.addAll(recursivelySort(biggerThan));
        return resultList;
    }
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        List<Integer> unSortedNum = new ArrayList<>();
        unSortedNum.add(3);
        unSortedNum.add(5);
        unSortedNum.add(4);
        unSortedNum.add(1);
        System.out.println(qs.quickSort(unSortedNum));
    }
}