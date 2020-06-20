package business;


public class Bomb extends PlanePart{

	public Bomb (IPlane plane) {
		super(0, 10, plane);
	}
	
	public AddableType getPartType() {
		return AddableType.BOMB;
	}
}
