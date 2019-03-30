package t03_prototype;

import java.util.Date;

/**
 * 原型模式深复制：把引用的变量指向复制过的新对象，而不是原有的被引用的对象 
 * 具体操作：让已实现Clonable接口的类中的属性也实现Clonable接口
 * 另外：基本数据类型和String能够自动实现深度克隆（值的复制），其余的对象属性需要手动深度克隆
 */
public class T01_DeepCopy implements Cloneable {
	private String name;
	private Date birthday;

	public T01_DeepCopy() {
		super();
	}

	public T01_DeepCopy(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();  //直接调用object对象的clone()方法！
		
		//添加如下代码实现深复制(deep copy)
		T01_DeepCopy s = (T01_DeepCopy) obj;
		s.birthday = (Date) this.birthday.clone();  //把属性也进行克隆！
		return s;  // return obj; 也是可以的
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return super.toString() + " [name=" + name + ", birthday=" + birthday + "]";
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Date birth = new Date(System.currentTimeMillis());
		T01_DeepCopy sheep = new T01_DeepCopy("Dolly", birth);
		System.out.println(sheep);
		
		T01_DeepCopy clone = (T01_DeepCopy) sheep.clone();
		clone.setName("Another Dolly");
		System.out.println(clone);
		
		/**
		 * 下面这行代码运行结果为false，说明拷贝前后两个对象的birthday属性指向不同的内存空间，
		 * 当修改birth变量的时候，只有sheep对象会改变，clone对象不会改变；
		 * 因为birth对象和sheep的birthday属性指向同一块内存空间
		 */
		System.out.println(sheep.getBirthday() == clone.getBirthday());
		
		System.out.println("####################");
		birth.setTime(System.currentTimeMillis() - 1000000000L);
		System.out.println(sheep);
		System.out.println(clone);
		
		System.out.println("####################");
		
		clone.setBirthday(new Date(System.currentTimeMillis() + 1000000000L));
		System.out.println(sheep);
		System.out.println(clone);
	}
}
