package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.AbstractFactory;
import business.AddableType;
import business.EngineType;
import business.IPlane;
import business.IShip;
import business.IVehicle;
import business.PlaneFactory;
import business.ShipFactory;
import business.User;
import business.VehicleType;

public class BattleGame {
	private User user1;
	private User user2;
	private AbstractFactory shipFactory;
	private AbstractFactory planeFactory;
	
	Scanner in = new Scanner(System.in);
	
	public BattleGame() {
		this.user1 = new User();
		this.user2 = new User();
		this.shipFactory = new ShipFactory();
		this.planeFactory = new PlaneFactory();
	}
	
	public void printMenu() {
		Boolean exit = false;
		while(!exit) {
			String choice = getMainMenuChoice();
			switch(choice) {
			  case "1":
				  printPlayers();
				  break;
			  case "2":
				  runSimulation();
				  break;
			  case "3":
				  resetItems();
				  break;
			  case "4":
				  System.out.println("Exit");
				  in.close();
			  	  exit = true;
				  break;
			  default:
				  System.out.println("Wrong input! Please enter 1,2 or 3.");
			}
		}
	}
	
	private String getMainMenuChoice() {
		System.out.println(" //// BATTLE GAME \\\\ ");
		System.out.println(" 1. Player Operations ");
		System.out.println(" 2. Run Simulation");
		System.out.println(" 3. Reset items of players");
		System.out.println(" 4. Exit");
		//Get input
		String choice = in.nextLine();        
		return choice;
	}
	
	private void runSimulation() {
		int user1Points = user1.calculateTotalPoints();
		int user2Points = user2.calculateTotalPoints();

		System.out.println("Player 1 Score :"+String.valueOf(user1Points));
		System.out.println("Player 2 Score :"+String.valueOf(user2Points));
		
		if(user1Points<user2Points) {
			System.out.println("Player 2 Win!");
		} else {
			System.out.println("Player 1 Win!");
		}
		
	}

	private void resetItems() {
		user1.resetVehicles();
		user2.resetVehicles();
		System.out.println("All items has been reset");
		
	}

	private void printPlayers() {
		System.out.println(" //// PLAYER OPERATIONS \\\\ ");
		System.out.println(" //// PLEASE SELECT AN USER \\\\ ");
		System.out.println(" 1. Player 1 ");
		System.out.println(" 2. Player 2");
		
		//Get input
		String choice = in.nextLine();
		
		switch(choice) {
		  case "1":
			  System.out.println("1.user");
			  printPlayerOperations(user1);
			  break;
		  case "2":
			  System.out.println("2.user");
			  printPlayerOperations(user2);
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1 or 2.");
		}
		
	}
	
	//bu user objesi olacak
	private void printPlayerOperations(User user) {
		System.out.println(" //// PLAYER OPERATIONS \\\\ ");
		System.out.println(" //// PLEASE SELECT OPERATION \\\\ ");
		System.out.println(" 1. Create Vehicle ");
		System.out.println(" 2. Add a Part");
		
		//Get input
		String choice = in.nextLine();
		
		switch(choice) {
		  case "1":
			  printVehicles(user);
			  break;
		  case "2":
			  addAPart(user);
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1 or 2.");
		}

	}
	
	//bu user objesi olacak
	private void printVehicles(User user) {
		System.out.println(" //// PLAYER OPERATIONS \\\\ ");
		System.out.println(" //// PLEASE SELECT VEHICLE TYPE \\\\ ");
		System.out.println(" 1. Create Plane ");
		System.out.println(" 2. Create Ship");
		
		//Get input
		String choice = in.nextLine();
		
		switch(choice) {
		  case "1":
			  System.out.println(user + " create plane");
			  printPlanes(user);
			  break;
		  case "2":
			  System.out.println(user + " create ship");
			  printShips(user);
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1 or 2.");
		}

	}
	
	//bu user objesi olacak
	private void printPlanes(User user) {
		System.out.println(" //// PLAYER OPERATIONS \\\\ ");
		System.out.println(" //// PLEASE SELECT PLANE TYPE \\\\ ");
		System.out.println(" 1. Fighter ");
		System.out.println(" 2. Bomber");
		System.out.println(" 3. Multirole");
		
		//Get input
		String choice = in.nextLine();
		
		switch(choice) {
		  case "1":
			  selectPlaneEngine(user,VehicleType.FIGHTER);
			  break;
		  case "2":
			  selectPlaneEngine(user,VehicleType.BOMBER);
			  break;
		  case "3":
			  selectPlaneEngine(user,VehicleType.MULTIROLE);
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1,2 or 3.");
		}

	}

	
	//bu user objesi olacak
	private void selectPlaneEngine(User user, VehicleType vehicleType) {
		System.out.println(" //// PLAYER OPERATIONS \\\\ ");
		System.out.println(" //// PLEASE SELECT ENGINE TYPE \\\\ ");
		System.out.println(" 1. Pulsejet ");
		System.out.println(" 2. Turbojet");
		
		//Get input
		String choice = in.nextLine();
		
		switch(choice) {
		  case "1":
			  user1.addPlane(this.planeFactory, vehicleType, EngineType.PULSEJET);
			  System.out.println(user+ ": Create Plane: "+ String.valueOf(vehicleType)+ " Engine: Pulsejet");
			  break;
		  case "2":
			  user1.addPlane(this.planeFactory, vehicleType, EngineType.TURBOJET);
			  System.out.println(user+ ": Create Plane: "+ String.valueOf(vehicleType)+ " Engine: Turbojet");
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1 or 2.");
		}
		

	}

	//bu user objesi olacak
	private void printShips(User user) {
		System.out.println(" //// PLAYER OPERATIONS \\\\ ");
		System.out.println(" //// PLEASE SELECT SHIP TYPE \\\\ ");
		System.out.println(" 1. Cruiser ");
		System.out.println(" 2. Destroyer");
		System.out.println(" 3. Frigate");
		
		//Get input
		String choice = in.nextLine();
		
		switch(choice) {
		  case "1":
			  user.addShip(this.shipFactory, VehicleType.CRUISER);
			  System.out.println("Ship Created: Cruiser");
			  break;
		  case "2":
			  user.addShip(this.shipFactory, VehicleType.DESTROYER);
			  System.out.println("Ship Created: Destroyer");
			  break;
		  case "3":
			  user.addShip(this.shipFactory, VehicleType.FRIGATE);
			  System.out.println("Ship Created: Frigate");
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1,2 or 3.");
		}

	}
	

	private void addAPart(User user) {
		System.out.println(" //// PLAYER OPERATIONS \\\\ ");
		System.out.println(" //// PLEASE SELECT VEHICLE TO ADD PART \\\\ ");
		List<IVehicle> vehicles = new  ArrayList<IVehicle>();
		for(IVehicle vehicle:user.getPlaneList()) {
			vehicles.add(vehicle);
		}
		
		for(IVehicle vehicle:user.getShipList()) {
			vehicles.add(vehicle);
		}
		
		for(int i=0;i<vehicles.size();i++) {
			IVehicle oneVehicle = vehicles.get(i);
			System.out.println(String.valueOf(i)+". "+oneVehicle.getType().toString() +" "+ getAddablePartsString(oneVehicle));
		}
		
		String choice = in.nextLine();
		
		//Check if specific vehicle index found
		IVehicle selectedVehicle = null;
		try {
			selectedVehicle = vehicles.get(Integer.valueOf(choice));
		}catch(Exception e) {
			System.out.println("Wrong input!");
		}

		//PLANE OR SHIP CHECK
		int intChoice = Integer.valueOf(choice);
		int planeSize = user.getPlaneList().size();
		if(intChoice<planeSize) {
			planeAddableParts(user, intChoice);
		} else {
			shipAddableParts(user, intChoice-user.getPlaneList().size());
		}
	}
	
	private String getAddablePartsString(IVehicle vehicle) {
		String result = "(";
		for(AddableType addable: vehicle.getParts()) {
			result += addable.toString();
		}
		result += ")";
		return result;
	}
	
	private void planeAddableParts(User user, int index) {
		System.out.println(" //// PLAYER OPERATIONS \\\\ ");
		System.out.println(" //// PLEASE SELECT PLANE ADDABLE PART \\\\ ");
		System.out.println(" 1. Rocket ");
		System.out.println(" 2. Missile");
		System.out.println(" 3. Machine Gun");
		System.out.println(" 4. Bomb");
		
		//Get input
		String choice = in.nextLine();
		
		switch(choice) {
		  case "1":
			  user.addPlaneAddable(this.planeFactory, AddableType.ROCKET, index);
			  System.out.println("Part Added : Rocket");
			  break;
		  case "2":
			  user.addPlaneAddable(this.planeFactory, AddableType.MISSILE, index);
			  System.out.println("Part Added : Missile");
			  break;
		  case "3":
			  user.addPlaneAddable(this.planeFactory, AddableType.MACHINEGUN, index);
			  System.out.println("Part Added : Machine Gun");
			  break;
		  case "4":
			  user.addPlaneAddable(this.planeFactory, AddableType.BOMB, index);
			  System.out.println("Part Added : Bomb");
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1,2,3 or 4.");
		}

	}

	
	private void shipAddableParts(User user, int index) {
		System.out.println(" //// PLAYER OPERATIONS \\\\ ");
		System.out.println(" //// PLEASE SELECT SHIP ADDABLE PART \\\\ ");
		System.out.println(" 1. Rocket ");
		System.out.println(" 2. Torpedo");
		System.out.println(" 3. Cannon");
		
		//Get input
		String choice = in.nextLine();
		
		switch(choice) {
		  case "1":
			  user.addShipAddable(this.shipFactory, AddableType.ROCKET, index);
			  System.out.println("Part Added : Rocket");
			  break;
		  case "2":
			  user.addShipAddable(this.shipFactory, AddableType.TORPEDO, index);
			  System.out.println("Part Added : Torpedo");
			  break;
		  case "3":
			  user.addShipAddable(this.shipFactory, AddableType.CANNON, index);
			  System.out.println("Part Added : Cannon");
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1,2,3 or 4.");
		}

	}
	
	
	
}
