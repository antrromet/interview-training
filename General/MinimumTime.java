import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MinimumTime {
	
	public static void main(String[] args){
		int k = 2, T = 5;
		int[] machines = new int[k];
		List<Integer> jobs = new ArrayList<Integer>();
		jobs.add(4);
		jobs.add(5);
		jobs.add(10);
// 		jobs.add(10);
// 		jobs.add(7);
// 		jobs.add(8);
// 		jobs.add(12);
// 		jobs.add(6);
// 		jobs.add(8);
		
		Collections.sort(jobs);
		Collections.reverse(jobs);
		System.out.println("Current Jobs: "+jobs);
		int counter = 0;
		boolean allJobsAssigned = false;
		boolean allJobsOver = false;
		
		for(int i=0;i<k;i++){
			int job = jobs.remove(0);
			System.out.println("Assigning job: " + job);
			System.out.println("Remaining jobs: "+jobs);
			machines[i] = job;	
		}
		
		while(true){
			for(int i=0;i<k;i++){
				machines[i] -= 1;
				System.out.println("machine "+i+": "+machines[i]);
				if(machines[i] == 0){
					if(jobs.size()>0){
						int job = jobs.remove(0);
						System.out.println("Assigning job: " + job);
						System.out.println("Remaining jobs: "+jobs);
						machines[i] = job;
						if(jobs.isEmpty()){
							allJobsAssigned = true;
							break;
						}
					} else {
						allJobsAssigned = true;
						break;
					}				
				}
			}
			counter++;
			System.out.println("Incrementing Counter: "+counter);
			if(allJobsAssigned){
				System.out.println("All jobs assigned");
				while(true){
					allJobsOver = true;
					for(int i=0;i<k;i++){
						if(machines[i] > 0){
							allJobsOver = false;
						}
						machines[i] -=1;
						System.out.println("machine "+i+": "+machines[i]);
					}
					if(allJobsOver){
						System.out.println("Counter: "+counter);
						System.out.println("Total time: "+counter*T);
						break;
					}
					counter++;
					System.out.println("Incrementing Counter: "+counter);
				}
			}
			if(allJobsOver){
				break;
			}
		}
	}
	
}