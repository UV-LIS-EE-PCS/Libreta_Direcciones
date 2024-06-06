package addressData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Representa una libreta de direcciones.
 * Contiene una lista de entradas de direcciones.
 * Permite agregar, eliminar y buscar entradas.
 */
public class AddressBook {

    private final List<AddressEntry> entries;

    /**
     * Constructor de la clase AddressBook.
     * Inicializa la lista de entradas de direcciones.
     */
    public AddressBook() {
        entries = new ArrayList<>();
    }

    /**
     * Agrega una entrada de direcciones a la libreta.
     * @param entry Entrada de direcciones a agregar.
     */
    public void agregarEntry(AddressEntry entry) {
        entries.add(entry);
    }

    /**
     * Elimina una entrada de direcciones de la libreta.
     * @param entry Entrada de direcciones a eliminar.
     */
    public void eliminarEntry(AddressEntry entry) {
        entries.remove(entry);
    }

    /**
     * Busca entradas de direcciones por apellido.
     * @param apellido Apellido de las entradas de direcciones a buscar.
     * @return Lista de entradas de direcciones que coinciden con el apellido.
     */
    public List<AddressEntry> buscarEntry(String apellido) {
        List<AddressEntry> coincidencias = new ArrayList<>();
        for (AddressEntry entry : entries) {
            if (entry.getApellido().toLowerCase().startsWith(apellido.toLowerCase())) {
                coincidencias.add(entry);
            }
        }
        return coincidencias;
    }

    /**
     * Carga las entradas de direcciones desde un archivo.
     * @param archivo Nombre del archivo que contiene las entradas de direcciones.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public void cargarDesdeArchivo(String archivo) throws IOException {
        File file = new File(archivo);

        if (!file.exists()) {
            System.out.println("No se encontró el archivo: " + archivo);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
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
                    agregarEntry(entry);
                } else {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                }
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
     * Muestra todas las entradas de direcciones ordenadas por apellido.
     */
    public void mostrarContactosOrdenados() {
        List<AddressEntry> copiaEntries = new ArrayList<>(entries);
        copiaEntries.sort(Comparator.comparing(AddressEntry::getApellido));

        for (AddressEntry entry : copiaEntries) {
            System.out.println(entry);
            System.out.println();
        }
    }
}
