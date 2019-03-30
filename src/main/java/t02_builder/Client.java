package t02_builder;

public class Client {
	public static void main(String[] args) {
		new MyAirShipDirector(new MyAirShipBuilder()).directAirShip().launch();
	}
}
