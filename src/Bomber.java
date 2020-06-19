
public class Bomber implements IPlane {
	
	private int minPoint;
	private int maxPoint;
	private IEngine engine;
	
	public Bomber(IEngine engine) {
		this.minPoint = 15;
		this.maxPoint = 20;
		this.engine = engine;
	}	
	
	@Override
	public int getMinPoint() {
		return this.minPoint + this.engine.getMinPoint();
	}

	@Override
	public int getMaxPoint() {
		return this.maxPoint + this.engine.getMaxPoint();
	}

}
