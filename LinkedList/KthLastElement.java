public class KthLastElement {

	private Node head;

	public static void main(String[] args){
		KthLastElement kle = new KthLastElement();
		kle.insert(1);
		kle.insert(2);
		kle.insert(2);
		kle.insert(3);
		kle.insert(4);
		kle.insert(5);
		kle.insert(6);
		kle.insert(7);
		kle.insert(8);
		kle.insert(9);
		kle.insert(10);
		kle.printList();
		kle.findKthLastElement(Integer.valueOf(args[0]));
	}
	
	private void insert(int n){
		head = insert(head, n);
	}
	
	private void printList(){
		printList(head);
	}
	
	private void findKthLastElement(int k){
		Node node = findKthLastElement(head, k);
		if(node == null){
			System.out.println("List size is smaller than "+k+". Invalid testcase!");
		} else {
			System.out.println(k+"th last element is "+node.data);
		}
	}
	
	private Node findKthLastElement(Node head, int k){
		if(head == null){
			return null;
		}
		Node runner = head;
		while(k!=0){
			if(runner == null){
				return null;
			}
			runner = runner.next;
			k--;
		}
		while(runner!=null){
			runner = runner.next;
			head = head.next;
		}
		return head;
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