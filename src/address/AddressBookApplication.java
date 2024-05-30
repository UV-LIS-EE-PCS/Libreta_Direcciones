package address;

import java.io.IOException;

/**
 * Contiene la clase principal del programa.
 */
public class AddressBookApplication {

    /**
     * Método principal del programa, que crea una instancia del objeto Menu y llama al método displayMenu() de este último.
     * @param args Argumentos de la línea de comando.
     */
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.displayMenu();
    }
}
