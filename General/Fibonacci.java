import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public static void main(String[] args){
		int n = Integer.valueOf(args[0]);
		
		long start = System.currentTimeMillis();
		System.out.println(fibonacci(n));
		long end = System.currentTimeMillis();
		System.out.println("Naive Duration: "+(float)(end-start)/1000+" s");
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0,0);
		map.put(1,1);
		start = System.currentTimeMillis();
		System.out.println(fibonacciDP(n, map));
		end = System.currentTimeMillis();
		System.out.println("DP Duration: "+(float)(end-start)/1000+" s");
	}
	
	private static int fibonacci(int n){
		if(n == 0 || n == 1){
			return n;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	private static int fibonacciDP(int n, Map<Integer,Integer> map){
		if(map.containsKey(n)){
			return map.get(n);
		}
		int value = fibonacci(n-1) + fibonacci(n-2);
		map.put(n, value);
		return value;
	}

}