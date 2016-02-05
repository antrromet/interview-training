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
	}
	
	private static void removeDuplicatesLinkedHashSet(int[] a){
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

}