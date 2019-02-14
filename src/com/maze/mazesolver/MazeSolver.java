/*********************************************************************
 * PROGRAM NAME    : MazeSolver.java
 * PURPOSE         : To solve a maze
 *
 *********************************************************************
 */
package com.maze.mazesolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MazeSolver {
    /**
     * Get path by back tracking the parent of points
     */
	private List<Point> backtrackPath(Point pt) {
		List<Point> path = new ArrayList<>();
		Point it = pt;
		while (it != null) {
		    path.add(it);
		    it = it.getParent();
		}
		return path;
	}
	
    /**
     * Construct points at North, East South and West of a given point
     * Enable wrapping movement 
     */
	private void setAdjacentPoints(Point pt, int mapWidth, int mapHeight) {
		if (pt.getY()-1 < 0) {
			pt.setN(new Point(pt.getX(), mapHeight-1, pt));
		} else {
			pt.setN(new Point(pt.getX(), pt.getY()-1, pt));
		}
		if (pt.getX()+1 > mapWidth - 1) {
			pt.setE(new Point(0, pt.getY(), pt));
		} else {
			pt.setE(new Point(pt.getX()+1, pt.getY(), pt));
		}
		if (pt.getY()+1 > mapHeight - 1) {
			pt.setS(new Point(pt.getX(), 0, pt));
		} else {
			pt.setS(new Point(pt.getX(), pt.getY()+1, pt));
		}
		if (pt.getX()-1 < 0) {
			pt.setW(new Point(mapWidth-1, pt.getY(), pt));
		} else {
			pt.setW(new Point(pt.getX()-1, pt.getY(), pt));
		}
	}

    /**
     * Solve provided maze
     */
	public List<Point> solve(Maze maze) {
		LinkedList<Point> nextVisit = new LinkedList<>();
		nextVisit.add(new Point(maze.getStart().getX(), maze.getStart().getY()));
		
		while (!nextVisit.isEmpty()) {
			Point pt = nextVisit.remove();
			if (maze.isVisited(pt)) {
				continue;
			}
			if (!maze.isPassageWay(pt)) {
				maze.setVisited(pt);
				continue;
			}
			if (maze.isEnd(pt)) {
				return backtrackPath(pt);
			}
			setAdjacentPoints(pt, maze.getMapWidth(), maze.getMapHeight());
			nextVisit.add(pt.getN());
			nextVisit.add(pt.getE());
			nextVisit.add(pt.getS());
			nextVisit.add(pt.getW());
			maze.setVisited(pt);
		}
		return Collections.emptyList();
	}
}
