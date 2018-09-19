import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString_438 {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int left = 0;
            int right = 0;
            int matchSize = p.length();
            int[] map = new int[256];
            List<Integer> res = new ArrayList<>();
            // count the char number in p 计算p中各个字符的数量
            for (char c:p.toCharArray()){
                map[c] ++;
            }


            // build window 开始进行sliding window
            while (right < s.length()){
                // this char exists in p
                // 如果当前的char是存在于p中，则目标大小matchsize就得减少
                // 判断标准就是他的值不是为-1
                if (map[s.charAt(right)] > 0)
                    matchSize --;
                map[s.charAt(right)] --;

                // if the window size equals to p
                // 如果此时左右指针的差值等于p的长度
                if (right - left == p.length()-1){
                    // check matchSize equals to 0
                    // 如果此时目标大小也是0，说明这就是需要的一个子串
                    if (matchSize == 0)
                        // add the left index
                        res.add(left);

                    // move left pointer to start new search
                    // 如果当这个字符原来是p中的话，现在移动指针需要还原以前原有的matchSize，开始新的搜索
                    if (map[s.charAt(left)] >= 0)
                        matchSize ++;
                    // 还原以前每个元素减去的1
                    map[s.charAt(left)]++;
                    left++;
                }
                // move right
                // 老哥们别忘了
                right++;
            }

            return res;
        }
    }
}
