package myHomework;

import java.io.*;
import java.util.Scanner;

public class HW7_2 {
	
	/* 
	 * method main()

	 * Input:
	 * 		
	 * int[] vals : array storing integers
	 * int numElements : made to determine how many elements are in the array that are being used
	 * int numOfZeros : determines how many zeros there are within the array.
	 * 		
	 * Process:
	 * 
	 * This is the main function that globally declares arrays and variables, passes them through methods and calls the methods.
	 * 		
	 * Output: 
	 * 
	 * main prints the heading, the new array, and the updated number of elements and zeros within the new array .
	 * 		
	 * */

	public static void main(String[] args) throws IOException{
		
		
		int[] vals = new int[100]; // new int array to hold the initial values. up to 100 indexes / positions.
		int numElements = 0; // declaring needed variables to pass through methods.
		int numOfZeros = 0;
		
		PrintWriter outputFile = new PrintWriter("HW7_2output.txt"); // making output file
		
		outputFile.print("Ceyhun Cafer \nProfessor Ziegler \nHW7_2\nCISC 1115\n\n"); // heading
	
		numElements = readData(vals, outputFile); // saving return values done by other method readData
		numOfZeros = countZeros(numElements, vals); // saving return value done by method countZeros
		
		outputFile.println("Total zeros counted: " + numOfZeros); // print the number of zeros in the initial array
		outputFile.println(); // blank line to separate in output file
		
		outputFile.println("Appended Array: \n"); // new array will be under here in output file
		
		numElements = append(numElements, vals); // new method is called to save new number into existing variable, will return and save a new number of elements
		numOfZeros = countZeros(numElements, vals); // new method is called to save new number into existing variable, will return and save a new number of zeros within the elements.
		
		
		
		
		for(int i = 0; i < numElements; i++) {
			
			outputFile.println(vals[i]); // display new array elements
			
		}
		
		
		outputFile.println("\nNew total integers counted: " + numElements); // prints new total element value to text file
		outputFile.println("New total zeros counted: " + numOfZeros); // print new zeros counted
		
		
		
		outputFile.close();

	}
	
	public static int readData(int[] vals, PrintWriter output) throws IOException{

		
		File myFile = new File("initValues.txt"); // make a new file to read the initial array
		Scanner inputFile = new Scanner(myFile);  // read the input file
		
		int i = 0; // declaring needed variables
		int numElements = 0;
		
		while(inputFile.hasNext()) { // stores data  into an array
			
			vals[i] = inputFile.nextInt();
			i++;
			numElements++; // increment to change index position and fill array
			
			
		}
		
		output.println("The elements within the array are: \n"); 
		
		for(int j = 0; j < numElements; j++) {
			
			output.println(vals[j]); // prints initial array list
			
		}
		output.println("\nTotal integers counted: " + i);
		
		inputFile.close();
		return numElements; // return the value to main and save it
		
	}
	
	/* 
	 * method readData()

	 * Input: 
	 * 
	 * int i : increments through array index positons
	 * int numElements : will increment if an  index position is filled	
	 * 		
	 * Process:
	 * 		
	 * What this method does is that it simply stores the initial values from the text values into an array
	 * 		
	 *
	 * Output: 
	 * 		
	 * Prints the initial array values,  how many elements there are, and the amount of zeros there are as well.
	 * returns numElements to main
	 * 
	 * */

	public static int countZeros(int numElements, int[] vals) {
		
		int numOfZeros = 0; // declaring needed variable
		
		for(int i = 0; i < numElements; i++) {
			
			if(vals[i] == 0) {
				
				numOfZeros++; // iterating through each index and determine if the element value contains a zero. If contains zero, increment variable by one.
				
			}
			
		}
		
		
		return numOfZeros; // return value to main
	}
	
	/* 
	 * method countZeros()

	 * Input:
	 * 
	 * int numOfZeros : determines how many zeros there are
	 * int i : simply goes through all the positions in the array
	 * 		
	 * Process:
	 * 
	 * checks each position in the array and if the value is 0, it will increment the variable numOfZeros
	 * 		
	 * 		
	 *
	 * Output: 
	 * 
	 * returns numOfZeros to main
	 * 		
	 * */

	public static int append(int numElements, int[] vals) throws IOException{
		
		File myFile = new File("newValues.txt"); // making a new file for the new values that will  be appended
		Scanner inputFile1 = new Scanner(myFile); // reading the file
		
		int newValue = 0; // declaring needed variable
		
		while(inputFile1.hasNext()) {
			
			newValue = inputFile1.nextInt(); // will simply store into the initial array starting at where the initial array ends.
			vals[numElements] = newValue;
			numElements++;
			
		}
		
		
	
		inputFile1.close();
		
		return numElements; // return value to main
	}
	
	/* 
	 * method append()
	 * 
	 * Input:
	 * 
	 * int newValue : storing the values from the appended array now
	 * 		
	 * 		
	 * Process:
	 * 		
	 * stores into array but from where the initial array values ended.
	 *
	 * Output: 
	 * 
	 * returns numElements
	 * 		
	 * */

}
