package business;

import java.util.ArrayList;
import java.util.Random;

public class User {
	private ArrayList<IVehicle> vehicles;
	private int sameTypeLimit = 2;
	private Random rand;
	
	public User(){
		vehicles = new ArrayList<IVehicle>();
		rand = new Random();
	}
	
	public boolean addShip(AbstractVehicleFactory factory, VehicleType type){
		return true;
	}
	
	public boolean addPlane(AbstractVehicleFactory factory, VehicleType vehicleType, EngineType engineType){
		return true;
	}
	
	public boolean addAddable(AbstractVehicleFactory factory, AddableType type){
		return true;
	}
	
	private boolean checkLegalAdd(VehicleType type){
		int typeCounter = 0;
		for(IVehicle vehicle:vehicles){
			if(type == vehicle.getType()){
				typeCounter++;
				if(typeCounter == sameTypeLimit){
					return false;
				};
			}
		}
		return true;
	}
	
	public void resetVehicles(){
		vehicles.clear();
	}
	
	public int calculateTotalPoints(){
		int sum = 0;
		for(IVehicle vehicle:vehicles){
			int min = vehicle.getMinPoint();
			int max = vehicle.getMaxPoint();
			int score = rand.nextInt(max+1) + min;
			sum += score;
		}
		return sum;
	}
	
	@Override
	public String toString(){
		int index = 1;
		String output = "";
		for(IVehicle vehicle:vehicles){
			output += String.valueOf(index) + ". "; // Item types should be concatenated here
			index++;
		}
		return output;
	}
}
