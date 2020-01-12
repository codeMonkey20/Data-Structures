
public class DemoRun {

	public static void main(String[] args) {
		List<Character> list = new List<>();
		list.append('A');
		list.append('B');
		list.append('C');
		list.append('D');
		list.append('E');
		list.append('F');
		list.append('G');
		list.append('H');
		list.append('I');
		list.append('J');

		Graph<Character> g = new Graph<>(list);
		g.printGraph();
		g.printEdges();
		g.initBFS();
		g.initDFS();

	}

}
