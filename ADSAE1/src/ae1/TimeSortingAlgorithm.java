package ae1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class TimeSortingAlgorithm {
    public static void main(String[] args) {
        String[] fileNames = {"int10.txt", "int50.txt"}; // List of file names to read arrays from
        //QuickSort (with partition)
        //QuickSort (with insertion)
        //3-Way Quicksort
        //ShellSort
        //SelectionSort
        //MergeSort
        //Task 3 Merge Sort
        // Loop through each file name
        for (String fileName : fileNames) {
            System.out.println("Time taken to sort " + fileName + ":");

            // Read array from file
            int[] array = readArrayFromFile(fileName);

            // Measure time taken by each sorting algorithm
            long startTime, endTime;
            startTime = System.currentTimeMillis();
            int[] sortedArrayInsertionSort = Arrays.copyOf(array, array.length);
            insertionSort(sortedArrayInsertionSort);
            endTime = System.currentTimeMillis();
            System.out.println("InsertionSort: " + (endTime - startTime) + " milliseconds");

            startTime = System.currentTimeMillis();
            int[] sortedArraySelectionSort = Arrays.copyOf(array, array.length);
            selectionSort(sortedArraySelectionSort);
            endTime = System.currentTimeMillis();
            System.out.println("SelectionSort: " + (endTime - startTime) + " milliseconds");

            // Add more sorting algorithms as needed

            System.out.println("---------------------------------------------");
        }
    }

    // Method to read array from file
    private static int[] readArrayFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            String[] numbers = line.split("\\s+");
            int[] array = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                array[i] = Integer.parseInt(numbers[i]);
            }
            reader.close();
            return array;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Insertion Sort Algorithm
    private static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are greater than key,
               to one position ahead of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Selection Sort Algorithm
    private static void selectionSort(int[] arr) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}

