public class ReverseLinkedList {

	private Node head;

	public static void main(String[] args){
		ReverseLinkedList rll = new ReverseLinkedList();
		rll.insert(7);
		rll.insert(2);
		rll.insert(4);
		rll.insert(9);
		rll.insert(5);
		rll.insert(6);
		rll.insert(10);
		rll.insert(3);
		rll.insert(8);
		rll.insert(1);
		rll.printList();
		rll.reverseLinkedList();
	}
	
	private void reverseLinkedList(){
		System.out.println("Reversed Linked List:");
		Node reverseHead = reverseLinkedList(head);
		printList(reverseHead);
	}
	
	private Node reverseLinkedList(Node n){
		Node prev = null;
		Node next;
		while(n!=null){
			next = n.next;
			n.next = prev;
			prev = n;
			n =  next;
		}
		return prev;
	}
	
	private void insert(int n){
		head = insert(head, n);
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