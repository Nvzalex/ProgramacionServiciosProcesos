package hilos;

public class PInterrupted extends Thread{
	public static void main(String[] args) {
		HInterrupted h = new HInterrupted();
		
		h.start();
		
		
		try {
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		h.interrupt();
	}
}
