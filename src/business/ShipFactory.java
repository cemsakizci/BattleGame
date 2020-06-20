package business;

public class ShipFactory extends AbstractFactory {

	@Override
	public IVehicle createVehicle(VehicleType vehicleType, EngineType engineType) {
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

	@Override
	public IAddable createAddable(IVehicle vehicle, AddableType addableType) {
		if(addableType == AddableType.TORPEDO) {
			return new Torpedo(vehicle);
		}
		else if(addableType == AddableType.ROCKET) {
			return new Rocket(vehicle);
		}
		else if(addableType == AddableType.CANNON) {
			return new Cannon(vehicle);
		}
		else {
			return null;
		}
		
	}

	
}
