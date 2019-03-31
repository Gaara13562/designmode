package t07_composite;

// 抽象构件
public interface Component {
	void operate();
}

// 叶子构件
interface Leaf extends Component {

}

// 容器构件，有独立的方法
interface Composite extends Component {
	void add(Component c); // 添加构件

	void remove(Component c); // 删除构件

	Component getChild(int index); // 通过索引获得构件
}