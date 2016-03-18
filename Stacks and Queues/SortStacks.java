import java.util.Stack;

public class SortStacks {

	public static void main(String[] args){
		SortStacks ss = new SortStacks();
		ss.test();
	}
	
	private void test(){
		Stack<Integer> s = new Stack<Integer>();
		System.out.println("Inserting 4");
		s.push(4);
		System.out.println("Inserting 9");
		s.push(9);
		System.out.println("Inserting 3");
		s.push(3);
		System.out.println("Inserting 1");
		s.push(1);
		System.out.println("Inserting 7");
		s.push(7);
		System.out.println("Inserting 5");
		s.push(5);
		System.out.println("Inserting 8");
		s.push(8);
		System.out.println("Inserting 2");
		s.push(2);
		
		s = sort(s);
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
	}
	
	private Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()){
			int temp = s.pop();
			while(!r.isEmpty() && r.peek() > temp){
				s.push(r.pop());
			}
			r.push(temp);
		}
		return r;
	}

}