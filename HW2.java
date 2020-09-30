package myHomework;
import java.io.*;

//Ceyhun Cafer
//Professor Ziegler CISC 1115 HW2 Topic 2 Assignment 1

public class CeyhunCaferTopic2Assignment1HW2 {
	public static void main(String[] args) throws IOException{ 
		
		PrintWriter outputFile = new PrintWriter("HW2output.txt");
		
		outputFile.print("Ceyhun Cafer \nProfessor Ziegler \nHW2\nCISC 1115\n");

		outputFile.println("\t\tThis is the output of my first program:\n");  // I inserted two tab characters here to space it into the middle and two newline characters to have some blank space between the program and this sentence

		outputFile.println("\t\t\tTable of Function Values\n"); // here I write the title of the table and insert three tab characters to space it to the middle and a newline character to insert a blank line underneath it.

		outputFile.println("X Value: \t\t\t Y Value: \t\t\t   Status:"); // here I write the headers for the chart, showing the different values for the equation. Status being if it is negative, positive , or zero.
		// This for loop starts with x = -3, and adds .5 for every time it runs through the equation. 
		
		double x = 0.0;// Declaring my variables y being the output, x being the input.
		double y = 0.0;
		
		for(x = -3; x < 4.5; x+= .5) {

			y = ((9 * x * x * x) - (27 * x * x) - (4 * x) + 12) / (Math.sqrt((3 * x * x) + 1) + Math.abs(5 - x * x * x * x));// 9x^3 - 27x^2 - 4x + 12 / (3x^2)^1/2 ( i used math.sqrt and put that part of the equation into paranthesis )
			//Then, i used Math.abs for the rest of the equation of |5 - x^4|

			//This is the precision, which makes it so no matter where it is viewed from the table stays straight and aligned perfectly.
			outputFile.printf("%5.2f%35.3f", x , y);

			if(y == 0) {
				outputFile.print("\t\t\tY Is Zero");// If the output of the equation equals to 0, on the line of status it will write under status "Y is Zero"
				outputFile.println();
			}

			if(y > 0 ) {
				outputFile.print("\t\t\tY is Positive");// If the output of the equation equals to a number greater than  0, it will write under status "Y is Positive"
				outputFile.println();
			}

			if(y < 0) {
				outputFile.print("\t\t\tY is Negative");// If the output of the equation equals to a number less than 0 , it will write under status  " Y is negative"
				outputFile.println();
			}
		}
		// I inserted a newline character for a blank space between the program and the message showing that the program has ended. I added tab characters as well to make it aligned evenly.
		outputFile.println("\n\t\tThe table is complete, and the program has halted.");
		outputFile.close();
	}
}
