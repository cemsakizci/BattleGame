package business;

import java.util.ArrayList;

public abstract class Plane implements IPlane{
	private int minPoint;
	private int maxPoint;
	private Engine engine;
	
	public Plane(int minPoint, int maxPoint, Engine engine) {
		this.minPoint = minPoint;
		this.maxPoint = maxPoint;
		this.engine = engine;
	}
	
	public int getMinPoint() {
		return this.minPoint + this.engine.getMinPoint();
	}
	
	public int getMaxPoint() {
		return this.maxPoint + this.engine.getMaxPoint();
	}
	
	public Engine getEngine() {
		return this.engine;
	}
	
	public ArrayList<AddableType> getParts() {
		return new ArrayList<AddableType>();
	}
	
	public EngineType getEngineType() {
		return this.engine.getEngineType();
	}
}
