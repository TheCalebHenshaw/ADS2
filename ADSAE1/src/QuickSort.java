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
    public static void quicksort(int[] A, int p, int r){
        //edit the existing array
        if(p < r){
            int q = partition(A, p, r);
            quicksort(A, p, q-1);
            quicksort(A, q+1, r);
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
    public static void main(String[] args){
        int[] lst = {6,2,78,23,2,57,2,8};
        quicksort(lst,0,7);
        for(int num : lst){
            System.out.print(num + ",");
        }
    }
}
