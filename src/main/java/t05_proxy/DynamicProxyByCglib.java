package t05_proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 通过 Cglib 实现动态代理
 */
public class DynamicProxyByCglib {

	private Object target;

	public DynamicProxyByCglib(Object target) {
		super();
		this.target = target;
	}

	public Object getProxy() {
		// 1.工具类
		Enhancer en = new Enhancer();
		// 2.设置父类
		en.setSuperclass(target.getClass());
		// 3.设置回调函数
		en.setCallback(new MethodInterceptor() {

			// 以下截取一段关于 intercept 方法的官方说明，可见调用真实角色的方法有两种方式：
			// 1. 通过method参数利用反射机制来调用；
			// 2. 通过proxy参数例用代理的invokeSuper()方法来实现；
			/**
			 * All generated proxied methods call this method instead of the
			 * original method. The original method may either be invoked by
			 * normal reflection using the Method object, or by using the
			 * MethodProxy (faster). * @param obj "this", the enhanced object
			 * 
			 * @param obj
			 *            "this", the enhanced object
			 * 
			 * @param method
			 *            intercepted Method
			 * @param args
			 *            argument array; primitive types are wrapped
			 * @param proxy
			 *            used to invoke super (non-intercepted method); may be
			 *            called as many times as needed
			 */
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				beforeProxy();
				// Object result = method.invoke(target, args);
				Object result = proxy.invokeSuper(obj, args); // 该语句与上一行代码相同
				afterProxy();
				return result;
			}
		});
		return en.create();
	}

	private void afterProxy() {
		System.out.println("DynamicProxyByCglib.afterProxy()");
	}

	private void beforeProxy() {
		System.out.println("DynamicProxyByCglib.beforeProxy()");
	}

	public static void main(String[] args) {
		Source proxy = (Source) new DynamicProxyByCglib(new SourceImpl()).getProxy();
		proxy.work();
	}
}
