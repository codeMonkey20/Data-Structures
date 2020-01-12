public class Vertex<E> {

	private E VALUE;
	private List<Vertex<E>> NEIGHBORS = new List<>();
	private boolean TRAVERSE = false;
	
	public Vertex(E value) {
		VALUE = value;
	}
	
	public E getValue() {
		return VALUE;
	}
	
	public boolean setNeighbor(Vertex<E> vertex) {
		for (int i = 0; i < NEIGHBORS.length; i++) {
			if (NEIGHBORS.getElement(i) == vertex) {
				return false;
			}
		}
		NEIGHBORS.append(vertex);
		return true;
	}
	
	public List<Vertex<E>> getNeighbor() {
		return NEIGHBORS;
	}
	
	public void setTraverse(boolean t) {
		TRAVERSE = t;
	}
	
	public boolean getTraverse() {
		return TRAVERSE;
	}
}
