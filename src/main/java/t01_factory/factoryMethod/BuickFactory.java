package t01_factory.factoryMethod;

import t01_factory.bean.Buick;
import t01_factory.bean.Car;

public class BuickFactory implements CarFactoryInterface {

	@Override
	public Car createCar() {
		return new Buick();
	}

	public static void main(String[] args) {
		new BuickFactory().createCar().run();
	}
}
