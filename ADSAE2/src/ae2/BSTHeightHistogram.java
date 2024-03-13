package ae2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class BSTHeightHistogram {
    



    public static void printHistogram(int n){
        float avgHeight;
        System.out.println("Height     Frequency");
        System.out.println("----------------------");
        for(int i = 0; i < n; i++){
            System.out.println(i+"       int result goes here");
        }
        System.out.println("\n" +"Average height of BSTs:" + " some float here");
    }

    public static void main(String[] args){
        int n = getInput();

        printHistogram(n);
    }
    public static int getInput(){

        try(Scanner scan = new Scanner(System.in)){
            System.out.println("Enter a positive integer n:");
            int toReturn = scan.nextInt();
            if(toReturn<0){
                System.out.println("Please enter a positive integer");
                toReturn = getInput();
            }
            return toReturn;
        }

    }
    public static int getBSTHeight(){
        return 0;
    }
}
