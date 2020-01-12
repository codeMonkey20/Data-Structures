import java.util.Random;

public class Graph<E> {
	private List<Edge<E>> EDGES = new List<>();
	private List<Vertex<E>> VERTICES = new List<>();
	private Random rand = new Random();
	
	public Graph(List<E> list) {
		
		// creates a list of possible values
		List<E> possibleValues = new List<>(list);
		int length = possibleValues.length;
		
		// adding the possible values/vertices into the graph
		for (int i = 0; i < length; i++) {
			
			// choosing random value from list of possible values
			E chosenData = chooseValue(possibleValues);
			
			// creating new vertex of chosen value
			Vertex<E> newVertex = new Vertex<>(chosenData);
			
			// setting neighbor/s to the new vertex, if graph has more than 1 vertex
			if (VERTICES.length != 0) {
				
				// creates random number of neighbors to be set
				int numNeighbors = 0;
				
				// number of neighbors should be greater than 0
				while (numNeighbors == 0)
					numNeighbors = rand.nextInt(VERTICES.length + 1);
				
				// setting neighbors
				for (int j = 0; j <= numNeighbors; j++) {
					Vertex<E> chosenNeighbor = chooseVertex(VERTICES);
					
					// edges only form when 2 vertices joined together
					if (newVertex.setNeighbor(chosenNeighbor) && chosenNeighbor.setNeighbor(newVertex)) {
						EDGES.append(new Edge<E>(newVertex, chosenNeighbor));
					}
				}
			}
			
			// insert new vertex into the graph
			VERTICES.append(newVertex);
			
			// deletes used values
			possibleValues.remove(chosenData);
		}
		System.out.println("Size: " + VERTICES.length);
	}
	
	public void printGraph() {
		for (int i = 0; i < VERTICES.length; i++) {
			Vertex<E> v = VERTICES.getElement(i);
			System.out.print("Vertex: " + v.getValue() + " --> ");
			List<Vertex<E>> currentNeighbors = v.getNeighbor();
			for (int j = 0; j < currentNeighbors.length; j++) {
				Vertex<E> nb = currentNeighbors.getElement(j);
				System.out.print(nb.getValue() + ", ");
			} System.out.println();
		}
	}
	
	public void printEdges() {
		System.out.println("EDGES:");
		for (int i = 0; i < EDGES.length; i++) {
			System.out.print(EDGES.getElement(i).getWeight() + " [");
			for (int j = 0; j < 2; j++) {
				if (j == 1) {
					System.out.println(EDGES.getElement(i).getPair().getElement(j).getValue() + "]");
				}
				else {
					System.out.print(EDGES.getElement(i).getPair().getElement(j).getValue() + ", ");
				}
			}
		}
	}
	
	public void initBFS() {
		
		// all vertices set traverse to false
		for (int i = 0; i < VERTICES.length; i++) {
			VERTICES.getElement(i).setTraverse(false);
		}
		
		System.out.print("BFS: [");
		
		// choose random vertex where to start
		Vertex<E> start = chooseVertex(VERTICES);
		startBFS(start);
		
		System.out.println("]");
	}
	
	private void startBFS(Vertex<E> start) {
		
		// start vertex prints and set traverse to true
		System.out.print(start.getValue() + ", ");
		start.setTraverse(true);
		
		// recurse to next vertex
		recursionBFS(start);
	}
	
	private void recursionBFS(Vertex<E> v) {
		boolean graphTraversed = true;
		
		// iterates whole neighbor of current vertex
		for (int i = 0; i < v.getNeighbor().length; i++) {
			
			// prints current neighboring vertex, if untraversed
			if (!v.getNeighbor().getElement(i).getTraverse()) {
				System.out.print(v.getNeighbor().getElement(i).getValue() + ", ");
				v.getNeighbor().getElement(i).setTraverse(true);
				
				// sets the whole 
				graphTraversed = false;
			}
		}
		
		// recursion stops if no where to be traversed
		if (graphTraversed) {
			return;
		}
		
		// traverses the neighbors of current vertex
		for (int i = 0; i < v.getNeighbor().length; i++) {
			recursionBFS(v.getNeighbor().getElement(i));
		}
	}
	
	public void initDFS() {
		for (int i = 0; i < VERTICES.length; i++) {
			VERTICES.getElement(i).setTraverse(false);
		}
		System.out.print("DFS: [");
		Vertex<E> start = chooseVertex(VERTICES);
		startDFS(start);
		System.out.println("]");
	}
	
	private void startDFS(Vertex<E> start) {
		System.out.print(start.getValue() + ", ");
		start.setTraverse(true);
		recursionDFS(start);
	}
	
	private void recursionDFS(Vertex<E> v) {
		Vertex<E> vChoice = null;
		int count = 0;
		boolean allNeighborTraversed = false;
		
		// counting and checking if there are remaining untraversed vertex
		for (int i = 0; i < VERTICES.length; i++) {
			if (VERTICES.getElement(i).getTraverse()) {
				count++;
			}
		}
		if (count == VERTICES.length) {
			return;
		}
		
		// choosing a neighbor that is not traversed
		for (int i = 0; i < v.getNeighbor().length; i++) {
			allNeighborTraversed = true;
			vChoice = chooseVertex(v.getNeighbor());
			if (!vChoice.getTraverse()) {
				allNeighborTraversed = false;
				break;
			}
		}
		
		// option to traverse a not neighboring vertex, if neighbors of
		// current vertex is traversed and whole graph is not yet traversed
		if (allNeighborTraversed) {
			while (true) {
				vChoice = chooseVertex(VERTICES);
				if (!vChoice.getTraverse()) {
					break;
				}
			}
			System.out.print(vChoice.getValue() + ", ");
			vChoice.setTraverse(true);
		} 
		
		// when everything does normal
		else {
			System.out.print(vChoice.getValue() + ", ");
			vChoice.setTraverse(true);
		}
		recursionDFS(vChoice);
	}

	/**
	 * chooses data from a list
	 * @param list
	 * @return data type E generic
	 */
	private E chooseValue(List<E> list) {
		int chosenIndex = rand.nextInt(list.length);
		return list.getElement(chosenIndex);
	}
	
	/**
	 * chooses vertex from a list
	 * @param list
	 * @return vertex of data type E generic
	 */
	private Vertex<E> chooseVertex(List<Vertex<E>> list) {
		int chosenIndex = rand.nextInt(list.length);
		return list.getElement(chosenIndex);
	}
}
