/*
 * Ejemplo desarrollado por Erick Navarro
 * Blog: e-navarro.blogspot.com
 * Septiembre - 2015
 */

package arbol;

/**
 * Clase que ejecuta las acciones de una instrucción imprimir y que implementa
 * la interfaz de instrucción
 * @author Erick
 */
public class Imprimir implements Instruccion{
    /**
     * Contenido que será impreso al ejecutar la instrucción imprimir, este debe
     * ser una instrucción que genere un valor al ser ejecutada.
     */
    private final Instruccion contenido;
    /**
     * Constructor de la clase imprimir
     * @param contenido contenido que será impreso al ejecutar la instrucción
     */
    public Imprimir(Instruccion contenido) {
        this.contenido = contenido;
    }
    /**
     * Método que ejecuta la accion de imprimir un valor, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts Tabla de símbolos del ámbito padre de la sentencia.
     * @return Esta instrucción retorna nulo porque no produce ningun valor al ser
     * ejecutada.
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        System.out.println(contenido.ejecutar(ts).toString());
        return null;
    }
    
}
