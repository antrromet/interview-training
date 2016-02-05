public class ReverseWords {
	
	public static void main(String[] args){
		char[] charArr = args[0].toCharArray();
		reverseArray(charArr, 0, charArr.length);
		int start = 0;
		for(int i=0;i<charArr.length;i++){
			if(charArr[i] == ' '){
				reverseArray(charArr, start, i);
				start = i+1;
			}
		}
		System.out.println(new String(charArr));
	}
	
	private static void reverseArray(char[] charArr, int start, int end){
		for(int i=start;i<(end/2);i++){
			swap(charArr, i, start+end-i-1);
		}

	}
	
	private static void swap(char[] ch, int x, int y){
		char temp = ch[x];
		ch[x] = ch[y];
		ch[y] = temp;
	}
	
}