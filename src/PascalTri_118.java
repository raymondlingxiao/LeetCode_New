public class PascalTri_118 {
    class Solution {
        // BF
        public List<List<Integer>> generate(int numRows) {
            List<Integer> pre = new LinkedList<>();
            List<List<Integer>> result = new LinkedList<List<Integer>>();
            for (int i=1;i<=numRows;i++){
                if (i == 1){
                    pre.add(1);
                    result.add(pre);
                }
                if (i > 1){
                    List<Integer> cur = new LinkedList<>();
                    for (int j = 0;j<pre.size()-1;j++){
                        int newEle = pre.get(j) + pre.get(j+1);
                        cur.add(newEle);
                    }
                    cur.add(0,1);
                    cur.add(cur.size(),1);
                    pre = new LinkedList<>(cur);
                    result.add(pre);
                }
            }
            return result;
        }
    }
}
