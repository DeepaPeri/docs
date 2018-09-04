class Shape{
	String name;

	public void print(){
		System.out.println("The name: " + name);
	}
}
class Box extends Shape{ 
	int width, height, depth;
	
	@Override
	public void print(){
		super.print(); //Call the super class print method.
		System.out.println("Dimensions: " + width + ", " + height + ", " + depth);
	}
}
public class Test{
	public static void main(String a[]){
		Box b1 = new Box(); //Default name and unit box.
		b1.print();
	}
}