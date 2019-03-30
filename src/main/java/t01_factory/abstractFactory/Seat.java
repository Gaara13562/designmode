package t01_factory.abstractFactory;

public interface Seat {
	void lay();
}

class LowSeat implements Seat {
	@Override
	public void lay() {
		System.out.println("低端座椅...");
	}
}

class HighSeat implements Seat {
	@Override
	public void lay() {
		System.out.println("高端座椅...");
	}
}