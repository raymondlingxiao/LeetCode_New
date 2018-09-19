public class PermutaionInString {
    class Solution {

        // 438
        public boolean checkInclusion(String s1, String s2) {
            int left = 0;
            int right = 0;
            int[] map = new int[256];
            int numTarget = s1.length();

            // load default
            for (char ch:s1.toCharArray()){
                map[ch] ++;
            }

            while (right < s2.length()){

                if (map[s2.charAt(right)] > 0)
                    numTarget -- ;
                map[s2.charAt(right)] --;

                // very interesting approach here
                while (numTarget == 0){
                    if (right - left == s1.length()-1)
                        return true;
                    if (map[s2.charAt(left)] >= 0)
                        numTarget++;
                    map[s2.charAt(left)]++;
                    left++;
                }



                right++;
            }

            return false;


        }
    }
}
