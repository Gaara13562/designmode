package t01_factory.abstractFactory;

public class Client {

	public static void main(String[] args) {
		LowCar lowCar = new LowCar();
		lowCar.createEngine().run();
		lowCar.createSeat().lay();
		
		System.out.println("##########");
		
		HighCar highCar = new HighCar();
		highCar.createEngine().run();
		highCar.createSeat().lay();
	}

}
