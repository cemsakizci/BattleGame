package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.AbstractFactory;
import business.AddableType;
import business.EngineType;
import business.IAddable;
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
		this.user1 = new User(1);
		this.user2 = new User(2);
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
		} else if (user1Points == user2Points){
			System.out.println("Draw!");
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
		System.out.println(" 1. Player 1");
		System.out.println(" 2. Player 2");
		System.out.println(" 3. Show Items");
		
		//Get input
		String choice = in.nextLine();
		
		switch(choice) {
		  case "1":
			  System.out.println("1.Player");
			  printPlayerOperations(user1);
			  break;
		  case "2":
			  System.out.println("2.Player");
			  printPlayerOperations(user2);
			  break;
		  case "3":
			  printPlayerItems();
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1 or 2.");
		}
		
	}
	
	private void printPlayerItems() {
		System.out.println(" //// PLAYERS ITEMS\\\\ ");
		
		System.out.println("Player 1:");
		ArrayList<IVehicle> player1Items = this.user1.getItems();
		for(IVehicle vehicle:player1Items){
			if(vehicle.getEngineType() == null) {
				System.out.print(vehicle.getType() + " [" + vehicle.getType().getValue()[0] +  " - " + vehicle.getType().getValue()[1] +"] ");
			}
			else {
				System.out.print(vehicle.getType() + " [" + vehicle.getType().getValue()[0] +  " - " + vehicle.getType().getValue()[1] + "] with " + vehicle.getEngineType() + " ["+ vehicle.getEngineType().getValue()[0] + " - " + vehicle.getEngineType().getValue()[1] + "] ");
			}
			
			ArrayList<AddableType> parts = vehicle.getParts();
			System.out.print("(");
			int i=0;
			for(i=0; i < parts.size(); i++) {
				if(i == parts.size()-1) {
					System.out.print(parts.get(i) + " [" + parts.get(i).getValue()[0] + " - " + parts.get(i).getValue()[1] + "]");
				}
				else {
					System.out.print(parts.get(i) + " [" + parts.get(i).getValue()[0] + " - " + parts.get(i).getValue()[1] + "], ");
				}
				
			}
			System.out.println(")");
			
		}
		
		System.out.println("\nPlayer 2:");
		ArrayList<IVehicle> player2Items = this.user2.getItems();
		for(IVehicle vehicle:player2Items){
			if(vehicle.getEngineType() == null) {
				System.out.print(vehicle.getType() + " [" + vehicle.getType().getValue()[0] +  " - " + vehicle.getType().getValue()[1] +"] ");
			}
			else {
				System.out.print(vehicle.getType() + " [" + vehicle.getType().getValue()[0] +  " - " + vehicle.getType().getValue()[1] + "] with " + vehicle.getEngineType() + " ["+ vehicle.getEngineType().getValue()[0] + " - " + vehicle.getEngineType().getValue()[1] + "] ");
			}
			
			ArrayList<AddableType> parts = vehicle.getParts();
			System.out.print("(");
			int i=0;
			for(i=0; i < parts.size(); i++) {
				if(i == parts.size()-1) {
					System.out.print(parts.get(i) + " [" + parts.get(i).getValue()[0] + " - " + parts.get(i).getValue()[1] + "]");
				}
				else {
					System.out.print(parts.get(i) + " [" + parts.get(i).getValue()[0] + " - " + parts.get(i).getValue()[1] + "], ");
				}
				
			}
			System.out.println(")");
		}
		
		System.out.println();
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
			  System.out.println("Player" + user.getUserID() + " created plane");
			  printPlanes(user);
			  break;
		  case "2":
			  System.out.println("Player" + user.getUserID() + " created ship");
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
		boolean result;
		switch(choice) {
		  case "1":
			  result = user.addPlane(this.planeFactory, vehicleType, EngineType.PULSEJET);
			  if(result){
				  System.out.println("Player" + user.getUserID() + " : Created Plane: "+ String.valueOf(vehicleType)+ " ,Engine: Pulsejet");
			  }else{
				  System.out.println("You exceed item limit. Operation failed.");
			  }
			  break;
		  case "2":
			  result = user.addPlane(this.planeFactory, vehicleType, EngineType.TURBOJET);
			  if(result){
				  System.out.println("Player" + user.getUserID() + " : Created Plane: "+ String.valueOf(vehicleType)+ " ,Engine: Turbojet");
			  }else{
				  System.out.println("You exceed item limit. Operation failed.");
			  }
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
		boolean result;
		switch(choice) {
		  case "1":
			  result = user.addShip(this.shipFactory, VehicleType.CRUISER);
			  if(result){
				  System.out.println("Ship Created: Cruiser");
			  }else{
				  System.out.println("You exceed item limit. Operation failed.");
			  }
			  
			  break;
		  case "2":
			  result = user.addShip(this.shipFactory, VehicleType.DESTROYER);
			  if(result){
				  System.out.println("Ship Created: Destroyer");
			  }else{
				  System.out.println("You exceed item limit. Operation failed.");
			  }
			  
			  break;
		  case "3":
			  result = user.addShip(this.shipFactory, VehicleType.FRIGATE);
			  if(result){
				  System.out.println("Ship Created: Frigate");
			  }else{
				  System.out.println("You exceed item limit. Operation failed.");
			  }
			  
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1,2 or 3.");
		}

	}
	

	private void addAPart(User user) {

		if (user.getItems().size() == 0) {
			System.out.println("No Plane/Ship to add a part.");
			return;
		}

		List<IVehicle> vehicles = new  ArrayList<IVehicle>();
		String menu = "";
		int menuIndex = 0;
		
		for(IVehicle vehicle:user.getPlaneList()) {
			menu += String.valueOf(menuIndex)+". "+vehicle.getType().toString() +" "+ getAddablePartsString(vehicle) + "\n";
			vehicles.add(vehicle);
			menuIndex++;
		}
		
		for(IVehicle vehicle:user.getShipList()) {
			menu += String.valueOf(menuIndex)+". "+vehicle.getType().toString() +" "+ getAddablePartsString(vehicle) + "\n";
			vehicles.add(vehicle);
			menuIndex++;
		}
		if(menuIndex == 0){
			System.out.println("This user hasn't any vehicle. Operation failed.");
			return;
		}else{
			System.out.println(" //// PLAYER OPERATIONS \\\\ ");
			System.out.println(" //// PLEASE SELECT VEHICLE TO ADD PART \\\\ ");
			System.out.println(menu);
		}
		String choice = in.nextLine();
		
		//Check if specific vehicle index found
		IVehicle selectedVehicle = null;
		try {
			selectedVehicle = vehicles.get(Integer.valueOf(choice));
		}catch(Exception e) {
			System.out.println("Wrong input!");
			return;
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
		String result = "( ";
		for(AddableType addable: vehicle.getParts()) {
			result += addable.toString() + " ";
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
		boolean result;
		switch(choice) {
		  case "1":
			  result = user.addPlaneAddable(this.planeFactory, AddableType.ROCKET, index);
			  if(result){
				  System.out.println("Part Added : Rocket");
			  }else{
				  System.out.println("You exceed item limit. Operation failed.");
			  }
			  break;
		  case "2":
			  result = user.addPlaneAddable(this.planeFactory, AddableType.MISSILE, index);
			  if(result){
				  System.out.println("Part Added : Missile");
			  }else{
				  System.out.println("You exceed item limit. Operation failed.");
			  }
			  
			  break;
		  case "3":
			  result = user.addPlaneAddable(this.planeFactory, AddableType.MACHINEGUN, index);
			  if(result){
				  System.out.println("Part Added : Machine Gun");
			  }else{
				  System.out.println("You exceed item limit. Operation failed.");
			  }
			  
			  break;
		  case "4":
			  result = user.addPlaneAddable(this.planeFactory, AddableType.BOMB, index);
			  if(result){
				  System.out.println("Part Added : Bomb");  
			  }else{
				  System.out.println("You exceed item limit. Operation failed.");
			  }
			  
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
		boolean result;
		switch(choice) {
		  case "1":
			  result = user.addShipAddable(this.shipFactory, AddableType.ROCKET, index);
			  if(result){
				  System.out.println("Part Added : Rocket");
			  }else{
				  System.out.println("You exceed item limit. Operation failed.");
			  }
			  
			  break;
		  case "2":
			  result = user.addShipAddable(this.shipFactory, AddableType.TORPEDO, index);
			  if(result){
				  System.out.println("Part Added : Torpedo");
			  }else{
				  System.out.println("You exceed item limit. Operation failed.");
			  }
			  
			  break;
		  case "3":
			  result = user.addShipAddable(this.shipFactory, AddableType.CANNON, index);
			  if(result){
				  System.out.println("Part Added : Cannon");  
			  }else{
				  System.out.println("You exceed item limit. Operation failed.");
			  }
			  
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1,2,3 or 4.");
		}

	}
	
	
	
}
