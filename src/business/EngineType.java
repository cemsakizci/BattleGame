package business;


public enum EngineType {
	PULSEJET,
	TURBOJET;
	
	private int[][] minMaxArray = {{2,4}, {5,7}};
    public int[] getValue() {
        return minMaxArray[ordinal()];
    }
}
