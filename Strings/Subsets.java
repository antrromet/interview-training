import java.util.ArrayList;

public class Subsets {
	
	public static void main(String[] args){
		String str = args[0];
		printPermutations(str);
	}
	
	private static void printPermutations(String str){
		int N = str.length();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<Math.pow(2,N);i++){
			StringBuilder builder = new StringBuilder();
			for(int j=0;j<N;j++){
				if(((1<<j)&i) > 0){
					builder.append(str.charAt(j));
				}
			}
			list.add(builder.toString());
		}
		System.out.println(list);
	}
	
}