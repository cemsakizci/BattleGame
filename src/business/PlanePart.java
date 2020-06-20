package business;

import java.util.ArrayList;

public abstract class PlanePart implements IAddable{
	private int minPoint;
	private int maxPoint;
	private IPlane plane;
	private VehicleType baseVehicleType;
	
	public PlanePart (int minPoint, int maxPoint, IPlane plane) {
		this.minPoint = minPoint;
		this.maxPoint = maxPoint;
		this.plane = plane;
		this.baseVehicleType = plane.getType();
	}
	
	public int getMinPoint() {
		return this.plane.getMinPoint() + this.minPoint;
	}

	public int getMaxPoint() {
		return this.plane.getMaxPoint() + this.maxPoint;
	}
	
	public VehicleType getType() {
		return this.baseVehicleType;
	}
	
	public ArrayList<AddableType> getParts() {
		ArrayList<AddableType> parts = this.plane.getParts();
		parts.add(this.getPartType());
		return parts;
	}
	
	public abstract AddableType getPartType();
}
