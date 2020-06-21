package business;

public class ShipFactory {

	public IShip createVehicle(VehicleType vehicleType, EngineType engineType) {
		if(vehicleType == VehicleType.CRUISER) {
			return new Cruiser();
		}
		else if(vehicleType == VehicleType.DESTROYER) {
			return new Destroyer();
		}
		else if(vehicleType == VehicleType.FRIGATE) {
			return new Frigate();
		}
		else {
			return null;
		}
	}

	public IAddable createAddable(IShip ship, AddableType addableType) {
		if(addableType == AddableType.TORPEDO) {
			return new Torpedo(ship);
		}
		else if(addableType == AddableType.ROCKET) {
			return new Rocket(ship);
		}
		else if(addableType == AddableType.CANNON) {
			return new Cannon(ship);
		}
		else {
			return null;
		}
		
	}

	
}

