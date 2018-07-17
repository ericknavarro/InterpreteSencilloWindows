/*
 * Ejemplo desarrollado por Erick Navarro
 * Blog: e-navarro.blogspot.com
 * Septiembre - 2015
 */

package arbol;

/**
 * Interfaz que implementan todas las clases que son instrucción y que contiene 
 * todas las acciones (métodos) que pueden realizar todas las instrucciones, en 
 * este caso, todas las instrucciones pueden ser ejecutadas, por lo que todas las
 * clases que implementen esta interfaz están obligadas a tener un método programado
 * para la ejecución.
 * @author Erick
 */
public interface Instruccion {
    /**
     * Método que ejecuta la accion propia de la instrucción que se implemente.
     * @param ts Tabla de símbolos del ámbito padre de la sentencia.
     * @return Retorna nulo cuando la sentencia no produce valor al ser ejecutada, 
     * pero cuando se trata de una operación aritmética, una concatenación o una 
     * operación relacional, entonces se devuelve el valor que la operación da como 
     * resultado.
     */
    public Object ejecutar(TablaDeSimbolos ts);
}
