import java.util.Stack;

public class MinStack extends Stack<Integer> {

	private Stack<Integer> minStack;

	public MinStack(){
		minStack = new Stack<Integer>();
	}

	public Integer push(Integer x){
		super.push(x);
		if(x <= min()){
			minStack.push(x);
		}
		return x;
	}
	
	public Integer pop(){
		Integer p = super.pop();
		if(p == min()){
			minStack.pop();
		}
		return p;
	}
	
	public Integer min(){
		if(minStack.isEmpty()){
			return Integer.MAX_VALUE;	
		}
		return minStack.peek();
	}

}