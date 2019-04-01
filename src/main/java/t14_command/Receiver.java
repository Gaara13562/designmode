package t14_command;

// 接收者
public class Receiver {
	public void action(String content) {
		System.out.println("处理具体的请求：" + content +  "...");
	}
}
