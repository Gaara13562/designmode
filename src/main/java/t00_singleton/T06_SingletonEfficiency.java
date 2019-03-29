package t00_singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 测试多线程环境下五种单例模式的效率 1. 饿汉式 2. 懒汉式 3. 双重检测锁 4. 内部静态类 5. 枚举
 */
public class T06_SingletonEfficiency {
	public static void main(String[] args) throws Exception {

		int threadNum = 10;
		final CountDownLatch countDownLatch = new CountDownLatch(threadNum);

		long start = System.currentTimeMillis();
		for (int i = 0; i < threadNum; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 1000000; i++) {
						// T00_HungryMode.getInstance();
						// T01_LazyMode.getInstance();
						// T02_DoubleCheckLock.getInstance();
						// T03_StaticInnerClass.getInstance();
						@SuppressWarnings("unused")
						T04_Enumeration instance = T04_Enumeration.INSTANCE;
					}
					countDownLatch.countDown();
				}
			}).start();
		}
		countDownLatch.await(); // main线程阻塞，直到计数器变为0，才会继续往下执行！
		long end = System.currentTimeMillis();
		System.out.println("总耗时：" + (end - start) + " 毫秒");
	}
}
