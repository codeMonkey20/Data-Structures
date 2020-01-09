public class Stack<T> {
	private Node<T> HEAD, TAIL = null;
	private int LENGTH = 0;

	public void push(T data) {
		Node<T> newNode = new Node<T>(data);
		if (HEAD == null) {
			HEAD = newNode;
			TAIL = newNode;
		} else {
			Node recentNode = TAIL;
			recentNode.setNextNode(newNode);
			newNode.setPreviousNode(recentNode);
			TAIL = newNode;
		} LENGTH++;
	}

	public void pop() {
		if (HEAD != null && TAIL != null) {
			if (LENGTH > 1) {
				TAIL = TAIL.getPreviousNode();
				TAIL.setNextNode(null);
			} else {
				HEAD = null;
				TAIL = null;
				System.gc();
			} LENGTH--;
		}
	}

	public Node get() {
		return TAIL;
	}

	public int length(){
		return LENGTH;
	}

	public void print() {
		if (LENGTH != 0) {
			Node iterate = TAIL;
			System.out.println("---------");
			while (true) {
				if (iterate == TAIL && iterate != HEAD) 
					System.out.println(iterate.getData() + " <--TAIL");
				else if (iterate != TAIL && iterate != HEAD)
					System.out.println(iterate.getData());
				else
					System.out.println(iterate.getData() + " <--HEAD");

				if (iterate.getPreviousNode() != null)
					iterate = iterate.getPreviousNode();
				else break;
			}
			System.out.print("---------");
		}
	}


}