package t19_memento;

import java.util.Date;

/**
 * 源发器类
 */
public class Originator {

	// 类的相关属性
	private int id;
	private String name;

	public Originator(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// 进行备忘操作
	public Memento memento(String msg) {
		// 将当前对象传递给Memento类实现一次备忘
		return new Memento(this, msg, new Date());
	}

	// 进行数据恢复
	public void recovery(Memento memento) {
		this.id = memento.getId();
		this.name = memento.getName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Originator [id=" + id + ", name=" + name + "]";
	}

}
