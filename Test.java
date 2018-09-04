class Shape{
	Shape(){
		System.out.println("Shape class no argument constructor");
	}
	Shape(int x){
		System.out.println("Shape class one argument constructor");
	}
}
class Box extends Shape{ //Box is a sub class of Shape
	Box(){
		//Error: We are trying to call two super class constructors.
		super(); //Calling default constructor.
		
		super(5); //We are violating the rule that the super class constructor call must be the first statement. 
		//Here, this is second statement.

		System.out.println("Box class no argument constructor");
	}
}
public class Test{
	public static void main(String a[]){
		Box b1 = new Box();
	}
}