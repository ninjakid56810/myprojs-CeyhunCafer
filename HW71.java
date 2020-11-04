package myHomework;

import java.io.*;
import java.util.*;


public class HW7 {

	/* 
	 * method main()

	 * Input:
	 * 		a character ( b, w, d, n )
	 * 		
	 * Process:
	 * 		goes through switch cases of which character fits into the switch
	 * 		then will call appropriate method for user choice...
	 *
	 * Output: 
	 * 		prints everything in the output file and console
	 * */

	public static void main(String[] args) throws IOException{


		final int MAX_NUM = 50;
		int[] acctNum = new int[MAX_NUM];
		double[] balance = new double[MAX_NUM];  // declaring variables
		int numAccts = 0;
		int maxAccts = 50;
		int account = 0;
		char myChoice;

		File myFile = new File("HW71input.txt"); // Making a new text file for input
		Scanner inputFile = new Scanner(myFile); // Letting it read the file
		PrintWriter outputFile = new PrintWriter("HW71output.txt"); // Creating the text output file

		outputFile.print("Ceyhun Cafer \nProfessor Ziegler \nHW7.1\nCISC 1115\n\n"); // heading

		numAccts = readAccts(acctNum, balance, maxAccts); // assigning what method readAccts returns to a new variable
		printAccts(acctNum, balance, numAccts, outputFile); //

		do {

			System.out.println("Please pick an option: "); // prompting to pick option

			menu(); //calling menu to display

			myChoice = inputFile.next().charAt(0); // will store user input into variable

			System.out.println("You chose: " + myChoice);
			System.out.println("");

			switch (myChoice) { // will pick the case depending on the value of my choice

			case 'W':
			case 'w':

				withdrawal(acctNum, balance, numAccts, inputFile, outputFile); // calls withdraw method

				break;

			case 'D':
			case 'd':

				deposit(acctNum, balance, numAccts, inputFile, outputFile); // calls deposit method

				break;

			case 'N':
			case 'n':

				account = newAcct(acctNum, balance, numAccts, outputFile, inputFile); // sets account variable to return value of method being called

				if (account != -1) { // return value determines if account should be added to array 

					numAccts++;
					acctNum[numAccts] = account; // stores account information
					balance[numAccts] = 0;

				}

				break;

			case 'B':
			case 'b':

				balanceMethod(acctNum, balance, numAccts, inputFile, outputFile); // calls balance method to run

				break;

			case 'Q':
			case 'q':
				outputFile.println("");
				outputFile.println("\t  Updated Accounts");
				printAccts(acctNum, balance, numAccts, outputFile); //call t chart one last time as stated to in prompt
				break;

			default:

				System.out.println("Invalid Option! Please pick again.\n"); // if user chose none of the cases within switch, you will send this to console, and prompt again.
				break;

			}

		} while(inputFile.hasNext()); // runs until file has nothing left

		inputFile.close(); // closes files properly
		outputFile.close();

	}

	/*
	 * method menu()
	 * 
	 * Input: 
	 * 		none
	 * 
	 * Process:
	 *		none
	 *
	 *Output:
	 *		prints the options to the console  
	 *  */


	public static void menu() {

		System.out.println("B/b - Check Balance");
		System.out.println("D/d - Deposit");
		System.out.println("W/w - Withdraw");		// menu of options to choose from printed to console
		System.out.println("N/n - New Account");
		System.out.println("Q/q - Quit");

	}

	/*
	 * method readAccts()
	 * 
	 * Input:
	 * 		initial database of banking accounts
	 * 
	 * Process: 
	 * 		will store all the account numbers into acctNum[] array, and all the balances into balance[] array, respectively.
	 * 
	 * Output:
	 * 		returns the number of accounts of active
	 * */

	public static int readAccts(int[] acctNum, double[] balance, int maxAccts) throws IOException{

		File myFile = new File("initAccts.txt"); // reading initial database of accounts and balances here and storing into arrays respectively
		Scanner inputFile = new Scanner(myFile); 

		int numAccts = 0; // declaring variables
		int j = 0;
		int n = 0;

		while(inputFile.hasNext()) {

			acctNum[n] = inputFile.nextInt();
			n++;
			balance[j] = inputFile.nextDouble(); // this stores array elements
			j++;
			numAccts++; // every time it stores, number of valid accounts must go up by one.

		}

		inputFile.close();
		return numAccts; // returns how many valid accounts there are to main.

	}

	/*
	 * method printAccts()
	 * 
	 * Input: 
	 * 		expects arrays acctNum[], balance[], number of active accounts (numAccts)
	 * 		and PrintWriter to write to output.
	 * 
	 * Process:
	 * 		uses for loop to iterate through all active accounts and display them to output file
	 * 
	 * Output:
	 * 		returns nothing, void function.
	 * */

	public static void printAccts(int[] acctNum, double[] balance, int numAccts, PrintWriter HW71output) throws IOException{

		HW71output.println("Account Number \t        Balance");

		for(int i = 0; i < numAccts; i++) { // cycles through each index and displays element 

			HW71output.printf("%10d %20.2f", acctNum[i], balance[i]); // makes arrays into t chart
			HW71output.println("");

		}

		HW71output.println();

	}

	/*
	 * method balanceMethod()
	 * 
	 * Input: 
	 * 		arrays acctNum[], balance[], numAccts, scanner to read file and print writer to write to file.
	 * 
	 * Process:
	 * 		stores account number entered, if account number is in database will display balance available.
	 * 		if not, prints error.
	 * 
	 * Output:
	 * 		returns nothing, void function.
	 * */

	public static void balanceMethod(int[] acctNum, double[] balance, int numAccts, Scanner HW71input, PrintWriter HW71output) {

		System.out.println("Please enter your account number: "); // prompt

		int currentAccountNumber = HW71input.nextInt();

		HW71output.println("Transaction Type: Show balance");
		HW71output.println("Account number entered: " + currentAccountNumber);

		boolean accountIsValid = true; // needed in order to stop for loop repeating so many times after condition is filled

		for(int i = 0; i < numAccts && accountIsValid; i++) {

			if(acctNum[i] == currentAccountNumber) {

				accountIsValid = false;
				HW71output.println("The current balance for this account is: $" + balance[i]);
				HW71output.println("");

			} 

		}

		if(accountIsValid) {

			HW71output.println("Error: Account does not exist.\n");

		}

	}

	/*
	 * method findAcct()
	 * 
	 * Input:
	 * 		arrays acctNum[], balance[], number of accounts, integer account for index position and validity of account
	 * 
	 * Process:
	 * 		account will cycle through 0 to the maximum active accounts (for loop)
	 * 		if account = index position, return i , and -1
	 * 
	 * Output:
	 * 		returns i and -1
	 * */

	public static int findAcct(int[] acctNum, int numAccts, int accountIndex) {

		for (int i = 0; i < numAccts; i++) {

			if(accountIndex == acctNum[i]) { // will cycle through valid accounts and assign them positions of index

				return i;

			}

		}

		return -1;

	}

	/*
	 * method withdrawal()
	 * 
	 * Input:
	 * 		arrays acctNum[], balance[], number of accounts, scanner to read and print writer to write to file
	 * 
	 * Process:
	 * 		checks if account is valid, then will withdraw money from balance if return value of balance is not negative.
	 * 		if account not valid, print error account doesn't exist
	 * 		if negative withdraw amount, print invalid error.
	 * 		if balance will  be negative after withdraw, error not enough money.
	 * 
	 * Output:
	 * 		returns nothing, void function
	 * */

	public static void withdrawal(int[] acctNum, double[] balance, int numAccts, Scanner HW71input, PrintWriter HW71output) {

		System.out.println("Please enter your account number: ");

		int currentAccountNumber = HW71input.nextInt();

		double finalBalance;

		HW71output.println("Transaction Type: Withdrawal");
		HW71output.println("Account number entered: " + currentAccountNumber);

		boolean accountIsValid = true;

		for(int i = 0; i < numAccts && accountIsValid; i++) {


			if(acctNum[i] == currentAccountNumber) {

				accountIsValid = false;
				System.out.println("How much would you like to withdraw?");
				double withdrawAmount = HW71input.nextDouble();

				if(withdrawAmount < 0) {
					HW71output.println("Amount tried to withdraw: $" + withdrawAmount);
					HW71output.println("Invalid withdraw amount.\n");
				} else {

					finalBalance = balance[i] - withdrawAmount;

					if(finalBalance != Math.abs(finalBalance)) { // if balance is negative after withdrawing print error and revert back.
						HW71output.println("Tried to withdraw: $" + withdrawAmount);
						HW71output.println("Error: Not enough money in account to be withdrawn.");
						HW71output.println("Current balance: $"+ balance[i]);
						HW71output.println("");

					} else {
						HW71output.println("Current Balance: $" + balance[i]); // will store new balance since condition met
						balance[i] = finalBalance;
						HW71output.println("You withdrew $" + withdrawAmount);
						HW71output.println("New Balance: $"+ finalBalance);
						HW71output.println();

					}

				}

			}

		}


		if(accountIsValid) {

			HW71output.println("Error: Account does not exist.\n");

		}

	}

	/*
	 * method deposit()
	 * 
	 * Input:
	 * 		arrays acctNum[], balance[], number of accounts, scanner to read and print writer to write to file
	 * 
	 * Process:
	 * 		takes account number, checks if existing.
	 * 		if exists, will read in next line of input
	 * 		if deposit amount is negative or account is real print error.
	 * 
	 * Output:
	 * 		returns nothing, void function
	 * */

	public static void deposit(int[] acctNum, double[] balance, int numAccts, Scanner HW71input, PrintWriter HW71output) {

		System.out.println("Please enter your account number: ");

		int currentAccountNumber = HW71input.nextInt();

		double finalBalance;

		HW71output.println("Transaction Type: Deposit");
		HW71output.println("Account number entered: " + currentAccountNumber);

		boolean accountIsValid = true;

		for(int i = 0; i < numAccts && accountIsValid; i++) {

			if(acctNum[i] == currentAccountNumber) {

				accountIsValid = false;

				HW71output.println("Curret Balance: $" + balance[i]);
				System.out.println("How much would you like to deposit?");
				double depositAmount = HW71input.nextDouble();

				if(depositAmount < 0) { // if negative deposit amount print error
					HW71output.println("Amount tried to deposit: $" + depositAmount);
					HW71output.println("Invalid deposit amount.\n");
				} else {

					finalBalance = balance[i] + depositAmount; // add deposit amount to balance if its valid

					balance[i] = finalBalance; 

					HW71output.println("You deposited $" + depositAmount);
					HW71output.println("New Balance: $" + finalBalance);
					HW71output.println();

				}

			}

		}

		if(accountIsValid) {

			HW71output.println("Error: Account does not exist.\n");

		}

	}

	/*
	 * method newAcct()
	 * 
	 * Input:
	 * 		arrays acctNum[], balance[], number of accounts, scanner to read and print writer to write to file
	 * 
	 * Process:
	 * 		will  store users new account information 
	 * 		then will look if account already exists, if exists print error and don't make account
	 * 		if doesn't exist make new account add it to array
	 * 
	 * Output:
	 * 		returns -1 or newAcct for main to receive the information on the account
	 * */

	public static int newAcct(int[] acctNum, double[] balance, int numAccts, PrintWriter HW71output, Scanner HW71input) {

		int newAcct = HW71input.nextInt();

		int existingAccount = findAcct(acctNum, numAccts, newAcct);

		HW71output.println("Transaction Type: New Account");
		HW71output.println("Account number entered: " + newAcct);

		if(existingAccount == -1) { // making sure its valid account

			acctNum[numAccts] = newAcct; // storing account number
			balance[numAccts] = 0; // setting account's balance to 0

			HW71output.println("Account Balance: $0");
			HW71output.println();
			return newAcct;

		} else {

			HW71output.println("Error: " + newAcct + " already exists");
			HW71output.println();

		}

		return -1;

	}
}



