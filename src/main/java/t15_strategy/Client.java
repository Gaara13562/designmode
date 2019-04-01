package t15_strategy;

public class Client {
	public static void main(String[] args) {
		new Context(new Strategy1()).execute();
		new Context(new Strategy2()).execute();
		new Context(new Strategy3()).execute();
	}
}
