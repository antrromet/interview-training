public class CheckRoute {

	public boolean search(Graph G, Node start, Node end) {
		Queue<Node> q = new LinkedList<Node>();
		start.visited = true;
		q.enqueue(start);
		
		while(!q.isEmpty()){
			Node n = q.dequeue();
			if(end == n){
				return true;
			}
			if(!n.visited){
				n.visited = true;
				for(Node v: G.neighbours(n)) {
					q.enqueue(v);
				}
			}
		}
		
		return false;
	}

}