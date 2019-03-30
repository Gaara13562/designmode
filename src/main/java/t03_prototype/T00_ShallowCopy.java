package t03_prototype;

import java.util.Date;

/**
 * 要实现克隆该对象，必须要实现Cloneable接口，当前是浅克隆（浅复制）
 */
public class T00_ShallowCopy implements Cloneable {
	private String name;
	private Date birthday;

	public T00_ShallowCopy() {
		super();
	}

	public T00_ShallowCopy(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
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
	protected Object clone() throws CloneNotSupportedException {
		return super.clone(); // 直接调用object对象的clone()方法！
	}

	@Override
	public String toString() {
		return super.toString() + " [name=" + name + ", birthday=" + birthday + "]";
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Date birth = new Date(System.currentTimeMillis());
		T00_ShallowCopy sheep = new T00_ShallowCopy("Dolly", birth);
		System.out.println(sheep);
		
		T00_ShallowCopy clone = (T00_ShallowCopy) sheep.clone();
		clone.setName("Another Dolly");
		System.out.println(clone);
		
		/**
		 * 下面这行代码运行结果为true，说明拷贝前后两个对象的birthday属性指向同一块内存空间，
		 * 因此这里的拷贝是浅拷贝，不是真正意义上的拷贝
		 * 当修改birth变量的时候，两个对象的birthday属性值都会改变
		 * 除非调用 setBirthday()方法，这个方法其实是生成了一个新的对象，此时两者birthday属性不再相同
		 */
		System.out.println(sheep.getBirthday() == clone.getBirthday());
		
		System.out.println("####################");
		birth.setTime(System.currentTimeMillis() - 1000000000L);
		System.out.println(sheep);
		System.out.println(clone);
		
		System.out.println("####################");
		
		clone.setBirthday(new Date(birth.getTime() + 1000000000L));
		System.out.println(sheep);
		System.out.println(clone);
	}
}
