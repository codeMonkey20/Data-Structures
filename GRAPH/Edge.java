import java.util.Random;

public class Edge<E> {
	private Random rand = new Random();
	private int WEIGHT = 0;
	private List<Vertex<E>> PAIR = new List<>();
	
	public Edge(Vertex<E> v1, Vertex<E> v2) {
		while (WEIGHT == 0)
			WEIGHT = rand.nextInt(10);
		PAIR.append(v1);
		PAIR.append(v2);
	}
	
	public int getWeight() {
		return WEIGHT;
	}
	
	public List<Vertex<E>> getPair() {
		return PAIR;
	}
}
