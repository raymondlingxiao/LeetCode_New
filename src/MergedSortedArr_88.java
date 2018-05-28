public class MergedSortedArr_88 {
    class Solution1 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // compare from the end
            int i = m-1;
            int j = n-1;
            int end = m+n-1;
            while (i >=0 && j >=0){
                if (nums1[i] < nums2[j])
                    nums1[end--] = nums2[j--];
                else
                    nums1[end--] = nums1[i--];
            }
            while (j>=0){
                nums1[end--] = nums2[j--];
            }
        }
    }

    class Solution2 {
        // qsort
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m;
            int j = 0;
            while (i<m+n && j<n){
                nums1[i++] = nums2[j++];
            }
            quickSort(nums1,0,m+n-1);

        }

        private void quickSort(int[] nums, int low, int high){
            if (low >= high)
                return;
            int i = low;
            int j = high;
            int key = nums[i];
            while (i < j){
                while (i < j && nums[j] >= key)
                    j --;
                if (i < j){
                    nums[i] = nums[j];
                    i ++;
                }

                while (i < j && nums[i] <= key)
                    i ++;
                if (i < j){
                    nums[j] = nums[i];
                    j --;
                }
            }
            nums[i] = key;
            quickSort(nums,low,i-1);
            quickSort(nums,i+1,high);

        }
    }
}
