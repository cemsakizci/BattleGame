
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPlane basePlane = new Bomber(new Pulsejet());
		IPlane missilePlane = new Missile(basePlane);
		IPlane missileRocketPlane = new Rocket(missilePlane);
		System.out.println(missileRocketPlane.getMaxPoint());
	}

}
