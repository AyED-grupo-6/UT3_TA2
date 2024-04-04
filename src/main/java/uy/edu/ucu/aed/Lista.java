package uy.edu.ucu.aed;

public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        if (primero == null) {
            primero = new Nodo<T>(clave, dato);

        } else {
            Nodo actual = primero;

            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(new Nodo<T>(clave, dato));
        }
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public T buscar(Comparable clave) {
        if (primero == null) {
            return null;
        } else {
            {
                Nodo<T> actual = primero;
                while (actual != null) {
                    if (actual.compareTo(clave) == 0) {
                        return actual.getDato();
                    }
                    actual = actual.getSiguiente();
                }
                return null;
            }
            // throw new UnsupportedOperationException("Unimplemented method 'buscar'");
        }
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (this.primero.getEtiqueta().compareTo(clave) == 0) {
            this.primero = this.primero.getSiguiente();
            return true;
        } else {
            INodo previo = this.primero;
            INodo actual = this.primero.getSiguiente();
            while (actual.getEtiqueta().compareTo(clave) != 0 && actual != null) {
                previo = actual;
                actual = actual.getSiguiente();
            }
            if (actual != null) {
                previo.setSiguiente(actual.getSiguiente());
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String imprimir() {
        StringBuilder stringBuilder = new StringBuilder();
        Nodo actual = this.primero;
        while (actual != null) {
            stringBuilder.append(actual.imprimitAString());
        }
        return stringBuilder.toString();
    }

    @Override
    public String imprimir(String separador) {
        StringBuilder stringBuilder = new StringBuilder();
        Nodo actual = this.primero;
        while (actual != null) {
            stringBuilder.append(actual.imprimitAString() + separador);
        }
        return stringBuilder.toString();
    }

    @Override
    public int cantElementos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cantElementos'");
    }

    @Override
    public boolean esVacia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esVacia'");
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPrimero'");
    }

    // implementar los metodos indicados en la interfaz
}
