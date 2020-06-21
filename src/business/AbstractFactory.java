package business;

public abstract class AbstractFactory<T> {
	public abstract T createVehicle(VehicleType vehicleType, EngineType engineType);
	public abstract IAddable createAddable(T vehicle, AddableType addableType);
}
