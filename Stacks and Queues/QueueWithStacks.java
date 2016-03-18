import java.util.Stack;

public class QueueWithStacks {

	public static void main(String[] args){
		QueueWithStacks qws = new QueueWithStacks();
		qws.test();
	}
	
	private void test(){
		MyQueue<Integer> q = new MyQueue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		
		q.peek();
		q.pop();
		
		q.add(6);
		q.add(7);
		q.add(8);
		
		q.pop();
		q.pop();
		q.pop();
		q.pop();
		q.pop();
		q.pop();
	}
	
	public class MyQueue<T> {
	
		private Stack<T> oldStack;
		private Stack<T> newStack;
		
		public MyQueue() {
			oldStack = new Stack<T>();
			newStack = new Stack<T>();
		}
		
		public int size(){
			return oldStack.size()+newStack.size();
		}
		
		public void add(T value){
			newStack.push(value);
			System.out.println("Insert: "+value);
		}
		
		public T peek(){
			shiftStacks();
			System.out.println("Peek: "+oldStack.peek());
			return oldStack.peek();
		}
		
		public T pop(){
			shiftStacks();
			T pop = oldStack.pop();
			System.out.println("Pop: "+pop);
			return pop;
		}
		
		private void shiftStacks(){
			if(oldStack.isEmpty()){
				while(!newStack.isEmpty()){
					oldStack.push(newStack.pop());
				}
			}
		}
	
	}

}