# OOPS in Java

## Core OOPS concepts
The core *OOPS* concepts are
* *Abstraction*
* *Polymorphism*
* *Encapsulation*
* *Inheritance*
* *Association*
* *Composition*
* *Aggregation*

### Abstraction
Abstraction is the concept of hiding the implementation details and exposing only the interface to an object.

## Inheritance Basics
* *Super class* / *Base class* / *Parent class*: The class from which one or more classes are being inherited.
* *Sub class* / *Derived class* / *Child class*: A class that is inheriting from some *super class*
* A super class is *generic* and a sub class is *specific*
* A sub class is a specialized version of its super class.
* In Java, a `class` can inherit from only one `class`, but can implement multiple `interface`s.
* **Definition**: *Inheritance* is a process where a class can aquire properties of another class.
* We derive a class from another class using the keyword `extends`
* A sub class object will have all the members of its own class along with the members of all super classes in hierarchy.

```java
class Shape{
	String name; //Name of the shape.
	Shape(String name){
		this.name = name;
	}
}
class Line extends Shape{
	int length;

	Line(String name, int length){
		super(name);
		this.length = length;
	}
}
public class Test{
    public static void main(String args[]){
        Shape sh = new Shape("None");
        Line line = new Line("Line", 5);
    }
}
```

* *Trivia*: A class cannot inherit from itself.

### Member access in Inheritance
* Although, a sub class inherits all the members of its all super classes, it cannot access `private` members of its super classes in the hierarchy.
* A `private` member is strictly `private` to the class - it is not accessible to any other class (except inner class) including its child classes.

```java
class Shape{
	private String name; //Name of the shape.
	Shape(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
}
class Line extends Shape{
	private int length;

	Line(String name, int length){
		super(name);
		this.length = length;
	}
	void print(){
		System.out.println("Name: " + this.name); //Compiler error - cannot access name.
		System.out.println("Name: " + getName()); //Perfect - Use accessor methods provided by super class.
		System.out.println("Length: " + this.length);
	}
}
public class Test{
    public static void main(String args[]){
        Line line = new Line("Line", 5);
        line.print();
    }
}
```

### Dynamic Polymorphism
> **A super class reference variable can reference a sub class object**: 
This is a key feature of inheritance. Apart from code reuse (using inheritance), by referencing sub class objects using super class reference variables, we achieve *dynamic polymorphism*

* **Dynamic polymorphism** is the concept of method binding at runtime as opposed to at compile time (static) binding. When the compiler cannot bind a method call to any particular method, the decision is deferred to runtime. Dynamic binding takes place, when there is
	* Inheritance
	* Overriding
	* A super class reference variable referring a sub class object
	* Such super class reference variable - calling an overridden method


```java
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
	public void someFunc(){
		System.out.println("Some function of Shape");
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
	
	public int getLength(){
		return length;
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
	public String getName(){
		return "";
	}
	@Override
	public void print(){
		super.print();
		System.out.println("And volume: " + this.volume);
	}
}

public class Test{
	static void printShape(Shape p){
		p.print();
	}

    public static void main(String args[]){
        Shape shapes[] = {
        	new Line("Line", 4), 
        	new Circle("Circle", 5),
        	new Line("Big line", 300),
        	new Circle("Large circle", 200),
        	new Cube("Cube", 190),
        	new Shape("None")
        };
        
        shapes[0].print(); //dynamic binding
        shapes[4].print(); //dynamic binding

        for(Shape shape: shapes){
        	//There are 3 implementations of print method in this program.
        	//Which method should the compiler bind the following call to?
        	shape.print();
        	//Compiler cannot decide which method to bind to. Hence,
        	//leaves the decision to run time.

        	shape.someFunc(); //Static binding.
        }

        Circle c = (Circle) shapes[1];
        c.print(); //static binding.
    }
}
```

* The runtime choses the method to call from the type of object, but not from the type of reference variable. In the above example, the reference type is `Shape` for all 4 objects in the array. The statement `shape.print();` results in calling `print` method from the class of the object type (*Circle* or *Line* or *Shape*)

**When a super class reference variable references a sub class object** it can only access those properties (methods or data) that are defined in its own class. For example, from the above example, you cannot call `shape.getLength();` => the *Shape* class does not have *getLength()* defined in itself.

**Using super**: From constructor and any methods - to access methods of immediate super class.
