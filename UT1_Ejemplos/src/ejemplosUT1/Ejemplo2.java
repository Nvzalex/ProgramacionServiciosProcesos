package ejemplosUT1;

import java.io.*;

public class Ejemplo2 {

	public static void main(String[] args) {

		String linea= "";
		ProcessBuilder pb = new ProcessBuilder("cmd","/c", "dir");
		Process p= null;
	
		try {
			p = pb.start();
			//Lee el stream de salida del proceso, lo que generó en consola
			InputStream salidaComando = p.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader (salidaComando));
			linea = buffer.readLine();
			while(linea != null) {
				System.out.println(linea);
				linea = buffer.readLine();
			}
			buffer.close();
			
		}catch (Exception e) {
			System.out.println("Error en: " + pb.command());
			e.printStackTrace();
		}			
	}
}
