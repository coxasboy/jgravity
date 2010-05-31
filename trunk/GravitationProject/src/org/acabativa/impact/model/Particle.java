package org.acabativa.impact.model;



import org.apache.log4j.Logger;

public class Particle implements Element{
		
	Logger logger = Logger.getLogger(Particle.class);

	private static int particlesCounter = 1;

	ForceStrategy fStrategy;
	Vector2D velocity;
	Point position;
	double radius;
	double mass;
	Vector2D force;	
	public final int id; 	
		
	public Particle(Vector2D velocity, double radius, double mass) {
		super();
		this.position = new Point();
		this.velocity = velocity;
		this.radius = radius;
		this.mass = mass;
		this.id = particlesCounter++;
		this.fStrategy = new AtractiveForce();
	}
		
	public Particle(Vector2D velocity, Point position, double radius,
			double mass) {
		super();
		this.velocity = velocity;
		this.position = position;
		this.radius = radius;
		this.mass = mass;
		this.id = particlesCounter++;
		this.fStrategy = new AtractiveForce();
	}

	public Vector2D getVelocity() {
		return velocity;
	}
	public void setVelocity(Vector2D velocity) {
		this.velocity = velocity;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
//		System.out.println("Setting position: " + position);
		this.position = position;
	}
	
	public boolean haveForce(){
		return this.force!=null && Double.compare(this.force.getNorm(),0)!=0;
	}
	
	
	

	public ForceStrategy getfStrategy() {
		return fStrategy;
	}

	public void setfStrategy(ForceStrategy fStrategy) {
		this.fStrategy = fStrategy;
	}

	public Vector2D getForce() {
		return force;
	}

	public void setForce(Vector2D force) {
//		System.out.println("Force: " + force);
		this.force = force;
	}

	@Override
	public String toString() {
		return "Particle [position=" + position.getX() + "/" + position.getY() + ", velocity=" + velocity
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Particle other = (Particle) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public boolean conflicts(Particle particle){
		double hipotenusa = LineWalker.getHipotenusa(this.getPosition(), particle.getPosition());
		if(hipotenusa<(this.getRadius()+particle.getRadius())){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public Vector2D getForce(Element element) {
		return fStrategy.getForce(this, (Particle)element);
	}

	@Override
	public double getDistance(Element element) {
		return fStrategy.getDistance(this, (Particle)element);
	}
	
	
	
}
