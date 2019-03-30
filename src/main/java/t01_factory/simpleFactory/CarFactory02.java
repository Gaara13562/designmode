package t01_factory.simpleFactory;

import t01_factory.bean.Audi;
import t01_factory.bean.Buick;
import t01_factory.bean.Car;

/**
 * 简单工厂模式 优点：将调用者和使用者解耦； 缺点：如果有新的类型加入，需要修改简单工厂的方法；
 */
public class CarFactory02 {
	// 简单工厂的另外一种实现方式
	public static Car createAudi(){
		return new Audi();
	}
	
	public static Car createBuick(){
		return new Buick();
	}

	public static void main(String[] args) {
		Car car1 = CarFactory02.createAudi();
		Car car2 = CarFactory02.createBuick();
		car1.run();
		car2.run();
	}
}
