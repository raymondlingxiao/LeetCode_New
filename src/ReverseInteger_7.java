public class ReverseInteger_7 {
    class Solution1 {
        //第一个解法，用list存储剪切的数字
        public int reverse(int x) {
            List<Integer> digits = new ArrayList<>();
            int length = -1;
            while(Math.abs(x)>=1){
                digits.add(x%10);
                x /= 10;
                length ++;
            }
            long result = 0;
            for (Integer digit: digits){
                if (result < -Math.pow(2,31) || result> Math.pow(2,31)-1)
                    return 0;
                result += digit * Math.pow(10,length);
                length --;
            }
            return (int)result;
        }
    }


}
