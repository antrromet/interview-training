public class RemoveChar {

	public static void main(String[] args){
		String str = args[0];
		char ch = args[1].charAt(0);
		
		StringBuilder builder = new StringBuilder(str);
		while(builder.indexOf(ch+"")!=-1){
			builder.deleteCharAt(builder.indexOf(ch+""));
		}
		System.out.println(builder.toString());
	}

}