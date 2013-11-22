package org.acabativa.impact.model.util;


public class Vector2DAcab {

	double x;
	double y;
	double teta;
	
	Point startPosition = new Point(0,0);

	public Vector2DAcab(double x, double y, Point startPosition) {
		super();
		this.x = x;
		this.y = y;
		this.startPosition = startPosition;
		this.teta = getTeta();
	}
	
	public double getTeta(){
		return Math.atan(y/x);
	}
	
	public double getNorm(){
		double hipotenusa = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		return hipotenusa;
	}
	
	public Point getEndPosition(){
		return new Point(startPosition.getX()+x, startPosition.getY()+y);
	}
	
	public Point getStartPosition(){
		return startPosition;
	}
	
	public static void main(String[] args) {
		Vector2D v2 = new Vector2D(-20, -30);
		Vector2D v1 = new Vector2D(10, 0);
		
		Vector2D v1b = v1.getProjection(v2);
		Vector2D v1a = v2.getOrtogonalToThis();
		v1a = v1.getProjection(v1a);
		
		System.out.println(v1b);
		System.out.println(v1b.getNorm());
		
		System.out.println(v1a);
		System.out.println(v1a.getNorm());
		
		v1a = v1a.scalarMultiply(-1);
		System.out.println(v1a);
		System.out.println(v1a.getNorm());
		
		Point a = new Point(0,0);
		
		Point b = new Point(20,30);
		
		Point c = new Point(40,60);
		
		System.out.println(new Vector2D(a,b));
		System.out.println(new Vector2D(b,c));
		System.out.println(new Vector2D(c,b));
		System.out.println(new Vector2D(a,c));
		
		
		
//		double factor = Vector2D.dotProduct(vA.normalize(), vB);
//		Vector2D result = vA.scalarMultiply(factor/vA.getNorm());
//				
//		System.out.println(factor);
//		System.out.println(result);
//		System.out.println(result.getNorm());
		
//		Vector2D vA = new Vector2D(20, 20);
//		Vector2D vB = new Vector2D(10, 0);
//		double factor = Vector2D.dotProduct(vA.normalize(), vB);
//		Vector2D result = vA.scalarMultiply(factor/vA.getNorm());
//		Vector2D orto = vB.subtract(result);	
//		
//		System.out.println(factor);
//		System.out.println(result);
//		System.out.println(result.getNorm());
//		System.out.println("------------");
//		System.out.println(orto);
//		System.out.println(orto.getNorm());
//		System.out.println("------------");
//		System.out.println(orto.add(result));
//		System.out.println(orto.add(result).normalize());
		
		
		
		
	}	
	
}
