package ae1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.*;

public class TimeSortingAlgorithm {
    static String path = "ADSAE1\\src\\ae1\\"; 
    public static void main(String[] args) {
        String[] fileNames = {"int1000.txt","Bad.txt","dutch.txt","int20k.txt","int500k.txt","intBig.txt"}; // List of file names to read arrays from

        for (String fileName : fileNames) {
            System.out.println("Time taken to sort " + fileName + ":");

            // Read array from file
            int[] array = readArrayFromFile(path+fileName);

            // Measure time taken by each sorting algorithm

            //Insertion Sort (Task 2)
            long startTime, endTime;
            startTime = System.currentTimeMillis();
            int[] sortedArrayInsertionSort = Arrays.copyOf(array, array.length);
            InsertionSort.insertionSort(sortedArrayInsertionSort);
            endTime = System.currentTimeMillis();
            System.out.println("InsertionSort: " + (endTime - startTime) + " milliseconds");
            
            //SelectionSort (Task 2)

            startTime = System.currentTimeMillis();
            int[] sortedArraySelectionSort = Arrays.copyOf(array, array.length);
            SelectionSort.selectionSort(sortedArraySelectionSort);
            endTime = System.currentTimeMillis();
            System.out.println("SelectionSort: " + (endTime - startTime) + " milliseconds");

            //QuickSort with Partition (Task 1 A)

            startTime = System.currentTimeMillis();
            int[] sortedArrayQuickSortPartition = Arrays.copyOf(array, array.length);
            QuickSort.quicksortpart(sortedArrayQuickSortPartition, 0, sortedArrayQuickSortPartition.length -1);
            endTime = System.currentTimeMillis();
            System.out.println("QuickSort with Partition: " + (endTime - startTime) + " milliseconds");

            //QuickSort with InsertionSort (Task 1 B)

            startTime = System.currentTimeMillis();
            int[] sortedArrayQuickSortInsertion = Arrays.copyOf(array, array.length);
            QuickSort.quickSortWithInsertion(sortedArrayQuickSortInsertion, 0, sortedArrayQuickSortInsertion.length -1, 100, true);;
            endTime = System.currentTimeMillis();
            System.out.println("QuickSort with Insertion: " + (endTime - startTime) + " milliseconds");

            //Three Way Quick Sort (Task 1 C)

            startTime = System.currentTimeMillis();
            int[] sortedArrayThreeWayQuickSort = Arrays.copyOf(array, array.length);
            ThreeWayQuickSort.QuickSort(sortedArrayThreeWayQuickSort, 0, sortedArrayThreeWayQuickSort.length -1);
            endTime = System.currentTimeMillis();
            System.out.println("Three way QuickSort: " + (endTime - startTime) + " milliseconds");


            //ShellSort (Task 2)
            startTime = System.currentTimeMillis();
            int[] sortedArrayShellSort = Arrays.copyOf(array, array.length);
            ShellSort.shellSort(sortedArrayShellSort);
            endTime = System.currentTimeMillis();
            System.out.println("ShellSort: " + (endTime - startTime) + " milliseconds");


            //MergeSort (Task 2)
            startTime = System.currentTimeMillis();
            int[] sortedArrayMergeSort = Arrays.copyOf(array, array.length);
            MergeSort.sort(sortedArrayMergeSort,0,sortedArrayMergeSort.length-1);
            endTime = System.currentTimeMillis();
            System.out.println("MergeSort: " + (endTime - startTime) + " milliseconds");


            System.out.println("---------------------------------------------");

        }
    }

    // Method to read array from file
    public static int[] readArrayFromFile(String fileName) {
        try {
            List<Integer> numbersList = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = reader.readLine()) != null){
                int number = Integer.parseInt(line.trim());
                numbersList.add(number);
            }

            reader.close();
            int[] array = new int[numbersList.size()];
            for(int i = 0; i < numbersList.size();i++){
                array[i] = numbersList.get(i);
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}