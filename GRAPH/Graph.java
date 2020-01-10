import java.util.Random;

public class Graph {
	private List<Edge> EDGES = new List<Edge>();
	private List<Vertex> VERTICES = new List<Vertex>();
	private Random rand = new Random();
	private int num_v = 30;

	public Graph() {
		List<Integer> possibleValues = new List<Integer>();
		for (int i = 1; i < num_v + 1; i++) possibleValues.append(i);

		// adding the possible values/vertices into the graph
		for (int i = 1; i < num_v + 1; i++) {
			int chosenNumber = choiceInt(possibleValues);
			Vertex<Integer> vertex = new Vertex<Integer>(chosenNumber);

			// setting neighbor/s to the new vertex
			if (VERTICES.length != 0) {
				int num_nb = 0;
				while (num_nb == 0) {
					num_nb = rand.nextInt(VERTICES.length + 1);
				}

				for (int a = 0; a < num_nb - 1; a++) {
					Vertex nb = choiceVertex(VERTICES);
					if (vertex.setNeighbor(nb) && nb.setNeighbor(vertex)) {
						EDGES.append(new Edge(vertex, nb));
					}
				}
			}

			VERTICES.append(vertex);
			possibleValues.remove(chosenNumber);
		}
	}

	public void printGraph() {
		for (int i = 0; i < VERTICES.length; i++) {
			Vertex v = (Vertex)VERTICES.getElement(i);
			System.out.print("Vertex: " + v.getValue() + " --> ");
			List currentNeighbors = v.getNeighbor();
			for (int j = 0; j < currentNeighbors.length; j++) {
				Vertex nb = (Vertex)currentNeighbors.getElement(j);
				System.out.print(nb.getValue() + ", ");
			} System.out.println();
		} System.out.println();
	}

	public void printEdge() {
		EDGES.println();
	}

	public void initBFS() {
		Vertex startVertex = choiceVertex(VERTICES);
		System.out.print("BFS: [");
		startBFS(startVertex);
		System.out.println("]");
	}

	private void startBFS(Vertex start) {
		System.out.print(start.getValue() + ", ");
		start.setTraverse(true);
		recursionBFS(start);
	}

	private void recursionBFS(Vertex v) {
		boolean graphTraversed = true;
		List nb = v.getNeighbor();
		for (int i = 0; i < nb.length; i++) {
			Vertex x = (Vertex)nb.getElement(i);
			if (!x.getTraverse()) {
				System.out.print(x.getValue() + ", ");
				x.setTraverse(true);
				graphTraversed = false;
			}
		} if (graphTraversed) return;

		for (int i = 0; i < nb.length; i++) {
			Vertex x = (Vertex)nb.getElement(i);
			recursionBFS(x);
		}
	}

	private Vertex choiceVertex(List<Vertex> list) {
		int chosen = rand.nextInt(list.length);
		return list.getElement(chosen);
	}

	private int choiceInt(List<Integer> list) {
		int chosen = rand.nextInt(list.length);
		return list.getElement(chosen);
	}
}