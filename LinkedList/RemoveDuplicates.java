import java.util.Set;
import java.util.HashSet;

public class RemoveDuplicates {
	
	private Node head;
	
	public static void main(String[] args){
		RemoveDuplicates rD = new RemoveDuplicates();
		rD.insert(1);
		rD.insert(2);
		rD.insert(2);
		rD.insert(3);
		rD.insert(4);
		rD.insert(4);
		rD.insert(4);
		rD.insert(5);
		rD.insert(2);
		rD.insert(4);
		rD.printList();
		//rD.removeDuplicatesSet();
		rD.removeDuplicatesRunner();
		rD.printList();
	}
	
	private void insert(int n){
		head = insert(head, n);
	}
	
	private void removeDuplicatesSet(){
		removeDuplicatesSet(head);
	}
	
	private void removeDuplicatesRunner(){
		removeDuplicatesRunner(head);
	}
	
	private void printList(){
		printList(head);
	}
	
	private void removeDuplicatesRunner(Node n){
		System.out.println("Removing duplicates using runner technique");
		while(n!=null){
			Node runner = n;
			while(runner.next!=null){
				if(runner.next.data == n.data){
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			n = n.next;
		}
	}
	
	private void removeDuplicatesSet(Node n){
		System.out.println("Removing duplicates using Set");
		Set<Integer> set = new HashSet<Integer>();
		Node prev = null;
		while(n!=null){
			if(set.contains(n.data)){
				prev.next = n.next;
			} else {
				prev = n;
				set.add(n.data);
			}
			n = n.next;
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
		System.out.print(n.data);
		n = n.next;
		while(n != null){
			System.out.print(" -> "+n.data);
			n = n.next;
		}
		System.out.println();
	}
	
}