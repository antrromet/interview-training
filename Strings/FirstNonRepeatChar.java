import java.util.Map;
import java.util.HashMap;

public class FirstNonRepeatChar {

	public static void main(String[] args){
		String str = args[0];
		printFirstNonRepeatCharacterArray(str);
		printFirstNonRepeatCharacterHashMap(str);
	}
	
	private static void printFirstNonRepeatCharacterArray(String str){
		System.out.println("Using Array:");
		int[] charCount = new int[256];
		for(int i=0;i<str.length();i++){
			int ch = (int) str.charAt(i);
			charCount[ch]++;
		}
		
		for(int i=0;i<str.length();i++){
			int ch = (int) str.charAt(i);
			if(charCount[ch]  == 1){
				System.out.println((char)ch);
				return;
			}
		}
	}
	
	private static void printFirstNonRepeatCharacterHashMap(String str){
		System.out.println("Using HashMap:");
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
			if(entry.getValue() == 1){
				System.out.println(entry.getKey());
				return;
			}
		}
	}

}