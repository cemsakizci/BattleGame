package presentation;

import java.util.Scanner;

public class BattleGame {
	//private User user1;
	//private User user2;
	//private AbstractVehicleFactory vehicleFactory;
	Scanner in = new Scanner(System.in);

	
	public BattleGame() {
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
		System.out.println("Player 1 Score :");
		System.out.println("Player 2 Score :");
		
	}

	private void resetItems() {
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
			  printPlayerOperations("User1");
			  break;
		  case "2":
			  System.out.println("2.user");
			  printPlayerOperations("User2");
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1 or 2.");
		}
		

	}
	
	//bu user objesi olacak
	private void printPlayerOperations(String user) {
		System.out.println(" //// PLAYER OPERATIONS \\\\ ");
		System.out.println(" //// PLEASE SELECT OPERATION \\\\ ");
		System.out.println(" 1. Create Vehicle ");
		System.out.println(" 2. Add a Part");
		
		//Get input
		String choice = in.nextLine();
		
		switch(choice) {
		  case "1":
			  System.out.println(user + " Create Vehicle");
			  printVehicles(user);
			  break;
		  case "2":
			  System.out.println(user + " Add a Part");
			  addAPart(user);
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1 or 2.");
		}

	}
	
	//bu user objesi olacak
	private void printVehicles(String user) {
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
			  printPlanes(user);
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1 or 2.");
		}

	}
	
	//bu user objesi olacak
	private void printPlanes(String user) {
		System.out.println(" //// PLAYER OPERATIONS \\\\ ");
		System.out.println(" //// PLEASE SELECT PLANE TYPE \\\\ ");
		System.out.println(" 1. Fighter ");
		System.out.println(" 2. Bomber");
		System.out.println(" 3. Multirole");
		
		//Get input
		String choice = in.nextLine();
		
		switch(choice) {
		  case "1":
			  //TODO USER1 is not string it is object
			  selectPlaneEngine(user,"Fighter");
			  break;
		  case "2":
			  //TODO USER1 is not string it is object
			  selectPlaneEngine(user,"Bomber");
			  break;
		  case "3":
			  selectPlaneEngine(user,"Multirole");
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1,2 or 3.");
		}

	}

	
	//bu user objesi olacak
	private void selectPlaneEngine(String user, String plane) {
		System.out.println(" //// PLAYER OPERATIONS \\\\ ");
		System.out.println(" //// PLEASE SELECT ENGINE TYPE \\\\ ");
		System.out.println(" 1. Pulsejet ");
		System.out.println(" 2. Turbojet");
		
		//Get input
		String choice = in.nextLine();
		
		switch(choice) {
		  case "1":
			  //TODO: Set the engine type of object plane
			  System.out.println(user+ ": Create Vehicle: "+ plane+ " engine: pulsejet");
			  break;
		  case "2":
			  //TODO: Set the engine type of object plane
			  System.out.println(user+ ": Create Vehicle: "+ plane+ " engine: turbojet");
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1 or 2.");
		}

	}

	//bu user objesi olacak
	private void printShips(String user) {
		System.out.println(" //// PLAYER OPERATIONS \\\\ ");
		System.out.println(" //// PLEASE SELECT SHIP TYPE \\\\ ");
		System.out.println(" 1. Cruiser ");
		System.out.println(" 2. Destroyer");
		System.out.println(" 3. Frigate");
		
		//Get input
		String choice = in.nextLine();
		
		switch(choice) {
		  case "1":
			  //TODO USER1 is not string it is object
			  System.out.println(user+ ": Create Vehicle: Cruiser");
			  break;
		  case "2":
			  //TODO USER1 is not string it is object
			  System.out.println(user+ ": Create Vehicle: Destroyer");
			  break;
		  case "3":
			  System.out.println(user+ ": Create Vehicle: Frigate");
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1,2 or 3.");
		}

	}
	
	
	//bu user objesi olacak
	private void addAPart(String user) {
		System.out.println(" //// PLAYER OPERATIONS \\\\ ");
		System.out.println(" //// PLEASE SELECT VEHICLE TO ADD PART \\\\ ");
		System.out.println(" 1. x1 ");
		System.out.println(" 2. x2");
		
		String choice = in.nextLine();
		//find corresponding vehicle type

		String vehicleType = "plane";

		
		if(vehicleType == "plane") {
			//Objeyi verecek
			planeAddableParts("x1");
		} else if (vehicleType == "plane") {
			//Objeyi verecek
			shipAddableParts("x2");
		} else {
			System.out.println("Wrong vehicle type!");
		}
	}
	

	private void planeAddableParts(String obje) {
		System.out.println(" //// PLAYER OPERATIONS \\\\ ");
		System.out.println(" //// PLEASE SELECT PLANE ADDABLE PART \\\\ ");
		System.out.println(" 1. Rocket ");
		System.out.println(" 2. Missile");
		System.out.println(" 3. Machine Gun");
		System.out.println(" 3. Bomb");
		
		//Get input
		String choice = in.nextLine();
		
		switch(choice) {
		  case "1":
			  //TODO USER1 is not string it is object
			  System.out.println(obje+ ": Add part : Rocket");
			  break;
		  case "2":
			  //TODO USER1 is not string it is object
			  System.out.println(obje+ ": Add part : Missile");
			  break;
		  case "3":
			  System.out.println(obje+ ": Add part : Machine Gun");
			  break;
		  case "4":
			  System.out.println(obje+ ": Add part : Bomb");
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1,2,3 or 4.");
		}

	}

	
	private void shipAddableParts(String obje) {
		System.out.println(" //// PLAYER OPERATIONS \\\\ ");
		System.out.println(" //// PLEASE SELECT SHIP ADDABLE PART \\\\ ");
		System.out.println(" 1. Rocket ");
		System.out.println(" 2. Torpedo");
		System.out.println(" 3. Cannon");
		
		//Get input
		String choice = in.nextLine();
		
		switch(choice) {
		  case "1":
			  //TODO USER1 is not string it is object
			  System.out.println(obje+ ": Add part : Rocket");
			  break;
		  case "2":
			  //TODO USER1 is not string it is object
			  System.out.println(obje+ ": Add part : Torpedo");
			  break;
		  case "3":
			  System.out.println(obje+ ": Add part : Cannon");
			  break;
		  default:
			  System.out.println("Wrong input! Please enter 1,2,3 or 4.");
		}

	}
	
	
	
}
