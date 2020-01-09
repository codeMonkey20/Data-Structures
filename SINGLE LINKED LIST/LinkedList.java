public class LinkedList<T> {
	private Node<T> NULL;

	public LinkedList() {
		NULL = new Node();
	}

	public void insert(T data) {
		if (NULL.getNextData() == null) {
			NULL.setNextData(new Node<T>(data));
		} else {
			Node<T> iterateNode = NULL;
			while (iterateNode.getNextData() != null) {
				iterateNode = iterateNode.getNextData();
			}
			iterateNode.setNextData(new Node<T>(data));
		}
	}

	public void remove(int index) {
		Node<T> iterateNode = NULL;
		Node<T> beforeIterateNode = NULL;
		for (int i = -1; i < index; i++) {
			beforeIterateNode = iterateNode;
			iterateNode = iterateNode.getNextData();
		}
		beforeIterateNode.setNextData(iterateNode.getNextData());
		iterateNode.setData(null);
		System.gc();
	}

	public T getElement(int index) {
		Node<T> iterateNode = NULL;
		for (int i = -1; i < index; i++) {
			iterateNode = iterateNode.getNextData();
		}
		return iterateNode.getData();
	}

	public int getIndex(T element) {
		Node<T> iterateNode = NULL;
		int c = -1;
		while (iterateNode.getNextData() != null) {
			iterateNode = iterateNode.getNextData();
			c++;
			if (iterateNode.getData() == element)
				return c;
		}
		return -1; 
	}

	public void print() {
		Node<T> iterateNode = NULL;
		while (iterateNode.getNextData() != null) {
			iterateNode = iterateNode.getNextData();
			System.out.println(iterateNode.getData());
		}
	}
}