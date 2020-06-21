package business;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPlane plane = new Fighter(new Pulsejet());
		
		IShip ship = new Cruiser();
		IShip cannonShip = new Cannon(ship);
		IShip crShip = new Rocket(cannonShip);
		IShip crtor = new Torpedo(crShip);
		System.out.println(crtor.getParts());
		
		AbstractFactory<IShip> shipFac = new ShipFactory();
		IShip newShip = shipFac.createVehicle(VehicleType.DESTROYER, null);
		System.out.println(newShip.getType());
		
		AbstractFactory<IPlane> planeFac = new PlaneFactory();
		IPlane newPlane = planeFac.createVehicle(VehicleType.FIGHTER, EngineType.PULSEJET);
		IPlane missilePlane = new Missile(plane);
		IPlane mrPlane = new Rocket(missilePlane);
		System.out.println(mrPlane.getEngineType());
		
		
	}

}
