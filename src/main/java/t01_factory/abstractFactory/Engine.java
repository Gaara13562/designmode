package t01_factory.abstractFactory;

public interface Engine {
	void run();
}

class LowEngine implements Engine {
	@Override
	public void run() {
		System.out.println("低端引擎...");
	}
}

class HighEngine implements Engine {
	@Override
	public void run() {
		System.out.println("高端引擎...");
	}
}