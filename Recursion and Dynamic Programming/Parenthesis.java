import java.util.ArrayList;
import java.util.List;

public class Parenthesis {
	
	public static void main(String[] args){
		int n = Integer.valueOf(args[0]);
		Parenthesis par = new Parenthesis();
		par.generateParens(n);
	}
	
	private void generateParens(int n){
		ArrayList<String> list = new ArrayList<String>();
		char[] str = new char[2*n];
		findParens(list, n, n, str, 0);
		System.out.println(list);
	}
	
	private void findParens(List<String> list, int leftRem, int rightRem, char[] str, int count){
		if(leftRem < 0 || rightRem < leftRem){
			return;
		}
		if(leftRem == 0 && rightRem == 0){
			String s = String.copyValueOf(str);
			list.add(s);
		} else {
			if(leftRem > 0){
				str[count] = '(';
				findParens(list, leftRem-1, rightRem, str, count+1);
			}
			if(rightRem > leftRem){
				str[count] = ')';
				findParens(list, leftRem, rightRem-1, str, count+1);
			}
		}
	}
	
}