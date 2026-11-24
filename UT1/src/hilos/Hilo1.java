package hilos;

public class Hilo1 extends Thread{
	private int max = 5;
	
	public Hilo1 (String h) {
		this.setName(h);
		System.out.println("Creando Hilo: " + this.getName());
	}

	public void run() {
		for (int count = 0; count <= max; count++) {	
			System.out.println("Hilo: " + this.getName() + " contador: " + count);
		}
	}
}
