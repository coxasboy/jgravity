package org.acabativa.impact.view.drawer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import org.acabativa.impact.model.Particle;
import org.acabativa.impact.model.Point;

public class ParticlesDrawer {
	Color blue = Color.lightGray;
	Color red = Color.red;
	Color green = Color.green;
	Color cyan = Color.CYAN;
	double multi = 1;
	double scalarX = 0;
	double scalarY = 0;
	double passo = 5;
	List<Color> pallete;
		
	{
		pallete = new ArrayList<Color>();
		pallete.add(Color.GRAY);
		pallete.add(Color.CYAN);
		pallete.add(Color.BLUE);
		pallete.add(Color.RED);
		pallete.add(Color.ORANGE);
		pallete.add(Color.LIGHT_GRAY);
		pallete.add(Color.CYAN);
		pallete.add(Color.ORANGE);
		pallete.add(Color.BLACK);
		pallete.add(Color.PINK);
		pallete.add(Color.YELLOW);
	}
	
	public void draw(Graphics2D g2d, Particle particle) throws IllegalArgumentException{
		createAndDrawShape(g2d, particle);
	}
			
	protected void createAndDrawShape(Graphics2D g2d, Particle particle){
		g2d.setColor(Color.BLACK);
		Point point = particle.getPosition();
//		Vector2D force = particle.getForce();
//		Vector2D speed = particle.getVelocity();
		double shapeSize = (int)particle.getRadius()*2*multi;
		g2d.setColor(getParticleColor(particle));
		if(shapeSize==0){
			shapeSize = 1;
			g2d.setColor(Color.RED);
		}
		Shape shape = new Ellipse2D.Double(
				((int)point.getX()*multi)+scalarX-(shapeSize/2),
				((int)point.getY()*multi)+scalarY-(shapeSize/2),
				shapeSize,
				shapeSize);
		g2d.fill(shape);
//		g2d.setColor(Color.RED);
//		g2d.drawLine((int)point.getX(), (int)point.getY(), (int)(force.getX()*150+(int)point.getX()), (int)(force.getY()*150+(int)point.getY()));
//		g2d.setColor(Color.GREEN);
//		g2d.drawLine((int)point.getX(), (int)point.getY(), (int)(speed.getX()*150+(int)point.getX()), (int)(speed.getY()*150+(int)point.getY()));
		g2d.setColor(Color.BLACK);
	}
	
	protected Color getParticleColor(Particle particle){
		int radius = (int)particle.getRadius();
		Color particleColor = pallete.get(radius/10);
		return particleColor;
	}
	
	public void incMulti(){
		multi = multi + 0.1;
		passo = passo / 1.1;
	}
	
	public void decMulti(){
		multi = multi - 0.1;
		passo = passo * 1.1;
	}
	
	public void addScalarX(){
		scalarX = scalarX + (passo);
	}

	public void removeScalarX(){
		scalarX = scalarX - (passo);
	}
	
	public void addScalarY(){
		scalarY = scalarY + passo;
	}

	public void removeScalarY(){
		scalarY = scalarY - passo;
	}
	
	
	
	protected Color getColor(Particle particle){
		if(particle.getMass()==5){
			return Color.BLACK;
		}
		if(particle.getMass()==6){
			return blue;
		}
		if(particle.getMass()==7){
			return red;
		}
		if(particle.getMass()==8){
			return green;
		}
		return Color.cyan;
	}
	
}
