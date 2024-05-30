package addressData;

/**
 * Contiene la clase AddressEntry, que representa una entrada de la libreta de direcciones.
 */
public class AddressEntry {
    /**
     * Variables de clase que representan los campos de una entrada de la libreta de direcciones.
     */
    private String nombre;
    private String apellido;
    private String calle;
    private String ciudad;
    private String estado;
    private String codigoPostal;
    private String correoElectronico;
    private String telefono;

    /**
     * Constructor de la clase AddressEntry.
     * @param nombre
     * @param apellido
     * @param calle
     * @param ciudad
     * @param estado
     * @param codigoPostal
     * @param correoElectronico
     * @param telefono
     */
    public AddressEntry(String nombre, String apellido, String calle, String ciudad,
                        String estado, String codigoPostal, String correoElectronico,
                        String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
    }

    /**
     * Método que devuelve una cadena con los datos de la entrada.
     * @return Cadena con los datos de la entrada.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece el nombre de la entrada.
     * @param nombre Nombre de la entrada.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve el apellido de la entrada.
     * @return Apellido de la entrada.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Método que establece el apellido de la entrada.
     * @param apellido Apellido de la entrada.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Método que devuelve la calle de la entrada.
     * @return Calle de la entrada.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Método que establece la calle de la entrada.
     * @param calle Calle de la entrada.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Método que devuelve la ciudad de la entrada.
     * @return Ciudad de la entrada.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Método que establece la ciudad de la entrada.
     * @param ciudad Ciudad de la entrada.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Método que devuelve el estado de la entrada.
     * @return Estado de la entrada.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método que establece el estado de la entrada.
     * @param estado Estado de la entrada.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método que devuelve el código postal de la entrada.
     * @return Código postal de la entrada.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Método que establece el código postal de la entrada.
     * @param codigoPostal Código postal de la entrada.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Método que devuelve el correo electrónico de la entrada.
     * @return Correo electrónico de la entrada.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Método que establece el correo electrónico de la entrada.
     * @param correoElectronico Correo electrónico de la entrada.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Método que devuelve el teléfono de la entrada.
     * @return Teléfono de la entrada.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método que establece el teléfono de la entrada.
     * @param telefono Teléfono de la entrada.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método que devuelve una cadena con los datos de la entrada.
     * @return Cadena con los datos de la entrada.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nApellido: " + apellido +
                "\nCalle: " + calle +
                "\nCiudad: " + ciudad +
                "\nEstado: " + estado +
                "\nCódigo Postal: " + codigoPostal +
                "\nCorreo Electrónico: " + correoElectronico +
                "\nTeléfono: " + telefono;
    }
}
