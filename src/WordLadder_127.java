public class WordLadder_127 {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> dict = new HashSet<>(wordList);
            Set<String> reached = new HashSet<>();
            // HERE
            //dict.add(endWord);
            reached.add(beginWord);
            int ladder = 1;
            while (!reached.contains(endWord)){
                Set<String> toAdd = new HashSet<>();
                for (String str:reached){
                    for (int i=0;i<str.length();i++){
                        char[] chars = str.toCharArray();
                        for (char ch = 'a';ch<='z';ch++){
                            chars[i] = ch;
                            String newStr = new String(chars);
                            if (dict.contains(newStr)){
                                toAdd.add(newStr);
                                dict.remove(newStr);
                            }
                        }
                    }
                }
                ladder += 1;
                if (toAdd.size() == 0)
                    return 0;
                reached = toAdd;
            }
            return ladder;
        }
    }
}
