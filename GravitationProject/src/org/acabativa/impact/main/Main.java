package org.acabativa.impact.main;

import org.acabativa.impact.controller.ColisionController;
import org.acabativa.impact.model.ColisionModel;
import org.apache.log4j.BasicConfigurator;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		BasicConfigurator.configure();
		ColisionModel cm = new ColisionModel();
		ColisionController controller = new ColisionController(cm);
		controller.start();
		while(controller.isAlive()){
			Thread.sleep(1000);
		}
		
	}
	
}
