import java.util.Scanner;

public class ZeroMatrix {

	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		int M = stdin.nextInt();
		int N = stdin.nextInt();
		int matrix[][] = new int[M][N];
		stdin.nextLine();
		int i=0;
		while(stdin.hasNextLine()){
			String line = stdin.nextLine();
			String tokens[] = line.split(" ");
			for(int j=0;j<tokens.length;j++){
				matrix[i][j] = Integer.valueOf(tokens[j]);
			}
			i++;
		}
		
		ZeroMatrix zm = new ZeroMatrix();
		System.out.println("Original Matrix:");
		zm.printMatrix(matrix, M, N);
		zm.zeroMatrix(matrix, M, N);
	}
	
	private void zeroMatrix(int[][] matrix, int M, int N){
		
		boolean hasZeroRow = false, hasZeroColumn = false;
		
		for(int i=0;i<N;i++){
			if(matrix[0][i] == 0){
				hasZeroRow = true;
			}
		}
		
		for(int j=0;j<M;j++){
			if(matrix[j][0] == 0){
				hasZeroColumn = true;
			}
		}
		
		for(int i=1;i<M;i++){
			for(int j=1;j<N;j++){
				if(matrix[i][j] == 0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;	
				}
			}
		}
		
		System.out.println("Modified Matrix:");
		
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				if((i == 0 && hasZeroColumn) || (j == 0 && hasZeroRow) || matrix[0][j] == 0 || matrix[i][0] == 0){
					System.out.print("0 ");
				} else {
					System.out.print(matrix[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
	
	private void printMatrix(int[][] matrix, int M, int N){
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}