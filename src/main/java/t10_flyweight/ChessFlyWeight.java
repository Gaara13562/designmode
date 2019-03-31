package t10_flyweight;

// 抽象享元类
public interface ChessFlyWeight {
	// 这个函数通常不太需要，因为这个是共享属性，通常认为不需要改，否则最好不要采用享元模式
	void setColor(String c);

	String getColor();

	void display(Coordinate c);
}

// 具体的享元实现类
class ConcreteChess implements ChessFlyWeight {

	// 共享状态，可以作为类的成员变量存在（为内部状态提供成员变量进行存储）
	private String color;

	public ConcreteChess(String color) {
		super();
		this.color = color;
	}

	@Override
	public void display(Coordinate c) {
		System.out.println("棋子颜色：" + color);
		System.out.println("棋子位置：" + c.getX() + "----" + c.getY());
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void setColor(String c) {
		this.color = c;
	}
	
	@Override
	public String toString() {
		return super.toString() + " [color = " + this.color + "]";
	}

}
