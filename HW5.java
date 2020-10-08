package myHomework;

import java.io.*;
import java.util.*;

public class HW5 {
	public static void main(String args[]) throws IOException{

		File myFile = new File("HW5input.txt"); // Making a new .txt file for input

		Scanner inputFile = new Scanner(myFile); // Letting it read the file

		PrintWriter outputFile = new PrintWriter("HW5output.txt"); // Creating the .txt output file

		outputFile.print("Ceyhun Cafer\nProfessor Ziegler\nHW3\nCISC 1115\n\n\n"); // My heading 

		int score1, score2, score3, totalGroups = 0, invalidGroups = 0, validGroups = 0; // declaring int variables

		score1 = inputFile.nextInt(); // read in the first score

		while(score1 != -999) { // sentinel at end of input to stop the program

			score2 = inputFile.nextInt();// read in the second score
			score3 = inputFile.nextInt(); // read in the third score

			outputFile.print("Score 1: " + score1 + "   ");
			outputFile.print("Score 2: " + score2 + "    "); // print out the three scores
			outputFile.println("Score 3: " + score3 + "   ");
			

			totalGroups++; // every iteration of the while loop this counter will go up 
			
			boolean isValid; // declaring boolean variables
			
			isValid = validGroup(score1, score2, score3, outputFile);  // setting a boolean value to what the method returned
			
			if(!isValid) { //takes the value of the bool isValid and basically if the value is false it will add to the counter of invalid groups. IF its true, then proceed with the other methods 
				
				invalidGroups++;
				
			} else {
				
				validGroups++;
				oneGameScore(score1, outputFile);
				oneGameScore(score2, outputFile);// Giving a statement for each score
				oneGameScore(score3, outputFile);
				outputFile.println("The average of the three scores were: " + avg3Scores(score1, score2, score3)); // averaging the three scores
				outputFile.print("Total ");
				oneGameScore(avg3Scores(score1, score2, score3), outputFile); // giving a statmement on the average of the three scores
				
			}

			outputFile.println("\n\n"); // blank spaces
			
			score1 = inputFile.nextInt(); // reading in the next score

		}

		outputFile.println("\n\nTotal number of groups processed: " + totalGroups);
		outputFile.println("Total number of valid groups processed: " + validGroups); // Stating the number total groups, valid and invalid processed 
		outputFile.println("Total number of invalid groups processed: " + invalidGroups);

		inputFile.close(); // closing input and output file
		outputFile.close();
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean validGroup(int score1, int score2, int score3, PrintWriter HW5output) {

		boolean validGroup = true; // needed for bool method

		if(score1 > 300) { // if user scored greater than 300 points which is impossible, validgroup will be false and print its invalid.
			
			validGroup = false;
			
			HW5output.println("Score " + score1 + " is invalid because it is greater than 300.");
			
		}
		if(score1 < 0) { // if user scored less than 0 points which is impossible, validgroup will  be false and pirnt its invalid.
			validGroup = false;
			
			HW5output.println("Score " + score1 + " is invalid because it is less than 0.");
		}

		if(score2 > 300) {
			validGroup = false;
			
			HW5output.println("Score " + score2 + " is invalid because it is greater than 300.");
		}

		if(score2 < 0) {
			validGroup = false;
			
			HW5output.println("Score " + score2 + " is invalid because it is less than 0.");
		}

		if(score3 > 300) {
			validGroup = false;
			
			HW5output.println("Score " + score3 + " is invalid because it is greater than 300.");
		}

		if(score3 < 0) {
			validGroup = false;
			
			HW5output.println("Score " + score3 + " is invalid because it is less than 0.");
		}

		
		if(!validGroup) { // If the validgroup is false , it will print to the outputfile the group is invalid.
			HW5output.println("Group is invalid");
			
		}
		
		if(validGroup) { // if the validgroup is true, it will print to the outputfile the group is valid.
			HW5output.println("Group is valid");
		}
		
		
		return validGroup; // returning the value of validgroup to main for further processing.
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void oneGameScore(int score, PrintWriter HW5output) {

		if(score  >= 250 && score <= 300) { // This function will only run if its valid. Therefore no if statements are needed for invalid values.
											// Valid values are between 0 - 300. First if statement is if score is greater than or equal to 250 and less than 300, it will print its a proffesional game.
			HW5output.println("Score of : " + score + " was a professional game");
		}

		if(score  >= 200 && score <= 249) { // if its between 200 and 249 , excellent game.
			
			HW5output.println("Score of : " + score + " was an excellent game");
			
		}

		if(score  >= 140 && score <= 199) { // if its between 140 and 199, it was a very good game.
			
			HW5output.println("Score of : " + score + " was a very good game");
			
		}

		if(score  >= 100 && score <= 139) {// if its between 100 and 139, it was a good game.
			
			HW5output.println("Score of : " + score + " was a good game");
			
		}

		if(score  >= 50 && score <= 99) {// if its between 50 and 99, it was a poor game.
			
			HW5output.println("Score of : " + score + " was a poor game");
			
		}

		if(score  <= 50) { // if its under 50, it was a horrible game.
			
			HW5output.println("Score of : " + score + " was a horrible game");
			
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static int avg3Scores(int score1, int score2 ,int score3) {
		
		int avg3Scores = 0;
		
		avg3Scores = (score1 + score2 + score3) / 3; // adding up all three scores and dividng by 3 to find average and setting it into a variable int.
		

		
		
		return avg3Scores; // returning it to main for further processing like calling into oneGameScore.
		
	}


}
