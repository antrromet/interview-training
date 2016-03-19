public class CreateMinimalBST {

	public static void main(String[] args){
		
	}
	
	private Node createMinimalBST(int[] a, int start, int end){
		if(end < start){
			return null;
		}
		int mid = (start+end)/2;
		Node n = new Node(a[mid]);
		n.left = createMinimalBST(a, start, mid-1);
		n.right = createMinimalBST(a, mid+1, end);
		return n;
	}
	
	private Node createMinimalBST(int[] arr){
		return createMinimalBST(arr, 0, arr.length-1);
	}
	
}