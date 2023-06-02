import java.util.Scanner;

public class MainAgenda {

	public static void main(String[] args) {
		int opcion;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(
					"Bienvenido a a tu agenda. Por favor, pulsa la tecla correspondiente para seleccionar una opcion:");
			System.out.println("1. Introducir un nuevo contacto");
			System.out.println("2. Buscar contacto por nombre");
			System.out.println("3. Mostrar toda la agenda");

			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				OpcionesAgenda.escribeContacto();
				break;
			case 2:
				OpcionesAgenda.leeContacto();
			case 3:
				OpcionesAgenda.mostrarAgenda();
				break;

			case 4:
				System.exit(0);
				break;
			}

		} while (opcion != 6);
	}

}
