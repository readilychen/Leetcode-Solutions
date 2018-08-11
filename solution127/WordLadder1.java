class WordLadder1{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         
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
    }
}