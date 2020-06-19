
public class Pulsejet implements IEngine {
	private int minPoint;
	private int maxPoint;
	public Pulsejet() {
		this.minPoint = 2;
		this.maxPoint = 4;
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
