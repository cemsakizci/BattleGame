package business;

public class PlaneFactory extends AbstractFactory {

	@Override
	public IVehicle createVehicle(VehicleType vehicleType, EngineType engineType) {
		Engine engine = null;
		if(engineType == EngineType.PULSEJET) {
			engine = new Pulsejet();
		}
		else {
			engine = new Turbojet();
		}
		
		if(vehicleType == VehicleType.FIGHTER) {
			return new Fighter(engine);
		}
		else if(vehicleType == VehicleType.BOMBER) {
			return new Bomber(engine);
		}
		else if(vehicleType == VehicleType.MULTIROLE) {
			return new Multirole(engine);
		}
		else {
			return null;
		}
		
	}

	@Override
	public IAddable createAddable(IVehicle vehicle, AddableType addableType) {
		if(addableType == AddableType.ROCKET) {
			return new Rocket(vehicle);
		}
		else if(addableType == AddableType.MISSILE) {
			return new Missile(vehicle);
		}
		else if(addableType == AddableType.MACHINEGUN) {
			return new Machinegun(vehicle);
		}
		else if(addableType == AddableType.BOMB) {
			return new Bomb(vehicle);
		}
		else {
			return null;
		}
	}

	
}
