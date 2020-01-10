import java.util.Random;

public class Edge {
	private Random rand = new Random();
	private int WEIGHT;
	private List<Vertex> pair = new List<Vertex>();

	public Edge(Vertex v1, Vertex v2) {
		WEIGHT = rand.nextInt(10);
		pair.append(v1);
		pair.append(v2);
	}

	public int getWeight() {
		return WEIGHT;
	}

	public List getPair() {
		return pair;
	}
}