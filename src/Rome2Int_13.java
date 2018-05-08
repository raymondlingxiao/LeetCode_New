import java.util.*;
public class Rome2Int_13 {
    class Solution1 {
        public int romanToInt(String s) {
            Map<String, Integer> normal = new HashMap<String,Integer>();
            Map<String, Integer> special = new HashMap<String,Integer>();
            //Basic set
            normal.put("I",1);
            normal.put("V",5);
            normal.put("X",10);
            normal.put("L",50);
            normal.put("C",100);
            normal.put("D",500);
            normal.put("M",1000);
            //special cases
            special.put("IV",4);
            special.put("IX",9);
            special.put("XL",40);
            special.put("XC",90);
            special.put("CD",400);
            special.put("CM",900);
            int result = 0;
            //Find Special first
            for (String key:special.keySet()){
                if (s.contains(key)){
                    result += special.get(key);
                    s = s.replace(key,"");
                }
            }
            //Find normal then
            for (String key:normal.keySet()){
                if (s.contains(key)){
                    char[] strChar = s.toCharArray();
                    int count = 0;
                    for(char str:strChar){
                        if(String.valueOf(str).equals(key))
                            count ++;
                    }
                    result += normal.get(key)*count;
                    s = s.replace(key,"");
                }
            }

            return result;
        }
    }

    class Solution2 {
        public int romanToInt(String s) {
            //Improved Version with rules for Roman Numbers
            Map<String, Integer> map = new HashMap<String,Integer>();
            //Basic set
            map.put("I",1);
            map.put("V",5);
            map.put("X",10);
            map.put("L",50);
            map.put("C",100);
            map.put("D",500);
            map.put("M",1000);
            int result = 0;
            char[] strChar = s.toCharArray();
            for (int i = strChar.length-1; i>=0; i--){
                char cur = strChar[i];
                result += map.get(String.valueOf(cur));
                if (i > 0){
                    char pre = strChar[i-1];
                    if (map.get(String.valueOf(pre)) < map.get(String.valueOf(cur))){
                        result -= map.get(String.valueOf(pre));
                        i --;
                    }
                }
            }
            return result;

        }
    }
}
