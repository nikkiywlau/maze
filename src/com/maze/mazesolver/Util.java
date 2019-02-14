/*********************************************************************
 * PROGRAM NAME    : Util.java
 * PURPOSE         : To initiate the application
 *
 *********************************************************************
 */
package com.maze.mazesolver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Util {
	public static List<Point> solve(Maze maze) {
		MazeSolver solver = new MazeSolver();
		return solver.solve(maze);
	}
	
	public static void printWarningMessage(String message) {
		System.out.println(message);
	}
	
	public static void closeWithException() {
		System.exit(1);
	}
	
	public static void close() {
		System.exit(1);
	}
	
	public static void main(String[] args) {
		Maze maze = new Maze();
		try {
			maze.initialize();
		} catch (FileNotFoundException e) {
			printWarningMessage("The file cannot be opened. The application will close..");
			closeWithException();
		} catch (IOException e) {
			printWarningMessage("The file cannot be opened. The application will close..");
			closeWithException();
		} catch (InvalidInputException e) {
			printWarningMessage(e.getMessage());
			closeWithException();
		} catch (Exception e) {
			printWarningMessage(e.getMessage());
			closeWithException();
		}
		List<Point> path = solve(maze);
		maze.print(path);
		close();
	}

}
