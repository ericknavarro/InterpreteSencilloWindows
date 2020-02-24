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
public class For implements Instruccion{
    private final Instruccion declarasignacion;
    private final Operacion condicion;
    private final LinkedList<Instruccion> listaInstrucciones;
    private final Instruccion cambio;
    
    public For(Instruccion c, Operacion a, LinkedList<Instruccion> b, Instruccion d)
        {
            declarasignacion = c;
            condicion = a;
            listaInstrucciones = b;
            cambio = d;
        }
    public Object ejecutar(TablaDeSimbolos ts)
    {
        TablaDeSimbolos local = new TablaDeSimbolos(ts);
        declarasignacion.ejecutar(local);
        while((Boolean)condicion.ejecutar(local))
        {
            for(Instruccion in: listaInstrucciones){
                in.ejecutar(local);
            }
            cambio.ejecutar(local);
        }
        return null;
    }
}
