public class FindUnionIntersection2SortedArrays {

	public static void main(String[] args){
		String str1 = args[0];
		String str2 = args[1];
		
		String[] spl1 = str1.split(" ");
		int a[] = new int[spl1.length];
		for(int i=0;i<spl1.length;i++){
			a[i] = Integer.valueOf(spl1[i]);
		}
		
		String[] spl2 = str2.split(" ");
		int b[] = new int[spl2.length];
		for(int i=0;i<spl2.length;i++){
			b[i] = Integer.valueOf(spl2[i]);
		}
		
		System.out.println("You entered the following arrays:");
		printArray(a);
		printArray(b);
		
		findUnion(a, b);
		findIntersection(a, b);
	}
	
	private static void findUnion(int[] a, int[] b){
		System.out.println("Union:");
		int c[] = new int[a.length+b.length];
		int i=0, j=0, k=0;
		while(i<a.length && j<b.length){
			if(a[i]  == b[j]){
				c[k++] = a[i++];
				c[k++] = b[j++];
			} else if(a[i] > b[j]){
				c[k++] = b[j++];
			} else {
				c[k++] = a[i++];
			}
		}
		
		if(i == a.length){
			while(j!=b.length){
				c[k++] = b[j++];
			}
		} else {
			while(i!=a.length){
				c[k++] = a[i++];
			}
		}
		
		printArray(c);
	}
	
	private static void findIntersection(int[] a, int[] b){
		System.out.println("Intersection:");
		int c[] = new int[a.length+b.length];
		int i=0, j=0, k=0;
		int intersectionCount = 0;
		while(i<a.length && j<b.length){
			if(a[i]  == b[j]){
				c[k++] = a[i++];
				intersectionCount++;
			} else if(a[i] > b[j]){
				j++;
			} else {
				i++;
			}
		}
		
		int[] result = new int[intersectionCount];
		for(int x=0;x<intersectionCount;x++){
			result[x] = c[x];
		}
		printArray(result);
	}
	
	private static void printArray(int[] a){
		for(Integer x:a){
			System.out.print(x+" ");
		}
		System.out.println();
	}

}