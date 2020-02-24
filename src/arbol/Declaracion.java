/*
 * Ejemplo desarrollado por Erick Navarro
 * Blog: e-navarro.blogspot.com
 * Septiembre - 2015
 */

package arbol;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una instrucción de declaración y que implementa
 * la interfaz de instrucción
 * @author Erick
 */
public class Declaracion implements Instruccion{
    /**
     * Identificador de la variable que será declarada.
     */
    private final LinkedList<String> id;
    /**
     * Tipo de la variable que será declarada.
     */
    Simbolo.Tipo tipo;
    private LinkedList<Operacion> nums;
    /**
     * Constructor de la clase
     * @param a Identificador de la variable que será declarada
     * @param t Tipo de la clase que será declarada
     */
    public Declaracion(LinkedList<String> a, String t) {
        id=a;
        this.tipo = obtenerTipo(t);
    }
    
    public Declaracion(LinkedList<String> a, LinkedList<Operacion> b, String t)
    {
        id=a;
        nums=b;
        this.tipo = obtenerTipo(t);
    }
    
    
    public Simbolo.Tipo obtenerTipo(String t)
    {
        switch(t)
        {
            case "int":
                return Simbolo.Tipo.INT;
            case "string":
                return Simbolo.Tipo.STRING;
            case "bool":
                return Simbolo.Tipo.BOOL;
            case "char":
                return Simbolo.Tipo.CHAR;
            default:
                System.out.println("Error interno, tipo de dato erroneo.");
                return null;
        } 
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
        for(String ids : id)
        {   
            if(nums == null)
            {
                ts.put(ids,new Simbolo(tipo));
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
                ts.put(ids,new Simbolo(tipo,l));
            }
        }
        return null;
    }
    
}
