package t18_observer;

// 观察者
public abstract class Observer {
	protected String name;

	public Observer(String name) {
		super();
		this.name = name;
	}

	// 订阅某个目标
	public void subscribe(Subject subject) {
		subject.register(this);
	}

	// 退订
	public void unsubscribe(Subject subject) {
		subject.remove(this);
	}

	// 观察者针对目标改变做出的反应，做成抽象方法，加油具体的子类去实现
	public abstract void handle(Subject subject);
}

class ShowObserver extends Observer {

	public ShowObserver(String name) {
		super(name);
	}

	@Override
	public void handle(Subject subject) {
		System.out.println(this.name + "得到消息：" + subject.getNews() + "...");
	}

}

class DBObserver extends Observer {

	public DBObserver(String name) {
		super(name);
	}

	@Override
	public void handle(Subject subject) {
		System.out.println(this.name + "将消息：" + subject.getNews() + " 存入数据库...");
	}

}