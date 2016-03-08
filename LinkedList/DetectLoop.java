public class DetectLoop {

	private Node head;
	private Node loopNode;

	public static void main(String[] args){
		DetectLoop dl = new DetectLoop();
		dl.insert(7);
		dl.insert(2);
		dl.insert(4);
		dl.insert(9);
		dl.insert(5);
		dl.insert(6);
		dl.insert(10);
		dl.insert(3);
		dl.insert(8);
		dl.insert(1);
		//dl.circularInsert(10);
		dl.detectLoop();
		//dl.printList();
	}
	
	private void detectLoop(){
		boolean isLoop = detectLoop(head);
		System.out.println("Loop is "+(isLoop?"":"not ")+"present!");
	}
	
	private boolean detectLoop(Node n){
		if(n == null){
			return false;
		}
		Node first = n;
		Node second = n;
		while(true){
			first = first.next;
			if(second.next != null){
				second = second.next.next;
			} else {
				return false;
			}
			if(first == null || second == null){
				return false;
			}
			if(first == second){
				return true;
			}
		}
	}
	
	private void insert(int n){
		head = insert(head, n);
	}
	
	private void circularInsert(int n){
		head = circularInsert(head, loopNode, n);
	}
	
	private Node circularInsert(Node head, Node loopNode, int n){
		if(loopNode.data == n){
			Node runner = head;
			while(runner.next!=null){
				runner = runner.next;
			}
			runner.next = loopNode;
		}
		return head;
	}
	
	private void printList(){
		printList(head);
	}
	
	private Node insert(Node head, int n){
		if(head == null){
			Node node = new Node(n);
			return node;
		} else {
			Node node = new Node(n);
			Node runner = head;
			while(runner.next!=null){
				runner = runner.next;
			}
			runner.next = node;
			if(n == 10){
				loopNode = node;
			}
			return head;
		}
	}
	
	private void printList(Node n){
		System.out.print(n.data);
		n = n.next;
		while(n != null){
			System.out.print(" -> "+n.data);
			n = n.next;
		}
		System.out.println();
	}
	
}