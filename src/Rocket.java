
public class Rocket implements IPlaneAddable {
	private int minPoints;
	private int maxPoints;
	private IPlane plane;
	
	public Rocket(IPlane plane) {
		this.minPoints = 2;
		this.maxPoints = 8;
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
