package inetAddress;

import java.net.InetAddress;

public class EjeminetAddress {
	public static void main(String[] args) {
		String[] ia = {"ED09012096X046","www.google.es"};

		for (int i = 0; i <= ia.length; i++) {
			try {

				System.out.println("Metodo getByName: " + ia[0]);
				System.out.println("Metodo getLocalHost: " + InetAddress.getLocalHost());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}
	}
}
