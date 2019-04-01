package t15_strategy;

/**
 * 通过上下文类，使得算法与客户端独立
 * 后期可以使用配置文件动态注入（如Spring注入）不同的策略对象
 */
public class Context {
	private Strategy strategy; // 当前采用的具体策略

	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}

	public void execute() {
		strategy.solve();
	}
}
