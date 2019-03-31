package t08_decorator;

public class Client {
	public static void main(String[] args) {
		ICar car = new Car();
		car.move();

		System.out.println("增加新的功能，飞行----------");
		ICar flycar = new FlyCar(car);
		flycar.move();

		System.out.println("增加新的功能，水里游---------");
		ICar waterCar = new WaterCar(car);
		waterCar.move();

		System.out.println("增加两个新的功能，飞行，水里游-------");
		ICar superCar = new WaterCar(new FlyCar(car));
		superCar.move();
	}
}
