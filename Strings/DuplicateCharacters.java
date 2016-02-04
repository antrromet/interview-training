import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class DuplicateCharacters {

	public static void main(String[] args){
		String str = args[0];
		printDuplicatesSet(str);
		printDuplicatesMap(str);
		printDuplicatesSort(str.toCharArray());
		printDuplicatesArray(str);
	}
	
	private static void printDuplicatesSet(String str){
		System.out.println("Duplicates using set:");
		Set<Character> set = new HashSet<Character>();
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			for(int j=i+1;j<str.length();j++){
				if(str.charAt(j) == ch){
					set.add(ch);
					break;
				}
			}
		}
		
		for(Character ch:set){
			System.out.println(ch);
		}
	}
	
	private static void printDuplicatesMap(String str){
		System.out.println("Duplicates with count using HashMap:");
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			int value = 1;
			if(map.containsKey(ch)){
				value = map.get(ch);
				value++;
			}
			map.put(ch, value);
		}
		
		for(Map.Entry<Character, Integer> entry: map.entrySet()){
			if(entry.getValue() > 1){
				System.out.println(entry.getKey() + " - " + entry.getValue());
			}
		}
	}
	
	private static void printDuplicatesSort(char[] charAr){
		System.out.println("Duplicates with count using sorting approach:");
		Arrays.sort(charAr);
		char last = charAr[0];
		int count = 1;
		for(int i=1;i<charAr.length;i++){
			if(charAr[i] == last){
				count++;
			} else {
				System.out.println(last + " - " + count);
				count = 1;
				last = charAr[i];
			}
		}
	}
	
	private static void printDuplicatesArray(String str){
		System.out.println("Duplicates with count using Array:");
		int[] charAr = new int[256];
		for(int i=0;i<str.length();i++){
			int ch = (int)str.charAt(i);
			charAr[ch]++;
		}
		for(int i=0;i<str.length();i++){
			int ch = (int)str.charAt(i);
			if(charAr[ch] > 1){
				System.out.println((char)ch + " - "+charAr[ch]);
			}
		}
				
	}

}