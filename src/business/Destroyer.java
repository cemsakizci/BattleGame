package business;


public class Destroyer extends Ship{
	public VehicleType getType() {
		return VehicleType.DESTROYER;
	}
	
	public Destroyer() {
		super(20, 40);
	}
}
