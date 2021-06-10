package abstracts;

public class ExampleGraphics {
	public static void main(String[] args) {
		runExample();
	}
	private static void runExample() {
		System.out.println("runExample()");
		
		Circle circle1 = new Circle();
		circle1.draw();
		circle1.resize();
		circle1.moveTo(25, 33);
		
		Rectangle rectangle1 = new Rectangle();
		rectangle1.draw();
		rectangle1.resize();
		rectangle1.moveTo(77, 55);
	}
}

abstract class GraphicObject {
	int j, k;
	void moveTo(int x, int y) {
		System.out.println("MOVE GRAPHIC OBJECT x=" + x + " y=" + y);
	}
	abstract void draw();
	abstract void resize();
}

class Circle extends GraphicObject {
	void draw() {
		System.out.println("DRAW CIRCLE");
	}
	void resize() {
		System.out.println("RESIZE CIRCLE");
	}
}

class Rectangle extends GraphicObject {
	void draw() {
		System.out.println("DRAW RECTANGLE");
	}
	void resize() {
		System.out.println("RESIZE RECTANGLE");
	}
}