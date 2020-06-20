package business;


public class Fighter extends Plane {
	public VehicleType getType() {
		return VehicleType.FIGHTER;
	}
	
	public Fighter(Engine engine) {
		super(10, 12, engine);
	}	

}
