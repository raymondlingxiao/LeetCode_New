public class longestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        //Convert into 2d array
        //It turns out to be a not efficient and easy way
        //O N square
        if (strs.length == 0)
            return "";
        char[][] charArray = new char[strs.length][];
        int i = 0;
        for (String str: strs){
            if (str == "")
                return "";
            charArray[i] = str.toCharArray();
            i++;
        }
        //find prefix
        String result = "";
        boolean flag = true;
        char prefix;
        for (int j= 0; j <charArray[0].length; j++){
            prefix = charArray[0][j];
            for (int k = 0; k<charArray.length;k++){
                if (j>= charArray[k].length||charArray[k][j] != prefix){
                    return result;
                }
            }
            result += prefix;
        }
        return result;
    }
    class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            //Another way of thinking
            //make rules based on the shortest char
            //cut off chars in the first element, until it becomes empty or the second element
            //contains some parts of the 1st
            if(strs == null || strs.length == 0)
                return "";
            String prefix = strs[0];
            for(int index =1; index <strs.length; index++){
                while(!strs[index].startsWith(prefix))
                    prefix = prefix.substring(0,prefix.length()-1);
            }
            return prefix;
        }
    }
}
