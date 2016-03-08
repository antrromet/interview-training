import java.util.Stack;

public class CheckPalindrome {

	private Node head;

	public static void main(String[] args){
		CheckPalindrome cp = new CheckPalindrome();
		cp.insert(7);
		cp.insert(2);
// 		cp.insert(4);
// 		cp.insert(9);
		cp.insert(9);
		cp.insert(4);
		cp.insert(2);
		cp.insert(7);
		cp.printList();
		cp.checkPlaindrome();
	}
	
	private void checkPlaindrome(){
		boolean isPalindrome = checkPalindromeReverse(head);
		System.out.println("It is"+(isPalindrome?"":" not")+" a palindrome");
	
		isPalindrome = checkPalindromeStack(head);
		System.out.println("It is"+(isPalindrome?"":" not")+" a palindrome");
	}
	
	private boolean checkPalindromeStack(Node head){
		System.out.println("Using Stack:");
		if(head == null){
			return true;
		}
		Stack<Integer> stack = new Stack<Integer>();
		Node fastRunner = head;
		Node slowRunner = head;
		while(fastRunner!=null){
			if(fastRunner.next == null){
				break;
			}
			fastRunner = fastRunner.next.next;
			stack.push(slowRunner.data);
			slowRunner = slowRunner.next;
		}
		if(fastRunner !=null){
			slowRunner = slowRunner.next;
		}
		while(!stack.isEmpty()){
			if(slowRunner.data!=stack.pop()){
				return false;
			}
			slowRunner = slowRunner.next;
		}
		return true;
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