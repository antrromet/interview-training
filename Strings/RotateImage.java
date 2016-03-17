import java.util.Scanner;

public class RotateImage {
	
	public static void main(String[] args){
		int N = Integer.valueOf(args[0]);
		int[][] matrix = new int[N][N];
		Scanner stdin = new Scanner(System.in);
		int i=0;
		while(stdin.hasNextLine()) {
			String line = stdin.nextLine();
			String[] tokens = line.split(" ");
			for(int j=0;j<tokens.length;j++){
				matrix[i][j] = Integer.valueOf(tokens[j]);
			}
			i++;
		}
		RotateImage ri = new RotateImage();
		System.out.println("Original Matrix:");
		ri.printMatrix(matrix, N);
		ri.rotateMatrix(matrix, N);
		System.out.println("After Rotation:");
		ri.printMatrix(matrix, N);
	}
	
	private void rotateMatrix(int[][] matrix, int N){
		for(int layer = 0;layer<N/2;layer++){
			int first = layer;
			int last = N - layer - 1;
			for(int i=first;i<last;i++){
				int offset = i - first;
				int temp = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[i][last];
				matrix[i][last] = temp;
			}
		}
	}
	
	private void printMatrix(int[][] matrix, int N){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}