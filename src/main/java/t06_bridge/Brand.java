package t06_bridge;

// 品牌维度
public class Brand {
	private String name;

	public Brand(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

// 联想品牌
class Lenovo extends Brand {
	public Lenovo() {
		super("Lenovo");
	}
}

// Dell品牌
class Dell extends Brand {
	public Dell() {
		super("Dell");
	}
}