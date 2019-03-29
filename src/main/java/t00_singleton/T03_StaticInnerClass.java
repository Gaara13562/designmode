package t00_singleton;

/**
 * 通过静态内部类来实现单例模式，且具备
 * 1. 线程安全
 * 2. 效率高
 * 3. 延迟加载
 */
public class T03_StaticInnerClass {

	// 构建一个内部静态类，未调用之前是不会初始化内部类的，因此具备延迟加载的特性
	// 跟饿汉式比起来，就是这里没有采用静态属性，而是采用静态内部类来实现对单例对象的初始化和引用
	private static class SingletonClass {
		// 由于类加载的过程是天然线程安全的，因此这里 instance 也是线程安全的，并且只加载一次，final可有可无
		private static final T03_StaticInnerClass instance = new T03_StaticInnerClass();
	}

	// 构造方法私有化
	private T03_StaticInnerClass() {

	}

	// 提供访问单例对象的方法，而且无需同步，因此效率自然也就高了
	public static T03_StaticInnerClass getInstance() {
		return SingletonClass.instance;
	}
}
