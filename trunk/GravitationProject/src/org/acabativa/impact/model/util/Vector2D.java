package org.acabativa.impact.model.util;

import org.apache.commons.math.geometry.Vector3D;

public class Vector2D {

	private static final Vector3D nullVec = new Vector3D(0, 0, 0);
	private final Vector3D v3d;
	
	public static double angle(Vector2D v1, Vector2D v2){
		return Vector3D.angle(v1.v3d, v2.v3d);
	}
	
	public static Vector2D crossProduct(Vector2D v1, Vector2D v2) {
		return new Vector2D(Vector3D.crossProduct(v1.v3d, v2.v3d));	
	}
	
	public static double distance(Vector2D v1, Vector2D v2){
		return Vector3D.distance(v1.v3d, v2.v3d);
	}
    
	public static double distanceSq(Vector2D v1, Vector2D v2){
		return Vector3D.distanceSq(v1.v3d, v2.v3d);
	}
    
	public static double dotProduct(Vector2D v1, Vector2D v2){
		return Vector3D.dotProduct(v1.v3d, v2.v3d);
	}
	
	public Vector2D() {
		v3d = nullVec;
	}
		
	public Vector2D(double x, double y) {
		v3d = new Vector3D(x, y, 0);
	}
	
	private Vector2D(Vector3D v) {
		v3d = v;
	}
	
	public Vector2D getProjection(Vector2D inThisOne){
		Vector2D normilezed = inThisOne.normalize();
		double factor = Vector2D.dotProduct(this, normilezed);
		return normilezed.scalarMultiply(factor);
	}
		
	public Vector2D getOrtogonalToThis(){
		Vector2D normilezed = this.normalize();
		Vector3D zAssis = new Vector3D(0, 0, 1);
		return new Vector2D(Vector3D.crossProduct(zAssis, normilezed.v3d).normalize());
	}
	
	public Vector2D vectorResolute (double vectorNorm, double angle, Vector2D direction){
		double newNorm = vectorNorm*Math.cos(angle);
		return (direction.normalize().scalarMultiply(newNorm));
	}

	public Vector2D add(double factor, Vector2D vector) {
		return new Vector2D(this.v3d.add(vector.v3d));
	}

	public Vector2D add(Vector2D vector) {
		return new Vector2D(this.v3d.add(vector.v3d));
	}

	public boolean equals(Object arg0) {
		return v3d.equals(arg0);
	}

	public double getAlpha() {
		return v3d.getAlpha();
	}

	public double getDelta() {
		return v3d.getDelta();
	}

	public double getNorm() {
		return v3d.getNorm();
	}

	public double getNorm1() {
		return v3d.getNorm1();
	}

	public double getNormInf() {
		return v3d.getNormInf();
	}

	public double getNormSq() {
		return v3d.getNormSq();
	}

	public double getX() {
		return v3d.getX();
	}

	public double getY() {
		return v3d.getY();
	}

	public double getZ() {
		return v3d.getZ();
	}

	public int hashCode() {
		return v3d.hashCode();
	}

	public boolean isInfinite() {
		return v3d.isInfinite();
	}

	public boolean isNaN() {
		return v3d.isNaN();
	}

	public Vector2D negate() {
		return new Vector2D(this.v3d.negate());
	}

	public Vector2D normalize() {
		return new Vector2D(this.v3d.normalize());
	}

	public Vector2D orthogonal() {
		return new Vector2D(this.v3d.orthogonal());
	}

	public Vector2D scalarMultiply(double a) {
		return new Vector2D(this.v3d.scalarMultiply(a));
	}

	public Vector2D subtract(double factor, Vector2D vector) {
		return new Vector2D(this.v3d.subtract(factor, vector.v3d));
	}

	public Vector2D subtract(Vector2D vector) {
		return new Vector2D(this.v3d.subtract(vector.v3d));
	}
	
	public Vector2D (Point reference, Point otherPoint){
		v3d = new Vector3D(otherPoint.getX()-reference.getX(), otherPoint.getY()-reference.getY(), 0);
	}

	public String toString() {
		return v3d.toString();
	}

	
	
}
