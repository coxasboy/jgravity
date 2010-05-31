package org.acabativa.impact.model;

public class Point {

	final double x;
	final double y;
	
	
	
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Point() {
		super();
		this.x = 0;
		this.y = 0;
	}
	
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
	
	
}
