public class StringCompression {

	public static void main(String[] args){
		String str = args[0];
		
		StringCompression sc = new StringCompression();
		System.out.println("Compressed String: "+sc.getCompressedString(str));
	}
	
	private String getCompressedString(String str){
		int newLength = getCompressedLength(str);
		if(newLength >= str.length()){
			return str;
		}
		StringBuilder builder = new StringBuilder();
		int count = 1;
		char prev = str.charAt(0);
		for(int i=1;i<str.length();i++){
			if(prev == str.charAt(i)){
				count++;
			} else{
				builder.append(prev);
				builder.append(count);
				count = 1;
				prev = str.charAt(i);
			}
		}
		builder.append(prev);
		builder.append(count);
		return builder.toString();
	}
	
	private int getCompressedLength(String str){
		int len = 0;
		int count = 1;
		int prev = str.charAt(0);
		for(int i=1;i<str.length();i++){
			if(prev == str.charAt(i)){
				count++;
			} else{
				len+=1;
				len+=String.valueOf(count).length();
				count = 1;
				prev = str.charAt(i);
			}
		}
		len+=1;
		len+=String.valueOf(count).length();
		return len;
	}

}