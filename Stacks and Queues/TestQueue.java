import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestQueue {

	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new Queue<>();
		while(true){
			System.out.println("1. Enqueue");
			System.out.println("2. Dequeue");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String in = br.readLine();
			System.out.println();
			int choice = -1;
			try{
				choice = Integer.valueOf(in);
			} catch(NumberFormatException e){
			}
			switch(choice){
				case 1: System.out.print("Enter Data: ");
						in = br.readLine();
						try{
							int data = Integer.valueOf(in);
							queue.enqueue(data);
						} catch(NumberFormatException e){
							System.out.println("Invalid Input!");
							break;
						}
						break;
				case 2: Integer pop = queue.dequeue();
						if(pop != null){
							System.out.println("Dequeued: "+pop);	
						}
						break;
				case 3: queue.display();
						break;
				case 4: System.exit(0);
				default: System.out.println("Invalid Input!");
						break;
			}
			System.out.println();
		}
	}

}