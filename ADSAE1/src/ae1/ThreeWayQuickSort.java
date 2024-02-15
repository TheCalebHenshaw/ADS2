package ae1;

public class ThreeWayQuickSort {

//Time Complexity of O(log n * n)

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
            swap(A, low++, mid++);
        }
        else if(A[mid] == pivot){
            mid++;
        }
        else if(A[mid] > pivot){
            swap(A,mid,high--);
        }
    }
    i = low-1;
    j = mid;
    }   
    public static void QuickSort(int[] A,int low, int high){
        if(low>=high){
            return;
        }
        int i = low, j = high;
        partition(A, low, high, i, j);
        QuickSort(A,low,i);
        QuickSort(A,j,high);
    }
}
