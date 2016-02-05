public class RemoveDuplicates {

	public static void main(String[] args){
		String str = args[0];
		removeDuplicatesStringBuilder(str);
	}
	
	private static void removeDuplicatesStringBuilder(String str){
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(builder.indexOf(""+ch) == -1){
				builder.append(ch);
			}
		}
		System.out.println(builder.toString());
	}

}