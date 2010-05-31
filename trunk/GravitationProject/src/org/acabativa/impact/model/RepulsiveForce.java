package org.acabativa.impact.model;

public class RepulsiveForce extends AtractiveForce implements ForceStrategy{

	public final double c = 0.75;
	
	@Override
	public Vector2D getForce(Particle reference, Particle particle) {
		return super.getForce(reference, particle).scalarMultiply(-1);
	}
			
}
