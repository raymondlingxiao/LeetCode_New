public class GroupAnagram_49 {
    // Time out
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();
            boolean[] used = new boolean[strs.length];
            for (int i=0;i<strs.length;i++){
                if (used[i] != false)
                    continue;
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                used[i] = true;
                for (int j=i+1;j<strs.length;j++){
                    if (used[j] != false)
                        continue;
                    if (isAnagram(strs[i],strs[j])){
                        temp.add(strs[j]);
                        used[j] = true;
                    }
                }
                result.add(temp);
            }

            return result;
        }

        private boolean isAnagram(String a, String b){
            int[] arr = new int[26];
            for(int i =0;i<a.length();i++)
                arr[a.charAt(i)-'a'] ++;
            for (int j=0;j<b.length();j++)
                arr[b.charAt(j)-'a'] --;
            for (int num:arr){
                if (num != 0)
                    return false;
            }
            return true;
        }
    }

    // 利用乱序单词的单词都是一样的特性,利用ascii进行排序,作为key
    class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> map = new HashMap<>();

            for (String str: strs){
                char[] temp = str.toCharArray();
                Arrays.sort(temp);
                String key = String.valueOf(temp);
                if (!map.containsKey(key)){
                    List<String> templist = new ArrayList<>();
                    templist.add(str);
                    map.put(key,templist);
                }
                else{
                    map.get(key).add(str);
                }
            }
            return new ArrayList<List<String>>(map.values());
        }

    }
}
