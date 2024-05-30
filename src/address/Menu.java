package address;


import addressData.AddressBook;
import addressData.AddressEntry;
import java.io.IOException;
import java.util.Scanner;

/**
 * Contiene la clase principal del programa.
 */
public class Menu {
    private final AddressBook addressBook;
    private final Scanner scanner;

    /**
     * Constructor de la clase Menu.
     * Crea una instancia del objeto AddressBook y una del objeto Scanner.
     */
    public Menu() {
        addressBook = new AddressBook();
        scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal del programa y solicita al usuario que ingrese una opción.
     * Ejecuta la opción seleccionada por el usuario.
     * @throws IOException Si ocurre un error al cargar las entradas desde un archivo.
     */
    public void displayMenu() throws IOException {
        boolean exit = false;
        while (!exit) {
            System.out.println("------ Menú ------");
            System.out.println("a) Cargar entradas desde un archivo.");
            System.out.println("b) Agregar una nueva entrada.");
            System.out.println("c) Eliminar una entrada.");
            System.out.println("d) Buscar entradas por apellido.");
            System.out.println("e) Mostrar todas las entradas ordenadas por apellido.");
            System.out.println("f) Salir.");
            System.out.print("Ingresa la opción deseada: ");
            String option = scanner.nextLine().toLowerCase();

            switch (option) {
                case "a" -> {
                    System.out.print("Ingresa el nombre del archivo: ");
                    String archivo = scanner.nextLine();
                    addressBook.cargarDesdeArchivo(archivo); // Carga las entradas desde el archivo especificado
                    System.out.println("¡Las entradas se cargaron correctamente!");
                }
                case "b" -> {
                    System.out.println("---- Agregar una nueva entrada ----");
                    // Solicita los datos de la nueva entrada al usuario
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Calle: ");
                    String calle = scanner.nextLine();
                    System.out.print("Ciudad: ");
                    String ciudad = scanner.nextLine();
                    System.out.print("Estado: ");
                    String estado = scanner.nextLine();
                    System.out.print("Código Postal: ");
                    String codigoPostal = scanner.nextLine();
                    System.out.print("Correo Electrónico: ");
                    String correoElectronico = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();

                    // Crea una nueva entrada con los datos proporcionados y la agrega a la libreta de direcciones
                    AddressEntry newEntry = new AddressEntry(nombre, apellido, calle, ciudad, estado,
                            codigoPostal, correoElectronico, telefono);
                    addressBook.agregarEntry(newEntry);
                    System.out.println("¡La entrada se agregó correctamente!");
                }
                case "c" -> {
                    System.out.println("---- Eliminar una entrada ----");
                    System.out.print("Ingresa el apellido de la entrada a eliminar: ");
                    String apellidoEliminar = scanner.nextLine();
                    // Busca la entrada con el apellido especificado y la elimina si existe
                    AddressEntry entryEliminar = addressBook.buscarEntry(apellidoEliminar);
                    if (entryEliminar != null) {
                        addressBook.eliminarEntry(entryEliminar);
                        System.out.println("¡La entrada se eliminó correctamente!");
                    } else {
                        System.out.println("No se encontró ninguna entrada con ese apellido.");
                    }
                }
                case "d" -> {
                    System.out.println("---- Buscar entradas por apellido ----");
                    System.out.print("Ingresa el inicio del apellido a buscar: ");
                    String inicioApellido = scanner.nextLine();
                    buscarEntradasPorApellido(inicioApellido); // Busca las entradas que coinciden con el inicio del apellido especificado
                }
                case "e" -> {
                    System.out.println("---- Mostrar todas las entradas ordenadas por apellido ----");
                    addressBook.mostrarContactosOrdenados(); // Muestra todas las entradas ordenadas por apellido
                }
                case "f" -> {
                    exit = true;
                    System.out.println("¡Hasta luego!");
                }
                default -> System.out.println("Opción inválida. Ingresa una opción válida (a-f).");
            }
            System.out.println();
        }
    }

    /**
     * Busca las entradas que coinciden con el inicio del apellido especificado.
     * @param inicioApellido El inicio del apellido a buscar.
     */
    private void buscarEntradasPorApellido(String inicioApellido) {
        System.out.println("---- Resultados de búsqueda ----");
        boolean encontradas = false;
        // Itera sobre las entradas en la libreta de direcciones y muestra las que coinciden con el inicio del apellido especificado
        for (AddressEntry entry : addressBook.getEntries()) {
            if (entry.getApellido().toLowerCase().startsWith(inicioApellido.toLowerCase())) {
                System.out.println(entry);
                encontradas = true;
            }
        }
        // Muestra un mensaje si no se encontraron entradas que coincidan con el inicio del apellido
        if (!encontradas) {
            System.out.println("No se encontraron entradas que coincidan con el inicio del apellido ingresado.");
        }
    }

    /**
     * Método principal del programa.
     * @param args Los argumentos de la línea de comandos.
     * @throws IOException Si ocurre un error al cargar las entradas desde un archivo.
     */
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.displayMenu(); // Inicia la aplicación mostrando el menú
    }
}
