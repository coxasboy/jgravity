package org.acabativa.impact.model;

import org.acabativa.impact.model.util.Vector2D;

public interface Element {

//	"O álcool é como o amor: o primeiro beijo é mágico, o segundo é íntimo, o terceiro é rotina. A partir daí, você apenas tira a roupa da garota"
	
	public Vector2D getForce(Element element);
	public double getDistance(Element element);
	
	
}
