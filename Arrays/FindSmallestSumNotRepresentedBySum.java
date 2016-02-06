public class FindSmallestSumNotRepresentedBySum {

	public static void main(String[] args){
		String str = args[0];
		String[] spl = str.split(" ");
		int[] a = new int[spl.length];
		for(int i=0;i<a.length;i++){
			a[i] = Integer.valueOf(spl[i]);
		}
		
		int res = 1;
		for(int i=0;i<spl.length && a[i]<=res;i++){
			res += a[i];
		}
		System.out.println(res);
	}

}