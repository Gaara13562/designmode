package t19_memento;

import java.util.LinkedList;
import java.util.List;

/**
 * 负责人类，负责管理备忘录对象
 */
public class CareTaker {
	// 用来保存备忘录，这里写成静态对象便于后续调用，实际不一定非要用静态属性
	// 这里的容器还可以考虑用 Map，或者 Stack（先进后出，最近的备忘录最先回复）
	private static List<Memento> list = new LinkedList<>();

	// 提取备忘录，用于恢复数据，默认提取最后一个
	public static Memento getMemento() {
		return list.get(list.size() - 1);
	}

	// 提取备忘录，用于恢复数据
	public static Memento getMemento(Integer index) {
		return list.get(index);
	}

	// 添加备忘录
	public static void addMemento(Memento memento) {
		list.add(memento);
	}

	// 显示所有备忘录
	public static void showAllMementos() {
		System.out.println("显示所有备忘录：");
		for (Memento m : list) {
			System.out.println(m.getDate() + "\t" + m.getMsg() + "\t" + m);
		}
	}

}
