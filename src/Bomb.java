
public class Bomb implements IPlaneAddable{
	private int minPoints;
	private int maxPoints;
	private IPlane plane;
	
	public Bomb (IPlane plane) {
		this.minPoints = 0;
		this.maxPoints = 10;
		this.plane = plane;
	}
	
	public int getMinPoint() {
		return this.plane.getMinPoint() + this.minPoints;
	}

	@Override
	public int getMaxPoint() {
		return this.plane.getMaxPoint() + this.maxPoints;
	}
}
