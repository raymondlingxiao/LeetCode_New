public class QuickSort {
    private void quickSort(int[]nums, int s, int e){
        // the exit for every recursion
        if (s>e)
            return;
        int pivot  = nums[s];
        int i=s;
        int j=e;

        while (i<j){
            while (j>i && nums[j] >=pivot){
                j--;
            }

            nums[i] = nums[j];
            while (i<j && nums[i] < pivot){
                i++;
            }

            nums[j] = nums[i];
        }

        nums[i] = pivot;
        quickSort(nums,s,i-1);
        quickSort(nums,i+1,e);


    }
}
