import java.util.Queue;
import java.util.LinkedList;

public class AnimalShelter {

	public static void main(String[] args){
			
	}
	
	public abstract class Animal {
	
		private int order;
		private String name;
		
		public Animal(String name){
			this.name = name;
		}
		
		public void setOrder(int order){
			this.order = order;
		}
		
		public boolean isOlderThan(Animal a){
			return order < a.order;
		}
	}
	
	public class AnimalQueue {
		LinkedList<Dog> dogs = new LinkedList<Dog>();
		LinkedList<Cat> cats = new LinkedList<Cat>();
		
		private int order = 0;
		
		public void enqueue(Animal a){
			a.setOrder(order);
			order++;
			if(a instanceof Cat){
				cats.addLast((Cat)a);
			} else {
				dogs.addLast((Dog)a);
			}
		}
		
		public Animal dequeueAny(){
			if(dogs.isEmpty()){
				return dequeueCats();
			} else if(cats.isEmpty()){
				return dequeueDogs();
			} else {
				Cat c = cats.peek();
				Dog d = dogs.peek();
				if(d.isOlderThan(c)){
					return dequeueDogs();
				} else {
					return dequeueCats();
				}
			}
		}
		
		private Cat dequeueCats(){
			return cats.poll();
		}
		
		private Dog dequeueDogs(){
			return dogs.poll();
		}
	}
	
	public class Cat extends Animal{
		public Cat(String name){
			super(name);
		}
	}
	
	public class Dog extends Animal{
		public Dog(String name){
			super(name);
		}
	}

}