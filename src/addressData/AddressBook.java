package addressData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Representa una libreta de direcciones.
 * Contiene una lista de entradas de direcciones.
 * Permite agregar, eliminar y buscar entradas.
 */
public class AddressBook {

    /**
     * Lista de entradas de direcciones.
     * Se utiliza para almacenar las entradas de direcciones.
     * Se utiliza un ArrayList porque es una estructura de datos dinámica.
     */
    private final List<AddressEntry> entries;

    /**
     * Constructor de la clase AddressBook.
     * Inicializa la lista de entradas de direcciones.
     */

    public AddressBook() {
        entries = new ArrayList<>();
    }

    /**
     * Carga las entradas de direcciones desde un archivo.
     * @param archivo Nombre del archivo que contiene las entradas de direcciones.
     * @param entry Entrada de direcciones a agregar.
     */
    public void agregarEntry(AddressEntry entry) {
        entries.add(entry);
    }

    /**
     * Elimina una entrada de direcciones.
     * @param entry Entrada de direcciones a eliminar.
     */
    public void eliminarEntry(AddressEntry entry) {
        entries.remove(entry);
    }

    /**
     * Busca una entrada de direcciones por nombre.
     * @param nombre Nombre de la entrada de direcciones a buscar.
     * @return La entrada de direcciones encontrada, o null si no se encontró.
     */
    public AddressEntry buscarEntry(String nombre) {
        for (AddressEntry entry : entries) {
            if (entry.getNombre().equalsIgnoreCase(nombre)) {
                return entry;
            }
        }
        return null;
    }

    /**
     * Busca una entrada de direcciones por apellido.
     * @param apellido Apellido de la entrada de direcciones a buscar.
     * @return La entrada de direcciones encontrada, o null si no se encontró
     */
    public void cargarDesdeArchivo(String archivo) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resourceUrl = classLoader.getResource(archivo);

        if (resourceUrl == null) {
            System.out.println("No se encontró el archivo: " + archivo);
            return;
        }
        File file = new File(resourceUrl.getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;
        while ((linea = br.readLine()) != null) {
            // Formato esperado: nombre,apellido,calle,ciudad,estado,codigoPostal,correoElectronico,telefono
            String[] campos = linea.split(",");
            if (campos.length == 8) {
                String nombre = campos[0].trim();
                String apellido = campos[1].trim();
                String calle = campos[2].trim();
                String ciudad = campos[3].trim();
                String estado = campos[4].trim();
                String codigoPostal = campos[5].trim();
                String correoElectronico = campos[6].trim();
                String telefono = campos[7].trim();

                AddressEntry entry = new AddressEntry(nombre, apellido, calle, ciudad, estado,
                        codigoPostal, correoElectronico, telefono);
                entries.add(entry);
            }
        }
    }

    /**
     * Devuelve la lista de entradas de direcciones.
     * @return Lista de entradas de direcciones.
     */

    public List<AddressEntry> getEntries() {
        return entries;
    }

    /**
     * Muestra todas las entradas de direcciones.
     * Muestra todas las entradas de direcciones en el orden en que se agregaron.
     */
    public void mostrarContactosOrdenados() {
        List<AddressEntry> copiaEntries = new ArrayList<>(entries);
        copiaEntries.sort(Comparator.comparing(AddressEntry::getApellido));

        for (AddressEntry entry : copiaEntries) {
            System.out.println(entry);
        }
    }
}
