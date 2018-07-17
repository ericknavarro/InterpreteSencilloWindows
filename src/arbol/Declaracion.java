/*
 * Ejemplo desarrollado por Erick Navarro
 * Blog: e-navarro.blogspot.com
 * Septiembre - 2015
 */

package arbol;

/**
 * Clase que ejecuta las acciones de una instrucción de declaración y que implementa
 * la interfaz de instrucción
 * @author Erick
 */
public class Declaracion implements Instruccion{
    /**
     * Identificador de la variable que será declarada.
     */
    private final String id;
    /**
     * Tipo de la variable que será declarada.
     */
    Simbolo.Tipo tipo;
    /**
     * Constructor de la clase
     * @param a Identificador de la variable que será declarada
     * @param t Tipo de la clase que será declarada
     */
    public Declaracion(String a, Simbolo.Tipo t) {
        id=a;
        tipo=t;
    }
    /**
     * Método que ejecuta la accion de declarar una variable, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts Tabla de símbolos del ámbito padre.
     * @return No retorna nada porque no es una sentencia que genere un valor.
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        ts.add(new Simbolo(id,tipo));
        return null;
    }
    
}
