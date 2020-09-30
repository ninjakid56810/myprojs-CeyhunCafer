package myHomework;
import java.io.*;
import java.util.*;

public class HW3 {
	public static void main(String[] args) throws IOException{

		File myFile = new File("HW3input.txt"); // Making a new .txt file for input

		Scanner inputFile = new Scanner(myFile); // Letting it read the file

		PrintWriter outputFile = new PrintWriter("HW3output.txt"); // Creating the .txt output file

		outputFile.print("Ceyhun Cafer \nProfessor Ziegler \nHW3\nCISC 1115\n\n\n\n"); // My heading 

		// Declaring my variables
		int id;  // ID number of the student
		int ansRight; // Questions the student answered correctly
		int ansWrong; // Questions the student answered incorrectly
		int numOfStudents = 0; // Total number of students processed, starting at  0 because once the program has started there are 0 students processed.
		int totalAns; // Answers right and wrong combined.
		id = inputFile.nextInt(); // This makes the scanner read in from the input file and takes the first integer value as the id.


		while (id != -1) { // I am using a sentinel here to end my while loop because the very last ID  of my input file is -1 which will end the program basically.

			ansRight = inputFile.nextInt(); // Scanner takes next number as the answers right.
			ansWrong = inputFile.nextInt(); // Scanner takes the next next number as the answers wrong.
			totalAns = ansRight + ansWrong; // Setting a variable here to two other variables added. Student correct and incorrect answers combined is how many they in all answered.

			if(totalAns <= 50) // one giant while loop to satisfy the condition to make sure that all students answered 50 questions or less. Needed for extra credit part A. Seen in the else block at the end.
			{
				//part A

				outputFile.println("ID: " + id + "\nAnswered Correctly: " + ansRight + "\nAnswered Incorrectly: " + ansWrong); // The scanner has already received information from the input file. I am printing the ID, answers right and wrong.

				//part B

				int totalOmitted = 50 - totalAns; // Total of 50 questions. To find how many were omitted, do 50 minus answers right and wrong combined.
				outputFile.println("Total Answered: " + totalAns + "\nTotal Omitted: " + totalOmitted); //  printing out the variables to the output file

				//part C

				if (totalAns > 0) // if statement to satisfy condition that student answered any questions at all. THis is Extra credit B. 
				{
					double correctAnsPercentage = (double)ansRight / (double)totalAns; // setting Correct Answer Percentage to a double as the prompt states it is a decimal value.
					outputFile.printf("Correct Answer Percentage: " + "%5.3f%n", correctAnsPercentage); // using print f to set a precision to three decimal places as the prompt states and printing it out.
				} 
				else // else block to run if students answered no questions.
				{
					//Extra credit B
					outputFile.printf("Divide by 0 error. Student not processed.\n\n\n\n");
					id = inputFile.nextInt(); // needed to keep scanner going
					//if teacher wants it to be processed: numOfStudents++;
					continue; // continue with rest of code
				}

				//part D

				int numGrade = ansRight * 2; // To calculate students grade, multiply how many answers they correctly got times two.
				outputFile.println("Grade: "+ numGrade); // print out the variable

				//part E

				if(ansRight > ansWrong){// If there are more right answers than wrong, print that.
					outputFile.println("More right answers than wrong");
				}
				else if(ansRight < ansWrong){ // If there are more wrong answers than right, print that.
					outputFile.println("More wrong answers than right");
				} else { //If there are the same amount of right and wrong answers, print that.
					outputFile.println("The same amount of right and wrong answers");
				}

				//part F

				if(totalOmitted < 10) { // The prompt asks to state if there are over 10 , less than 10, or exactly 10 omitted. So if the variable is less or greater than 10 , it will print, and the last else block is for exactly 10. no condition needed.
					outputFile.println("Less than 10 omitted");
				}
				else if (totalOmitted > 10){
					outputFile.println("More than 10 omitted");
				} else {
					outputFile.println("Exactly 10 omitted");
				}

				outputFile.println("\n\n\n"); // some blank spaces

				//part H

				numOfStudents++; // Needed because for each iteration of the while loop, it counts as one student. 

				id = inputFile.nextInt(); // give scanner input to read
			}
			else
			{	//Extra credit  A  Remember this is all a giant if statement which condition is that the total answers has to be less than or equal to 50. This else block is saying that it is greater than 50 so the student can't be processed.
				outputFile.println("ID: " +id); // prints out id
				outputFile.println("More than 50 questions answered. Student Not processed\n\n\n\n");
				id = inputFile.nextInt(); // gives scanner input to read
			}
		}

		//part H

		outputFile.println("\n\n\n\nTotal amount of students processed: " + numOfStudents); // printing out how many students were  processed.


		inputFile.close(); // close the input file
		outputFile.close(); // close the output file.

	}


}