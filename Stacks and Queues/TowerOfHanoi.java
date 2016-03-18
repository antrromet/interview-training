import java.util.Stack;
import java.util.EmptyStackException;

public class TowerOfHanoi {

	private Tower[] towers;

	public TowerOfHanoi() {
		towers = new Tower[3];
		for(int i=0;i<3;i++){
			towers[i] = new Tower(i);
		}
	}

	public static void main(String[] args){
		TowerOfHanoi toh = new TowerOfHanoi();
		toh.run();
	}
	
	private void run(){
		int n = 3;
		for(int i=n-1;i>=0;i--){
			towers[0].add(i);
		}
		
		towers[0].moveDisks(n, towers[2], towers[1]);
	}
	
	public class Tower {
	
		private Stack<Integer> disks;
		private int index;
		
		public Tower(int i){
			disks = new Stack<Integer>();
			index = i;
		}
		
		public void add(int d){
			if(!disks.isEmpty() && disks.peek() <= d){
				System.err.println("Error placing disk = "+d+" in Tower "+index);
			} else {
				disks.push(d);
			}
		}
		
		public void moveTopTo(Tower origin, Tower destination){
			try{
				int top = origin.disks.pop();
				destination.add(top);
				System.out.println("Move disk "+top+" from Tower "+origin.index+" to Tower "+destination.index);
			} catch(EmptyStackException e){
				System.err.println("Error: Trying to move the top of Tower "+origin.index+" to Tower "+destination.index);
			}
		}
		
		public void moveDisks(int n, Tower destination, Tower buffer){
			moveDisks(n, this, destination, buffer);
		}
		
		public void moveDisks(int n, Tower origin, Tower destination, Tower buffer){
			if(n > 0){
				moveDisks(n-1, origin,  buffer, destination);
				moveTopTo(origin, destination);
				moveDisks(n-1, buffer, destination, origin);
			}
		}
	
	}

}