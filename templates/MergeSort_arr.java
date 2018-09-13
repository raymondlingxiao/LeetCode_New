public class MergeSort_arr {
    public int[] mergesort(int[] arr){
        if (arr == null || arr.length <= 1)
            return arr;

        int len = arr.length;
        int[] left = new int[len/2];
        int[] right = new int[len-len/2];

        System.arraycopy(arr,0,left,0,len/2);
        System.arraycopy(arr,0,right,len/2,len-len/2);

        left = mergesort(left);
        right = mergesort(right);

        return merge(left,right);
    }

    private int[] merge(int[] a, int[] b){
        if (a == null || a.length == 0)
            return b;
        if (b == null || b.length == 0)
            return a;
        int lenA = a.length;
        int lenB = b.length;

        int[] res = new int[lenA+lenB];
        int left =0;
        int right = 0;
        int resPos = 0;

        while (left < lenA && right < lenB){
            if (a[left] < b[right]){
                res[resPos++] = a[left++];
            }
            else{
                res[resPos++] = b[right++];
            }
        }

        if (left >= lenA){
            while (right < lenB)
                res[resPos++] = b[right++];
        }
        else{
            while (left < lenA)
                res[resPos++] = a[left];
        }

        return res;
    }
}
