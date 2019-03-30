package t04_adapter;

/**
 * 需要被适配的类
 */
public class Adaptee {
	public void workByAdaptee() {
		System.out.println("Adaptee的工作结果，但是与标准接口不兼容...");
	}
}
