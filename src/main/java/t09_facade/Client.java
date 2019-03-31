package t09_facade;

public class Client {
	public static void main(String[] args) {
		// 不使用外观模式，此时需要自己组装
		/*Commerce a = new 海淀区工商局();
		a.checkName();
		Quality b = new 海淀质检局();
		b.orgCodeCertificate();
		Tax c = new 海淀税务局();
		c.taxCertificate();
		Bank d = new 中国工商银行();
		d.openAccount();*/

		System.out.println("####################");
		
		// 使用外观模式封装之后一步完成
		new RegisterFacade().register();

	}
}
