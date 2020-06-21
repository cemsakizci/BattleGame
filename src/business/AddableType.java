package business;


public enum AddableType {
	ROCKET,
	MISSILE,
	MACHINEGUN,
	BOMB,
	TORPEDO,
	CANNON;
	
	private int[][] minMaxArray = {{2,8}, {3,6}, {1,3}, {0,10}, {3,5}, {3,7}};
    public int[] getValue() {
        return minMaxArray[ordinal()];
    }
}
