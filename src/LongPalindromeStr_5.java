public class LongPalindromeStr_5 {
    /**
     * 最容易想到的一个方法，拟定一个窗口，从头开始逐渐扩大窗口的大小，同时在窗口内检查是不是一个回文字符串
     * On3
     * */
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 1 || s.length() == 0)
                return s;
            int max = 0;
            String longStr = String.valueOf(s.charAt(0));
            for (int i=0;i<s.length();i++){
                for (int winSize =1;i+winSize <s.length();winSize ++){
                    int strLen = winSize +1;
                    if (strLen > max && isPalindrome(i,i+winSize,s)){
                        max = strLen;
                        longStr = s.substring(i,i+winSize+1);
                        if (max == s.length())
                            return longStr;
                    }
                }
            }
            return longStr;
        }

        private boolean isPalindrome(int start, int end, String s){
            while (start < end){
                if (s.charAt(start) == s.charAt(end)){
                    start ++;
                    end --;
                }
                else
                    return false;
            }
            return true;
        }
    }

    /**
     * 改良版，从每个字符串的中间开始，两个指针进行回文判断，同时更新最长的大小和最低点的index
     * On2
     * */
    class Solution2 {
        private int maxLen = 0;
        private int low = 0;
        public String longestPalindrome(String s) {
            if (s.length() == 1 || s.length() == 0)
                return s;
            for (int i=0;i<s.length();i++){
                // if (s.length()%2==0)
                findPalindrome(i,i+1,s);
                // if (s.length()%2 != 0)
                findPalindrome(i,i,s);

            }
            return s.substring(low,low+maxLen);

        }

        private void findPalindrome(int start, int end, String s){
            while (start>=0 && end <s.length() && s.charAt(start) == s.charAt(end)){
                start --;
                end ++;
            }
            if (maxLen < end -start -1){
                maxLen = end -start -1;
                low = start +1;
            }
        }
    }
}
