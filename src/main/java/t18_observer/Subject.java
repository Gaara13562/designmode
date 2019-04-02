package t18_observer;

import java.util.HashSet;
import java.util.Set;

// 目标类
public class Subject {

	private String news;// 目标的状态，这里简单的用String类型的数据模拟一下
	private Set<Observer> set;// 用set不用list是防止观察者重复订阅

	public Subject() {
		super();
		set = new HashSet<>();
	}

	public String getNews() {
		return news;
	}

	// 发布消息，这里可以做成抽象方法，由具体的子类来实现该方法，确定要发布具体消息
	public void publishNews(String news) {
		this.news = news;
		publish(); // 设置消息之后，立即发布给订阅者（观察者）
	}

	// 通知所有的观察者目标发生改变，如发布新的消息
	private void publish() {
		for (Observer observer : set) {
			observer.handle(this);
		}
	}

	// 观察者订阅
	public void register(Observer observer) {
		set.add(observer);
	}

	// 观察者取消订阅
	public void remove(Observer observer) {
		set.remove(observer);
	}

}
