
public class Machinegun implements IPlaneAddable {
	private int minPoints;
	private int maxPoints;
	private IPlane plane;
	
	public Machinegun (IPlane plane) {
		this.minPoints = 1;
		this.maxPoints = 3;
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
