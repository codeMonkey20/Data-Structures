public class Vertex<T> {
	private T VALUE;
	private List<Vertex> NB = new List<Vertex>();
	private boolean TRAVERSE = false;

	public Vertex(T value) {
		VALUE = value;
	}

	public T getValue() {
		return VALUE;
	}

	public void setValue(T value) {
		VALUE = value;
	}

	public boolean setNeighbor(Vertex nb) {
		if (NB.isExisting(nb)) {
			return false;
		}
		NB.append(nb);
		return true;
	}

	public List getNeighbor() {
		return NB;
	}

	public void setTraverse(boolean t) {
		TRAVERSE = t;
	}

	public boolean getTraverse() {
		return TRAVERSE;
	}


}