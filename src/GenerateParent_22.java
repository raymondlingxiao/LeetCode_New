public class GenerateParent_22 {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new LinkedList<>();
            int left = 0;
            int right = 0;
            helper(result,"",left,right,n);
            return result;
        }

        private void helper(List<String> result,String str, int left, int right, int max){
            if (left + right == max*2){
                result.add(str);
                return;
            }
            if (left<max)
                helper(result,str+"(",left+1,right,max);
            if (right<left)
                helper(result,str+")",left,right+1,max);
        }
    }
}
