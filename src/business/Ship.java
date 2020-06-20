package business;


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
}
