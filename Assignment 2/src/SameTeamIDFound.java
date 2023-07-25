
//.....................................................
// Assignment 2
// Part 2 
// Due Date : 11/27/2022
// Written by: Saswati Chowdhury, Student Id: 40184906
//.....................................................

/**
 * This is a custom exception class which is thrown when two Team objects have
 * same teamID.
 */
public class SameTeamIDFound extends Exception {
	public SameTeamIDFound(String msg) {
		super(msg);
	}
}