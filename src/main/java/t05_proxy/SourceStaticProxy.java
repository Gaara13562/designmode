package t05_proxy;

/**
 * 静态代理类，也就是代理角色，需要为每一个接口提供一个代理类实现
 */
public class SourceStaticProxy implements Source {

	private Source source;

	public SourceStaticProxy(Source source) {
		super();
		this.source = source;
	}

	@Override
	public void work() {
		beforeProxy();
		source.work();
		afterProxy();
	}

	private void afterProxy() {
		System.out.println("After proxy...");
	}

	private void beforeProxy() {
		System.out.println("Before proxy...");
	}
}
