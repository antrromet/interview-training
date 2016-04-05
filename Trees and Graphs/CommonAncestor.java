public class CommonAncestor {

	private Node root, p, q;

	public static void main(String[] args){
		CommonAncestor ca = new CommonAncestor();
		ca.find();
	}
	
	private void find(){
		commonAncestor(root, p, q);
	}
	
	private boolean covers(Node root, Node n){
		if(root == null){
			return false;
		}
		if(root == n){
			return true;
		}
		return covers(root.left, n) || covers(root.right, n);
	}
	
	private Node commonAncestorHelper(Node root, Node p, Node q){
		if(root == p || root == q){
			return root;
		}
		boolean is_p_on_left = coverts(root.left, p);
		boolean is_q_on_left = coverts(root.left, q);
		
		if(is_p_on_left != is_q_on_left){
			return root;
		}
		Node sameSideRoot = is_p_on_left? root.left:root.right;
		return commonAncestorHelper(sameSideRoot, p, q);
	}
	
	private Node commonAncestor(Node root, Node p, Node q){
		if(root == null){
			return null;
		}
		if(!covers(root, p) || !covers(root, q)){
			return null;
		}
		return commonAncestorHelper(root, p, q);
	}

}