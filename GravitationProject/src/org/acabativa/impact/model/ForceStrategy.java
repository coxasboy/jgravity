package org.acabativa.impact.model;

public interface ForceStrategy {

//	"Para se alcançar um ideal, é necessário ter ambição, e ter ambição é perder de vista o ideal."
	
	public Vector2D getForce(Particle reference, Particle particle);
	
	public double getDistance(Particle reference, Particle particle);
	
}
