package t05_proxy;

// import java.lang.reflect.InvocationHandler;
// import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 通过 JDK 实现动态代理
 */
public class DynamicProxyByJDK {
	private Object target;

	public DynamicProxyByJDK(Object target) {
		super();
		this.target = target;
	}

	/*public Object getProxy() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						beforeProxy();
						Object result = method.invoke(target, args);
						afterProxy();
						return result;
					}
				});
	}*/
	
	public Object getProxy() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				// 这里采用lambda表达式，效果跟上面代码是一样的
				(proxy, method, args) -> {
					beforeProxy();
					Object result = method.invoke(target, args);
					afterProxy();
					return result;
				}
		);
	}

	private void afterProxy() {
		System.out.println("DynamicProxyByJDK.afterProxy()");
	}

	private void beforeProxy() {
		System.out.println("DynamicProxyByJDK.beforeProxy()");
	}

	public static void main(String[] args) {
		Source proxy = (Source) new DynamicProxyByJDK(new SourceImpl()).getProxy();
		proxy.work();
	}
}
