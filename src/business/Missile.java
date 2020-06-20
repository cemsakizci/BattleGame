package business;


public class Missile extends PlanePart {

	public Missile (IVehicle plane) {
		super(3, 6, plane);
	}
	
	public AddableType getPartType() {
		return AddableType.MISSILE;
	}
}
