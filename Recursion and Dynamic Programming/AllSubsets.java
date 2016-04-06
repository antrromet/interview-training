import java.util.List;
import java.util.ArrayList;

public class AllSubsets {
	
	public static void main(String[] args){
		String str = args[0];
		AllSubsets allSub = new AllSubsets();
		allSub.findPermutations(str);	
	}
	
	private void findPermutations(String str){
		System.out.println("All permutations:");
		List<String> list = getPermutations(str);
		System.out.println(list);
	}
	
	private List<String> getPermutations(String str){
		List<String> perms = new ArrayList<String>();
		int N = (int)Math.pow(2, str.length());
		for(int i=0;i<N;i++){
			StringBuilder builder = new StringBuilder();
			for(int j=0;j<str.length();j++){
 				// System.out.println("i="+i+", j="+j+" and 1<<j="+(1<<j)+" and (i & (1<<j)="+(i & (1<<j)));
				if((i & (1<<j)) > 0){
					builder.append(str.charAt(j));
				}
			}
			perms.add(builder.toString());
		}
		return perms;
	}
	
}