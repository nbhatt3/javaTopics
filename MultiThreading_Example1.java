class Printer{
	
	void printDocuments(int num, String documentName) {
		for(int i=1; i<=num;i++) {
			System.out.println(">> Printing "+ documentName+" "+ i);
		}
	}
}

class MyThread extends Thread{
	
	Printer pRef;
	MyThread(Printer p){
		pRef = p;
	}
	
	@Override 
	public void run() {
		synchronized (pRef) {	// using synchronized to allow one thread to run at a time, acquire the lock on Printer
			pRef.printDocuments(10, "JohnsProfile.pdf");
		}
	}
}

class YourThread extends Thread{
	
	Printer pRef;
	YourThread(Printer p){
		pRef = p;
	}
	
	@Override 
	public void run() {
		synchronized (pRef) {	// using synchronized to allow one thread to run at a time, acquire the lock on Printer
			pRef.printDocuments(10, "MichaelsProfile.pdf");
		}
	}
}

public class MultiThreading_Example1 {

	public static void main(String[] args) {
		System.out.println("Application MAIN Thread started");

		Printer printer = new Printer();
				
		MyThread mRef = new MyThread(printer);	// MyThread is having reference to Printer object
		YourThread yRef = new YourThread(printer);	// YourThread is having reference to Printer object
		
		// Scenario is we have multiple threads working on same Printer Object (resource)
		mRef.start();  // printing with help of a Thread
		yRef.start();  // printing with help of a YourThread
		
		System.out.println("Application MAIN Thread ended");
	}

}

//OUTPUT 1
//shown  below is Asynchronously run of thread ( NOTE: when NOT using synchronized() method to acquire lock)
//The below Scenario suited where same resource is sharable for 
// more than one thread and NO Issue is faced.
// This output is not suitable for actual PRINTER execution - when more than one user submits print request
// ,we don't want to print in asynchronous manner. But one full print job (buy one user)
//to be executed and then other user print job.

/* OUTPUT 1:
Application MAIN Thread started
Application MAIN Thread ended
>> Printing JohnsProfile.pdf 1
>> Printing JohnsProfile.pdf 2
>> Printing JohnsProfile.pdf 3
>> Printing MichaelsProfile.pdf 1
>> Printing JohnsProfile.pdf 4
>> Printing MichaelsProfile.pdf 2
>> Printing JohnsProfile.pdf 5
>> Printing MichaelsProfile.pdf 3
>> Printing JohnsProfile.pdf 6
>> Printing MichaelsProfile.pdf 4
>> Printing MichaelsProfile.pdf 5
>> Printing MichaelsProfile.pdf 6
>> Printing MichaelsProfile.pdf 7
>> Printing JohnsProfile.pdf 7
>> Printing JohnsProfile.pdf 8
>> Printing MichaelsProfile.pdf 8
>> Printing JohnsProfile.pdf 9
>> Printing MichaelsProfile.pdf 9
>> Printing JohnsProfile.pdf 10
>> Printing MichaelsProfile.pdf 10
*/

//OUTPUT 2
//shown  below is Synchronized run of threads ( NOTE: when using synchronized() method to acquire lock)
/*
The Thread executes fully by acquiring a lock over Printer object(resource) and then 2nd thread uses it,
OUTPUT 2:
Application MAIN Thread started
Application MAIN Thread ended
>> Printing JohnsProfile.pdf 1
>> Printing JohnsProfile.pdf 2
>> Printing JohnsProfile.pdf 3
>> Printing JohnsProfile.pdf 4
>> Printing JohnsProfile.pdf 5
>> Printing JohnsProfile.pdf 6
>> Printing JohnsProfile.pdf 7
>> Printing JohnsProfile.pdf 8
>> Printing JohnsProfile.pdf 9
>> Printing JohnsProfile.pdf 10
>> Printing MichaelsProfile.pdf 1
>> Printing MichaelsProfile.pdf 2
>> Printing MichaelsProfile.pdf 3
>> Printing MichaelsProfile.pdf 4
>> Printing MichaelsProfile.pdf 5
>> Printing MichaelsProfile.pdf 6
>> Printing MichaelsProfile.pdf 7
>> Printing MichaelsProfile.pdf 8
>> Printing MichaelsProfile.pdf 9
>> Printing MichaelsProfile.pdf 10
 
*/