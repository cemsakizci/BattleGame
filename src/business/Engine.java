package business;


public abstract class Engine {
	private int minPoint;
	private int maxPoint;
	
	public Engine(int minPoint, int maxPoint) {
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
