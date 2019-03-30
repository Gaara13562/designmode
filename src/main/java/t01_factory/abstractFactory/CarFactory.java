package t01_factory.abstractFactory;

public interface CarFactory {
	Engine createEngine();
	Seat createSeat();
}

class LowCar implements CarFactory {

	@Override
	public Engine createEngine() {
		return new LowEngine();
	}

	@Override
	public Seat createSeat() {
		return new LowSeat();
	}
}

class HighCar implements CarFactory {

	@Override
	public Engine createEngine() {
		return new HighEngine();
	}

	@Override
	public Seat createSeat() {
		return new HighSeat();
	}
}