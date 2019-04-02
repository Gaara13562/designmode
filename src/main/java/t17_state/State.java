package t17_state;

public interface State {
	void handle();
}

class Free implements State {
	@Override
	public void handle() {
		System.out.println("房间空闲，可以预订或者入住...");
	}
}

class Reserved implements State {
	@Override
	public void handle() {
		System.out.println("房间已经预定，等待入住或者被退订...");
	}
}

class CheckIn implements State {
	@Override
	public void handle() {
		System.out.println("房间已经入住，等待客户退房...");
	}
}
