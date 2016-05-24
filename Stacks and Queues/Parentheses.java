public class Parentheses {

	public static void main(String[] args){
		Stack<Character> stack = new Stack<Character>();
		String in = args[0];
		for(int i=0;i<in.length();i++) {
			char ch = in.charAt(i);
			if(ch == '('|| ch == '{' || ch == '['){
				stack.push(ch);
			} else {
				if(stack.isEmpty()){
					System.out.println(false);
					System.exit(1);
				}
				char top = stack.peek();
				if((ch == ')' && top == '(') || (ch == '}' && top == '{') || (ch == ']' && top == '[')) {
					stack.pop();
				} else {
					System.out.println(false);
					System.exit(1);
				}
			}
		}
		
		System.out.println(stack.isEmpty());
	}

}