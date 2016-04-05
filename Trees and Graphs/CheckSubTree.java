public class CheckSubTree {

	private Node t1, t2;

	public static void main(String[] args){
		CheckSubTree cst = new CheckSubTree();
		cst.check();
	}
	
	private void check(){
		containsTree(t1, t2);
	}
	
	private boolean containsTree(Node t1, Node t2){
		if(t2 == null){
			return true;
		}
		return subTree(t1, t2);
	}
	
	private boolean subTree(Node r1, Node r2){
		if(r1 == null){
			return false;
		}
		
		if(r1.data == r2.data){
			if(matchTree(r1, r2)){
				return true;
			}
		}
		return subTree(r1.left, r2) || containsTree(r1.right, r2);
	}
	
	private boolean matchTree(Node r1, Node r2){
		if(r1 == null && r2 == null){
			return true;
		}
		if(r1 == null || r2 == null){
			return false;
		}
		if(r1.data!=r2.data){
			return false;
		}
		return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
	}

}