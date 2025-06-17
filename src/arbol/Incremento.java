/*
 * Ejemplo desarrollado por Erick Navarro
 * GitHub Page: ericknavarro.github.io
 * Septiembre - 2015
 */
package arbol;

/**
 * Clase que representa una instrucción de incremento postfijo.
 * Implementa la interfaz Instruccion y permite aumentar en uno
 * el valor de una variable existente en la tabla de símbolos.
 * <p>
 * Por ejemplo, para la instrucción: x++, se retorna el valor
 * actual de x y luego se incrementa su valor en 1.
 *
 * @author Bruno Coronado
 */
public class Incremento implements Instruccion {

    /**
     * Identificador de la variable que se va a incrementar.
     */
    private final String id;

    /**
     * Constructor de la clase Incremento.
     *
     * @param id identificador de la variable que se va a incrementar.
     */
    public Incremento(String id) {
        this.id = id;
    }

    /**
     * Ejecuta el incremento de una variable usando notación postfija.
     * Incrementa en 1 el valor actual de la variable y retorna su valor previo.
     *
     * @param ts tabla de símbolos del ámbito actual.
     * @return el valor anterior al incremento.
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        Object tmp = ts.getValor(id.toString());
        ts.setValor(id, ((Double) tmp + 1));
        return tmp;
    }
}
