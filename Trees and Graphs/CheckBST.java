public class CheckBST {

	private Node root;
	private int prev = Integer.MIN_VALUE;
	
	public static void main(String[] args){
		CheckBST cbst = new CheckBST();
		cbst.check();
	}
	
	private void check(){
		check(root);
	}
	
	private boolean check(Node root){
		if(root == null){
			return true;
		}
		if(!check(root.left)){
			return false;
		}
		if(root.data <= prev){
			return false;
		}
		prev = root.data;
		if(!check(root.right)){
			return false;
		}
		return true;
	}

}