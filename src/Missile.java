
public class Missile implements IPlaneAddable {
	private int minPoints;
	private int maxPoints;
	private IPlane plane;
	
	public Missile(IPlane plane) {
		this.minPoints = 3;
		this.maxPoints = 6;
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
