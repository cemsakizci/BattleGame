package business;

import java.util.ArrayList;
import java.util.Random;

public class User {
	private ArrayList<IVehicle> planeList;
	private ArrayList<IVehicle> shipList;
	private int sameVehicleLimit = 3; // only 3 ships or planes allowed
	private int sameTypeLimit = 2; // only 2 same specific type (ex: fighter planes )allowed
	private Random rand;
	
	public User(){
		planeList = new ArrayList<IVehicle>();
		shipList = new ArrayList<IVehicle>();
		rand = new Random();
	}
	
	public boolean addShip(AbstractVehicleFactory factory, VehicleType vehicleType){
		if(shipList.size() == sameVehicleLimit){
			return false;
		}
		int typeCounter = 0;
		for(IVehicle ship:shipList){
			if(ship.getType() == vehicleType)
				typeCounter++;
			if(typeCounter == sameTypeLimit){
				return false;
			}
		}
		IVehicle newShip = factory.createVehicle(vehicleType);
		shipList.add(newShip);
		return true;
	}
	
	public boolean addPlane(AbstractVehicleFactory factory, VehicleType vehicleType, EngineType engineType){
		if(planeList.size() == sameVehicleLimit){
			return false;
		}
		int typeCounter = 0;
		for(IVehicle plane:planeList){
			if(plane.getType() == vehicleType)
				typeCounter++;
			if(typeCounter == sameTypeLimit){
				return false;
			}
		}
		IVehicle newPlane = factory.createVehicle(vehicleType, engineType);
		planeList.add(newPlane);
		return true;
	}
	
	public boolean addShipAddable(AbstractVehicleFactory factory, AddableType type, int index){
		IAddable updatedShip = factory.createAddable(shipList.get(index), type);
		if(updatedShip != null){
			shipList.set(index, updatedShip);
			return true;
		}
		return false;
	}
	
	public boolean addPlaneAddable(AbstractVehicleFactory factory, AddableType type, int index){
		IAddable updatedPlane = factory.createAddable(planeList.get(index), type);
		if(updatedPlane != null){
			planeList.set(index, updatedPlane);
			return true;
		}
		return false;
	}
	
	public void resetVehicles(){
		shipList.clear();
		planeList.clear();
	}
	
	public int calculateTotalPoints(){
		int sum = 0;
		for(IVehicle ship:shipList){
			int min = ship.getMinPoint();
			int max = ship.getMaxPoint();
			int score = rand.nextInt(max-min+1) + min;
			sum += score;
		}
		
		for(IVehicle plane:planeList){
			int min = plane.getMinPoint();
			int max = plane.getMaxPoint();
			int score = rand.nextInt(max-min+1) + min;
			sum += score;
		}
		return sum;
	}
	
	public ArrayList<IVehicle> getShipList(){
		return shipList;
	}
	
	public ArrayList<IVehicle> getPlaneList(){
		return planeList;
	}
}
