/*
 * Ejemplo desarrollado por Erick Navarro
 * GitHub Page: ericknavarro.github.io
 * Septiembre - 2015
 */

package arbol;

/**
 * Clase que representa una instrucción de decremento postfijo.
 * Implementa la interfaz Instruccion y permite disminuir en uno
 * el valor de una variable existente en la tabla de símbolos.
 * <p>
 * Por ejemplo, para la instrucción: x--, se retorna el valor
 * actual de x y luego se decrementa su valor en 1.
 *
 * @author Bruno Coronado
 */
public class Decremento implements Instruccion {

    /**
     * Identificador de la variable que se va a decrementar.
     */
    private final String id;

    /**
     * Constructor de la clase Decremento.
     *
     * @param id identificador de la variable que se va a decrementar.
     */
    public Decremento(String id) {
        this.id = id;
    }

    /**
     * Ejecuta el decremento de una variable usando notación postfija.
     * Decrementa en 1 el valor actual de la variable y retorna su valor previo.
     *
     * @param ts tabla de símbolos del ámbito actual.
     * @return el valor anterior al decremento.
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        Object tmp = ts.getValor(id.toString());
        ts.setValor(id, ((Double) tmp - 1));
        return tmp;
    }
}
