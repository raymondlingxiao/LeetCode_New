public class strStr_28 {
    class BFSolution1 {
        public int strStr(String haystack, String needle) {
            if (needle.isEmpty())
                return 0;
            if (haystack.isEmpty())
                return -1;
            for (int i=0;i<haystack.length();i++){
                for (int j=0; j<needle.length(); j++){
                    if (i+j >= haystack.length())
                        return -1;
                    // very important part by using "i+j"
                    if (haystack.charAt(i+j) != needle.charAt(j))
                        break;
                    // when matched
                    if (j == needle.length()-1)
                        return i;
                }
            }
            return -1;
        }
    }
}
