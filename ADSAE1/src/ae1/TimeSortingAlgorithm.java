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
            InsertionSort.insertionSort(sortedArrayInsertionSort);
            endTime = System.currentTimeMillis();
            System.out.println("InsertionSort: " + (endTime - startTime) + " milliseconds");

            startTime = System.currentTimeMillis();
            int[] sortedArraySelectionSort = Arrays.copyOf(array, array.length);
            SelectionSort.selectionSort(sortedArraySelectionSort);
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
}

