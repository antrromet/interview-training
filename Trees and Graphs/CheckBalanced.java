public class CheckBalanced {

	public static void main(String[] args) {
		
	}
	
	private int getHeight(Node n){
		if(n == null){
			return 0;
		}
		return getHeight(n.right)+getHeight(n.left)+1;
	}
	
	private boolean isBalanced(Node root){
		if(root == null){
			return true;
		}
		int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
		if(diff > 1){
			return false;
		}else{
			return isBalanced(root.right) && isBalanced(root.left);
		}
	}
	
	private int checkHeight(Node root){
		if(root == null){
			return 0;
		}
		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1){
			return -1;
		}
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == -1){
			return -1;
		}
		
		int diff = Math.abs(leftHeight - rightHeight);
		if(diff > 1){
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight)+1;
		}
	}
	
	private boolean checkBalanced(Node root){
		if(checkHeight(root) == -1){
			return false;		
		} else {
			return true;
		}
	}

}