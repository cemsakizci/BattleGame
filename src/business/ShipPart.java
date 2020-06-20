package business;

import java.util.ArrayList;

public abstract class ShipPart implements IAddable{
	private int minPoint;
	private int maxPoint;
	private IVehicle ship;
	private VehicleType baseVehicleType;
	
	public ShipPart (int minPoint, int maxPoint, IVehicle ship) {
		this.minPoint = minPoint;
		this.maxPoint = maxPoint;
		this.ship = ship;
		this.baseVehicleType = ship.getType();
	}
	
	public int getMinPoint() {
		return this.ship.getMinPoint() + this.minPoint;
	}

	public int getMaxPoint() {
		return this.ship.getMaxPoint() + this.maxPoint;
	}
	
	public VehicleType getType() {
		return this.baseVehicleType;
	}
	
	public ArrayList<AddableType> getParts() {
		ArrayList<AddableType> parts = this.ship.getParts();
		parts.add(this.getPartType());
		return parts;
	}
	
	public EngineType getEngineType() {
		return null;
	}
	
	public abstract AddableType getPartType();
}
