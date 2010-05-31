package org.acabativa.impact.view.drawer;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import org.acabativa.impact.model.Particle;
import org.acabativa.impact.model.Point;

public class VoidParticleDrawer extends ParticlesDrawer{

	protected void createAndDrawShape(Graphics2D g2d, Particle particle){
		Point point = particle.getPosition();
		int shapeSize = (int)4;
		Shape shape = new Ellipse2D.Double((int)point.getX()-(shapeSize/2),(int)point.getY()-(shapeSize/2),shapeSize,shapeSize);
		g2d.fill(shape);
	}
	
}
