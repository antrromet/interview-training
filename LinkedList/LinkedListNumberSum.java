import java.util.Stack;

public class LinkedListNumberSum {
	
	private Node head1;
	private Node head2;
	
	public static void main(String[] args){
		LinkedListNumberSum lls = new LinkedListNumberSum();
		lls.insert(7,1);
		lls.insert(1,1);
 		lls.insert(6,1);
		lls.printList(1);
		
		lls.insert(5,2);
		lls.insert(9,2);
		lls.insert(2,2);
		lls.printList(2);
		
		lls.addLists(true);
		lls.addLists(false);
	}
	
	private void addLists(boolean isForward){
		if(isForward){
			Node newListHead = addListsBackwards(head1, head2);
			printList(newListHead);
		} else {
			Node newListHead = addListsForwards(head1, head2);
			printList(newListHead);
		}
	}
	
	private Node addListsBackwards(Node h1, Node h2){
		System.out.println("Summation backwards: ");
		Node head = null;
		Node tail = null;
		int rem = 0;
		while(h1!=null || h2!=null){
			int val = (h1 == null?0:h1.data)+(h2 == null?0:h2.data)+rem;
			if(val>9){
				rem = 1;
				val = val-10;
			} else {
				rem = 0;
			}
			Node node = new Node(val);
			if(head == null){
				head = node;
				tail = head;
			} else {
				tail.next = node;
				tail = node;
			}
			h1 = (h1 == null?null:h1.next);
			h2 = (h2 == null?null:h2.next);
		}
		return head;
	}
	
	private Node addListsForwards(Node h1, Node h2){
		System.out.println("Summation forwards: ");
		int l1 = length(h1);
		int l2 = length(h2);
		int len = 0;
		if(l1 > l2){
			h2 = padZeroes(l1-l2, h2);
			len = l1;
		} else if(l2>l1){
			h1 = padZeroes(l2-l1, h1);
			len = l2;
		}
		Stack<Integer> stack = new Stack<Integer>();
		while(len!=0){
			stack.push(h1.data+h2.data);
			h1 = h1.next;
			h2 = h2.next;
			len--;
		}
		Node head = null;
		int rem = 0;
		while(!stack.isEmpty()){
			int val = rem + stack.pop();
			if(val>9){
				rem = 1;
				val = val-10;
			} else {
				rem = 0;
			}
			Node node = new Node(val);
			if(head == null){
				head = node;
			} else {
				node.next = head;
				head = node;
			}
		}
		if(rem>0){
			Node node = new Node(rem);
			node.next = head;
			head = node;
		}
		return head;
	}
	
	private Node padZeroes(int pad, Node h){
		while(pad!=0){
			Node n = new Node(0);
			n.next = h;
			h = n;
			pad--;
		}
		return h;
	}
	
	private int length(Node n){
		int length = 0;
		while(n!=null){
			n = n.next;
			length++;
		}
		return length;
	}
	
	private void insert(int n, int listNum){
		if(listNum == 1){
			head1 = insert(head1, n);
		} else if(listNum == 2){
			head2 = insert(head2, n);
		}
	}
	
	private void printList(int listNum){
		if(listNum == 1){
			printList(head1);
		} else if(listNum == 2){
			printList(head2);
		}
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
		if(n == null){
			return;
		}
		System.out.print(n.data);
		n = n.next;
		while(n != null){
			System.out.print(" -> "+n.data);
			n = n.next;
		}
		System.out.println();
	}
	
}