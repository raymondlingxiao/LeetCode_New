public class LengthLastWord_58 {
    class Solution1 {
        public int lengthOfLastWord(String s) {
            // without using split
            if (s == null || s.length() == 0)
                return 0;
            s = s.trim();
            int len = s.length();
            int pointer = len-1;
            // be careful when using the index of an array
            while(pointer >=0 && pointer < len && s.charAt(pointer) != ' '){
                pointer --;
            }
            return len-pointer-1;
        }
    }

    class Solution2 {
        public int lengthOfLastWord(String s) {
            if (s == null|| s.length() == 0)
                return 0;
            String[] strArr = s.split(" ");
            if (strArr.length != 0)
                return strArr[strArr.length-1].length();
            else
                return 0;
        }
    }
}
