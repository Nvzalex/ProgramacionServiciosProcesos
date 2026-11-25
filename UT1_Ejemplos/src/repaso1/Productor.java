package repaso1;

public class Productor extends Thread{
	private Cola cola;
	private int n;
	private int maxPila;
	
	public Productor(Cola cola, int n, int maxPila) {
		this.cola = cola;
		this.n = n;
		this.maxPila = maxPila;
	}

	public void run () {
		for (int i = 0; i < maxPila; i++) {
			cola.put(i);
			System.out.println(i + " Productor: " + n + " produce el número " + i);
		}
		
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}