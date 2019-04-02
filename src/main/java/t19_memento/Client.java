package t19_memento;

import java.util.concurrent.TimeUnit;

public class Client {
	public static void main(String[] args) {
		Originator o = new Originator(1, "Allen");
		System.out.println(o);
		CareTaker.addMemento(o.memento("第一次备忘录"));
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		o = new Originator(2, "Bob");
		System.out.println(o);
		CareTaker.addMemento(o.memento("第二次备忘录"));
		
		CareTaker.showAllMementos();
		
		o.recovery(CareTaker.getMemento(0));
		System.out.println("恢复第一次备忘录时刻：" + o);
	}
}
