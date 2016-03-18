public class MinStackTest {
	
	private MinStack minStack = new MinStack();
	
	public static void main(String[] args){
		MinStackTest mst = new MinStackTest();
		mst.test();
	}
	
	private void test(){
		minStack.push(7);
		minStack.push(2);
		minStack.push(3);
		minStack.push(4);
		minStack.push(5);
		minStack.push(1);
		System.out.println(minStack.min());
	}
	
}