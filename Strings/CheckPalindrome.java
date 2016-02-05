public class CheckPalindrome {
	
	public static void main(String[] args){
		String str = args[0];
		for(int i=0;i<str.length()/2;i++){
			if(str.charAt(i) != str.charAt(str.length()-i-1)){
				System.out.println("Not a Palindrome");
				return;
			}
		}
		System.out.println("Palindrome");
	}
	
}