package t13_mediator;

// 同事类
public abstract class Colleague {

	protected Mediator mediator;

	public Colleague(String name, Mediator mediator) {
		super();
		this.mediator = mediator;
		mediator.register(name, this);
	}

	// 做自己的事情
	abstract void selfAction();

	// 向总经理发出申请，向其余同事
	abstract void outAction(String name);
}

class Research extends Colleague {

	public Research(Mediator mediator) {
		super("研发部", mediator);
	}

	@Override
	public void selfAction() {
		System.out.println("Research.selfAction()...");
	}

	@Override
	void outAction(String name) {
		System.out.println("申请经费做科研...");
		mediator.command(name);
	}
}

class Finance extends Colleague {

	public Finance(Mediator mediator) {
		super("财务部", mediator);
	}

	@Override
	void selfAction() {
		System.out.println("Finance.selfAction()...");
	}

	@Override
	void outAction(String name) {
		
	}

}

class Market extends Colleague {

	public Market(Mediator mediator) {
		super("市场部", mediator);
	}

	@Override
	void selfAction() {
		System.out.println("Market.selfAction()...");
	}

	@Override
	void outAction(String name) {
		System.out.println("申请经费做市场调研...");
		mediator.command(name);
	}

}