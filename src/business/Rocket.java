package business;

//import java.util.ArrayList;

public class Rocket extends ShipPart implements IVehicle{
	//private int minPoint;
	//private int maxPoint;
	private IVehicle vehicle;
	//private VehicleType baseVehicleType;
	
	public Rocket (IVehicle vehicle) {
		super(2, 8, vehicle);
	}
	
	public IVehicle getBase() {
		return this.vehicle;
	}
	
	public AddableType getPartType() {
		return AddableType.ROCKET;
	}
	
	public EngineType getEngineType() {
		return this.vehicle.getEngineType();
	}
}
