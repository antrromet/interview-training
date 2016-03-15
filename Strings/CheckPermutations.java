import java.util.Arrays;

public class CheckPermutations {

	public static void main(String[] args) {
		String str1 = args[0];
		String str2 = args[1];
		
		CheckPermutations cp = new CheckPermutations();
		System.out.println(cp.checkPermutationsSorting(str1, str2));
		System.out.println(cp.checkPermutationsCount(str1, str2));
	}
	
	private boolean checkPermutationsSorting(String str1, String str2){
		System.out.println("Checking by sorting");
		return sort(str1).equals(sort(str2));
	}
	
	private String sort(String str){
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
	
	private boolean checkPermutationsCount(String str1, String str2){
		System.out.println("Checking by count");
		if(str1.length() != str2.length()){
			return false;
		}
		int[] arr = new int[256];
		for(int i=0;i<str1.length();i++){
			int ch = (int) str1.charAt(i);
			arr[ch]++; 
		}
		for(int i=0;i<str2.length();i++){
			int ch = (int) str1.charAt(i);
			arr[ch]--;
			if(arr[ch] < 0){
				return false;
			}
		}
		
		return true;
	}

}