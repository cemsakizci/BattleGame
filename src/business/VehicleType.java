package business;


public enum VehicleType {
	FIGHTER, 
	BOMBER,
	MULTIROLE,
	CRUISER,
	DESTROYER,
	FRIGATE;
	
	private int[][] minMaxArray = {{10,12}, {15,20}, {10,25}, {15,30}, {20,40}, {10,40}};
    public int[] getValue() {
        return minMaxArray[ordinal()];
    }
}
