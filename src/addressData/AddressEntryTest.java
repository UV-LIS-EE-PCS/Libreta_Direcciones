package addressData;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import addressData.AddressEntry;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressEntryTest {

    @Test
    void testAddressEntry() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "City", "State", "12345", "john@example.com", "1234567890");
        assertNotNull(entry);
        assertEquals("John", entry.getNombre());
        assertEquals("Doe", entry.getApellido());
        assertEquals("123 Main St", entry.getCalle());
        assertEquals("City", entry.getCiudad());
        assertEquals("State", entry.getEstado());
        assertEquals("12345", entry.getCodigoPostal());
        assertEquals("john@example.com", entry.getCorreoElectronico());
        assertEquals("1234567890", entry.getTelefono());
    }

    @Test
    void testToString() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "City", "State", "12345", "john@example.com", "1234567890");
        String expected = "Nombre: John\nApellido: Doe\nCalle: 123 Main St\nCiudad: City\nEstado: State\nCódigo Postal: 12345\nCorreo Electrónico: john@example.com\nTeléfono: 1234567890";
        assertEquals(expected, entry.toString());
    }

    @Test
    void testSetters() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "City", "State", "12345", "john@example.com", "1234567890");
        entry.setNombre("Jane");
        entry.setApellido("Smith");
        entry.setCalle("456 Elm St");
        entry.setCiudad("Town");
        entry.setEstado("Another State");
        entry.setCodigoPostal("54321");
        entry.setCorreoElectronico("jane@example.com");
        entry.setTelefono("9876543210");

        assertEquals("Jane", entry.getNombre());
        assertEquals("Smith", entry.getApellido());
        assertEquals("456 Elm St", entry.getCalle());
        assertEquals("Town", entry.getCiudad());
        assertEquals("Another State", entry.getEstado());
        assertEquals("54321", entry.getCodigoPostal());
        assertEquals("jane@example.com", entry.getCorreoElectronico());
        assertEquals("9876543210", entry.getTelefono());
    }
}
