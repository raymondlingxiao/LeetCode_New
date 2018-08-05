public class KthLargestEle_215 {
    /**
     * 此题可以用多个排序方法进行解决
     * */

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
            for (int num:nums){
                maxHeap.offer(num);
            }
            while (k>0){
                int res = maxHeap.poll();
                k--;
                if (k == 0)
                    return res;
            }
            return -1;
        }
    }

    // quick sort
    class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            quickSort(nums,0,nums.length-1);
            int pos = nums.length-1;
            int result = -1;
            while (k>0){
                result = nums[pos];
                k--;
                pos--;
            }
            return result;

        }
        private void quickSort(int[]nums, int left, int right){
            if (left > right)
                return;
            int i = left;
            int j = right;
            int pivot = nums[i];
            while (i < j){
                while (i < j && nums[j] >= pivot)
                    j --;
                if (i<j)
                    nums[i] = nums[j];
                while (i < j && nums[i] <= pivot)
                    i ++;
                if (i<j)
                    nums[j] = nums[i];
            }
            nums[i] = pivot;
            quickSort(nums,left,i-1);
            quickSort(nums,i+1,right);
        }
    }

    // Selection Sort
    /**
     * 通过分治法的思想,将元素分别放在pivot左右两边,不过当pivot处为所需要的元素的时候
     * 直接return,否则缩小范围
     * */
    class Solution3 {
        public int findKthLargest(int[] nums, int k) {
            if (nums.length == 0 || nums == null)
                return -1;
            return selectSort(nums,0,nums.length-1,nums.length-k);

        }
        private int selectSort(int[]nums, int left, int right, int k){
            int i=left;
            int j = right;
            if (i>j)
                return -1;
            int pivot = nums[left];
            while (i<j){
                while (i<j && nums[j] >=pivot)
                    j--;
                if (i<j)
                    nums[i] = nums[j];
                while (i<j && nums[i] <= pivot)
                    i++;
                if (i<j)
                    nums[j] = nums[i];
            }
            nums[i] = pivot;

            if (i == k)
                return pivot;
            if (i < k)
                return selectSort(nums,i+1,right,k);
            else
                return selectSort(nums,left,i-1,k);

        }
    }
}
