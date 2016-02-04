public class CheckDigits {

	public static void main(String[] args){
		char[] charArr = args[0].toCharArray();
		for(char ch:charArr){
			int diff = (int)ch - 48;
			if(diff <0 || diff>9){
				System.out.println("Other characters");
				return;
			}
		}
		System.out.println("Only digits");
	}

}