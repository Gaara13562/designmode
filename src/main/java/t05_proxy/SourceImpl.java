package t05_proxy;

/**
 * 抽象接口的具体实现，代表真是角色
 */
public class SourceImpl implements Source {

	@Override
	public void work() {
		System.out.println("Doing real work here...");
	}

}
