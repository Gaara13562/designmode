package t19_memento;

/**
 * 备忘录类，通过对Originator对象的备忘而产生
 */
public class Memento {

	// 对应 Originator 对象的属性
	private int id;
	private String name;
	
	// 保存备忘录时的备注信息
	private String msg;

	public Memento(Originator originator, String msg) {
		// 将Originator对象的属性值赋给 Memento对象，实现对象的保存，也就是相当于一个存储操作
		this.id = originator.getId();
		this.name = originator.getName();
		this.msg = msg; // 添加备注信息
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
