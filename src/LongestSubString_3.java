public class LongestSubString_3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int sum = 0;
            Map<Character,Integer> map = new HashMap<Character,Integer>();
            for (int i=0,j =0;i<s.length();i++){
                if (map.containsKey(s.charAt(i))){
                    j = Math.max(j,map.get(s.charAt(i))+1);
                }
                map.put(s.charAt(i),i);
                sum = Math.max(sum,i-j+1);
            }
            return sum;
        }
    }
}
