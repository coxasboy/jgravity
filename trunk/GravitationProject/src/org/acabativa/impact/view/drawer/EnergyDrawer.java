package org.acabativa.impact.view.drawer;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.text.DecimalFormat;

public class EnergyDrawer {

	private static final int SHAPE_SIZE = 6;
	DecimalFormat df = new DecimalFormat("0000.000");
		
	public void draw(Graphics2D g2d, double energy){
		g2d.drawString("Energia: " + df.format(energy), 0, 20);
		g2d.drawString(" (+) = Adiciona energia", 0, 40);
		g2d.drawString(" (-) = Remove energia", 0, 60);
	}
	
	@SuppressWarnings("unused")
	private void createAndDrawShape(Graphics2D g2d, Point point){
		Shape shape = new Ellipse2D.Double((int)point.getX()-(SHAPE_SIZE/2),(int)point.getY()-(SHAPE_SIZE/2),SHAPE_SIZE,SHAPE_SIZE);
		g2d.fill(shape);
	}
	
}