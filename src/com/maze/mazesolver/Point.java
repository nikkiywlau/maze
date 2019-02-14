/*********************************************************************
 * PROGRAM NAME    : Point.java
 * PURPOSE         : To store the location of a point and its adjacent points
 *
 *********************************************************************
 */
package com.maze.mazesolver;

public class Point {
	private int x; 
	private int y; 
	private Point N, S, E, W; 
	private Point parent; 
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, Point parent) {
		this.x = x;
		this.y = y;
		this.parent = parent;
	}
	
    @Override
    public boolean equals(Object o) { 
        if (o == this) { 
            return true; 
        } 
        if (!(o instanceof Point)) { 
            return false; 
        } 
        Point p = (Point) o; 
        return this.x == p.x && this.y == p.y;
    } 
	
	public String toString() {
		return "x coordinate: " + x + ", y coordinate: " + y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Point getN() {
		return N;
	}

	public void setN(Point n) {
		this.N = n;
	}

	public Point getS() {
		return S;
	}

	public void setS(Point s) {
		this.S = s;
	}

	public Point getE() {
		return E;
	}

	public void setE(Point e) {
		this.E = e;
	}

	public Point getW() {
		return W;
	}

	public void setW(Point w) {
		this.W = w;
	}

	public Point getParent() {
		return parent;
	}

	public void setParent(Point parent) {
		this.parent = parent;
	}

}

