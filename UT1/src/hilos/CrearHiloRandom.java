package hilos;

public class CrearHiloRandom implements Runnable {

	@Override
	public void run() {
		int random;

		do {
			// Número aleatorio del 1 al 10
			random = (int) (Math.random() * 10) + 1;
			System.out.println(Thread.currentThread().getName() + " -> " + random);
		} while (random != 2);

		/**try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		System.out.println("FIN " + Thread.currentThread().getName());
	}
}