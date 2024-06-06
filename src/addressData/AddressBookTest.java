package addressData;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;


class AddressBookTest {

    private AddressBook addressBook;

    @BeforeEach
    void setUp() {
        // Se crea una instancia de la libreta de direcciones para cada prueba
        addressBook = new AddressBook();
    }

    @Test
    void testAgregarEntry() {
        // Primera prueba: Agregar una entrada
        AddressEntry entry1 = new AddressEntry("Diego", "Dominguez", "Alamo", "Coatzacoalcos", "Veracruz", "96590", "diegodgz.182@gmail.com", "9211688116");
        addressBook.agregarEntry(entry1);
        assertEquals(1, addressBook.getEntries().size());

        // Segunda prueba: Agregar otra entrada
        AddressEntry entry2 = new AddressEntry("Rafa", "Sandoval", "Quevedo", "Coatzacoalcos", "Veracruz", "96520", "rafa@gmail.com", "9211688182");
        addressBook.agregarEntry(entry2);
        assertEquals(2, addressBook.getEntries().size());
    }

    @Test
    void testEliminarEntry() {
        // Primera prueba: Eliminar una entrada
        AddressEntry entry1 = new AddressEntry("Diego", "Dominguez", "Alamo", "Coatzacoalcos", "Veracruz", "96590", "diegodgz.182@gmail.com", "9211688116");
        addressBook.agregarEntry(entry1);
        addressBook.eliminarEntry(entry1);
        assertTrue(addressBook.getEntries().isEmpty());

        // Segunda prueba: Intentar eliminar una entrada que no existe
        AddressEntry entry2 = new AddressEntry("Rafa", "Sandoval", "Quevedo", "Coatzacoalcos", "Veracruz", "96520", "rafa@gmail.com", "9211688182");
        assertDoesNotThrow(() -> addressBook.eliminarEntry(entry2)); // No debería lanzar excepción
    }

    @Test
    void testBuscarEntry() {
        // Añadir algunas entradas para la prueba de búsqueda
        AddressEntry entry1 = new AddressEntry("Diego", "Dominguez", "Alamo", "Coatzacoalcos", "Veracruz", "96590", "diegodgz.182@gmail.com", "9211688116");
        AddressEntry entry2 = new AddressEntry("Rafa", "Sandoval", "Quevedo", "Coatzacoalcos", "Veracruz", "96520", "rafa@gmail.com", "9211688182");
        addressBook.agregarEntry(entry1);
        addressBook.agregarEntry(entry2);

        // Búsqueda por apellido parcial "Dom"
        List<AddressEntry> foundEntries = addressBook.buscarEntry("Dom");
        assertNotNull(foundEntries);
        assertFalse(foundEntries.isEmpty());
        assertEquals("Dominguez", foundEntries.get(0).getApellido());
    }

    @Test
    void testCargarDesdeArchivo() {
        String archivo1 = "test1.txt";
        assertDoesNotThrow(() -> addressBook.cargarDesdeArchivo(archivo1));
        assertFalse(addressBook.getEntries().isEmpty());

        String archivo2 = "test2.txt";
        assertDoesNotThrow(() -> addressBook.cargarDesdeArchivo(archivo2));
        assertFalse(addressBook.getEntries().isEmpty());
    }

    @Test
    void testMostrarContactosOrdenados() {
        // Primera prueba: Mostrar contactos ordenados con una entrada
        AddressEntry entry1 = new AddressEntry("Diego", "Dominguez", "Alamo", "Coatzacoalcos", "Veracruz", "96590", "diegodgz.182@gmail.com", "9211688116");
        addressBook.agregarEntry(entry1);
        assertDoesNotThrow(() -> addressBook.mostrarContactosOrdenados());

        // Segunda prueba: Mostrar contactos ordenados con múltiples entradas
        AddressEntry entry2 = new AddressEntry("Rafa", "Sandoval", "Quevedo", "Coatzacoalcos", "Veracruz", "96520", "rafa@gmail.com", "9211688182");
        addressBook.agregarEntry(entry2);
        assertDoesNotThrow(() -> addressBook.mostrarContactosOrdenados());
    }
}
