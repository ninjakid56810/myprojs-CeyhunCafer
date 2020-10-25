package myHomework;

import java.io.*;
import java.util.*;

public class HW6 {

	public static void main(String[] args)  throws IOException{
		
		File myFile = new File("HW6input.txt"); // Making a new file to input

		Scanner inputFile = new Scanner(myFile); // Letting it read the file

		PrintWriter outputFile = new PrintWriter("HW6output.txt"); // Creating the output file
		
		outputFile.print("Ceyhun Cafer\nProfessor Ziegler\nHW6\nCISC 1115\n\n\n"); // My heading
		
		
		int calcUsed = 0;//This is a counter for how many times the calculator is used. It will be shown at the very bottom of the output.
		
		do {// The program runs through these cases as it receives input, when it hits Q, the while loop will stop.
			
			menu(); // the menu of options printed to the console / screen.
			
			char userChoice = inputFile.next().charAt(0);// Will read in the operations ex: + , - , / , A, X, m, M
			
			switch(userChoice) { // userChoice is the variable that holds the operations and will sort through them for which case to pick
			
			case '+': // if user choice stores the character + from input, it will call the function to add.
				methodAdd(inputFile, outputFile);// my parameters are my input and output file that i am sending to the method to write to them.
				calcUsed++; // If the input has a +, it will add one to the counter for the amount of times the calculator is used.
				break;// will not go through other cases and will repeat to top of loop until condition of the while is met of Q or has next line.
				
			case '-': // if user choice stores the character - from input, it will call the function to subtract two numbers.
				methodSubtract(inputFile, outputFile);// my parameters are my input and output file that i am sending to the method to write to them.
				calcUsed++;
				break;
				
			case '*': // if user choice stores the character * from input, it will call the function to multiply the two numbers.
				methodMultiply(inputFile, outputFile);// my parameters are my input and output file that i am sending to the method to write to them.
				calcUsed++;
				break;
				
			case '/': // if user choice stores the character / from input, it will call the function to divide two numbers.
				methodDivide(inputFile, outputFile);// my parameters are my input and output file that i am sending to the method to write to them.
				calcUsed++;
				break;
				
			case '%': // if user choice stores the character % from input, it will call the function to find the remainder of two numbers.
				methodModulo(inputFile, outputFile);// my parameters are my input and output file that i am sending to the method to write to them.
				calcUsed++;
				break;
				
			case 'A': // letting the user input a or A so the case of the letter does not matter.
			case 'a': // if user choice stores the character A from input, it will call the function to find the average of two numbers.
				methodAverage(inputFile,outputFile);// my parameters are my input and output file that i am sending to the method to write to them.
				calcUsed++;
				break;
				
			case 'X': // if user choice stores the character X from input, it will call the function to find the max of two numbers.
			case 'x':
				methodMax(inputFile, outputFile);// my parameters are my input and output file that i am sending to the method to write to them.
				calcUsed++;
				break;
				
			case 'M': // if user choice stores the character M from input, it will call the function to find the minimum value of the two numbers.
			case 'm':
				methodMin(inputFile, outputFile);// my parameters are my input and output file that i am sending to the method to write to them.
				calcUsed++;
				break;
			
			case 'S': // if user choice stores the character S / s from input, it will call the function to find the square of the number.
			case 's':
				methodSquare(inputFile, outputFile);// my parameters are my input and output file that i am sending to the method to write to them.
				calcUsed++;
				break;
				
			case 'Q': // if the user inputs this, the program stops.
			case 'q':
				break;
			}
			
		} while(inputFile.hasNext());
		
		outputFile.println("Number of times this calculator was used before user Quit: " + calcUsed);
		System.out.println("The program was terminated successfully.");
		
		inputFile.close();
		outputFile.close();
		
	}
	
	public static void menu() {
		
		System.out.println("Please pick any of the following, or type Q to quit: "); // console showing the menu
		System.out.println("+");
		System.out.println("-");
		System.out.println("*");
		System.out.println("/");
		System.out.println("%");
		System.out.println("A");
		System.out.println("X");
		System.out.println("M");
		System.out.println("S");
		System.out.println("Q\n\n");
		
	}
	
	public static void methodAdd(Scanner HW6input, PrintWriter HW6output) throws IOException{ // void function, calling my input and output from my main
		
		int num1 = HW6input.nextInt(); // taking in the numbers the user put in
		int num2 = HW6input.nextInt();
		
		int sum = num1 + num2; // setting a variable to the numbers added to eachother.
		
		HW6output.println("Operation: addition"); // shows what operation they chose
		HW6output.println("Augend: " + num1);
		HW6output.println("Addend: " + num2);
		HW6output.println("Sum: " + sum);
		HW6output.println("\n"); // blank space to seperate between each calculator use for operation
		
	}
	
	public static void methodSubtract(Scanner HW6input, PrintWriter HW6output) throws IOException{
		
		int num1 = HW6input.nextInt();
		int num2 = HW6input.nextInt();
		
		int difference = num1 - num2; // subtracting the first number by the second number and setting it to a variable that I will call into the output
		
		HW6output.println("Operation: subtraction");
		HW6output.println("Minuend: " + num1);
		HW6output.println("Subtrahend: " + num2);
		HW6output.println("Difference: " + difference);
		HW6output.println("\n");

	}
	
	public static void methodMultiply(Scanner HW6input, PrintWriter HW6output) throws IOException{
		
		int num1 = HW6input.nextInt();
		int num2 = HW6input.nextInt();
		
		int product = num1 * num2; // multiplies the two numbers and stores it as variable product
		
		HW6output.println("Operation: multiplication");
		HW6output.println("Multiplicand: " + num1);
		HW6output.println("Multiplier: " + num2);
		HW6output.println("Product: " + product);
		HW6output.println("\n");
		
	}
	
	public static void methodDivide(Scanner HW6input, PrintWriter HW6output) throws IOException{
		
		double num1 = HW6input.nextDouble();
		double num2 = HW6input.nextDouble();
		
		double quotient = num1 / num2; // divides the two numbers and stores it as a double to account for decimals
		
		HW6output.println("Operation: division");
		HW6output.println("Dividend: " + num1);
		HW6output.println("Divisor: " + num2);
		HW6output.println("Quotient: " + quotient);
		HW6output.println("\n");
		
	}
	
	public static void methodModulo(Scanner HW6input, PrintWriter HW6output) throws IOException{
		
		int num1 = HW6input.nextInt();
		int num2 = HW6input.nextInt();
		
		int modulo = num1 % num2; // finds the remainder of the two numbers
		
		HW6output.println("Operation: modulo");
		HW6output.println("Dividend: " + num1);
		HW6output.println("Divisor: " + num2);
		HW6output.println("Modulo: " + modulo);
		HW6output.println("\n");
		
	}
	
	public static void methodAverage(Scanner HW6input, PrintWriter HW6output) throws IOException{
		
		int num1 = HW6input.nextInt();
		int num2 = HW6input.nextInt();
		
		int average = (num1 + num2) / 2;  // finds the avereage of the two numbers by adding the numbers first then dividing by 2
		
		HW6output.println("Operation: average");
		HW6output.println("First number: " + num1);
		HW6output.println("Second number: " + num2);
		HW6output.println("Average: " + average);
		HW6output.println("\n");
		
	}
	
	public static void methodMax(Scanner HW6input, PrintWriter HW6output) throws IOException{
		
		int num1 = HW6input.nextInt();
		int num2 = HW6input.nextInt();
		
		if(num1 > num2) { // what this does is that if the first number is greater than the second number, print the first number.
			
			HW6output.println("Operation: maximum");
			HW6output.println("First number: " + num1);
			HW6output.println("Second number: " + num2);
			HW6output.println("The biggest value of the two numbers is: " + num1);
			HW6output.println("\n");
			
		} else if(num2 > num1) { // if the second number is greater than the first number, print the second number.
			
			HW6output.println("Operation: maximum");
			HW6output.println("First number: " + num1);
			HW6output.println("Second number: " + num2);
			HW6output.println("The biggest value of the two numbers is: " + num2);
			HW6output.println("\n");
			
		} else { // if it is neither of the if statements above, then they must be equal to eachother.
			
			HW6output.println("Operation: maximum");
			HW6output.println("First number: " + num1);
			HW6output.println("Second number: " + num2);
			HW6output.println("The two numbers are equal to each other.\n\n");
			
		}

	}
	
	public static void methodMin(Scanner HW6input, PrintWriter HW6output) throws IOException{
		
		int num1 = HW6input.nextInt();
		int num2 = HW6input.nextInt();
		
		if(num1 < num2) {// if the first number is less than the second number, print the first number because we are looking for the least value.
			
			HW6output.println("Operation:  minimum");
			HW6output.println("First number: " + num1);
			HW6output.println("Second number: " + num2);
			HW6output.println("The smallest value of the two numbers is: " + num1);
			HW6output.println("\n");
			
		} else if(num2 < num1){// if the second number is less than the first number, print the second number because we are looking for the least value.
			
			HW6output.println("Operation: minimum");
			HW6output.println("First number: " + num1);
			HW6output.println("Second number: " + num2);
			HW6output.println("The smallest value of the two numbers is: " + num2);
			HW6output.println("\n");
			
		} else { // if none of the if statements above are true, then they must be equal to eachother. So we print that the two numbers are equal.
			
			HW6output.println("Operation: minimum");
			HW6output.println("First number: " + num1);
			HW6output.println("Second number: " + num2);
			HW6output.println("The two numbers are equal to each other.\n\n");
			
		}
		
	}
	
	public static void methodSquare(Scanner HW6input, PrintWriter HW6output) throws IOException{
		
		int num1 = HW6input.nextInt(); // only taking one input this time since we are only looking for the square of one number.
		
		int square = num1 * num1; // To find the square simply multiply the number put in by the user by itself.
		
		HW6output.println("Operation: square");
		HW6output.println("The number you chose to square is: " + num1);
		HW6output.println("The squared value is: " + square);
		HW6output.println("\n");
		
	}
	
}
