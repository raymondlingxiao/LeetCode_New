public class PalindromeNum_9 {
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0||(x != 0 && x %10 == 0))
                return false;
            int origin = x;
            int reversedResult = 0;
            while (x!=0){
                reversedResult = reversedResult * 10 + x%10;
                x /= 10;
            }
            if ( reversedResult == origin)
                return true;
            return false;
        }
    }
}
