package business;


public class Pulsejet extends Engine {
	
	public Pulsejet() {
		super(2, 4);
	}

	public EngineType getEngineType() {
		return EngineType.PULSEJET;
	}
}
