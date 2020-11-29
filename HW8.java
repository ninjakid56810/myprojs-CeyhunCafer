package myHomework;

import java.io.*;
import java.util.*;

public class HW8 {

	public static void main(String[] args) throws IOException{

		File myFile = new File("HW8input.txt");
		Scanner inputFile = new Scanner(myFile); // making file, reading file, making output file.
		PrintWriter outputFile = new PrintWriter("HW8output.txt");
		outputFile.print("Ceyhun Cafer \nProfessor Ziegler \nHW8\nCISC 1115\n\n");

		String str= inputFile.nextLine(); // takes input from input file and stores it
		String str1 = str.replace(".",""); // gets rid of any periods
		str1 = str1.toLowerCase(); // makes all words lower case

		String storeEveryWord[] = str1.split(" "); // stores each word into array
		Arrays.sort(storeEveryWord); // sorts by alphabetical order
		String[] uniqueWords = new String[storeEveryWord.length]; // parallel arrays , new array is created to hold unique words
		int[] wordCount = new int[storeEveryWord.length];

		countWords(str1, storeEveryWord, uniqueWords, wordCount); // calls method here
		
		for(int i=0; i < uniqueWords.length && uniqueWords[i] != null; i++){

			outputFile.println(uniqueWords[i] + ": " + wordCount[i]); // displays to file what the arrays hold.

		}

		inputFile.close();
		outputFile.close();

	}
	
	/* method wordCount()
	 * Input:
	 * 		
	 * 		String storeEveryWord[] : turns the string input by the user into array elements basing each element 
	 *      off the cutoff of a space bar within the string. 
	 * 
	 * 		String[] uniqueWords - This array makes it so it holds only 1 of every word within the first array.
	 *      Every different / unique word.
	 * 
	 * 		int[] wordCounts - This counts the frequency of the word. it is of course a parallel array so its corresponding index in unique words matches the frequency for that word.
	 * 
	 * Process:
	 * 
	 * 		countWords(String str1, PrintWriter outputFile, String[] storeEveryWord, String[] uniqueWords, int[] wordCount ): 
	 *       countWords() is a void function where it iterates through every array element within uniqueWords and storeEveryWord. It compares the two values and if they are the same the word frequency
	 *       for that word (array wordCount) is added +1 (++). If not, it will just stay at one.
	 * 
	 * Output:
	 * 
	 * 		The method does not print anything but it does alter the data of the two parallel arrays uniqueWords and wordCount, returns the data back to main and main outputs it to the file.
	 * 
	 */

	public static void countWords(String str1, String[] storeEveryWord, String[] uniqueWords, int[] wordCount ) {

		uniqueWords[0] = storeEveryWord[0]; // sets them as the same value

		wordCount[0] = 1; // if word appears it is at least always one

		for (int i = 1, j = 0; i < storeEveryWord.length; i++){ // iterates through entire array

			if (storeEveryWord[i].equals(uniqueWords[j])){ // if these two are the same the count must go up  because it appears twice

				wordCount[j]++;

			} else{

				j++; // keeps iterating
				uniqueWords[j] = storeEveryWord[i];
				wordCount[j] = 1;
				
			}

		}

	}



}

