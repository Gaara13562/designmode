package t18_observer;

public class Client {

	public static void main(String[] args) {
		// 1. 创建目标对象
		Subject sub1 = new Subject();
		
		// 2. 创建多个观察者，并订阅目标
		Observer obs1 = new ShowObserver("显示订阅者");
		obs1.subscribe(sub1);
		Observer obs2 = new DBObserver("数据库订阅者");
		obs2.subscribe(sub1);
		
		// 3. 测试消息发布
		sub1.publishNews("今天习近平访欧...");
		System.out.println("############");
		obs1.unsubscribe(sub1);
		sub1.publishNews("特朗普又皮了一下...");
	}
}
