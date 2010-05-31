package org.acabativa.impact.model;

public class NeutronForce implements ForceStrategy{

	@Override
	public double getDistance(Particle reference, Particle particle) {
		return 0;
	}

	@Override
	public Vector2D getForce(Particle reference, Particle particle) {
		return new Vector2D();
	}

}
