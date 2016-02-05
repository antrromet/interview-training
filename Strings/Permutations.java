import java.util.ArrayList;

public class Permutations {

	public static void main(String[] args){
		String str = args[0];
		System.out.println(getPermutations(str));
	}
	
	private static ArrayList<String> getPermutations(String str){
		if(str == null){
			return null;
		}
		ArrayList<String> perms = new ArrayList<String>();
		if(str.length() == 0){
			perms.add("");
			return perms;
		}
		char ch = str.charAt(0);
		ArrayList<String> words = getPermutations(str.substring(1));
		for(String word:words){
			for(int i=0;i<=word.length();i++){
				String s = insertChar(word,i,ch);
				perms.add(s);
			}
		}
		return perms;
	}
	
	private static String insertChar(String str, int pos, char ch){
		String left = str.substring(0,pos);
		String right = str.substring(pos);
		return left+ch+right;
	}

}