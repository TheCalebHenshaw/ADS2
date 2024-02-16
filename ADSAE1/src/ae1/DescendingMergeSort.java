package ae1;

import java.util.Arrays;

//PART 3 TASK A

public class DescendingMergeSort {
    public static void mergeSortDescending(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSortDescending(arr, low, mid);
            mergeSortDescending(arr, mid + 1, high);
            mergeDescending(arr, low, mid, high);
        }
    }

    public static void mergeDescending(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] >= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }
    }

    public static int[] findILargestElements(int[] arr, int i) {
        mergeSortDescending(arr, 0, arr.length - 1);
        return Arrays.copyOfRange(arr, 0, i);
    }
    public static void main(String [] args){
        int[] arr = {1,5,8,2,4,2};

        int[] sortedArr = findILargestElements(arr, 3);
        System.out.println(Arrays.toString(sortedArr));
    }
}
