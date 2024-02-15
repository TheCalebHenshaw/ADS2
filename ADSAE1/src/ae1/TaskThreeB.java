package ae1;

import java.util.Arrays;

public class TaskThreeB {
     public static int[] findElements(int[] arr, int i) {
        int n = arr.length;
        
        // perform Merge Sort to sort the array
        mergeSort(arr, 0, n - 1);

        // return the last i elements of the sorted array
        return Arrays.copyOfRange(arr, n-i,n-i+i);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; ++i) {
            left[i] = arr[low + i];
        }
        for (int j = 0; j < n2; ++j) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2 && k < high) {
            if (left[i] <= right[j]) {
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
    public static void main(String[] args){
        int[] arr = {1,5,8,2,4,2};

        int[] sortedArr = findElements(arr, 3);
        System.out.println(Arrays.toString(sortedArr));
    }

}
