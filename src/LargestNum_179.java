public class LargestNum_179 {
    /**
     * 主要是利用两个字符串的组合方式只有两种，每两个之间得到最大的组合方式
     * 再与下一个字符串比较
     * 需要注意的是compareTo这个funcion的使用
     * */
    class Solution {
        public String largestNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for (int i=0;i<nums.length;i++){
                strs[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(strs,new Comparator<String>(){
                public int compare(String a, String b){
                    String order1 = a + b;
                    String order2 = b + a;
                    return order2.compareTo(order1);
                }
            });
            if (Integer.valueOf(strs[0]) == 0)
                return "0";
            StringBuilder res = new StringBuilder();
            for (String str:strs){
                res.append(str);
            }
            return res.toString();

        }
    }
}
