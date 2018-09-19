public class MinWinSize_76 {
    class Solution {
        public String minWindow(String s, String t) {
            int left = 0;
            int right = 0;
            int head = 0;
            int len = Integer.MAX_VALUE;
            int[] map = new int[256];
            int numTarget = t.length();

            // load default
            for (char ch:t.toCharArray()){
                map[ch] ++;
            }

            while (right < s.length()){

                if (map[s.charAt(right)] > 0)
                    numTarget -- ;
                map[s.charAt(right)] --;
                right ++;

                // 这里是关键，因为当num为0时，此时已经满了所有的元素存在
                // 但是，此时需要缩小左边的指针来得到最小的window装满了所有元素
                while (numTarget == 0){
                    if (right - left < len){
                        len = right - left;
                        head = left;
                    }
                    if (map[s.charAt(left)] >= 0)
                        numTarget++;
                    map[s.charAt(left)]++;
                    left++;
                }


            }
            if (len == Integer.MAX_VALUE)
                return "";
            return s.substring(head,head+len);
        }
    }
}
