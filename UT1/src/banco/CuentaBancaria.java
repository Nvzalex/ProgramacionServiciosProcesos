package banco;

public class CuentaBancaria {
	private double saldo;
	
	private CuentaBancaria(double saldo) {
		this.saldo=saldo;
	}
	
	public  double getSaldoActual() {
		return saldo;
	}
	
	private void retirarDinero(double importe) {
		if (saldo >= importe) {
			
		}
	}
}
