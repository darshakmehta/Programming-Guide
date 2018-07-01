import java.util.*;
import java.lang.*;
import java.io.*;

class Animal
{
	int order;
	String name;
	
	Animal(String name) {
		this.name = name;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public int getOrder() {
		return this.order;
	}
	
	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}
}

class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}
} 

class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}
} 

class AnimalQueue
{	
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	int order = 0;
	
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;

		if(a instanceof Dog) dogs.addLast((Dog) a);
		else if(a instanceof Cat) cats.addLast((Cat) a);	
	}

	public Dog dequeueDog() {
		return dogs.poll();
	}

	public Cat dequeueCat() {
		return cats.poll();
	}

	public Animal dequeueAny() {
		if(dogs.size() == 0)
			return dequeueDog();
		else if(cats.size() == 0)
			return dequeueCat();

		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		if(dog.isOlderThan(cat)) {
			return dequeueDog();
		} else {
			return dequeueCat();
		}
	}
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Dog d1 = new Dog("Dog1");
		Cat c1 = new Cat("Cat1");
		Dog d2 = new Dog("Dog2");
		Cat c2 = new Cat("Cat2");
		Dog d3 = new Dog("Dog3");
		Cat c3 = new Cat("Cat3");
		Dog d4 = new Dog("Dog4");
		Cat c4 = new Cat("Cat4");
		Dog d5 = new Dog("Dog5");
		Cat c5 = new Cat("Cat5");
		
		AnimalQueue a = new AnimalQueue();
		a.enqueue(d1);
		a.enqueue(d2);
		a.enqueue(d3);
		a.enqueue(c1);
		a.enqueue(c2);
		a.enqueue(c3);
		a.enqueue(c4);
		a.enqueue(d5);
		a.enqueue(d4);
		a.enqueue(c5);

		System.out.println(a.dequeueCat().order);
		System.out.println(a.dequeueDog().order);
		System.out.println(a.dequeueCat().order);
		System.out.println(a.dequeueCat().order);
		System.out.println(a.dequeueAny().order);
		System.out.println(a.dequeueDog().order);
		System.out.println(a.dequeueCat().order);

	}
}
	