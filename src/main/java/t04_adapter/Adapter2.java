package t04_adapter;

/**
 * 类适配器，让适配器直接继承需要适配的类（由于单继承的原因，不建议采用，而且拓展性不强）
 */
public class Adapter2 extends Adaptee implements Target {

	// 通过需要适配的类来为目标接口提供具体的工作内容
	@Override
	public void workByTarget() {
		super.workByAdaptee();
		System.out.println("通过【类】适配器将需要适配的类转换为目标接口，并开始工作...");
	}

}
