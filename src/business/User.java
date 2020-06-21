package business;

import java.util.ArrayList;
import java.util.Random;

public class User {
	private ArrayList<IPlane> planeList;
	private ArrayList<IShip> shipList;
	private int sameVehicleLimit = 3; // only 3 ships or planes allowed
	private int sameTypeLimit = 2; // only 2 same specific type (ex: fighter planes )allowed
	private Random rand;
	private int userID;
	
	public User(int userID){
		planeList = new ArrayList<IPlane>();
		shipList = new ArrayList<IShip>();
		rand = new Random();
		setUserID(userID);
	}
	
	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public boolean addShip(AbstractFactory<IShip> factory, VehicleType vehicleType){
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
		IShip newShip = factory.createVehicle(vehicleType, null);
		shipList.add(newShip);
		return true;
	}
	
	public boolean addPlane(AbstractFactory<IPlane> factory, VehicleType vehicleType, EngineType engineType){
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
		IPlane newPlane = factory.createVehicle(vehicleType, engineType);
		planeList.add(newPlane);
		return true;
	}
	
	public boolean addShipAddable(AbstractFactory<IShip> factory, AddableType type, int index){
		IShip ship = shipList.get(index);
		if(ship.getParts().contains(type)){
			return false;
		}
		IAddable updatedShip = factory.createAddable(ship, type);
		if(updatedShip != null){
			shipList.set(index, updatedShip);
			return true;
		}
		return false;
	}
	
	public boolean addPlaneAddable(AbstractFactory<IPlane> factory, AddableType type, int index){
		IPlane plane = planeList.get(index);
		if(plane.getParts().contains(type)){
			return false;
		}
		IAddable updatedPlane = factory.createAddable(plane, type);
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
	
	public ArrayList<IShip> getShipList(){
		return shipList;
	}
	
	public ArrayList<IPlane> getPlaneList(){
		return planeList;
	}
	
	public ArrayList<IVehicle> getItems() {
		ArrayList<IVehicle> items = new ArrayList<IVehicle>();
		for(IVehicle plane:planeList){
			items.add(plane);
		}
		for(IVehicle ship:shipList){
			items.add(ship);
		}
		
		return items;
	}
}
