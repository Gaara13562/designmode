package t00_singleton;

/**
 * 懒汉式单例模式 
 * 优点：延迟加载，线程安全 
 * 缺点：效率不高
 */
public class T01_LazyMode {

	/**
	 * 这里加上 volatile 关键字，可以避免其他线程可能访问一个没有初始化的对象（由于指令重排而引起的）
	 * 具体参考 concurrent_jvm_thread 项目中 thread.advanced.T04_DoubleCheckedLocking 类
	 * 
	 * 类初始化的时候并没有初始化这个对象，而是在使用的时候才初始化
	 */
	private volatile static T01_LazyMode instance = null;

	private T01_LazyMode() {

	}

	// 方法同步，效率很低，因为每次获取单例对象都需要获取锁，造成潜在的效率低下
	public static synchronized T01_LazyMode getInstance() {
		if (instance == null) {
			instance = new T01_LazyMode();
		}
		return instance;
	}

	// 部分同步，这种方式比前述方式效率要高，避免了无意义的低效（双重检测锁）
	public static T01_LazyMode getInstance2() {
		if (instance == null) {
			synchronized (T01_LazyMode.class) {
				if (instance == null) {
					instance = new T01_LazyMode();
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(() -> System.out.println(T01_LazyMode.getInstance2())).start();
			new Thread(() -> System.out.println(T01_LazyMode.getInstance2())).start();
			new Thread(() -> System.out.println(T01_LazyMode.getInstance2())).start();
		}
	}
}
