package t00_singleton;

import java.io.Serializable;

/**
 * 单例模式的增强版，修复因反射和反序列化造成单例失效的情形
 */
public class T05_SingletonStrengthen implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final static T05_SingletonStrengthen instance = new T05_SingletonStrengthen();

	private T05_SingletonStrengthen() {
		// 修复因反射造成单例失效的代码
		/*if (instance != null) {
			throw new RuntimeException("只能创建一个对象...");
		}*/
	}

	public static T05_SingletonStrengthen getInstance() {
		return instance;
	}

	/**
	 * 修复由于反序列化造成单例失效的代码，其根本原因是：
	 * 反序列化时，如果定义了readResolve()则直接返回此方法指定的对象（实际上是一种回调），而不需要单独再创建新对象；
	 * 注意：这里返回对象的类型必须是 Object，而不能是 T05_SingletonStrengthen
	 */
	/*private Object readResolve() {
		return instance;
	}*/
}
