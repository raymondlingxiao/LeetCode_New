public class ValidPalindrome_125 {
    class Solution {
        // BF
        public boolean isPalindrome(String s) {
            s = s.replaceAll("[^0-9a-zA-Z]","");
            StringBuffer buffer = new StringBuffer(s);
            String newS = buffer.reverse().toString();
            return newS.equalsIgnoreCase(s);
        }
    }

    class Solution2 {
        // by using two pointers
        // but should consider two consecutive non-digit chars
        // else if is essential
        public boolean isPalindrome(String s) {
            int phead = 0;
            int ptail = s.length()-1;
            while (phead <= ptail){
                if (!Character.isLetterOrDigit(s.charAt(phead)))
                    phead ++;
                else if (!Character.isLetterOrDigit(s.charAt(ptail)))
                    ptail --;
                else if (Character.toLowerCase(s.charAt(phead)) != Character.toLowerCase(s.charAt(ptail)))
                    return false;
                else{
                    phead ++;
                    ptail --;
                }
            }
            return true;
        }
    }
}
