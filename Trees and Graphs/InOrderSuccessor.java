public class InOrderSuccessor {

	private Node root;

	public static void main(String[] args){
		InOrderSuccessor ios = new InOrderSuccessor();
		ios.inOrderSucc();
	}
	
	private void inOrderSucc(){
		inOrderSucc(root);
	}
	
	private Node inOrderSucc(Node n){
		if(n == null){
			return null;
		}
		if(n.right != null){
			return leftMostChild(n.right);
		} else {
			Node q = n;
			Node x = n.parent;
			while(x!=null && x.left != q){
				q = x;
				x = x.parent;
			}
			return x;
		}
	}
	
	private Node leftMostChild(Node n){
		if(n == null){
			return null;
		}
		while(n.left!=null){
			n = n.left;
		}
		return n;
	}

}