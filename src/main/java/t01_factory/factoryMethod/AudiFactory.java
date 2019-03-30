package t01_factory.factoryMethod;

import t01_factory.bean.Audi;
import t01_factory.bean.Car;

public class AudiFactory implements CarFactoryInterface {

	@Override
	public Car createCar() {
		return new Audi();
	}
	
	public static void main(String[] args) {
		new AudiFactory().createCar().run();
	}
}
