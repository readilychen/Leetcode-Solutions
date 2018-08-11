import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
class WordLadder1{
    int min = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> myWordList = new Vector<>();
        for(String str:wordList){
            myWordList.add(str);
        }
        DFS(beginWord,endWord,myWordList,1);
        return min == Integer.MAX_VALUE? 0:min;  
    }
    public void DFS(String beginWord, String endWord, List<String> wordList,int count){
        if(count > min){
            return;
        }
        if(beginWord.equals(endWord)){
            min = count;
            return;
        }
        for(String ls : wordList){
            System.out.println(ls);
            int tempcount = 0;
            for(int i=0;i<ls.length();i++){
                if(ls.charAt(i)!=beginWord.charAt(i)){
                    tempcount++;
                }
            }
            //System.out.println(tempcount);
            //if it is one character different from the target, go to search it 
            if(tempcount == 1){
                wordList.remove(ls);
                //Recurisively invoke
                DFS(ls,endWord,wordList,count+1);
                wordList.add(ls);
            }
        }
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("cog");
        wordList.add("dog");
        wordList.add("tot");
        wordList.add("hog");
        wordList.add("hop");
        wordList.add("pot");
        wordList.add("dot");
        WordLadder wl = new WordLadder();

        System.out.println(wl.ladderLength(beginWord,endWord,wordList));
        long endTime = System.currentTimeMillis();
        System.out.println("execute Time "+(endTime - startTime));
    }
}