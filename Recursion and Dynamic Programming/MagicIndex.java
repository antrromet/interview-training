public class MagicIndex {
	
	public static void main(String[] args){
		MagicIndex mi = new MagicIndex();
		int[] a = new int[args.length];
		for(int i=0;i<args.length;i++){
			a[i] = Integer.valueOf(args[i]);
		}
		mi.findMagicIndex(a);
	}
	
	private void findMagicIndex(int[] a){
		System.out.println("Brute Force Approach: "+findMagicIndexBruteForce(a));
		System.out.println("Binary Search Approach: "+findMagicIndexBinarySearch(a, 0, a.length-1));
		System.out.println("Non Unique Values Solution: "+findMagicIndexNotUnique(a, 0, a.length-1));
	}
	
	private int findMagicIndexBruteForce(int[] a){
		for(int i=0;i<a.length;i++){
			if(a[i] == i){
				return i;
			}
		}
		return -1;
	}
	
	private int findMagicIndexBinarySearch(int[] a, int low, int high){
		if(low > high || low < 0 || high >= a.length){
			return -1;
		} else {
			int mid = (low+high)/2;
			if(a[mid] == mid){
				return mid;
			} else if(a[mid] > mid){
				return findMagicIndexBinarySearch(a, low, mid-1);
			} else {
				return findMagicIndexBinarySearch(a, mid+1, high);
			}
		}
	}
	
	private int findMagicIndexNotUnique(int[] a, int low, int high){
		if(low > high || low < 0 || high >= a.length){
			return -1;
		} else {
			int midIndex = (low+high)/2;
			int midValue = a[midIndex];
			if(midValue == midIndex){
				return midIndex;
			}
			
			int leftIndex = Math.min(midValue, midIndex-1);
			int left = findMagicIndexNotUnique(a, low, leftIndex);
			if(left>=0){
				return left;
			}
			
			int rightIndex = Math.min(midValue, midIndex+1);
			return findMagicIndexNotUnique(a, rightIndex, high);
		}
	}

}