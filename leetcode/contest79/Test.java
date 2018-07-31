import java.util.List;
import java.util.ArrayList;
class Test{
    static List<Integer[]> resultList = new ArrayList<>();
    public static void combination(int totalNum ,int selectedNum, int startIndex, List<Integer> selectedList){
        if(selectedNum == 0){
            Integer[] addInteger = new Integer[selectedList.size()];
            for(int i =0; i < selectedList.size();i++){
                addInteger[i] = selectedList.get(i);
            }
            resultList.add(addInteger);
            return;
        }
        for(int i = startIndex; i < totalNum-selectedNum+1;i++){
            selectedList.add(i);
            combination(totalNum,selectedNum-1,i+1,selectedList);
            selectedList.remove(selectedList.size()-1);
        }
    }
    public static void main(String[] args) {
        List<Integer> selectedList = new ArrayList<>();
        combination(5,2,1,selectedList);
        for(Integer[] integers : resultList){
            for(int i =0;i<integers.length;i++){
                System.out.print(integers[i]+" ");
            }
            System.out.println(" ");
        }
    }
}