package ae1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TaskThreeB {
     public static int[] findLargest(int[] arr, int i){
        int n = arr.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(i);
        for(int j = 0; j < i; j++){
            minHeap.offer(arr[j]);

        }
        for(int j = i; j < n; j++){
            if(arr[j] > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(arr[j]);
            }
        }
        int[] result = new int[i];
        for(int j = i - 1; j >= 0; j--){
            result[j] = minHeap.poll();
        }
        return result;
     }

    public static void main(String[] args){
        int[] arr = {1,5,8,2,4,2};

        int[] sortedArr = findLargest(arr, 3);
        System.out.println(Arrays.toString(sortedArr));
    }

}
