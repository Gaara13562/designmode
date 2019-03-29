package t00_singleton;

/**
 * 通过枚举来实现单例模式 （天然单例）
 * 枚举本身就是单例模式，由JVM从根本上提供单例保障，且避免了反射和反序列化的漏洞
 * 缺点：没有延迟加载（懒加载）
 */
public enum T04_Enumeration {
	// 单例对象
	INSTANCE;

	// 可以针对单例对象自己添加所需操作
	public void singletonOperation() {
	}
	
	public static void main(String[] args) {
		System.out.println(T04_Enumeration.INSTANCE.hashCode());
		System.out.println(T04_Enumeration.INSTANCE.hashCode());
	}
}
