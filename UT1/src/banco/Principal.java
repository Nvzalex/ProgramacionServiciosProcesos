package banco;

public class Principal {
	public static void main(String[] args) {
		CuentaBancaria cuenta = new CuentaBancaria(500.0);
		CajeroAutomatico cajero = new CajeroAutomatico(cuenta, 150.0, 3);

		Thread h1 = new Thread(cajero, "Usuario 1");
		Thread h2 = new Thread(cajero, "Usuario 2");

		h1.start();
		h2.start();

		try {
			h1.join();
			h2.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		System.out.println("Saldo final en la cuenta: " + cuenta.getSaldoActual() + " €");
	}
}