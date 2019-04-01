package t14_command;

// 调用者
public class Invoker {
	private Command command;

	public Invoker(Command command) {
		super();
		this.command = command;
	}
	
	public void invoke() {
		command.execute();
	}
}
