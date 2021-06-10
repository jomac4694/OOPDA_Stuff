package abstracts;

public class ExampleAnimals {
	public static void main(String[] args) {
		runExample();
	}
	private static void runExample() {
		System.out.println("runExample()");
		
		Dog dog1 = new Dog();
		dog1.makeNoise();
		dog1.eat("meat");
		
		Cat cat1 = new Cat();
		cat1.makeNoise();
		cat1.eat("meat");
	}
}

abstract class Animal {
	int j, k;
	void eat(String food) {
		System.out.println("EAT " + food);
	}
	abstract void makeNoise();
}

class Dog extends Animal {
	void makeNoise() {
		System.out.println("BARK! BARK!");
	}
}

class Cat extends Animal {
	void makeNoise() {
		System.out.println("MEOW! MEOW!");
	}
}