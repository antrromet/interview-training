public class MergeLinkedLists {

	private Node head1;
	private Node head2;

	public static void main(String[] args){
		
		MergeLinkedLists mll = new MergeLinkedLists();
	
		String str1 = args[0];
		String str2 = args[1];
		
		String[] spl1 = str1.split(" ");
		int a[] = new int[spl1.length];
		for(int i=0;i<spl1.length;i++){
			mll.insert1(Integer.valueOf(spl1[i]));
		}
		
		String[] spl2 = str2.split(" ");
		int b[] = new int[spl2.length];
		for(int i=0;i<spl2.length;i++){
			mll.insert2(Integer.valueOf(spl2[i]));
		}
		
		mll.printList(mll.head1);
		mll.printList(mll.head2);
		Node res = mll.mergeLists(mll.head1, mll.head2);
		System.out.println("Merged Lists: ");
		mll.printList(res);
	}
	
	private Node mergeLists(Node head1, Node head2){
		Node n = null;
		while(head1!=null && head2!=null){
			if(head1.data < head2.data){
				n = insertData(n, head1.data);
				head1 = head1.next;
			} else {
				n = insertData(n, head2.data);
				head2 = head2.next;
			}
		}
		if(head1 == null){
			while(head2!=null){
				n = insertData(n, head2.data);
				head2 = head2.next;
			}
		}
		if(head2 == null){
			while(head1!=null){
				n = insertData(n, head1.data);
				head1 = head1.next;
			}
		}
		return n;
	}
	
	private void insert1(int x){
		head1 = insertData(head1, x);
	}
	
	private void insert2(int x){
		head2 = insertData(head2, x);
	}
	
	private Node insertData(Node head, int data){
		Node n = new Node(data);
		if(head == null){
			return n;
		} else {
			Node runner = head;
			while(runner.next!=null){
				runner = runner.next;
			}
			runner.next = n;
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