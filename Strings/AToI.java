public class AToI {
	
	public static void main(String[] args){
		String str = args[0];
		int num = 0;
		for(int i=0;i<str.length();i++){
			num += (str.charAt(str.length()-i-1)-48)*Math.pow(10,i);
		}
		System.out.println(num);
	}
	
}