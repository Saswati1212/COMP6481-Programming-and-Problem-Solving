
//.....................................................
// Assignment 1
// © Saswati Chowdhury
// Written by: Saswati Chowdhury, Student Id: 40184906
//.....................................................

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Class that defines the Voter
 */

public class Voter {

	private long voterID;
	String voterName;
	byte voterAge;
	String voterEmail;
	char[] voterPcode;
	private static int count = 1; // to find the number of voters created
	static List<Voter> voterBase = new ArrayList<>();
//	public static Voter[] voterBase;
	static int total_Password_Count = 0;
	static int maxVoters;
	public static Scanner scr = new Scanner(System.in);
	public static int attempts = 0;
	public static final String PASSWORD = "password";
	public static long capacity;

	/**
	 * default constructor for the Voter object
	 */

	public Voter() {
		voterID = count++;
		voterName = "";
		voterAge = 0;
		voterEmail = "";
		voterPcode = null;
	}

	/**
	 * parameterized constructor
	 * 
	 * @param voterName
	 * @param voterAge
	 * @param voterEmail
	 * @param voterPcode
	 */

	public Voter(String voterName, byte voterAge, String voterEmail, char[] voterPcode) {

		this.voterName = voterName;
		this.voterAge = voterAge;
		this.voterEmail = voterEmail;
		this.voterPcode = voterPcode;
		this.voterID = count++;
	}

	/**
	 * Copy constructor
	 * 
	 * @param voter
	 */
	public Voter(Voter voter) {

		this.voterID = count++;
		this.voterName = voter.voterName;
		this.voterAge = voter.voterAge;
		this.voterEmail = voter.voterEmail;
		this.voterPcode = voter.voterPcode;

	}

	/**
	 * This getter method to fetch the voter id
	 * 
	 * @return the voterID of long type
	 */

	public long get_voterID() {
		return voterID;
	}

	/**
	 * This getter method to fetch the voter name
	 * 
	 * @return the name of the voter in String
	 */

	public String get_voterName() {
		return voterName;
	}

	/**
	 * This setter method to set the voter name
	 * 
	 * @return the voterName of String type
	 */

	public void set_voterName(String voterName) {
		this.voterName = voterName;
	}

	/**
	 * This getter method to fetch the voter age
	 * 
	 * @return the voterAge of byte type
	 */

	public byte get_voterAge() {
		return voterAge;
	}

	/**
	 * This setter method to set the voter age
	 * 
	 * @return the voterAge of byte type
	 */

	public void set_voterAge(byte voterAge) {
		this.voterAge = voterAge;
	}

	/**
	 * This getter method to fetch the voter email
	 * 
	 * @return the voterEmail of String type
	 */
	public String get_voterEmail() {
		return voterEmail;
	}

	/**
	 * This setter method to set the voter email
	 * 
	 * @return the voterEmail of String type
	 */

	public void set_voterEmail(String voterEmail) {
		this.voterEmail = voterEmail;
	}

	/**
	 * this getter method to retrieve voter Pcode
	 * 
	 * @return the Pcode of the voter
	 */

	public char[] get_voterPcode() {
		return voterPcode;
	}

	/**
	 * this setter method to set voter Pcode
	 * 
	 * @return the Pcode of the voter
	 */

	public void set_voterPcode(char[] voterPcode) {
		this.voterPcode = voterPcode;
	}

	/**
	 * Overrides the toString method of the Object class to print the custom
	 * formatted output describing the voter object when the object is printed
	 * 
	 * @return the formatted string output
	 */
	@Override
	public String toString() {
		return "ID: " + voterID + "\n" + "Name: " + voterName + "\n" + "Age: " + voterAge + "\n" + "Email: "
				+ voterEmail + "\n" + "Pcode: " + Arrays.toString(voterPcode);

	}

	/**
	 * This static method returns the count of object that are created
	 * 
	 * @return the object count of int type
	 */
	public static int findNumberOfCreatedVoters() {
		if (count >= 1) {
			return count++;
		} else {
			return 0;
		}
	}

	/**
	 * Override the equals method to compare the equality of the two objects based
	 * on user defined parameters Here: voters with same ID and Pcode are equal
	 * @param otherVoters the voter object to compare against the current one
	 * @return boolean value for whether the two voters are equal or not
	 */
	@Override
	public boolean equals(Object otherVoters) {
		if (otherVoters == null) {
			return false;
		} else if (getClass() != otherVoters.getClass()) {
			return false;
		} else {
			Voter newVoter;
			newVoter = (Voter) otherVoters;
			return ((voterID == newVoter.voterID) && (Arrays.equals(voterPcode, newVoter.voterPcode)));
		}
	}

///////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Driver method
	 * @param args Command line arguments
	 */

	public static void main(String[] args) {



		System.out.println("Welcome to the Parti Québécois!");
		System.out.println("What is the maximum capacity of the voters in your neighborhood?");
		maxVoters = Integer.valueOf(scr.nextLine());
		// displayMenu();

		try {
			// maxVoters = Integer.valueOf(sc.nextLine());

			System.out.println("What do you want to do?\n" + "1. Enter new voters (password required)\n"
					+ "2. Change information of a voter (password required)\n"
					+ "3. Display all voters by a specific voterPcode\n"
					+ "4. Display all voters under a certain age.\n" + "5. Quit\n" + "Please enter your choice > ");

			do {
				inputChoiceUser(scr);
				System.out.println("What do you want to do?\n" + "1. Enter new voters (password required)\n"
						+ "2. Change information of a voter (password required)\n"
						+ "3. Display all voters by a specific voterPcode\n"
						+ "4. Display all voters under a certain age.\n" + "5. Quit\n" + "Please enter your choice > ");
			} while (scr.hasNextInt());

		} catch (NumberFormatException e) {
			System.out.println("This is string input, but needs a number.");
			System.exit(0);
		} catch (Exception e) {
			System.out.println("An unknown error occured. Please try again");
		} finally {
			scr.close();
		}

	}



	/**
	 * Function to take input from user
	 *
	 * @param scr
	 */

	private static void inputChoiceUser(Scanner scr) {
		try {

			// System.out.println("enter the choice again");

//			int user_choice = Integer.parseInt(scr.nextLine());
			int user_choice = scr.nextInt();

			switch (user_choice) {
			case 1:
				if (maxVoters != voterBase.size()) {
					enterPassword();
				} else {
					System.out.println("Sorry, you can not add new voter. Parti Québécois is full");
				}
				break;
			case 2:
				changeOfInformationOfVoter();
				break;
			case 3:
				displayVotersByPcode();
				break;
			case 4:
				displayVotersByAge();
				break;
			case 5:
				quitVoter();
				break;
			default:
				System.out.println("Wrong choice!! Please choose the appropriate action from the menu");
				break;
			}

		} catch (InputMismatchException e) {
			System.out.println("This is incorrect input. Please try again.");
			System.exit(0);
		} catch (NumberFormatException e) {
			System.out.println("This is string input, but needs a number.");
			System.exit(0);
		} catch (IllegalArgumentException e) {
			System.out.println("This is incorrect input. Please try again.");
			System.exit(0);
		} catch (Exception e) {
			System.out.println("An unknown error occured. Please try again");
			System.exit(0);
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/* ************Functions for choice 1 *********** */


	/**
	 * Function to check for correct password
	 *
	 * @param sc
	 */
	private static void checkPassword(Scanner scr, int voter_PasswordCount) {
		String voter_password;

		while (voter_PasswordCount <= 2) {
			System.out.println("Please enter the correct password");
			voter_password = scr.nextLine();
			voter_PasswordCount++;
			total_Password_Count++;
			if (voter_password.matches("password")) {
				enterNewVoter();
				break;
			}
		}

	}

	/**
	 * Function to authenticate the user via password
	 * 
	 * @param voter_case if the user wants to add a new voter or update the existing
	 *                   one
	 */

	private static void enterPassword() {

		System.out.println("Enter Your Password");
		String voter_password = scr.nextLine();
		int voter_PasswordCount = 0;
		// int totalPasswordCount;
		if (!voter_password.matches("password")) {
			total_Password_Count++;
			voter_PasswordCount++;
			checkPassword(scr, voter_PasswordCount);
			if (total_Password_Count >= 3) {
				do {
					System.out.println("Please enter the correct password");
					voter_password = scr.nextLine();
					// passwordCount++;
					if (!voter_password.matches("password")) {
						total_Password_Count++;
						if (total_Password_Count == 12) {
							System.out.println(
									"Program detected suspicious activities and will terminate immediately!\n");
							System.exit(0);
						}
						System.out.println("\t 1. Enter new voters(password required)");
						System.out.println("\t 2. Change information of a voter (password required)");
						System.out.println("\t 3. Display all voters by a specific VoterPcode");
						System.out.println("\t 4. Display all voters under a certain age");
						System.out.println("\t 5. Quit");
						System.out.print("Please enter your choice >");
						System.out.println();
						inputChoiceUser(scr);

					}


					if (voter_password.matches("password")) {
						enterNewVoter();
						break;
					}
					// if (totalPasswordCount == 6 || totalPasswordCount == 9) {
					// input(sc);
					// passwordCount++;
					// totalPasswordCount++;
					// }
					if (total_Password_Count == 12) {
						System.out.println("Program detected suspicious activities and will terminate immediately!\n");
						System.exit(0);
					}
				} while (total_Password_Count <= 12);
			}
			voter_PasswordCount = 0;
		} else {
			enterNewVoter();
		}
	}

//	private static void enterPassword() {
//		// int p = scr.nextInt();
//		System.out.println("Enter the password to access Parti Québécois: ");
//		System.out.println("Attempts done: " + total_Password_Count);
//		String voter_password = scr.next();
//		if (!voter_password.equals(PASSWORD)) {
//			// attempts++;
//			total_Password_Count++;
//
//			// when the case 1 (enter new voter) is chosen by the user and more than 12
//			// wrong attempts are made for password, then exit the program.
//			if (total_Password_Count == 12) {
//				System.out.println("Program detected suspicious activities and will terminate immediately!");
//				System.exit(0);
//			}
//			if (total_Password_Count % 3 == 0) { // after every third wrong attempt, display the main menu!
//				displayMenu();
//			} else {
//
//				enterPassword();
//			}
//		} else {
//			System.out.println("Correct Password!"); // when the correct password is entered, move to the next step
//			total_Password_Count = 0;
//			enterNewVoter();
//		}
//	}

//	private static void enterPassword(int voter_case) {
//		System.out.println("Enter the password to access Parti Québécois: ");
//		System.out.println("Attempts done: " + attempts);
//		String voter_password = scr.next();
//		if (!voter_password.equals(PASSWORD)) {
//			//attempts++;
//			total_Password_Count++;
//
//			// when the case 1 (enter new voter) is chosen by the user and more than 12
//			// wrong attempts are made for password, then exit the program.
//			if (attempts == 12 && voter_case == 1) {
//				System.out.println("Program detected suspicious activities and will terminate immediately!");
//				System.exit(0);
//			}
//			if (attempts % 3 == 0) { // after every third wrong attempt, display the main menu!
//				displayMenu();
//			} else {
//
//				enterPassword(voter_case);
//			}
//		} else {
//			System.out.println("Correct Password!"); // when the correct password is entered, move to the next step
//			attempts = 0;
//		}
//	}




	private static void enterNewVoter() {

		System.out.println("How many voters would you like to add?");
		int new_VoterCount = scr.nextInt();
		if (new_VoterCount > maxVoters) // see if the desired number of voters can be added or not
		{
			System.out.println("You can add only " + Integer.valueOf(maxVoters - voterBase.size())
					+ " voters! Please enter the valid value!!!");
			enterNewVoter();
		} else
		{

			for (int i = 0; i < new_VoterCount; i++) {

				System.out.println("Please enter the voter details below: ");
				System.out.println("Enter the voter name ");
				String Name = scr.next();
				System.out.println("Enter the voter age ");
				byte Age = Byte.parseByte(scr.next());
				System.out.println("Enter the voter email");
				String Mail = scr.next();
				System.out.println("Enter the voter Pcode");
				String strPcode = scr.next();
				char[] Pcode = strPcode.toCharArray();

				Voter new_Voter = new Voter(Name, Age, Mail, Pcode);
				voterBase.add(new_Voter);
				System.out.println("New voter is added successfully");

			}
			// displayMenu();

		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/* ************Function for choice 2 *********** */

	/**
	 * Function to update the specific voter in the database
	 */

	private static void changeOfInformationOfVoter() {
		// int passwordCount = 0;
		System.out.println("Enter your password: ");
		String strPassword = scr.nextLine();
		if (!strPassword.matches("password")) {
			total_Password_Count++;
			enterPassword(); // ----------------------after 3 attempt diplay fig 1
		} else {
			updateVoterInformation(scr);
		}
	}

	public static void updateVoterInformation(Scanner scr) {
		System.out.print("Which voter ID you want to update: ");
		int voterID = scr.nextInt();

		// checking if selected voter is present in array or not
		if (voterID <= voterBase.size()) {
			Voter getVoter = voterBase.get(voterID - 1);
			System.out.println("\nVoter Number: " + voterID);
			System.out.println(getVoter.toString());
			int choice;

			// This do-while loop will ask the user if he/she wants to change any
			// information of selected voters.
			// This loop will continuously ask the user to change the information until user
			// selects the quit option.
			do {
				System.out.println("\n What information would you like to change?" + "\n    1. Name " + "\n    2. Age"
						+ "\n    3. Email " + "\n    4. Pcode" + "\n    5. Quit");
				System.out.print("Enter your choice > ");
				choice = scr.nextInt();

				// switch case for menu option
				switch (choice) {

				// if user selects option 1
				case 1:
					System.out.print("**** Enter the new Voter name: ");
					String newName = scr.next();
					getVoter.set_voterName(newName);
					System.out.println("\nUpdated successfully");
					System.out.println("Voter Name: " + getVoter.voterName);
					System.out.println("Voter Id: " + getVoter.voterID);
					System.out.println("Voter Age: " + getVoter.voterAge);
					System.out.println("Voter Email: " + getVoter.voterEmail);
					System.out.println("Voter Pcode: " + String.valueOf(getVoter.voterPcode));
					break;

				// if user selects option 2
				case 2:
					System.out.print("**** Enter the new age: ");
					byte newAge = scr.nextByte();
					getVoter.set_voterAge(newAge);
					System.out.println("\nUpdated successfully");
					System.out.println("Voter Name: " + getVoter.voterName);
					System.out.println("Voter Id: " + getVoter.voterID);
					System.out.println("Voter Age: " + getVoter.voterAge);
					System.out.println("Voter Email: " + getVoter.voterEmail);
					System.out.println("Voter Pcode: " + String.valueOf(getVoter.voterPcode));
					break;

				// if user selects option 3
				case 3:

					System.out.print("**** Enter the new email: ");
					String newEmail = scr.next();
					getVoter.set_voterEmail(newEmail);
					System.out.println("\nUpdated successfully");
					System.out.println("Voter Name: " + getVoter.voterName);
					System.out.println("Voter Id: " + getVoter.voterID);
					System.out.println("Voter Age: " + getVoter.voterAge);
					System.out.println("Voter Email: " + getVoter.voterEmail);
					System.out.println("Voter Pcode: " + String.valueOf(getVoter.voterPcode));
					break;

				// if user selects option 4
				case 4:

					System.out.println("Enter new postal code");
					String strPostal = scr.next();
					char[] chPostal = strPostal.toCharArray();
					getVoter.set_voterPcode(chPostal);
					System.out.println("\nUpdated successfully");
					System.out.println("Voter Name: " + getVoter.voterName);
					System.out.println("Voter Id: " + getVoter.voterID);
					System.out.println("Voter Age: " + getVoter.voterAge);
					System.out.println("Voter Email: " + getVoter.voterEmail);
					System.out.println("Voter Pcode: " + String.valueOf(getVoter.voterPcode));
					break;

				// if user selects option 5
				case 5:
					break;
				default:
					System.out.println("\nPlease enter the valid choice from the menu");
				}

				// to quit the loop, if user selects the option 5
				if (choice == 5) {
					break;
				}

			} while (true);
		}

		// shows message if requested voter is not present in array
		else {
			System.out.println("INVALID Voter ID Number");
			System.out.print("Do you want to re-enter another voter id number (yes/no): ");
			String user_response = scr.next();
			if (user_response.equalsIgnoreCase("yes")) {
				updateVoterInformation(scr);
			}
		}

	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	/* ************Functions for choice 3 *********** */

	/**
	 * Function to display all the voters by a specific postal code entered by the
	 * user
	 */

	private static void displayVotersByPcode() {
		System.out.println("Enter the voter postal code you want to search: ");
		String strPcode = scr.nextLine();
		char[] chrPcode = strPcode.toCharArray();
		findVotersBy(chrPcode);
	}

	/**
	 * Function to find all the voters by postal code
	 *
	 * // * @param postal_code
	 */

	private static void findVotersBy(char[] postal_code) {
		if (voterBase.isEmpty()) {
			System.out.println("No one is found in the Parti Québécois with this postal code");
		}

		System.out.println("Voter information by the postal code " + postal_code + " are as follows:");

		voterBase.forEach(i -> {
			if (Arrays.equals(i.voterPcode, postal_code)) {
				System.out.println("Voter Name: " + i.voterName);
				System.out.println("Voter ID: " + i.voterID);
				System.out.println("Voter Age: " + i.voterAge);
				System.out.println("Voter Email: " + i.voterEmail);
				System.out.println();
			} else {
				System.out.println("No one is found in the Parti Québécois with this postal code");
			}

		});
	}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/* ************Function for choice 4 *********** */

	/**
	 * Function to display all the voters who are younger than the user entered
	 * value
	 */
	private static void displayVotersByAge() {
		if (voterBase.isEmpty()) {
			System.out.println("No one is found in the Parti Québécois");
		}

		System.out.println("Enter the age you want to find: ");
		byte findByAge = scr.nextByte();
		voterBase.forEach(i -> {
			if (i.get_voterAge() <= findByAge) {
				System.out.println("Voter Name: " + i.voterName);
				System.out.println("Voter Age:" + i.voterAge);
				System.out.println();
			} else {
				System.out.println("No one is found in the Parti Québécois");
			}
		});
	}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/* ************Function for choice 5 *********** */

	/**
	 * Quit the application
	 */
	private static void quitVoter() {
		System.out.println("Exit from the Parti Québécois application!! Have a Great Day!!!");
		scr.close();
		System.exit(0);
	}

}
