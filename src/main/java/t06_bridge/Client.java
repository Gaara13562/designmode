package t06_bridge;

public class Client {
	public static void main(String[] args) {
		ComputerWithBridge lenevo = new Laptop2(new Lenovo());
		lenevo.sale();
		
		ComputerWithBridge dell = new Desktop2(new Dell());
		dell.sale();
	}
}
