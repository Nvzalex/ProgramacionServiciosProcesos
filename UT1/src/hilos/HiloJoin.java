package hilos;

public class HiloJoin extends Thread{
	private int limite;
	
	public HiloJoin(String name, int limite ) {
		this.setName(name);
		this.limite = limite;
	}

	public void run () {
		for (int i = 0; i < limite; i++) {
			System.out.println("Hilo " + this.getName() + " contador " + this.threadId());
		}
		System.out.println("Hilo " + this.getName() + " terminado ");
	}
}