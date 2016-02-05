import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class PairSum {

	public static void main(String[] args){
		String str = args[0];
		int sum = Integer.valueOf(args[1]);
		
		String[] spl = str.split(" ");
		int[] arr = new int[spl.length];
		int i=0;
		for(String s: spl){
			arr[i++] = Integer.valueOf(s);
		}
		
		findPairsHashMap(arr, sum);
		findPairsSort(arr, sum);
	}
	
	private static void findPairsHashMap(int[] a, int sum){
		System.out.println("Using HashMap:");
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<a.length;i++){
			if(map.containsKey(a[i])){
				System.out.println(a[i]+" + "+(sum-a[i]));
			} else {
				map.put(sum-a[i],a[i]);
			}
		}
	}
	
	private static void findPairsSort(int[] a, int sum){
		System.out.println("Using Sort:");
		Arrays.sort(a);
		int i = 0;
		int j = a.length-1;
		while(j>i){
			int curSum = a[i] + a[j];
			if(sum == curSum){
				System.out.println(a[i]+" + "+a[j]);
				i++;
				j--;
			} else {
				if(curSum > sum){
					j--;
				} else {
					i++;
				}
			}
		}
	}

}