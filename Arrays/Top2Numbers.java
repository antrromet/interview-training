public class Top2Numbers {

	public static void main(String[] args){
		String str = args[0];
		String[] spl = str.split(" ");
		int[] a = new int[spl.length];
		for(int i=0;i<spl.length;i++){
			a[i] = Integer.valueOf(spl[i]);
		}
		
		findTop2Numbers(a);
	}
	private static void findTop2Numbers(int[] a){
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		
		for(int i=0;i<a.length;i++){
			if(a[i] > max1 && a[i] > max2){
				max2 = max1;
				max1 = a[i];
			} else if(a[i] > max2 && a[i] < max1){
				max2 = a[i];
			}
		}
		
		System.out.println("The top 2 numbers are: "+max1+" and "+max2);
		
		
	}

}