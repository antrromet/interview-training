public class CountStairWays {

	public static void main(String[] args){
		int n = Integer.valueOf(args[0]);
		CountStairWays csw = new CountStairWays();
		csw.countWays(n);
	}
	
	private void countWays(int n){
		System.out.println("Number of ways (Recursion): "+countWaysRec(n));
		int[] map = new int[100];
		map[0] = 1;
		System.out.println("Number of ways (DP): "+countWaysDP(n, map));
	}
	
	private int countWaysRec(int n){
		if(n < 0){
			return 0;
		} else if (n == 0){
			return 1;
		} else {
			return countWaysRec(n-1)+countWaysRec(n-2)+countWaysRec(n-3);
		}
	}
	
	private int countWaysDP(int n, int[] map){
		if(n < 0){
			return 0;
		} else if(map[n] > 0) {
			return map[n];
		} else {
			map[n] = countWaysDP(n-1, map)+countWaysDP(n-2, map)+countWaysDP(n-3, map);
			return map[n];
		}
	}

}