package t04_adapter;

/**
 * 借助目标接口进行工作的终端
 */
public class Client {
	
	public void work(Target t) {
		t.workByTarget();
	}
	
	public static void main(String[] args) {
		Adaptee adaptee = new Adaptee();
		Target t = new Adapter(adaptee);
		new Client().work(t);
		System.out.println("##########");
		new Client().work(new Adapter2());
	}
}
