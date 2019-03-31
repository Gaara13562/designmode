package t12_Iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Aggregate<T> {
	private List<T> list = new ArrayList<>();

	public Aggregate() {
		super();
	}

	public void add(T t) {
		list.add(t);
	}

	public void remove(T t) {
		list.remove(t);
	}

	public Iterator<T> iterator() {
		return new AggregateIterator();
	}

	// 定义一个内部类，用来生成聚合对象的迭代器
	private class AggregateIterator implements Iterator<T> {

		private int cursor = 0;

		public AggregateIterator() {
			super();
		}

		@Override
		public T next() {
			if (hasNext()) {
				return list.get(cursor++);
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public boolean hasNext() {
			return cursor < list.size();
		}

	}
}
