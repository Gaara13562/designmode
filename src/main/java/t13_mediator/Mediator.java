package t13_mediator;

import java.util.HashMap;
import java.util.Map;

// 中介者类
public interface Mediator {
	// 将同事对象注册到中介者这里来，便于中介者进行管理
	void register(String name, Colleague c);

	// 向同事发布指令
	void command(String name);
}

class Manager implements Mediator {

	private Map<String, Colleague> map = new HashMap<>();

	@Override
	public void register(String name, Colleague c) {
		map.put(name, c);
	}

	@Override
	public void command(String name) {
		Colleague colleague = map.get(name);
		if (colleague != null) {
			colleague.selfAction();
		}
	}

}