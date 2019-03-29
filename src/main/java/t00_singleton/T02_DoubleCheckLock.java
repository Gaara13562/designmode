package t00_singleton;

/**
 * 双重检测锁单例模式 （不考虑这一模式应用）
 * 参考资料：https://blog.csdn.net/qq646040754/article/details/81327933
 * 另外参考：thread.advanced.T04_DoubleCheckedLocking
 */
public class T02_DoubleCheckLock {

	private static T02_DoubleCheckLock instance;

	private T02_DoubleCheckLock() {

	}

	// 解决无序读写的问题，但是仍然有问题，且暂时无法避免
	public static T02_DoubleCheckLock getInstance() {
		if (instance == null) {
			synchronized (T02_DoubleCheckLock.class) {
				T02_DoubleCheckLock inst = instance;
				if (inst == null) {
					synchronized (T02_DoubleCheckLock.class) {
						inst = new T02_DoubleCheckLock();
					}
					instance = inst;
				}
			}
		}
		return instance;
	}
}
