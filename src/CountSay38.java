public class CountSay38 {
    class Solution {
        public String countAndSay(int n) {
            if (n<1)
                return "";
            int stop = 1;
            String initial = "1";
            while (stop < n){
                initial = doCount(initial);
                stop++;
            }
            return initial;
        }

        private String doCount(String str){
            if (str.isEmpty())
                return "";
            char last = str.charAt(0);
            String temp = "";
            int count = 0;
            for (int i=0;i<str.length();i++){
                if (str.charAt(i) == last){
                    count++;
                }
                else{
                    temp += count + String.valueOf(last);
                    count = 1;
                    last = str.charAt(i);
                }
                if (i == str.length()-1)
                    temp += count + String.valueOf(last);
            }
            return temp;
        }
    }
}
