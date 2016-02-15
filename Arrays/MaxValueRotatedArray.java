public class MaxValueRotatedArray {

	public static void main(String[] args){
		String str = args[0];
		String[] spl = str.split(" ");
		int[] a = new int[spl.length];
		for(int i=0;i<spl.length;i++){
			a[i] = Integer.valueOf(spl[i]);
		}
		
		System.out.println("Min Value: "+findMaxValue(a,0, a.length-1));
	}
	
	private static int findMaxValue(int[] a, int low, int high){
		if(low>high){
			return a[0];
		}
		if(high == low){
			return a[low];
		}
		int mid = (low+high)/2;
		if(mid < high && a[mid+1] < a[mid]){
			return a[mid+1];
		}
		if(mid > low && a[mid] < a[mid-1]){
			return a[mid];
		}
		if(a[high] > a[mid]){
			return findMaxValue(a, low, mid-1);
		} else {
			return findMaxValue(a, mid+1, high);
		}
	}

}