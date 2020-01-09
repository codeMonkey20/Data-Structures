public class Demo {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i < 11; i++) {
			list.insert(i);
		}
		list.remove(1);
		list.print();
	}
}