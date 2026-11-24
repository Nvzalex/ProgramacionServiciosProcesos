package hilos;

public class HInterrupted extends Thread {
	public void run() {

		while (this.isInterrupted() == false) {
			System.out.println("Hilo " + this.getName() + " esta activo");
		}

		// try {
		while (this.isInterrupted()) {
			System.out.println("Hilo " + this.getName() + " esta interumpido");
			try {
				Thread.sleep(3000);
				// }
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Hilo " + this.getName() + " finalizado");
		}
	}
}
