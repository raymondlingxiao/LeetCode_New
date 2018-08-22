public class ReverseWordInSting_151 {
    public class Solution {
        public String reverseWords(String s) {
            String[] str = s.trim().split(" ");
            StringBuilder builder = new StringBuilder();
            for (int i=str.length-1;i>=0;i--){
                if (str[i].matches(""))
                    continue;
                builder.append(str[i]);
                builder.append(" ");
            }
            return builder.toString().trim();
        }

    }
}
