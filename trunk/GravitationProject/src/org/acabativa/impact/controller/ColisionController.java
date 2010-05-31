package org.acabativa.impact.controller;

import org.acabativa.impact.model.ColisionModel;
import org.acabativa.impact.view.ParticlesView;

public class ColisionController {

	ColisionModel model;
	ParticlesView view;
//	EnergyView eView;
	Thread t;
		
	public ColisionController(ColisionModel model) {
		super();
		this.model = model;
		this.view = new ParticlesView(this, model);
		
		for (int i = 0; i < 8; i++) {
			view.zoomOut();
		}
		
		for (int i = 0; i < 25; i++) {
			view.moveLeft();
			view.moveUp();
		}
		
//		this.eView = new EnergyView(this, model);
		start();	
	}	
	
	public void addEnergy(){
		this.model.addEnergy();
	}
	
	public void zoomIn(){
		this.view.zoomIn();
	}
	
	public void zoomOut(){
		this.view.zoomOut();
	}
	
	public void moveUp(){
		this.view.moveUp();
	}
	
	public void moveDown(){
		this.view.moveDown();
	}
	
	public void moveRight(){
		this.view.moveRight();
	}
	
	public void moveLeft(){
		this.view.moveLeft();
	}
	
	public void removeEnergy(){
		this.model.removeEnergy();
	}

	public void start() {
		t = new Thread(model);
		t.start();
	}
	
	public boolean isAlive(){
		return this.t.isAlive();
	}

	public void stop() {
		model.stop();
	}
	
}
