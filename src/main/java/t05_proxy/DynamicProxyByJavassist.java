package t05_proxy;

import java.lang.reflect.Method;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

/**
 * 通过 Javassist 实现动态代理
 */
public class DynamicProxyByJavassist {

	private Object target;

	public DynamicProxyByJavassist(Object obj) {
		super();
		this.target = obj;
	}

	@SuppressWarnings("deprecation")
	public Object getProxy() throws Exception {
		// 1. 创建代理工厂
		ProxyFactory factory = new ProxyFactory();

		// 2. 设置被代理的类型
		factory.setSuperclass(target.getClass());

		/*
		 * 3. 定义一个拦截器。在调用目标方法时，Javassist会回调MethodHandler接口方法拦截，
		 * 来实现你自己的代理逻辑，类似于JDK中的InvocationHandler接口。
		 */
		factory.setHandler(new MethodHandler() {

			/*
			 * self为由Javassist动态生成的代理类实例；
			 * thismethod 为 当前要调用的方法；
			 * proceed 为生成的代理类对方法的代理引用；
			 * Object[]为参数值列表；
			 * 返回：从代理实例的方法调用返回的值。
			 * 
			 * 其中，proceed.invoke(self, args); 或者 thisMethod.invoke(target, args);
			 * 表示调用代理类实例上的代理方法的父类方法（即实体类中对应的方法）
			 */
			@Override
			public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
				beforeProxy();
				// Object result = thisMethod.invoke(target, args);
				Object result = proceed.invoke(self, args); // 这行语句与上面等价
				afterProxy();
				return result;
			}
		});
		return factory.createClass().newInstance();
	}

	private void afterProxy() {
		System.out.println("DynamicProxyByJavassist.afterProxy()");
	}

	private void beforeProxy() {
		System.out.println("DynamicProxyByJavassist.beforeProxy()");
	}

	public static void main(String[] args) throws Exception {
		Source proxy = (Source) new DynamicProxyByJavassist(new SourceImpl()).getProxy();
		proxy.work();
	}
}
