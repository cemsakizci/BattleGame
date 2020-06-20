package business;

import java.util.ArrayList;

public abstract class Ship implements IShip{
	private int minPoint;
	private int maxPoint;
	
	public Ship(int minPoint, int maxPoint) {
		this.minPoint = minPoint;
		this.maxPoint = maxPoint;
	}
	
	public int getMinPoint() {
		return this.minPoint;
	}
	
	public int getMaxPoint() {
		return this.maxPoint;
	}
	
	public ArrayList<AddableType> getParts() {
		return new ArrayList<AddableType>();
	}
	
	public IVehicle getBase() {
		return null;
	}
}
