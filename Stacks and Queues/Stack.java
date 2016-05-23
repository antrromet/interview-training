public class Stack<Item> {

	private Node top;
	
	public void push(Item x){
		if(top == null){
			top = new Node(x);
		} else {
			Node n = new Node(x);
			n.next = top;
			top = n;
		}
	}
	
	public Item pop(){
		if(top == null){
			System.out.println("Underflow!!!");
			return null;
		}
		Node n = top;
		top = top.next;
		return n.data;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public int size(){
		int size = 0;
		Node n = top;
		while(n!=null){
			n = n.next;
			size+=1;
		}
		return size;
	}
	
	public void display(){
		Node n = top;
		if(n == null){
			System.out.println("Stack Empty!");
			return;
		}
		System.out.println(n.data + "<--");
		n = n.next;
		while(n!=null){
			System.out.println(n.data);
			n = n.next;
		}
	}

	class Node {
		private Node next;
		private Item data;
		
		public Node(Item data){
			this.data = data;
			next = null;
		}
	}

}