/*
 * Ejemplo desarrollado por Erick Navarro
 * Blog: e-navarro.blogspot.com
 * Septiembre - 2015
 */

package arbol;

import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una instrucción de asignación y que implementa
 * la interfaz de instrucción
 * @author Erick
 */
public class Asignacion implements Instruccion{
    /**
     * Identificador de la variable a la que se le asigna el valor.
     */
    private final LinkedList<String> id;
    /**
     * Valor que se le asigna a la variable.
     */
    private final Operacion valor;
    
    private LinkedList<Operacion> nums;
    /**
     * Constructor de la clase asignación
     * @param a identificador de la variable
     * @param b valor que se le va a asignar
     */
    public Asignacion(LinkedList<String> a, Operacion b) {
        this.id=a;
        this.valor=b;
    }
    public Asignacion(LinkedList<String> a, LinkedList<Operacion> b, Operacion c)
    {
        this.id=a;
        this.nums=b;
        this.valor=c;
    }
    /**
     * Método que ejecuta la accion de asignar un valor, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts tabla de símbolos del ámbito padre de la sentencia asignación
     * @return En este caso retorna nulo porque no es una sentencia que genere un valor.
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        for(String ids : id)
        {
            if(nums == null)
            {
                ts.setValor(ids,valor.ejecutar(ts), valor.getTipo());
            }
            else
            {
                LinkedList<Integer> l = new LinkedList<Integer>();
                for(Operacion op : nums)
                {
                    double num = (double)op.ejecutar(ts);
                    int n = (int) num;
                    l.add(n);
                }
                ts.setValor(ids, l, valor.ejecutar(ts), valor.getTipo());
            }
        }
        return null;
    }
    
}
