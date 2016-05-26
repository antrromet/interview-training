public class InsertionSort {
	
	public static void main(String[] args){
		String[] spl = args[0].split(" ");
		int n = spl.length;
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = Integer.valueOf(spl[i]);
		}
		System.out.println("Before Sorting: ");
		printArray(a);
		insertionSort(a);
		System.out.println("After Sorting: ");
		printArray(a);
	}
	
	private static void insertionSort(int[] a){
		for(int i=0;i<a.length;i++){
			for(int j=i;j>0;j--){
				if(a[j] < a[j-1]){
					swap(a, j, j-1);
				}
			}
		}
	}
	
	private static void swap(int[] a, int i, int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static void printArray(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
}