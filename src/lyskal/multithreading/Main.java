package lyskal.multithreading;

/**
 * Implementation the simple example redefinition of a method of run().
 * And creation of two streams.
 * 
 * @author LyskaL
 */
public class Main {

	public static void main(final String[] args) {
		System.out.println("The thread " + Thread.currentThread().getName());
		new MyThreadOne().start();
		new MyThreadTwo().start();
	}
}

class MyThreadOne extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 400; i++) {
			System.out.println("Thread name: " + Thread.currentThread().getName() + 
					"\ti = " + i);
		}
		System.out.println("The thread " + Thread.currentThread().getName() + " has finished the work.");
	}
}

class MyThreadTwo extends Thread {
	@Override
	public void run() {
		for (int i = 400; i > 0; i--) {
			System.out.println("Thread name: " + Thread.currentThread().getName() + 
					"\ti = " + i);
		}
		System.out.println("The thread " + Thread.currentThread().getName() + " has finished the work.");
	}
}