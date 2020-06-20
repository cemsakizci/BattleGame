package business;


public class Frigate extends Ship{
	public VehicleType getType() {
		return VehicleType.FRIGATE;
	}
	
	public Frigate() {
		super(10, 40);
	}
}
