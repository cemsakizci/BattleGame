package business;


public abstract class ShipPart implements IAddable{
	private int minPoint;
	private int maxPoint;
	private IShip ship;
	
	public ShipPart (int minPoint, int maxPoint, IShip ship) {
		this.minPoint = minPoint;
		this.maxPoint = maxPoint;
		this.ship = ship;
	}
	
	public int getMinPoint() {
		return this.ship.getMinPoint() + this.minPoint;
	}

	public int getMaxPoint() {
		return this.ship.getMaxPoint() + this.maxPoint;
	}
}
