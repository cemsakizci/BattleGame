package business;

public abstract class AbstractFactory {

	public abstract IVehicle createVehicle(VehicleType vehicleType, EngineType engineType);
	public abstract IAddable createAddable(IVehicle vehicle, AddableType addableType);
	
}
