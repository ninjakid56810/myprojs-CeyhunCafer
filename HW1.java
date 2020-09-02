//Ceyhun Cafer
//Professor Ziegler
//Homework 1 Due 9-2-2020
package myHomework;

public class HW1 {
	public static void main(String[] args) {
		
		//Write a program that prints the numbers from 1 to 100 with five values per line, two blank spaces between values.
		
		//declare variable
		int i;
		
		
		
		//insert for loop
		for(i = 1; i <= 100; i = i + 5) {			
			System.out.println(i + " " + (i + 1) + " " + (i + 2) + " " + (i + 3) + " " + (i + 4));
			
		/* The for loop will start going through my print statement with the variable i starting at i = 1. Since i = 1, it
		   will print out 1, then i + 1, which = 2, then i + 2, = 3, then i + 3, = 4, then i + 4, = 5. Now it will loop back 
		   since it is a for loop and since within the for loop i = 1 and we loop back to it the new i value is 6. this will
		   continue on a new line since we are using "println" and it will start at 6 since i itself after the first loop is i + 5 = 6.
		   So, on this new line i = 6, and i + 1 = 7 and so on. It caps at 100 and the for loop stops after it reaches 100.
		   */
			
		}
	}
}
