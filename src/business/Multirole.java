package business;


public class Multirole extends Plane {
	public VehicleType getType() {
		return VehicleType.MULTIROLE;
	}
	
	public Multirole(Engine engine) {
		super(10, 25, engine);
	}	
	
}
