package ae1;

public class ThreeWayQuickSort {

//Time Complexity of O(log n * n)

    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void partition(int A[], int low, int high, int[] pivotIndices){
        int pivot = A[high];
        int i = low;
        int mid = low;
        int j = high;

        while (mid <= j) {
            if (A[mid] < pivot) {
                swap(A, i++, mid++);
            } else if (A[mid] == pivot) {
                mid++;
            } else { // A[mid] > pivot
                swap(A, mid, j--);
            }
        }

        pivotIndices[0] = i - 1;
        pivotIndices[1] = mid;
    }

       
    public static void QuickSort(int[] A,int low, int high){
        if(low>=high){
            return;
        }
        int[] pivotIndices = new int[2];
        partition(A, low, high, pivotIndices);
        QuickSort(A,low,pivotIndices[0]);
        QuickSort(A, pivotIndices[1], high);
    }
}
