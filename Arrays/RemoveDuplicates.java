import java.util.Set;
import java.util.LinkedHashSet;

public class RemoveDuplicates {

	public static void main(String[] args){
		
		String str = args[0];
		String[] spl = str.split(" ");
		int a[] = new int[spl.length];
		for(int i=0;i<spl.length;i++){
			a[i] = Integer.valueOf(spl[i]);
		}
		
		removeDuplicatesLinkedHashSet(a);
		
		removeDuplicatesInPlace(a);
	}
	
	private static void removeDuplicatesLinkedHashSet(int[] a){
		System.out.println("Using LinkedHashSet");
		Set<Integer> set = new LinkedHashSet<Integer>();
		int duplicatesCount = 0;
		for(int i=0;i<a.length;i++){
			int val = 1;
			if(set.contains(a[i])){
				duplicatesCount++;
			}
			set.add(a[i]);
		}
		
		int[] b = new int[a.length-duplicatesCount];
		int i=0;
		for(Integer x : set){
			b[i++] = x;
			System.out.print(x+" ");	
		}
		System.out.println();
	}
	
	private static void removeDuplicatesInPlace(int[] a){
		System.out.println("In place:");
		int duplicatesCount = 0;
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length-duplicatesCount;j++){
				if(a[j] == a[i]){
					int k = j;
					while(k!=a.length-duplicatesCount-1){
						a[k] = a[k+1];
						k++;
					}
					duplicatesCount++;
					j--;
				}
			}
		}
		
		System.out.println("Duplicates: "+duplicatesCount);
		
		printArray(a, a.length-duplicatesCount);
	}
	
	private static void printArray(int[] a){
		for(Integer x: a){
			System.out.print(x+" ");
		}
		System.out.println();
	}
	
	private static void printArray(int[] a, int n){
		for(int i=0;i<n;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

}