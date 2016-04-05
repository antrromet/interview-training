public void FindPathsSum {

	private Node root;

	private static void main(String[] args){
		int sum = Integer.valueOf(args[0]);
		FindPathsSum fps = new FindPathsSum();
		fps.findPaths(sum);
	}
	
	private void findPaths(int sum){
		findSum(root, sum);
	}
	
	private int findDepth(Node n){
		if(n == null){
			return 0;
		}
		return Math.max(findDepth(n.left), findDepth(n.right))+1;
	}
	
	private void printPath(int[] path, int start, int end){
		for(int i=start;i<=end;i++){
			System.out.print(path[i]+" ");
		}
		System.out.println();
	}
	
	private void findSum(Node root, int sum, int[] path, int level){
		if(root == null){
			return;
		}
		path[level] = root.data;
		
		int t = 0;
		for(int i=level;i>=0;i--){
			t+=path[i];
			if(t == sum){
				printPath(path, i, level);
			}
		}
		
		findSum(root.left, sum, path, level+1);
		findSum(root.right, sum, path, level+1);
		
		path[level] = Integer.MIN_VALUE;
	}
	
	private void findSum(Node root, int sum){
		int depth = findDepth(root);
		int[] path = new path[depth];
		findSum(node, sum, path, 0);
	}

}