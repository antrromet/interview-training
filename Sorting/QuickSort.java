public class QuickSort {

	public static void main(String[] args){
		String[] spl = args[0].split(" ");
		int n = spl.length;
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = Integer.valueOf(spl[i]);
		}
		System.out.println("Before Sorting: ");
		printArray(a);
		quicksort(a, 0, a.length - 1);
		System.out.println("After Sorting: ");
		printArray(a);
	}
	
	private static void quicksort(int[] a, int low, int high){
		if(high > low){
			int j = partition(a, low, high);
			quicksort(a, low, j-1);
			quicksort(a, j+1, high);
		}
	}
	
	private static int partition(int[] a, int low, int high){
		int i = low;
		int j = high+1;
		
		while(true){
			while(a[++i] < a[low]){
				if(i == high){
					break;
				}
			}
			
			while(a[--j] > a[low]){
				if(j == low){
					break;
				}
			}
			
			if(i>=j){
				break;
			}
			swap(a, i, j);
		}
		swap(a, low, j);
		return j;
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