package org.acabativa.impact.model.forces;

import org.acabativa.impact.model.Particle;
import org.acabativa.impact.model.util.Vector2D;

public class AtractiveForce implements ForceStrategy{

	public final double c = 0.0000066742867;
	
	@Override
	public Vector2D getForce(Particle reference, Particle particle) {
		double catetoAdjacente = 0; 
		
//		System.out.println("PX: " + reference.getPosition().getX());
//		System.out.println("PY: " + particle.getPosition().getX());
		
		catetoAdjacente = -reference.getPosition().getX()+particle.getPosition().getX();
				
		double catetoOposto = 0;
		
		catetoOposto = -reference.getPosition().getY()+particle.getPosition().getY();
		
		double coeficient = c * reference.getMass()* particle.getMass() / Math.pow(getDistance(reference, particle), 2);
				
//		System.out.println("Coef: " + c);
//		System.out.println("CA: " + catetoAdjacente);
//		System.out.println("CO: " + catetoOposto);
		
		Vector2D normalized = new Vector2D(catetoAdjacente, catetoOposto).normalize();
		
		return normalized.scalarMultiply(coeficient);
	}

	@Override
	public double getDistance(Particle reference, Particle particle) {
		double catetoAdjacente = 0; 
		
		catetoAdjacente = -reference.getPosition().getX()+particle.getPosition().getX();
				
		double catetoOposto = 0;
		
		catetoOposto = -reference.getPosition().getY()+particle.getPosition().getY();
		
		return Math.sqrt((Math.pow(catetoAdjacente, 2)) + (Math.pow(catetoOposto, 2)));
	}
		
}
