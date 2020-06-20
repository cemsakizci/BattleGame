package business;

import java.util.ArrayList;

public interface IVehicle {
	public int getMinPoint();
	public int getMaxPoint();
	public VehicleType getType();
	public ArrayList<AddableType> getParts();
	public EngineType getEngineType();
}
