package business;


public abstract class PlanePart implements IAddable{
	private int minPoint;
	private int maxPoint;
	private IPlane plane;
	
	public PlanePart (int minPoint, int maxPoint, IPlane plane) {
		this.minPoint = minPoint;
		this.maxPoint = maxPoint;
		this.plane = plane;
	}
	
	public int getMinPoint() {
		return this.plane.getMinPoint() + this.minPoint;
	}

	public int getMaxPoint() {
		return this.plane.getMaxPoint() + this.maxPoint;
	}
}
