package ae2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class BSTHeightHistogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();
        scanner.close();

        int[] heights = new int[n + 1];
        long totalHeight = 0;

        // Generate all permutations of {1, 2, ..., n}
        List<List<Integer>> permutations = generatePermutations(n);

        // Compute BST heights for each permutation
        for (List<Integer> permutation : permutations) {
            BST bst = new BST();
            for (int num : permutation) {
                bst.insert(num);
            }
            int height = bst.getHeight();
            heights[height]++;
            totalHeight += height;
        }

        // Print histogram
        System.out.println("Height\tFrequency");
        for (int i = 0; i <= n; i++) {
            System.out.println(i + "\t\t" + heights[i]);
            
        }

        // Calculate and print average height
        double averageHeight = (double) totalHeight / permutations.size();
        averageHeight-=1.0; //average must be n-1

        System.out.println("Average Height: " + averageHeight);
    }

    // Generate all permutations of {1, 2, ..., n}
    private static List<List<Integer>> generatePermutations(int n) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        permute(nums, 0, permutations);
        return permutations;
    }

    private static void permute(List<Integer> nums, int start, List<List<Integer>> permutations) {
        if (start == nums.size() - 1) {
            permutations.add(new ArrayList<>(nums));
        } else {
            for (int i = start; i < nums.size(); i++) {
                Collections.swap(nums, start, i);
                permute(nums, start + 1, permutations);
                Collections.swap(nums, start, i);
            }
        }
    }

    // Binary Search Tree (BST) class
    static class BST {
        Node root;

        static class Node {
            int data;
            Node left, right;

            Node(int data) {
                this.data = data;
                left = right = null;
            }
        }

        // Insert a node in BST
        void insert(int data) {
            root = insertRec(root, data);
        }

        Node insertRec(Node root, int data) {
            if (root == null) {
                root = new Node(data);
                return root;
            }

            if (data < root.data) {
                root.left = insertRec(root.left, data);
            } else if (data > root.data) {
                root.right = insertRec(root.right, data);
            }

            return root;
        }

        // Get height of BST
        int getHeight() {
            return getHeightRec(root);
        }

        int getHeightRec(Node root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = getHeightRec(root.left);
            int rightHeight = getHeightRec(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
