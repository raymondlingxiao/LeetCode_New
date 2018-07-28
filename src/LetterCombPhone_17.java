public class LetterCombPhone_17 {
    class Solution {
        // On^2
        /**
         * 可使用String数组来提高速度
         * */
        //private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        private Map<Character,String> map = new HashMap<Character,String>();
        public List<String> letterCombinations(String digits) {
            map.put('2',"abc");
            map.put('3',"def");
            map.put('4',"ghi");
            map.put('5',"jkl");
            map.put('6',"mno");
            map.put('7',"pqrs");
            map.put('8',"tuv");
            map.put('9',"wxyz");
            List<String> result = new LinkedList<>();
            if (digits.length() == 0)
                return result;
            for (int i=0;i<digits.length();i++){
                //String nxt = map[digits.charAt(i)-'0'];
                String nxt = map.get(digits.charAt(i));
                if (result.size() == 0){
                    for (int k=0;k<nxt.length();k++){
                        result.add(""+nxt.charAt(k));
                    }
                    continue;
                }
                if (result.size() != 0){
                    List<String> temp = new LinkedList<>();
                    for (int j = 0;j<result.size();j++){
                        for (int k=0;k<nxt.length();k++){
                            temp.add(result.get(j)+nxt.charAt(k));
                        }
                    }
                    result = temp;
                }
            }
            return result;
        }
    }
}
