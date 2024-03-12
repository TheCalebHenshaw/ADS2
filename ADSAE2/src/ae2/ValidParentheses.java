package ae2;

import java.util.Stack;
import java.util.Scanner;


public class ValidParentheses {

    public static boolean preCheck(String toCheck){ //to check if empty and all are parantheses
        String noSpaces = toCheck.strip();
        if(noSpaces.isEmpty()){ return false;}
        
        for(int i = 0; i < noSpaces.length(); i++){
            char curr = noSpaces.charAt(i);
            if (curr != '(' && curr != '{' && curr != '[' && curr != ')' && curr != ']' && curr != '}') 
            {
                return false;
            }
            
    }
    return true;
    }
    public static String getInput(){
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter the parantheses: ");
            String toReturn = scan.nextLine().strip();
            if(!preCheck(toReturn)){
                toReturn = getInput();
            }
            return toReturn;
        }
    }
    public static boolean checkValidity(String toCheck){
        Stack<Character> stack = new Stack<>();
        for(char ch : toCheck.toCharArray()){
            if(ch == '(' || ch == '{' || ch== '['){
                stack.push(ch);
            } else if(ch == ')' || ch == '}' || ch == ']'){
                if(stack.isEmpty() || !matchingChar(stack.pop(), ch)){
                    notValid();
                    return false;
                    
                }
            }
        }
        return stack.isEmpty();
    }

    public static void notValid(){
        System.out.println("The expression is not valid");
    }
    public static void isValid(){
        System.out.println("The expression is valid");
    }
    public static boolean matchingChar(char left, char right){
        return (left == '(' && right == ')') || (left == '{' && right == '}') || (left == '[' && right == ']');
    }




    public static void main(String[] args){
        String test = getInput();
        System.out.println("Input recognized as: "+test);
        System.out.println(checkValidity(test));

    }
}
