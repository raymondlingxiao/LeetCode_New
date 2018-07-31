public class MultiplyStr_43 {
    class Solution {
        public String multiply(String num1, String num2) {
            // 此题关键是理解数学定理
            // i,j分别为num1 num2下标，每个digit*的结果都是对应数组下标的结果
            // ie. num[i] * num[j] = resultArr[i+j]*10 + resultArr[i+j+1];
            int len1 = num1.length();
            int len2 = num2.length();

            int[] result = new int[len1+len2];
            for (int i=len1-1;i>=0;i--){
                for (int j=len2-1;j>=0;j--){
                    int mult = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                    // 与最后一位相加，这里需要处理进位
                    int sum = mult + result[i+j+1];
                    // get the add num
                    result[i+j] += sum/10;
                    // get the remaing num after add up to the upper
                    result[i+j+1] = sum%10;

                }
            }

            StringBuilder rt  = new StringBuilder();
            for (int num: result){
                if (!(rt.length()==0 && num == 0))
                    rt.append(num);
            }
            if (rt.length() == 0)
                return "0";
            return rt.toString();

        }
    }
}
