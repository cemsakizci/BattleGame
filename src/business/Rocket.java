package business;

import java.util.ArrayList;

public class Rocket implements IPlane, IShip{
	private int minPoint;
	private int maxPoint;
	private IVehicle vehicle;
	private VehicleType baseVehicleType;
	
	public Rocket (IVehicle vehicle) {
		this.minPoint = 2;
		this.maxPoint = 8;
		this.vehicle = vehicle;
		this.baseVehicleType = vehicle.getType();
	}
	
	public int getMinPoint() {
		return this.vehicle.getMinPoint() + this.minPoint;
	}

	public int getMaxPoint() {
		return this.vehicle.getMaxPoint() + this.maxPoint;
	}
	
	public VehicleType getType() {
		return this.baseVehicleType;
	}
	
	public ArrayList<AddableType> getParts() {
		ArrayList<AddableType> parts = this.vehicle.getParts();
		parts.add(this.getPartType());
		return parts;
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
