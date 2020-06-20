package business;


public class Rocket implements IPlane, IShip{
	private int minPoint;
	private int maxPoint;
	private IVehicle vehicle;
	
	public Rocket (IVehicle vehicle) {
		this.minPoint = 2;
		this.maxPoint = 8;
		this.vehicle = vehicle;
	}
	
	public int getMinPoint() {
		return this.vehicle.getMinPoint() + this.minPoint;
	}

	public int getMaxPoint() {
		return this.vehicle.getMaxPoint() + this.maxPoint;
	}

}
