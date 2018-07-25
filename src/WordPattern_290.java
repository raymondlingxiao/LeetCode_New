public class WordPattern_290 {
    class Solution {
        public boolean wordPattern(String pattern, String str) {
            String[] words = str.split(" ");
            if (words.length != pattern.length())
                return false;
            //这样写是动态的分配类型
            Map index = new HashMap();
            for (Integer i=0; i<words.length; ++i)
                if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                    return false;
            return true;
        }
    }
}
