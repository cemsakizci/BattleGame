package business;


public class Machinegun extends PlanePart {

	public Machinegun (IPlane plane) {
		super(1, 3, plane);
	}
	
	public AddableType getPartType() {
		return AddableType.MACHINEGUN;
	}
}
