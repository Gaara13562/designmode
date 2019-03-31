package t06_bridge;

// 类型维度
public abstract class ComputerWithBridge {
	// 通过brand属性将品牌维度和类型维度桥接（这里可以将brand设置为protected，这样子类可以直接访问）
	private Brand brand;

	public ComputerWithBridge(Brand brand) {
		super();
		this.brand = brand;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public abstract void sale();
}

// 台式机类型
class Desktop2 extends ComputerWithBridge {
	public Desktop2(Brand brand) {
		super(brand);
	}

	@Override
	public void sale() {
		System.out.println("销售【" + super.getBrand().getName() + "】品牌的【台式机】...");
	}

}

// 笔记本类型
class Laptop2 extends ComputerWithBridge {

	public Laptop2(Brand brand) {
		super(brand);
	}

	@Override
	public void sale() {
		System.out.println("销售【" + super.getBrand().getName() + "】品牌的【笔记本】...");
	}

}