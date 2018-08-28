public class QueueReconstrucHeight_406 {
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            // Sort from high to small
            // Then add each person to a new array
            // the order would not be affected, since each person to be inserted
            // is the smallest person in the new array

            if (people == null || people.length == 0 || people[0].length == 0)
                return new int[0][0];

            Arrays.sort(people, new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    if (a[0] == b[0])
                        return a[1] - b[1];
                    return b[0]-a[0];
                }
            });

            List<int[]> res = new ArrayList<>();
            for (int i=0;i<people.length;i++){
                res.add(people[i][1], new int[]{people[i][0],people[i][1]});
            }

            return res.toArray(new int[people.length][2]);

        }
    }
}
