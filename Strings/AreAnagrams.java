import java.util.Arrays;

public class AreAnagrams {
	
	public static void main(String[] args){
		String str1 = args[0];
		String str2 = args[1];
		
		checkAnagramsSort(str1.toCharArray(), str2.toCharArray());
		checkAnagramsCount(str1.toCharArray(), str2.toCharArray());
		checkAnagramsStringBuilder(str1.toCharArray(), str2);
	}
	
	private static void checkAnagramsSort(char[] ch1, char[] ch2){
		System.out.println("Sorting method:");
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		System.out.println((Arrays.equals(ch1,ch2)?"":"Not ") + "Anagrams");
	}
	
	private static void checkAnagramsCount(char[] ch1, char[] ch2){
		System.out.println("Counting method:");
		if(ch1.length != ch2.length){
			System.out.println("Not Anagrams");
			return;
		}
		int[] charArr = new int[256];
		for(char c:ch1){
			charArr[c]++;
		}
		for(char c:ch2){
			charArr[c]--;
			if(charArr[c] < 0){
				System.out.println("Not Anagrams");
				return;
			}
		}
		System.out.println("Anagrams");
	}
	
	private static void checkAnagramsStringBuilder(char[] ch1, String str){
		System.out.println("StringBuilder method:");
		StringBuilder builder = new StringBuilder(str);
		for(char c : ch1){
			int index = builder.indexOf(c+"");
			if(index == -1){
				System.out.println("Not Anagrams");
				return;
			} else {
				builder.deleteCharAt(index);
			}
		}
		System.out.println((builder.length() == 0?"":"Not ") + "Anagrams");
	}
	
}