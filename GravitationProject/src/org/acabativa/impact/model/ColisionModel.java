package org.acabativa.impact.model;

import java.util.ArrayList;
import java.util.List;

import org.acabativa.impact.util.Observable;
import org.acabativa.impact.util.Observer;
import org.apache.log4j.Logger;

public class ColisionModel implements Runnable, Observable{

	protected int MAX_WIDTH = 800;
	protected int MAX_HEIGHT = 800;
	int clock = 0;
	boolean modelOn = true;
	SimulatorEngine engine;
	
	List<Observer> observers = new ArrayList<Observer>(); 
	int fps = 400;
	int auxFps = 120;
	int pass = 1000/fps;
	int waitTime = 0;
	List<Integer> intList = new ArrayList<Integer>();
	
	Logger logger = Logger.getLogger(ColisionModel.class);
	
	public ColisionModel() {
		engine = new SimulatorEngine(MAX_WIDTH, MAX_HEIGHT);
		populateModel();
	}
	
	public void populateModel(){
		Particle particle = null;
//		for (int i = 0; i < 900; i+=100) {
//			addNewSuperStableParticle(i);
//		}
		
//		addNewSuperStableParticle(400);
		particle = new Particle(
				new Vector2D(0, +0.03), 
				new Point(400,400),
				100, 
				1000000);	
		engine.addParticles(particle);
		
		particle = new Particle(
				new Vector2D(-0.12, 0), 
				new Point(400,700),
				20, 
				20000);	
		engine.addParticles(particle);
		
		particle = new Particle(
				new Vector2D(-0.14, 0), 
				new Point(400,850),
				5, 
				5000);	
		engine.addParticles(particle);
		
		particle = new Particle(
				new Vector2D(+0.12, 0), 
				new Point(400,1000),
				10, 
				10000);	
		engine.addParticles(particle);
		
		particle = new Particle(
				new Vector2D(0, -0.05), 
				new Point(1200,1200),
				70, 
				700000);	
		engine.addParticles(particle);
		
		particle = new Particle(
				new Vector2D(0, +0.11), 
				new Point(0,0),
				70, 
				700000);	
		engine.addParticles(particle);
		
//		particle = new Particle(
//				new Vector2D(0, +0.12), 
//				new Point(100,400),
//				20, 
//				5740);	
//		engine.addParticles(particle);
//		
//		particle = new Particle(
//				new Vector2D(0, -0.12), 
//				new Point(700,400),
//				20, 
//				5740);	
//		engine.addParticles(particle);

		
	}	
	
	public double getAllEnergy(){
		return engine.getAllEnergy();
	}
	
	public void addEnergy(){
		engine.addEnergyToTheSystem();
		this.notifyAll("Change Energy");
	}
	
	public void removeEnergy(){
		engine.removeEnergyFromTheSystem();
		this.notifyAll("Change Energy");
	}
	
	@SuppressWarnings("unused")
	private Particle getExtraHeavyParticle(int posx, int posY){
		return  new Particle(
				new Vector2D(0, 0), 
				new Point(posx,posY),
				10, 
				Integer.MAX_VALUE);		
	}	
	
	@Override
	public void run() {
		while(modelOn){
			try {
//				logger.info("Model Clock: " + clock);
				long startProcessAt = System.currentTimeMillis();
				engine.iterateAll();
//				engine.changeStatesAll();
				engine.changeAllVelocity();
				engine.changeAllForce();
				
				clock++;
				notifyAll("Clock change");
				
				long endProcessAt = System.currentTimeMillis();
				long diff = endProcessAt - startProcessAt;
				if(diff>pass){
//					System.out.println("Dif>:"+diff);
					waitTime = 0;
//					System.out.println("W:>"+waitTime);
					auxFps = 1000/(int)diff;
//					System.out.println(auxFps);
//					intList.add(1000/(int)diff);
					continue;
				}
				else{
//					System.out.println("dif<:"+diff);
					auxFps = fps;
					waitTime = pass-(int)diff;
//					System.out.println("w<:"+waitTime);
//					System.out.println(auxFps);
					Thread.sleep(waitTime);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public List<Particle> getAllParticles(){
		return this.engine.getParticles();
	}
	
	public Vector2D getNormAngle(Particle reference, Particle particle){
		return this.engine.getImpactVector(reference, particle);
	}
				
	private void notifyAll(String event){
		synchronized(observers){
			for (Observer observer : observers) {
				observer.notifyEvent(event);
			}
		}
	}
	
	public void addObserver(Observer observer) {
		synchronized(observers){
			observers.add(observer);		
		}
	}

	public void removeObserver(Observer observer) {
		synchronized(observers){
			observers.remove(observer);
		}
	}
	
	public int getWidth(){
		return MAX_WIDTH;
	}
	
	public int getHeight(){
		return MAX_HEIGHT;
	}

	public void stop() {
		this.modelOn = false;		
	}
	
	
}
