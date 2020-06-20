package business;


public class Turbojet extends Engine {

	public Turbojet() {
		super(5, 7);
	}
	
	public EngineType getEngineType() {
		return EngineType.TURBOJET;
	}
}
