/*********************************************************************
 * PROGRAM NAME    : Maze.java
 * PURPOSE         : To store and manipulate maze data
 *
 *********************************************************************
 */
package com.maze.mazesolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Maze {
	private int[][] mazeMap;
	private boolean[][] visitedMap;
	private Point start;
	private Point end;
	private int mapWidth;
	private int mapHeight;
	
	public void print(List<Point> path) {
		if (!path.isEmpty()) {
			System.out.println("Output: ");
			char[][] resultMap = new char[mapHeight][mapWidth];
			for (int i = 0; i < mapHeight; i++) {
				for (int j = 0; j < mapWidth; j++) {
					if (mazeMap[i][j] == 1) {
						resultMap[i][j] = '#';
					} 
					else if (start.getX() == j && start.getY() == i) {
						resultMap[i][j] = 'S';
					} 
					else if (end.getX() == j && end.getY() == i) {
						resultMap[i][j] = 'E';
					} 
					else if (path.contains(new Point(j, i))) {
						resultMap[i][j] = 'X';
					} 
					else {
						resultMap[i][j] = ' ';
					}
				}
			}
			for (char[] c : resultMap) {
				System.out.println(String.valueOf(c));
			}
		} else {
			System.out.println("There is no possible solution to the maze. ");
		}
	}
	
	private void validateInput() throws InvalidInputException {
	    if (mapWidth <1 || mapHeight < 1) {
	    	throw new InvalidInputException("Invalid map width or height, cannot create maze. ");
	    }
	    if (start.getX() > mapWidth-1 || start.getY() > mapHeight-1
	    		 || start.getX() < 0 || start.getY() < 0) {
	    	throw new InvalidInputException("Invalid start location. ");
	    }
	    if (end.getX() > mapWidth-1 || end.getY() > mapHeight-1
	    		 || end.getX() < 0 || end.getY() < 0) {
	    	throw new InvalidInputException("Invalid end location. ");
	    }
	}
	
	public void initialize() throws InvalidInputException, FileNotFoundException, IOException {
		System.out.println("Welcome to the Maze Solver. ");
		System.out.println("Please select input maze file. ");
		BufferedReader br = null;
		try {
			String line = null;
			start = new Point();
			end = new Point();
			
			final JFileChooser fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Normal text file", "txt");
			fc.setFileFilter(filter);
			int returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
			    File file = fc.getSelectedFile();
			    br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			    if ((line = br.readLine()) != null) {
			    	String[] mapSize = line.split(" ");
			    	mapWidth = Integer.valueOf(mapSize[0]);
			    	mapHeight = Integer.valueOf(mapSize[1]);
			    }
			    if ((line = br.readLine()) != null) {
			    	String[] startLocation = line.split(" ");
			    	start.setX(Integer.valueOf(startLocation[0]));
			    	start.setY(Integer.valueOf(startLocation[1]));
			    }
			    if ((line = br.readLine()) != null) {
			    	String[] endLocation = line.split(" ");
			    	end.setX(Integer.valueOf(endLocation[0]));
			    	end.setY(Integer.valueOf(endLocation[1]));
			    }
			    validateInput();
			    
				mazeMap = new int[mapHeight][mapWidth];
				visitedMap = new boolean[mapHeight][mapWidth];
				for (int i = 0; i < mapHeight; i++) {
					if ((line = br.readLine()) != null) {
				    	String[] content = line.split(" ");
				    	for (int j = 0; j < mapWidth; j++) {
				    		mazeMap[i][j] = Integer.valueOf(content[j]);
				    	}
				    }
				}
			} else {
				throw new IOException();
			}
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}
	
	public void setVisited(Point pt) {
		visitedMap[pt.getY()][pt.getX()] = true;
	}
	
	public boolean isVisited(Point pt) {
		return (visitedMap[pt.getY()][pt.getX()] == true);
	}
	
	public boolean isPassageWay(Point pt) {
		return (mazeMap[pt.getY()][pt.getX()] == 0);
	}
	
	public boolean isEnd(Point pt) {
		return end.equals(pt);
	}
	
	public int[][] getMazeMap() {
		return mazeMap;
	}

	public void setMazeMap(int[][] mazeMap) {
		this.mazeMap = mazeMap;
	}

	public boolean[][] getVisitedMap() {
		return visitedMap;
	}

	public void setVisitedMap(boolean[][] visitedMap) {
		this.visitedMap = visitedMap;
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public int getMapWidth() {
		return mapWidth;
	}

	public void setMapWidth(int mapWidth) {
		this.mapWidth = mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

	public void setMapHeight(int mapHeight) {
		this.mapHeight = mapHeight;
	}
}
