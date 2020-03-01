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
public class Incremento implements Instruccion {

    //Identificador de la variable que se va a incrementar.
    private final String id;

    /**
     * Constructor de la clase Incremento
     * @param id identificador de la variable que se va a incrementar
     */
    public Incremento(String id) {
        this.id = id;
    }
    
    
    /**
     * Metodo que ejecuta el incremento de una variables mediante el incremento
     * postfijo, por lo tanto incrementa la variable en 1 y retorna el valor antiguo.
     * @param ts tabla de símbolos del ámbito padre de la sentencia asignación.
     * @return el valor anterior al incremento.
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        Object tmp = ts.getValor(id.toString());
        ts.setValor(id,((Double)tmp + 1));
        return tmp;
    }   
}
