public class RegularExpMatch_10 {
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();

            Boolean[][] memo = new Boolean[m+1][n+1];
            memo[0][0] = true;

            for (int i=1;i<=m;i++)
                memo[i][0] = false;


            return getMemo(m,n,memo,s,p);
        }

        private boolean getMemo(int x, int y, Boolean[][] memo, String s, String p){
            if (x<0||y<0||x>memo.length||y>memo[0].length){
                return false;
            }

            if (memo[x][y] != null)
                return memo[x][y];

            boolean matchFirst = false;
            if (x >0 && (s.charAt(s.length()-x) == p.charAt(p.length()-y) ||p.charAt(p.length()-y) == '.'))
                matchFirst = true;
            if (p.length()-y+1 < p.length() && p.charAt(p.length()-y+1) == '*'){
                return memo[x][y] = getMemo(x,y-2,memo,s,p) || matchFirst && getMemo(x-1,y,memo,s,p);
            }
            else{
                return memo[x][y] = matchFirst && getMemo(x-1,y-1,memo,s,p);
            }


        }
    }
}
