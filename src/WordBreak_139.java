public class WordBreak_139 {
    class Solution {
        // dfs
        public boolean wordBreak(String s, List<String> wordDict) {
            return helper(s,new HashSet<String>(wordDict),0);

        }

        private boolean helper(String s,Set<String> dict,int start){
            if (start == s.length())
                return true;
            for (int end = start +1;end <=s.length();end++){
                if (dict.contains(s.substring(start,end)) && helper(s,dict,end))
                    return true;
            }
            return false;
        }
    }

    class Solution2 {
        // dfs + memo
        public boolean wordBreak(String s, List<String> wordDict) {
            return helper(s,new HashSet<String>(wordDict),0,new Boolean[s.length()]);

        }

        private boolean helper(String s,Set<String> dict,int start, Boolean[] memo){
            if (start == s.length())
                return true;
            if (memo[start] != null)
                return memo[start];
            for (int end = start +1;end <=s.length();end++){
                if (dict.contains(s.substring(start,end)) && helper(s,dict,end,memo))
                    return memo[start] = true;
            }
            return memo[start] = false;
        }
    }
}
