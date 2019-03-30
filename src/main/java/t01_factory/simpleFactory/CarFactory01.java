package t01_factory.simpleFactory;

import t01_factory.bean.Audi;
import t01_factory.bean.Buick;
import t01_factory.bean.Car;

/**
 * 简单工厂模式 优点：将调用者和使用者解耦； 缺点：如果有新的类型加入，需要修改简单工厂的方法；
 */
public class CarFactory01 {
	// 通过这个方法将类的具体实现交由工厂来解决，而解除了调用者与使用者之间的耦合
	public static Car createCar(String type) {
		if ("audi".equalsIgnoreCase(type)) {
			return new Audi();
		} else if ("Buick".equalsIgnoreCase(type)) {
			return new Buick();
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		// 此时使用者不需要去new对象，只需要通过CarFactory即可得到对象
		Car car1 = CarFactory01.createCar("audi");
		Car car2 = CarFactory01.createCar("buick");
		Car car3 = CarFactory01.createCar("unknown");
		if (car1 != null) {
			car1.run();
		}
		if (car2 != null) {
			car2.run();
		}
		if (car3 != null) {
			car3.run();
		}
	}
}
