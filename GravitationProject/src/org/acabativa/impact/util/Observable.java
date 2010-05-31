package org.acabativa.impact.util;

public interface Observable {

	void addObserver(Observer observer);
	void removeObserver(Observer observer);
	
}
