package t16_templateMethod;

public class Client {
	public static void main(String[] args) {
		// 通过匿名内部类来实现
		BankTemplateMethod withdraw = new BankTemplateMethod() {
			@Override
			protected void transact() {
				System.out.println("取钱业务...");
			}
		};
		withdraw.process();
		
		System.out.println("############");
		
		// 通过集成抽象类来实现
		BankTemplateMethod saveMoney = new SaveMoney();
		saveMoney.process();
	}
}

class SaveMoney extends BankTemplateMethod {

	@Override
	protected void transact() {
		System.out.println("存钱业务...");
	}
	
}