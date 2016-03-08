// https://www.careercup.com/question?id=5733696185303040

import java.util.ArrayList;
import java.util.List;

public class StringLettersCountPermutations {

	public static void main(String[] args){
		String str = args[0];
	
		StringLettersCountPermutations slcp = new StringLettersCountPermutations();
		List<String> list = slcp.findPermutations(str);
		for(String s: list){
			System.out.println(s);
		}
	}
	
	public List<String> findPermutations(String str){
		List<String> list = new ArrayList<String>();
		for(int i=0;i<str.length()-1;i++){
			for(int j=str.length()-1;j>i+1;j--){
				list.add(getString(i, j, str));
			}
		}
		list.add(str);
		return list;
	}
	
	private String getString(int i, int j, String str){
		StringBuilder builder = new StringBuilder();
		int x = 0;
		while(x<=i){
			builder.append(str.charAt(x++));
		}
		builder.append(j-i-1);
		x = j;
		while(x < str.length()){
			builder.append(str.charAt(x++));
		}
		return builder.toString();
	}
}