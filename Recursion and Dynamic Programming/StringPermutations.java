import java.util.List;
import java.util.ArrayList;

public class StringPermutations {

	public static void main(String[] args){
		String str = args[0];
		StringPermutations sp = new StringPermutations();
		sp.findPermutations(str);
	}
	
	private void findPermutations(String str){
		List<String> perms = getPerms(str);
		System.out.println(perms);
	}
	
	private List<String> getPerms(String str){
		if(str == null){
			return null;
		}
		List<String> perms = new ArrayList<String>();
		if(str.length() == 0){
			perms.add("");
			return perms;
		}
		char ch = str.charAt(0);
		List<String> words = getPerms(str.substring(1));
		for(String word: words){
			for(int i=0;i<=word.length();i++){
				String s = insertCharAt(word, i, ch);
				perms.add(s);
			}
		}
		return perms;
	}
	
	private String insertCharAt(String s, int i, char ch){
		String left = s.substring(0,i);
		String right = s.substring(i);
		return left+ch+right;
	}

}