package t09_facade;

public interface Bank {
	void openAccount(); // 开户
}

class 中国工商银行 implements Bank {

	@Override
	public void openAccount() {
		System.out.println("在中国工商银行开户！");
	}

}
