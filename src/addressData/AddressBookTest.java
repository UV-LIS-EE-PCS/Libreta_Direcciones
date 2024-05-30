package addressData;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
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
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Main St", "City", "State", "12345", "john@example.com", "1234567890");
        addressBook.agregarEntry(entry1);
        assertEquals(1, addressBook.getEntries().size());

        // Segunda prueba: Agregar otra entrada
        AddressEntry entry2 = new AddressEntry("Jane", "Smith", "456 Elm St", "Town", "State", "54321", "jane@example.com", "9876543210");
        addressBook.agregarEntry(entry2);
        assertEquals(2, addressBook.getEntries().size());
    }

    @Test
    void testEliminarEntry() {
        // Primera prueba: Eliminar una entrada
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Main St", "City", "State", "12345", "john@example.com", "1234567890");
        addressBook.agregarEntry(entry1);
        addressBook.eliminarEntry(entry1);
        assertTrue(addressBook.getEntries().isEmpty());

        // Segunda prueba: Intentar eliminar una entrada que no existe
        AddressEntry entry2 = new AddressEntry("Jane", "Smith", "456 Elm St", "Town", "State", "54321", "jane@example.com", "9876543210");
        assertDoesNotThrow(() -> addressBook.eliminarEntry(entry2)); // No debería lanzar excepción
    }

    @Test
    void testBuscarEntry() {
        List<AddressEntry> foundEntries = addressBook.buscarEntry("Doe");
        assertNotNull(foundEntries);
        assertEquals(1, foundEntries.size());
        assertEquals("John", foundEntries.get(0).getNombre());
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
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Main St", "City", "State", "12345", "john@example.com", "1234567890");
        addressBook.agregarEntry(entry1);
        assertDoesNotThrow(() -> addressBook.mostrarContactosOrdenados());

        // Segunda prueba: Mostrar contactos ordenados con múltiples entradas
        AddressEntry entry2 = new AddressEntry("Jane", "Smith", "456 Elm St", "Town", "State", "54321", "jane@example.com", "9876543210");
        addressBook.agregarEntry(entry2);
        assertDoesNotThrow(() -> addressBook.mostrarContactosOrdenados());
    }
}
