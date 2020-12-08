package myHomework;

import java.io.*;
import java.util.*;


public class HW9 {

	public static void main(String[] args) throws IOException{

		PrintWriter outputFile = new PrintWriter("HW9output.txt"); // making output file to display to
		outputFile.print("Ceyhun Cafer \nProfessor Ziegler \nHW9\nCISC 1115\n\n"); // heading

		final int MAX_SIZE = 50; // max size of 50 elements the array can hold

		int[] id = new int[MAX_SIZE];
		double[] donations = new double[MAX_SIZE]; // making arrays

		int donorCount = readData(id, donations); // readData is called to run and returns the integer to variable donorCount

		outputFile.println("\tOriginal Set of Data:\n");
		printData(id, donations, outputFile, donorCount); // calls printData for the initial set of ID numbers and donations

		selectionSort(id, donations, donorCount); // calls selectionSort method to selectively sort all ID numbers from least to greatest

		outputFile.println(" Selection Sort respective to ID's:\n"); // prints new array elements
		printData(id, donations, outputFile, donorCount);

		bubbleSort(id , donations, donorCount); // calls bubbleSort method to bubble sort all donations from least to greatest

		outputFile.println(" Bubble Sort respective to Donations:\n");// prints new array elements
		printData(id, donations, outputFile, donorCount);

		outputFile.close();

	}

	/*
	 * method readData(int[] id, double[] donations)
	 * 
	 * Input:
	 * 
	 *  text file of id numbers and donations 
	 * 
	 * Process:
	 * 	stores all the id numbers into the id[] array and all the donation amounts respective to the id number in the donations[] array
	 * 
	 * Output:
	 * 
	 *  returns the number of people who donated
	 * 
	 */

	public static int readData(int[] id, double[] donations) throws IOException{

		File myFile = new File("HW9input.txt"); // making file to read in id numbers and donations
		Scanner inputFile = new Scanner(myFile); // allowing it to be read 

		int i = 0; // i will be incremented to iterate through array index and change the values of them as the input file is read into each array index

		int donorCount = 0;

		while(inputFile.hasNext()) {

			id[i] = inputFile.nextInt();
			donations[i] = inputFile.nextDouble();
			i++;
			donorCount++; // each iteration is one person 

		}

		inputFile.close();

		return donorCount;
	}

	/*
	 * method printAccts()
	 * 
	 * Input: 
	 * 		expects arrays id[], donations[], number of people who donated (donorCount)
	 * 		and PrintWriter to write to output.
	 * 
	 * Process:
	 * 		uses for loop to iterate through all id's and donations and display them to output file
	 * 
	 * Output:
	 * 		returns nothing, void function.
	 * */

	public static void printData(int[] id, double[] donations, PrintWriter out, int donorCount) throws IOException{

		out.println("   ID NUMBER: \t        BALANCE: "); // table

		for(int i = 0; i < donorCount; i++) {

			out.printf("%10d %20.2f", id[i], donations[i]);
			out.println("");

		}

		out.println("");
	}

	/*
	 * method selectionSort(int id[], double donations[], int donorCount)
	 * 
	 * Input:
	 *  id[] array, donations[] array, donorCount[]
	 * 
	 * Process:
	 *  will selectively sort the id numbers from least to greatest
	 * 
	 * Output:
	 * 
	 * nothing, void function
	 * 
	 */

	public static void selectionSort(int id[], double donations[], int donorCount){

		/*this function selection sorts ID in numeric order*/

		int i,j;
		for(i = 0; i < donorCount-1; i++){

			int curr = i;

			for(j = i+1 ; j < donorCount; j++){

				if(id[j] < id[curr]){

					curr = j;

				}
			}

			if(curr != i){

				//what this does is it swaps the two id's being compared if j is greater than the element after it
				
				int tempId = id[i];
				id[i] = id[curr];
				id[curr] = tempId;
				
				// this swaps the donations with it to keep the id and donation number the same
				
				double tempDonation = donations[i];
				donations[i] = donations[curr];
				donations[curr] = tempDonation;

			}
		}
	}

	/*
	 * method bubbleSort(int id[], double donations[], int donorCount)
	 * 
	 * Input: id[] array, donations[] array, donorCount[]
	 *  
	 * 
	 * Process: will bubble sort the donations from least to greatest still with their respective ID number
	 * 
	 * Output:
	 * 
	 * nothing, void function.
	 * 
	 */

	public static void bubbleSort(int id[], double donations[], int donorCount){
		/*this function bubble sorts donations in ascending order*/

		for(int i = 0; i < donorCount-1; i++){

			for(int j = 0; j<donorCount-i-1; j++){

				if(donations[j] > donations[j+1]){

					//what this does is it swaps the two id's being compared if j is greater than the element after it
					
					int tId = id[j]; 
					id[j] = id[j+1];
					id[j+1] = tId;
					
					// this swaps the donations with it to keep the id and donation number the same
					
					double tDonation = donations[j];
					donations[j] = donations[j+1];
					donations[j+1] = tDonation;

				}
			}
		}
	}
}
