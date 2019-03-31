package t09_facade;

public interface Tax {
	void taxCertificate(); // 办理税务登记证
}

class 海淀税务局 implements Tax {

	@Override
	public void taxCertificate() {
		System.out.println("在海淀税务局办理税务登记证！");
	}

}
