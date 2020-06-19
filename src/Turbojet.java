
public class Turbojet implements IEngine {
	private int minPoint;
	private int maxPoint;
	
	public Turbojet() {
		this.minPoint = 5;
		this.maxPoint = 7;
	}
	
	@Override
	public int getMinPoint() {
		return this.minPoint;
	}

	@Override
	public int getMaxPoint() {
		return this.maxPoint;
	}

}
