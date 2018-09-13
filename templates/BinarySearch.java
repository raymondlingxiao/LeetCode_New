public class BinarySearch {
    public boolean binarySearch(int[] arr, int target{
        if (arr == null || arr.length == 0)
            return false;
        int s = 0;
        int t = arr.length-1;

        while (s+1<t){
            int mid = s + (t-s)/2;
            if (mid == target)
                return true;
            if (mid < target)
                s = mid;
            if (mid > target)
                t = mid;
        }

        if (arr[s] == target)
            return true;
        if (arr[t] == target)
            return true;
        return false;

    }
}
