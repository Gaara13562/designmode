package t04_adapter;

/**
 * 对象适配器，通过对象之间的组合来实现相应的功能
 */
public class Adapter implements Target {

	private Adaptee adaptee;

	public Adapter(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	// 通过需要适配的类来为目标接口提供具体的工作内容
	@Override
	public void workByTarget() {
		adaptee.workByAdaptee();
		System.out.println("通过【对象】适配器将需要适配的类转换为目标接口，并开始工作...");
	}

}
