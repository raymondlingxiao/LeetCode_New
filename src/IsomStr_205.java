public class IsomStr_205 {
    class Solution {
        // 只需要判断新添加的元素，上一次插入的位置是不是一样的
        // 由此可知元素在相同的位置插入了，故结构是一样的
        public boolean isIsomorphic(String s1, String s2) {
            Map<Character, Integer> m1 = new HashMap<>();
            Map<Character, Integer> m2 = new HashMap<>();

            for(Integer i = 0; i < s1.length(); i++) {
                //利用map每次put返回的是这个元素上一次存的值（位置）
                if(m1.put(s1.charAt(i), i) != m2.put(s2.charAt(i), i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
