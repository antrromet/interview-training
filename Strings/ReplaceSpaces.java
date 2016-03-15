public class ReplaceSpaces {

	public static void main(String[] args){
		String str = args[0];
		String[] spl = str.split(" ");
		ReplaceSpaces rs = new ReplaceSpaces();
		int len = rs.getLength(str.toCharArray());
		System.out.println(rs.replaceSpaces(str.toCharArray(), len));
	}
	
	private String replaceSpaces(char[] ch, int length){
		int x = length-1;
		int i=ch.length-1;
		while(i>=0){
			if(ch[x] == ' '){
				ch[i--] = '0';
				ch[i--] = '2';
				ch[i--] = '%';
			} else {
				ch[i--] = ch[x]; 
			}
			x--;
		}
		return new String(ch);
	}
	
	private int getLength(char[] ch){
		int len = 0;
		char prev = ch[0];
		for(int i=1;i<ch.length;i++){
			if(ch[i] == ch[i-1] && ch[i] == ' '){
				break;
			}
			len++;
		}
		return len;
	}

}