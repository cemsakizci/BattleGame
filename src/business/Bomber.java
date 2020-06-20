package business;


public class Bomber extends Plane {
	public VehicleType getType() {
		return VehicleType.BOMBER;
	}
	
	public Bomber(Engine engine) {
		super(15, 20, engine);
	}	
	
}
