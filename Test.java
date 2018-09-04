class Shape{
	private String name; //Name of the shape.
	Shape(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void print(){
		System.out.println("Shape name: " + this.name);
	}
}
class Line extends Shape{
	private int length;

	Line(String name, int length){
		super(name);
		this.length = length;
	}

	@Override
	public void print(){
		System.out.println("Name: " + getName() + ", Length: " + this.length);
	}
}
class Circle extends Shape{
	private int radius;

	Circle(String name, int radius){
		super(name);
		this.radius = radius;
	}
	public void print(){
		System.out.println("Name: " + getName() + ", Radius: " + this.radius);
	}
}
class Cube extends Shape{
	int volume;
	Cube(String name, int volume){
		super(name);
		this.volume = volume;
	}
	@Override
	public void print(){
		super.print();
		System.out.println("And volume: " + this.volume);
	}
}

public class Test{
	public static void main(String args[]){
        Shape shapes[] = {
        	new Line("Line", 4), 
        	new Circle("Circle", 5),
        	new Line("Big line", 300),
        	new Circle("Large circle", 200),
        	new Cube("Cube", 190),
        	new Shape("None")
        };
        for(Shape shape: shapes){
        	//Test class is the message sender.
        	shape.print();
        }
    }
}