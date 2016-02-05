public class QuickSort {
	
	public static void main(String[] args){
		String str = args[0];
		String[] spl = str.split(" ");
		int[] a = new int[spl.length];
		for(int i=0;i<spl.length;i++){
			a[i] = Integer.valueOf(spl[i]);
		}
		
		quickSort(a, 0, a.length-1);
		printArray(a);
	}
	
	private static void quickSort(int[] a, int low, int high){
		if(high>low){
			int partition = partition(a, low, high);
			quickSort(a, low, partition-1);
			quickSort(a, partition+1, high);
		}
	}
	
	private static int partition(int[] a, int low, int high){
		int i = low;
		int j = high+1;
		while(true){
			do {
				i++;
				if(i == high){
					break;
				}
			} while(a[i] < a[low]);
			
			do {
				j--;
				if(j == low){
					break;
				}
			} while(a[j] > a[low]);
			
			if(j<=i){
				break;
			}
			swap(a, i, j);
		}
		
		swap(a, low, j);
		return j;
	}
	
	private static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	private static void printArray(int[] a){
		for(Integer x:a){
			System.out.print(x+" ");
		}
		System.out.println();
	}
	
}