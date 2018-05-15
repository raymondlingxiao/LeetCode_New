public class AddBinary_67 {
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int i = a.length()-1;
            int j = b.length()-1;
            int carry = 0;
            while (i>=0 || j >=0){
                int sum = carry;
                if (j>=0){
                    sum += b.charAt(j--) - '0';
                }
                if (i>=0){
                    sum += a.charAt(i--) - '0';
                }
                if (sum >=2){
                    carry = 1;
                    sum -= 2;
                }
                else
                    carry  =0;
                sb.append(sum);
            }
            if (carry != 0)
                sb.append(carry);
            return sb.reverse().toString();

        }

    }
}
