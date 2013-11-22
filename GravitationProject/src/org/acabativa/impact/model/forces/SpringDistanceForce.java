package org.acabativa.impact.model.forces;

import org.acabativa.impact.model.Particle;
import org.acabativa.impact.model.util.Vector2D;

public class SpringDistanceForce implements ForceStrategy{

	private double k = 0.01;
	private double restPosition = 299;
	
	private Particle particleOne;
	private Particle particleTwo;
	
	public SpringDistanceForce(Particle particleOne, Particle particleTwo) {
		this.particleOne = particleOne;
		this.particleTwo = particleTwo;
	}

	@Override
	public Vector2D getForce(Particle reference, Particle particle) {
		if(!areThoseMyParticles(reference, particle)){
			System.out.println("Not my particles!!");
			return new Vector2D(0,0);
		}
		double catetoAdjacente = 0; 
		
		catetoAdjacente = -reference.getPosition().getX()+particle.getPosition().getX();
				
		double catetoOposto = 0;
		
		catetoOposto = -reference.getPosition().getY()+particle.getPosition().getY();
		
		double distance = getDistance(reference, particle);
		System.out.println("Distance: " + distance);
		
		
		double coeficient = (distance-restPosition) * k;
		System.out.println("Coeficiente: " + coeficient);
		
		if(Double.compare(distance, restPosition)==0){
			return new Vector2D(0,0);
		}
		else if(Double.compare(distance, restPosition)>0){
			coeficient = coeficient*(+1);
		}
		else{
			coeficient = coeficient*(-1);
		}
				
		
		Vector2D normalized = new Vector2D(catetoAdjacente, catetoOposto).normalize();
		
		return normalized.scalarMultiply(coeficient);
		
	}
	
	
	private boolean areThoseMyParticles(Particle testOne, Particle testTwo){
		if(particleOne.equals(testOne) && particleTwo.equals(testTwo)){
			return true;
		}
		else if(particleOne.equals(testTwo) && particleTwo.equals(testOne)){
			return true;
		}
		else{
			return false;
		}
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
