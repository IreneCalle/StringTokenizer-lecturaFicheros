import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class OpcionesAgenda {

	public static void escribeContacto() {
		try (BufferedWriter fichero = new BufferedWriter(new FileWriter("Contactos.TXT", true))) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("introduce un nombre");
				String nombre = sc.nextLine();
				System.out.println("introduce un telefono");
				String telefono = sc.nextLine();
				fichero.write(nombre + "@" + telefono);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fichero.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	public static void leeContacto() {

		Scanner sc = new Scanner(System.in);
		System.out.println("escribe el nombre que deseas buscar");
		String nombre = sc.nextLine();

		try {
			FileReader entrada = new FileReader("Contactos.txt");
			BufferedReader mibuffer = new BufferedReader(entrada);
			String linea = "";
			while (linea != null) {
				linea = mibuffer.readLine();
				if (linea.contains(nombre)) {
					StringTokenizer st = new StringTokenizer(linea, "@");
					while (st.hasMoreTokens()) {
						System.out.print(st.nextToken() + " ");
					}
					entrada.close();
				}
			}
		} catch (IOException e) {
			System.out.println(" ");
		}

	}

	public static void mostrarAgenda() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Esta es tu agenda");

		try {
			FileReader entrada = new FileReader("Contactos.txt");
			BufferedReader mibuffer = new BufferedReader(entrada);
			String linea = "";
			while (linea != null) {
				linea = mibuffer.readLine();
				if (linea.contains("@")) {

					StringTokenizer st = new StringTokenizer(linea, "@");
					while (st.hasMoreTokens()) {

						for (int i = 0; st.hasMoreTokens(); i++) {

							if (i % 2 != 1 && st.hasMoreTokens()) {
								System.out.print("Nombre: " + (st.nextToken() + " "));
							}
							if (i % 2 == 1) {
								System.out.print("Telefono: " + (st.nextToken() + " "));
								System.out.println("");
							}
						}

					}
					entrada.close();
				}
			}
		} catch (IOException e) {
			System.out.println(" ");
		}

	}
}
