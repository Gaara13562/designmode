package t09_facade;

public interface Commerce {
	void checkName(); // 核名
}

class 海淀区工商局 implements Commerce {

	@Override
	public void checkName() {
		System.out.println("检查名字是否有冲突！");
	}

}
