public class Queue<Item> {

	private Node front;
	private Node rear;
	
	public void enqueue(Item x){
		if(rear == null){
			front = rear = new Node(x);
			return;
		} else {
			Node n = new Node(x);
			rear.next = n;
			rear = n;
		}
	}
	
	public Item dequeue(){
		if(front == null){
			System.out.println("Queue Underflow!!!");
			return null;
		}
		Node n = front;
		if(front.next == null){
			front = rear = null;
		} else {
			front = front.next;
		}
		return n.item;
	}
	
	public boolean isEmpty(){
		return rear == null;
	}
	
	public int size(){
		int size = 0;
		Node n = front;
		while(n!=null){
			n = n.next;
			size+=1;
		}
		return size;
	}
	
	public void display(){
		Node n = front;
		if(n == null){
			System.out.println("Queue Empty!");
			return;
		}
		System.out.print(n.item);
		n = n.next;
		while(n!=null){
			System.out.print("<--"+n.item);
			n = n.next;
		}
		System.out.println();
	}

	class Node {
		private Node next;
		private Item item;
		
		public Node(Item item){
			this.item = item;
			next = null;
		}
	}

}