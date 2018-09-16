import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RmvInvalidParent {
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            int maxRmLeft = 0;
            int maxRmRight =0;
            //count the max of left and right parens which can be deleted
            for (int i=0;i<s.length();i++){
                if (s.charAt(i) == '('){
                    maxRmLeft ++;
                }
                if (s.charAt(i) == ')'){
                    if (maxRmLeft != 0)
                        maxRmLeft --;
                    else
                        maxRmRight ++;
                }
            }
            // index for string
            int i=0;
            // check the res string fulfill the requirement
            int open = 0;
            HashSet<String> res = new HashSet<>();
            dfs(s,i,maxRmLeft, maxRmRight, open, new StringBuilder(),res);

            return new ArrayList<String>(res);

        }

        private void dfs(String s, int i, int maxLeft, int maxRight, int open,StringBuilder sb, HashSet<String> res){
            // exit point
            if (maxLeft < 0|| maxRight < 0 || i > s.length() || open < 0)
                return ;
            // when moves to the end of string
            if (i == s.length()){
                if (maxLeft == 0 && maxRight == 0 && open == 0)
                    res.add(sb.toString());
                return;
            }

            char ch = s.charAt(i);
            int len = sb.length();

            if (ch == '(') {
                // delete this paren
                dfs(s,i+1,maxLeft-1,maxRight, open,sb,res);
                // not delete this paren
                dfs(s,i+1,maxLeft,maxRight,open+1,sb.append(ch),res);

            }
            else if (ch == ')'){
                // delete this paren
                dfs(s,i+1,maxLeft,maxRight-1,open,sb,res);
                // not delete this paren
                dfs(s,i+1,maxLeft,maxRight,open-1,sb.append(ch),res);
            }
            else{
                // add other chars
                dfs(s,i+1,maxLeft,maxRight,open,sb.append(ch),res);
            }

            // backTrack
            sb.setLength(len);
        }
    }
}
