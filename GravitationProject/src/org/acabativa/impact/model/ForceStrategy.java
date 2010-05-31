package org.acabativa.impact.model;

public interface ForceStrategy {

//	"Para se alcan�ar um ideal, � necess�rio ter ambi��o, e ter ambi��o � perder de vista o ideal."
	
	public Vector2D getForce(Particle reference, Particle particle);
	
	public double getDistance(Particle reference, Particle particle);
	
}
