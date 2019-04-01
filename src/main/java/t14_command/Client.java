package t14_command;

// 客户端
public class Client {
	public static void main(String[] args) {
		new Invoker(new ConcreteCommand(new Receiver(), "三天之内学习完23中设计模式")).invoke();
	}
}
