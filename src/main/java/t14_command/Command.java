package t14_command;

// 抽象命令
public interface Command {
	void execute();
}

// 具体的命令，需要与接收者相关联
class ConcreteCommand implements Command {

	private Receiver rec; // 命令的接收方
	private String content; // 命令内容

	public ConcreteCommand(Receiver rec, String content) {
		super();
		this.rec = rec;
		this.content = content;
	}

	@Override
	public void execute() {
		// 调用接收者的方法来执行具体的请求处理
		rec.action(content);
	}

}
