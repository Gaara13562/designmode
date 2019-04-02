package t16_templateMethod;

public abstract class BankTemplateMethod {

	private void acquireNumber() {
		System.out.println("取号排队...");
	}

	private void evaluate() {
		System.out.println("反馈评分...");
	}

	// 具体的业务在子类中实现，也称之为钩子函数
	protected abstract void transact();
	
	// 模板方法，将基本操作组合在一起，子类一般不能重写该方法
	public final void process() {
		acquireNumber();
		transact();
		evaluate();
	}

}
