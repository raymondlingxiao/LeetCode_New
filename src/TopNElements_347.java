public class TopNElements_347 {
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            // 从排序算法来考虑的话,比快排nlogn更快的,就是bucket sort(这里每个元素出现的次数都小于k)
            // 这里以出现的次数来作为排序的依据,取k个最高的元素返回即可

            Map<Integer,Integer> map = new HashMap<>();
            for (Integer num:nums){
                map.put(num,map.getOrDefault(num,0)+1);
            }

            // Bucket Sort
            List<Integer>[] bucket = new ArrayList[nums.length+1];
            for (Integer key:map.keySet()){
                int freq = map.get(key);
                if (bucket[freq] == null)
                    bucket[freq] = new ArrayList<Integer>();
                bucket[freq].add(key);
            }

            // Get k
            List<Integer> result = new ArrayList<>();
            for(int pos = bucket.length-1;pos>=0;pos--){
                if (k <= 0)
                    break;
                if (bucket[pos] != null){
                    result.addAll(bucket[pos]);
                    k -= bucket[pos].size();
                }
            }

            return result;
        }
    }

    // 采用heap结构来取每次最大的freq的元素,排序为ologn
    class Solution2 {
        public List<Integer> topKFrequent(int[] nums, int k) {

            Map<Integer,Integer> map = new HashMap<>();
            for (Integer num:nums){
                map.put(num,map.getOrDefault(num,0)+1);
            }

            // Max heap
            PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
            for (Map.Entry<Integer,Integer> entry:map.entrySet()){
                maxHeap.offer(entry);
            }

            // Get K elements
            List<Integer> result = new ArrayList<>();
            while (k>0){
                result.add(maxHeap.poll().getKey());
                k--;
            }

            return result;
        }
    }
}
