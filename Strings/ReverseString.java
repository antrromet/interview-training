public class ReverseString {
	
	public static void main(String[] args){
		String str = args[0];
		reverseRecursion(str);
		reverseIteration(str.toCharArray());
	}
	
	private static void reverseRecursion(String str){
		System.out.println("Using Recursion:");
		System.out.println(recurse(str));
	}
	
	private static String recurse(String str){
		if(str.length() == 0){
			return str;
		}
		return recurse(str.substring(1))+str.charAt(0);
	}
	
	private static void reverseIteration(char[] charArr){
		System.out.println("Using Iteration:");
		int N = charArr.length;
		for(int i=0;i<N/2;i++){
			swap(charArr, i, N-i-1);
		}
		System.out.println(new String(charArr));
	}
	
	private static void swap(char[] ch, int x, int y){
		char temp = ch[x];
		ch[x] = ch[y];
		ch[y] = temp;
	}
	
}