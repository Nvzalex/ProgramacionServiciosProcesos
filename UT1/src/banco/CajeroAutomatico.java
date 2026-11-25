package banco;

public class CajeroAutomatico implements Runnable {
	private final CuentaBancaria cuenta;
	private final double importePorRetiro;
	private final int numeroIntentos;

	public CajeroAutomatico(CuentaBancaria cuenta, double importePorRetiro, int numeroIntentos) {
		this.cuenta = cuenta;
		this.importePorRetiro = importePorRetiro;
		this.numeroIntentos = numeroIntentos;
	}

	@Override
	public void run() {
		for (int i = 0; i < numeroIntentos; i++) {
			cuenta.retirarDinero(importePorRetiro);
		}
	}
}