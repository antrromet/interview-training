public class IndexOf {

	public static void main(String[] args){
		String str1 = args[0];
		String str2 = args[1];
		
		System.out.println(checkSubstring(str1,str2));
	}
	
	private static int checkSubstring(String str1, String str2){
		int j=0;
		for(int i=0;i<str1.length();i++){
			if(str2.charAt(j) == str1.charAt(i)){
				j++;
				if(j == str2.length()){
					return i-j+1;
				}
			} else {
				j = 0;
			}
		}
		return -1;
	}

}