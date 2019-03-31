package t12_Iterator;

public class Client {
	public static void main(String[] args) {
		Aggregate<String> agg = new Aggregate<>();
		agg.add("Str0");
		agg.add("Str1");
		agg.add("Str2");
		agg.add("Str3");
		
		Iterator<String> iterator = agg.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
