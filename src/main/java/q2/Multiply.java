package q2;

public class Multiply implements Runnable {
	private int value;
	
	public Multiply(int value) {
		this.value = value;
	}
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " started.");
		// Print the multiplication table
		for (int i = 1; i <= 10; i++) {
			System.out.println(threadName + ": " +value + " * " + i + " = " + (value * i));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Got interrupted");
			}
		}
		System.out.println(threadName + " ended.");
	}
	
	public static void main(String[] args) {
		System.out.println("Main thread started.");
		
		// Define the threads
		Multiply m1 = new Multiply(2);
		Thread slowThread = new Thread(m1, "SlowThread");
		slowThread.setPriority(Thread.MIN_PRIORITY);
		System.out.println("SlowThread priority: " + slowThread.getPriority());
		
		Multiply m2 = new Multiply(5);
		Thread mediumThread = new Thread(m2, "MediumThread");
		mediumThread.setPriority(5);
		System.out.println("MediumThread priority: " + mediumThread.getPriority());
		
		Multiply m3 = new Multiply(10);
		Thread fastThread = new Thread(m3, "FastThread");
		fastThread.setPriority(Thread.MAX_PRIORITY);
		System.out.println("FastThread priority: " + fastThread.getPriority());
		
		// Start the threads and add delay
		slowThread.start();
		mediumThread.start();
		fastThread.start();
		
		// Wait for the threads to finish
		try {
			slowThread.join();
			mediumThread.join();
			fastThread.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		
		System.out.println("Main thread ended.");
	}
}
