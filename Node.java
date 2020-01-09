public class Node<T> {
	private T DATA;
	private Node<T> NEXT_DATA = null;
	private Node<T> PREVIOUS_DATA = null;

	public Node(T data) {
		DATA = data;
	}

	public Node() {
		DATA = null;
	}

	public void setData(T data) {
		DATA = data;
	}

	public T getData() {
		return DATA;
	}

	public void setNextNode(Node<T> data) {
		NEXT_DATA = data;
	}

	public Node getNextNode() {
		return NEXT_DATA;
	}

	public void setPreviousNode(Node<T> data) {
		PREVIOUS_DATA = data;
	}

	public Node getPreviousNode() {
		return PREVIOUS_DATA;
	}
}