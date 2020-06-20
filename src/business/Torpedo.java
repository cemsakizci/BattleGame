package business;


public class Torpedo extends ShipPart{

	public Torpedo(IVehicle ship) {
		super(3, 5, ship);
	}

	public AddableType getPartType() {
		return AddableType.TORPEDO;
	}
}
