package t12_Iterator;

public interface Iterator<T> {
	// 返回当前对象，同时游标后移一个
	T next();

	// 判断是否有下一个对象
	boolean hasNext();
}
