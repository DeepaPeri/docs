abstract class ClassA{
	abstract void check(); 
}

//The child of this class must implement two methods
//check() and test() to become concrete.
abstract class ClassB extends ClassA{
	abstract void test();
}

//This class is abstract because the check() method is not implemented.
//The sub classes of this class should implement check() to become concrete class.
abstract class ClassC extends ClassB{
	@Override 
	void test(){
		System.out.println("ClassC test method");
	}
}

//It must implement check() method.
//The test() method is implemented in its ancestors.
class ClassD extends ClassC{
	@Override
	////This must be implemented.
	//If not, even this class should be declared as abstract
	void check(){ 
		System.out.println("ClassD check method");
	}
}
public class Test{
	public static void main(String args[]){
		ClassD d = new ClassD();
	}
}