package business;

public class PlaneFactory extends AbstractFactory<IPlane>{

	public IPlane createVehicle(VehicleType vehicleType, EngineType engineType) {
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

	public IAddable createAddable(IPlane plane, AddableType addableType) {
		if(addableType == AddableType.ROCKET) {
			return new Rocket(plane);
		}
		else if(addableType == AddableType.MISSILE) {
			return new Missile(plane);
		}
		else if(addableType == AddableType.MACHINEGUN) {
			return new Machinegun(plane);
		}
		else if(addableType == AddableType.BOMB) {
			return new Bomb(plane);
		}
		else {
			return null;
		}
	}

	
}
