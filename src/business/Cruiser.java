package business;


public class Cruiser extends Ship{
	public VehicleType getType() {
		return VehicleType.CRUISER;
	}
	
	public Cruiser() {
		super(15, 30);
	}
}
