public class Garbage {
	
	//Finalize is a method we can call right before we destroy an object in Java
	@Override
	protected void finalize() {
		System.out.println("GarbageDrivers finalize method called");
		System.out.println("Goodbye cruel world");
		System.exit(0);
	}

	public static void main(String[] args) {
		System.out.println("Instantiate a new Garbage Object");
		Garbage g = new Garbage(); //Garbage object 1
		System.out.println("Garbage object was created");
		
		System.out.println("Assign the variable g to some other garabage object");
		g = new Garbage(); //Garbage object 2
		
		System.gc();
		
		//this creates an infinite loop, waiting for System.gc() to exit/destroy the loop
		for(;;) {
			System.out.println("Waiting for garbage collection");
		}
	}
	
}