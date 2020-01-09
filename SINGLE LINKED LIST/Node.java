public class Node<T> {
	private T DATA;
	private Node<T> NEXT_DATA;
	
	public Node(T data) {
		DATA = data;
		NEXT_DATA = null;
	}

	public Node(T data, Node nextData) {
		DATA = data;
		NEXT_DATA = nextData;
	}

	public Node() {
		DATA = null;
		NEXT_DATA = null;
	}

	public void setData(T data) {
		DATA = data;
	}

	public T getData() {
		return DATA;
	}

	public void setNextData(Node<T> data) {
		NEXT_DATA = data;
	}

	public Node getNextData() {
		return NEXT_DATA;
	}
}