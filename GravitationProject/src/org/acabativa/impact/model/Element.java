package org.acabativa.impact.model;

import org.acabativa.impact.model.util.Vector2D;

public interface Element {

//	"O �lcool � como o amor: o primeiro beijo � m�gico, o segundo � �ntimo, o terceiro � rotina. A partir da�, voc� apenas tira a roupa da garota"
	
	public Vector2D getForce(Element element);
	public double getDistance(Element element);
	
	
}
