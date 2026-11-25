package banco;

public class CuentaBancaria {
	private double saldo;

	public CuentaBancaria(double saldo) {
		this.saldo = saldo;
	}

	public synchronized double getSaldoActual() {
		return saldo;
	}

	public synchronized void retirarDinero(double importe) {
		String usuario = Thread.currentThread().getName();
		System.out.println(usuario + " intenta retirar " + importe + " €. Saldo actual: " + saldo + " €");

		if (saldo >= importe) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

			saldo -= importe;
			System.out.println("  -> " + usuario + " retiró " + importe + " €. Nuevo saldo: " + saldo + " €");
		} else {
			System.out.println("  -> Saldo insuficiente para " + usuario + ". Se mantiene en: " + saldo + " €");
		}
	}
}