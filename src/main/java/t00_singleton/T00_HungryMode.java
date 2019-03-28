package t00_singleton;

/**
 * 饿汉式单例模式
 * 优点：线程安全，效率高
 * 缺点：无法延迟加载
 */
public class T00_HungryMode {

	/**
	 *  设置单例静态变量（最好加上final修饰，更为严谨），类初始化时，立即加载该对象。
	 *  之所以称之为饿汉式，就是因为一开始就已经创建了这么一个对象；
	 *  由此也带来了潜在的性能损失，无法延迟加载，造成资源浪费。
	 */
	private final static T00_HungryMode instance = new T00_HungryMode();

	// 构造器私有化，保证不被外部new新的对象
	private T00_HungryMode() {

	}

	// 提供一个静态方法，用于访问静态单例对象，此处无需带上synchronized关键字，没有同步，效率高
	public static T00_HungryMode getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		T00_HungryMode single1 = T00_HungryMode.getInstance();
		T00_HungryMode single2 = T00_HungryMode.getInstance();
		System.out.println(single1 == single2);
	}

}
