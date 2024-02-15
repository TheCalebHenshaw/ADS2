package ae1;

public class ThreeWayQuickSort {

    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void partition(int[] A, int low, int high, int i, int j){
        if(high - low <=1){
            if(A[high] < A[low]){
                swap(A, high, low);
            }
        i = low;
        j = high;
        return;
        }
    int mid = low;
    int pivot = A[high];
    while(mid <= high){
        if(A[mid] < pivot){
            
        }
    }
    }   
}
