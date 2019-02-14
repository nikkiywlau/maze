/*********************************************************************
 * PROGRAM NAME    : InvalidInputException.java
 * PURPOSE         : To create exception for invalid input 
 *
 *********************************************************************
 */
package com.maze.mazesolver;

public class InvalidInputException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidInputException() {
        super("The input is invalid");
	}

	public InvalidInputException(String message) {
		super(message);
	}
}
