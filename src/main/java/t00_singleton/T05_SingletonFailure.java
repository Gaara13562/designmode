package t00_singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 通过反射或者反序列化可以破解枚举模式意外的单例模式
 * 参考代码：t00_singleton.T05_SingletonStrengthen
 */
public class T05_SingletonFailure {
	public static void main(String[] args) throws Exception {
		T05_SingletonStrengthen instance1 = T05_SingletonStrengthen.getInstance();
		T05_SingletonStrengthen instance2 = T05_SingletonStrengthen.getInstance();
		System.out.println(instance1);
		System.out.println(instance2);
		
		System.out.println("########## 1. 由于反射造成的单例失效 ##########");
		
		@SuppressWarnings("unchecked")
		Class<T05_SingletonStrengthen> clazz = (Class<T05_SingletonStrengthen>) Class.forName("t00_singleton.T05_SingletonStrengthen");
		// 通过反射的方式直接访问私有构造器，让单例模式失效
		Constructor<T05_SingletonStrengthen> constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true); // 取消检查，否则私有构造器无法被访问
		/**
		 *  通过setAccessible(true)访问私有构造器，从而创建多个对象，跳过单例
		 *  当然，针对这种情况有解决方案，在私有构造其中添加下述代码
		 *  	if (instance != null) {
		 *  		throw new RuntimeException();
		 *  	}
		 *  当直接访问私有构造器且尚未初始化 instance 的时候，抛出运行时异常
		 */
		T05_SingletonStrengthen reflectInstance1 = constructor.newInstance();
		T05_SingletonStrengthen reflectInstance2 = constructor.newInstance();
		System.out.println(reflectInstance1);
		System.out.println(reflectInstance2);
		
		System.out.println("########## 2. 由于反序列化造成的单例失效 ##########");
		/**
		 * 解决方案：通过定义一个 private Object readResolve() 方法，返回类型必须是 Object，代码如下：
		 * 		private Object readResolve() {
		 *			return instance;
		 *		}
		 */
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./object.txt"));
		oos.writeObject(instance1);
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./object.txt"));
		T05_SingletonStrengthen instance3 = (T05_SingletonStrengthen) ois.readObject();
		ois.close();
		
		System.out.println(instance3);
		System.out.println(instance3 == instance1);  // false，跟序列化之前的对象已经不是同一个对象了
	}
}
