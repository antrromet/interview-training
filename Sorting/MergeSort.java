public class MergeSort {
	
	public static void main(String[] args){
		String[] spl = args[0].split(" ");
		int n = spl.length;
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = Integer.valueOf(spl[i]);
		}
		System.out.println("Before Sorting: ");
		printArray(a);
		int[] aux = new int[n];
		sort(a, aux, 0, a.length - 1);
		System.out.println("After Sorting: ");
		printArray(a);
	}
	
	private static void sort(int[] a, int[] aux, int low, int high){
		if(high>low){
			int mid = (low+high)/2;
			sort(a, aux, low, mid);
			sort(a, aux, mid+1, high);
			merge(a, aux, low, mid, high);
		}
	}
	
	private static void merge(int[] a, int[] aux, int low, int mid, int high) {
		for(int i=0;i<a.length;i++){
			aux[i] = a[i];
		}
		
		int i = low;
		int j = mid+1;
		
		for(int k=low;k<=high;k++){
			if(i > mid){
				a[k] = aux[j++];
			} else if(j > high){
				a[k] = aux[i++];
			} else if(a[i] > a[j]){
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
		
	}
	
	private static void printArray(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
}