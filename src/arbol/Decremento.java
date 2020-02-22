/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author bruno
 */
public class Decremento implements Instruccion{

    //Identificador de la variable que se va a decrementar.
    private final String id;

    /**
     * Constructor de la clase Decremento
     * @param id identificador de la variable que se va a decrementar
     */
    public Decremento(String id) {
        this.id = id;
    }
    
    /**
     * Metodo que ejecuta el decremento de una variables mediante el decremento
     * postfijo, por lo tanto decrementa la variable en 1 y retorna el valor antiguo.
     * @param ts tabla de símbolos del ámbito padre de la sentencia asignación.
     * @return el valor anterior al decremento.
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        Object tmp = ts.getValor(id.toString());
        ts.setValor(id,((Double)tmp - 1));
        return tmp;
    }   
}
