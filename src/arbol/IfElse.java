/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

import java.util.LinkedList;

/**
 *
 * @author josef
 */
public class IfElse implements Instruccion{
    private Instruccion listaInstruccion;
    private LinkedList<Instruccion> listaInstrucciones;
    
    
    public IfElse(Instruccion a)
    {
        listaInstruccion = a;
    }
    
    public IfElse(LinkedList<Instruccion> a)
    {
        listaInstrucciones = a;
    }
    
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        if(listaInstruccion != null)
        {
            listaInstruccion.ejecutar(ts);
        }else if(listaInstrucciones != null)
        {
            TablaDeSimbolos tablaLocal=new TablaDeSimbolos(ts);
            for(Instruccion in: listaInstrucciones){
                in.ejecutar(tablaLocal);
            }
        }
        return null;
    }
}
