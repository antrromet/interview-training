import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestStack {

	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
		while(true){
			System.out.println("1. Push");
			System.out.println("2. Pop");
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
							stack.push(data);
						} catch(NumberFormatException e){
							System.out.println("Invalid Input!");
							break;
						}
						break;
				case 2: Integer pop = stack.pop();
						if(pop != null){
							System.out.print("Popped: "+pop);	
						}
						break;
				case 3: stack.display();
						break;
				case 4: System.exit(0);
				default: System.out.println("Invalid Input!");
						break;
			}
			System.out.println();
		}
	}

}