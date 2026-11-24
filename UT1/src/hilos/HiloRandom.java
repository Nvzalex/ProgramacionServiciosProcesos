package hilos;

public class HiloRandom {

	public static void main(String[] args) throws InterruptedException {
		Thread hilo1 = new Thread(new CrearHiloRandom());
		Thread hilo2 = new Thread(new CrearHiloRandom());

		hilo1.setName("Hilo 1");
		hilo2.setName("Hilo 2");

		hilo1.start();
		hilo2.start();

		// Esperamos a que ambos terminen
		hilo1.join();
		hilo2.join();

		System.out.println("Fin programa");
	}
}