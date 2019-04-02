package t18_observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Java内部提供了两个接口，用于实现观察者模式，分别是 
 * java.util.Observable - 对应目标 
 * java.util.Observer	- 对应观察者
 */
public class JavaObserver {
	public static void main(String[] args) {
		ObserverByJava obs = new ObserverByJava();
		
		SubjectByJava sub = new SubjectByJava();
		// sub.addObserver(obs); // 这是通过目标主动添加观察者的方式
		obs.subscribe(sub); // 这是观察者订阅的方式（自己添加的方法，本质仍然是 observable.addObserver()方法）
		
		sub.publishNews("通过Java自带的类和接口来实现观察者模式...");
	}
}

// 观察者
class ObserverByJava implements Observer {

	public void subscribe(Observable sub) {
		sub.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("观察者接收到消息：" + arg);
	}

}

// 目标对象
class SubjectByJava extends Observable {

	public void publishNews(String news) {
		/**
		 *  表示目标对象做了更改，通知观察者之前一定要做这个设置，否则下面的notifyObservers不会执行
		 *  通过查看源代码可以得到这一结论，源代码中做了 if (!changed) 的判断
		 *  此外，从原代码还可以看出Java提供的观察者类中实现了线程安全
		 */
		this.setChanged();

		// 通知所有的观察者目标状态发生改变，并且news参数可以以参数的形式传递过去
		this.notifyObservers(news);
	}
}