package t17_state;

import java.util.concurrent.TimeUnit;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		Context ctx = new Context();
		ctx.setState(new Free()); // 初始设置为空闲状态
		TimeUnit.SECONDS.sleep(1);
		ctx.setState(new Reserved()); // 1秒之后切换为预定状态
		TimeUnit.SECONDS.sleep(1);
		ctx.setState(new CheckIn()); // 1秒之后设置为入住状态
	}
}
