import java.util.*;
public class ValidParenthese_20 {
    class Solution {
        public boolean isValid(String s) {
            // when considering about the order of something
            // think in using structures
            // stack or queue?
            // Here is a stupid example
            if (s == null)
                return false;
            String[] pairs = {"{}","[]","()"};
            for (int i=0; i<pairs.length;i++){
                if (s.contains(pairs[i])){
                    s = s.replace(pairs[i],"");
                    i = -1;
                }
            }
            if (!s.isEmpty())
                return false;
            return true;

        }

    }
    class Solution2 {
        public boolean isValid(String s) {
            // improve with solid idea
            // think in structures!
            // pay attention to stack overflows
            if(s == null)
                return false;
            Stack<Character> stack = new Stack<>();
            char cur;
            for(char ch: s.toCharArray()){
                switch(ch){
                    case('{'):
                    case('['):
                    case('('):
                        stack.push(ch);
                        break;
                    case('}'):
                        if(stack.isEmpty()||stack.pop()!='{')    return false;
                        break;
                    case(']'):
                        if(stack.isEmpty()||stack.pop()!='[')    return false;
                        break;
                    case(')'):
                        if(stack.isEmpty()||stack.pop()!='(')    return false;
                        break;

                }
            }
            return stack.isEmpty();
        }
    }
}
