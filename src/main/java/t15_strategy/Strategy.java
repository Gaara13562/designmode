package t15_strategy;

// 策略接口
public interface Strategy {
	void solve();
}

// 具体的策略实现类
class Strategy1 implements Strategy {
	@Override
	public void solve() {
		System.out.println("Strategy1.solve()");
	}
}

class Strategy2 implements Strategy {
	@Override
	public void solve() {
		System.out.println("Strategy2.solve()");
	}
}

class Strategy3 implements Strategy {
	@Override
	public void solve() {
		System.out.println("Strategy3.solve()");
	}
}