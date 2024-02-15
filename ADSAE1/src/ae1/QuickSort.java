package ae1;

public class QuickSort {
    //partition and quicksort as methods
    //implement testing 
    public static int partition(int[] A, int p, int r){
        int x = A[r];
        int i = p - 1;
        for(int j = p; j< r;j++){
            if(A[j] <= x){
                i = i + 1;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp; 

        return i+1;
    }
    public static void quicksortpart(int[] A, int p, int r){
        //edit the existing array
        //Part A
        if(p < r){
            int q = partition(A, p, r);
            quicksortpart(A, p, q-1);
            quicksortpart(A, q+1, r);
        }
    }


    public static int[] insertionsort(int[] arr){
        int n = arr.length -1;
        for(int j =1; j<=n; j++){
            int key = arr[j];
            int i = j-1;
            while(i >= 0 && arr[i] < key){
                arr[i+1] = arr[i];
                i=i-1;
            }
            arr[i+1] = key;
        }
        return arr;
    }
    public static void quickSortWithInsertion(int[] A, int p, int r, int k, boolean first){
        if(p < r && r-p >= k){
            int q = partition(A, p, r);
            quickSortWithInsertion(A, p, q-1, k, false);
            quickSortWithInsertion(A, q+1, r, k, false);

        }
        if(first){
            InsertionSort.insertionSort(A);;
        }

    }
    public static void main(String[] args){
        //Use this to test inside the class
        int[] A = {5,3,56,8,9,6,4,2,1,3,4,6,8,5,7,1,5,3,7,8,9};
        quickSortWithInsertion(A, 0, A.length -1, 10, true);
        for(int a : A){
            System.out.print(a + ",");
        }

    }
}
