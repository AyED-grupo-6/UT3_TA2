package uy.edu.ucu.aed;

public class Almacen implements IAlmacen {
    private String direccion;
    private String telefono;
    private Lista<IProducto> listaProductos;
    private String nombre;

    public String getDireccion() {
        return this.direccion;
    };

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    };

    public String getTelefono() {
        return this.telefono;
    };

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    };

    public String getNombre() {
        return this.nombre;
    };

    public Lista<IProducto> getListaProductos() {
        return this.listaProductos;
    };

    public long obtenerValorStock() {
        return 0;
    }

    /**
     * Incorporar un nuevo producto al supermercado.
     *
     * @param unProducto
     */
    public void insertarProducto(IProducto unProducto) {
        this.listaProductos.insertar(unProducto, unProducto.getCodProducto());
    };

    /**
     * Eliminar productos que ya no se venden (por no ser comercializados m�s).
     *
     * @param clave
     * @return
     */
    public boolean eliminarProducto(Comparable codProducto) {
        try {
            this.listaProductos.eliminar(codProducto);
            return true;
        } catch (Exception e) {
            return false;
        }
    };

    /**
     * Imprime la lista de productos
     *
     * @return
     */
    public String imprimirProductos() {
        return this.listaProductos.imprimir();
    };

    /**
     * Dado un separador ej.:",", ";", imprime los productos separados por tal
     * caracter
     *
     * @param separador
     * @return
     */
    public String imprimirSeparador(String separador) {
        return this.listaProductos.imprimir(separador);
    };

    /**
     * Agregar stock a un producto existente.
     *
     * @param clave
     * @param cantidad
     * @return
     */
    public Boolean agregarStock(Comparable codProducto, Integer cantidad) {
        try {
            this.listaProductos.buscar(codProducto).agregarCantidadStock(cantidad);
            return true;
        } catch (Exception e) {
            return false;
        }
    };

    /**
     * Simular la venta de un producto (reducir el stock de un producto
     * existente
     *
     * @param clave
     * @param cantidad
     * @return
     */
    public Integer restarStock(Comparable codProducto, Integer cantidad) {
        try {
            int cantidadPrevia = this.listaProductos.buscar(codProducto).getStock();
            if (cantidadPrevia - cantidad < 0) {
                throw new Exception("");
            }
            this.listaProductos.buscar(codProducto).restarCantidadStock(cantidad);
            return cantidadPrevia - cantidad;
        } catch (Exception e) {
            return null;
        }
    };

    /**
     * Dado un código de producto, indicar las existencias del mismo en el
     * almac�n.
     *
     * @param clave
     * @return
     */
    public IProducto buscarPorCodigo(Comparable codProducto) {
        return this.listaProductos.buscar(codProducto);
    };

    /**
     * Listar todos los productos registrados, ordenados por nombre, presentando
     * adem�s su stock. Imprime por consola la lista de todos los productos
     * registrados y su stock actual.
     */
    public void listarOrdenadoPorNombre() {
    };

    /**
     * Busca un producto por su descripci�n.
     *
     * @param descripcion
     * @return
     */
    public IProducto buscarPorDescripcion(String descripcion) {
        return null;
    };

    /**
     * Retorna el tama�o del almacen: cantidad de productos. No es lo mismo que
     * el total de stock, sino que ser�a en definitiva el tama�o de la lista.
     *
     * @return
     */
    public int cantidadProductos() {
        return 0;
    };
}
