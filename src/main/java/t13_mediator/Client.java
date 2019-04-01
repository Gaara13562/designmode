package t13_mediator;

public class Client {
	public static void main(String[] args) {
		Mediator m = new Manager();
		
		Colleague research = new Research(m);
		new Finance(m);
		Colleague market = new Market(m);
		
		research.outAction("财务部");
		market.outAction("财务部");
	}
}
