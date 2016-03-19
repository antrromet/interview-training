import java.util.ArrayList;
import java.util.LinkedList;

public class LevelLinkedLists {

	private Node root;

	public static void main(String[] args){
		LevelLinkedLists lll = new LevelLinkedLists();
		lll.createLevelLinkedLists();
	}
	
	private void createLevelLinkedLists(){
		createLevelLinkedLists(root);
	}
	
	private ArrayList<LinkedList<Node>> createLevelLinkedLists(Node root){
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		if(root == null){
			return result;
		}
		LinkedList<Node> current = new LinkedList<Node>();
		current.add(root);
		
		while(current.size()>0){
			result.add(current);
			LinkedList<Node> parents = current;
			current = new LinkedList<Node>();
			for(Node n:parents){
				if(n.left!=null){
					current.add(n.left);
				}
				if(n.right!=null){
					current.add(n.right);
				}
			}
		}
		
		return result;
	}

}