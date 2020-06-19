
public class Fighter implements IPlane {
	private int minPoint;
	private int maxPoint;
	private IEngine engine;
	
	public Fighter(IEngine engine) {
		this.minPoint = 10;
		this.maxPoint = 12;
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
