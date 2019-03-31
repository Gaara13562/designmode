package t09_facade;

/**
 * 办理注册公司流程的门面对象
 */
public class RegisterFacade {
	public void register() {
		Commerce a = new 海淀区工商局();
		a.checkName();
		Quality b = new 海淀质检局();
		b.orgCodeCertificate();
		Tax c = new 海淀税务局();
		c.taxCertificate();
		Bank d = new 中国工商银行();
		d.openAccount();
	}
}
