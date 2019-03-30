package t03_prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 使用序列化和反序列化实现深复制，此时对象需要实现 java.io.Serializable 接口
 */
public class T02_DeepCopy2 implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private Date birthday;

	public T02_DeepCopy2() {
		super();
	}

	public T02_DeepCopy2(String name, Date birthday) {
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
	public String toString() {
		return super.toString() + " [name=" + name + ", birthday=" + birthday + "]";
	}

	public static void main(String[] args) {
		Date birth = new Date(System.currentTimeMillis());
		T02_DeepCopy2 sheep = new T02_DeepCopy2("Dolly", birth);
		System.out.println(sheep);

		/** 
		 * 通过序列化和反序列化来实现深复制，
		 * 跟单例模式中失效情形 t00_singleton.T05_SingletonFailure是类似的
		 */
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ios = null;
		ByteArrayInputStream bais = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(sheep);
			byte[] bytes = baos.toByteArray();
			
			bais = new ByteArrayInputStream(bytes);
			ios = new ObjectInputStream(bais);
			T02_DeepCopy2 obj = (T02_DeepCopy2) ios.readObject();
			System.out.println(obj);
			
			System.out.println(sheep.getBirthday() == obj.getBirthday()); // false，深复制
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try { oos.close(); } catch (IOException e) { e.printStackTrace(); }
			}
			if (baos != null) {
				try { baos.close(); } catch (IOException e) { e.printStackTrace(); }
			}
			if (ios != null) {
				try { ios.close(); } catch (IOException e) { e.printStackTrace(); }
			}
			if (bais != null) {
				try { bais.close(); } catch (IOException e) { e.printStackTrace(); }
			}
		}
	}
}
