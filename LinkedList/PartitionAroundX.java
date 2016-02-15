public class PartitionAroundX {
	
	private Node head;
	
	public static void main(String[] args){
		PartitionAroundX pax = new PartitionAroundX();
		pax.insert(7);
		pax.insert(2);
		pax.insert(4);
		pax.insert(9);
		pax.insert(5);
		pax.insert(6);
		pax.insert(10);
		pax.insert(3);
		pax.insert(8);
		pax.insert(1);
		pax.printList();
		pax.partitionAroundX(Float.valueOf(args[0]));
	}
	
	private void insert(int n){
		head = insert(head, n);
	}
	
	private void printList(){
		printList(head);
	}
	
	private void partitionAroundX(float x){
		head = partitionAroundXDoubleLists(head, x);
		printList();
		head = partitionAroundXSingleList(head, x);
		printList();
	}
	
	private Node partitionAroundXSingleList(Node node, float x){
		System.out.println("Partitioning using a single linked list - Order is maintained");
		Node head = node;
		Node tail = node;
		
		while(node!=null){
			Node next = node.next;
			if(node.data<x){
				node.next = head;
				head = node;
			} else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}

		tail.next = null;
		return head;
	}
	
	private Node partitionAroundXDoubleLists(Node node, float x){
		System.out.println("Partitioning using 2 linked lists - Order is not maintained");
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		
		while(node!=null){
			Node next = node.next;
			node.next = null;
			
			if(node.data<x){
				if(beforeStart == null){
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if(afterStart == null){
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		if(beforeStart == null){
			return afterStart;
		}
		beforeEnd.next = afterStart;
		return beforeStart;
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