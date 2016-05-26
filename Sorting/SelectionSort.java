public class SelectionSort {
	
	public static void main(String[] args){
		String[] spl = args[0].split(" ");
		int n = spl.length;
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = Integer.valueOf(spl[i]);
		}
		System.out.println("Before Sorting: ");
		printArray(a);
		selectionSort(a);
		System.out.println("After Sorting: ");
		printArray(a);
	}
	
	private static void selectionSort(int[] a){
		for(int i=0;i<a.length;i++){
			int min = i;
			for(int j=i+1;j<a.length;j++){
				if(a[j]<a[min]){
					min = j;
				}
			}
			swap(a, i, min);
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