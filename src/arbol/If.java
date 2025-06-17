/*
 * Ejemplo desarrollado por Erick Navarro
 * GitHub Page: ericknavarro.github.io
 * Septiembre - 2015
 */

package arbol;

import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una instrucción si...entonces y que implementa
 * la interfaz de instrucción
 * @author Erick Navarro
 */
public class If implements Instruccion{
    /**
     * Condición de la instrucción si..entonces.
     */
    private final Operacion condicion;
    /**
     * Lista de instrucciones que serán ejecutadas si la condición se cumple.
     */
    private final LinkedList<Instruccion> listaInstrucciones;
    /**
     * Lista de instrucciones que serán ejecutadas si la condición ELSE IF se cumple.
     */
    private LinkedList<Instruccion> listaElseIfInstrucciones;
    /**
     * Lista de instrucciones que se ejecutarán si la condición no se cumple,
     * esta lista existirá solo si la instrucción posee la clausula ELSE, de lo
     * contrario la lista será null.
     */
    private LinkedList<Instruccion> listaInsElse;
    /**
     * Primer constructor de la clase, este se utiliza cuando la instrucción no 
     * tiene clausula ELSE.
     * @param a Condición del si..entonces
     * @param b Lista de instrucciones que deberían ejecutarse si la condición se cumple
     */
    public If(Operacion a, LinkedList<Instruccion> b) {
        condicion=a;
        listaInstrucciones=b;
    }
    /**
     * Segundo constructor de la clase, este se utiliza cuando la instrucción tiene
     * clausula ELSE.
     * @param a Condición del si..entonces
     * @param b Lista de instrucciones que deberían ejecutarse si la condición se cumple
     * @param c Lista de instrucciones que deberían ejecutarse si la condición no se cumple
     */
    public If(Operacion a, LinkedList<Instruccion> b, LinkedList<Instruccion> c) {
        condicion=a;
        listaInstrucciones=b;
        listaInsElse=c;
    }
    /**
     * Tercer constructor de la clase, este se utiliza cuando la instrucción tiene
     * clausula IF (ELSE IF/ ELSE).
     * @param a Condición del si..entonces
     * @param b Lista de instrucciones que deberían ejecutarse si la condición se cumple
     * @param l Lista de instrucciones que deberían ejecutarse si la condición ElSE IF se cumple
     * @param c Lista de instrucciones que deberían ejecutarse si la condición no se cumple
     */
    public If(Operacion a, LinkedList<Instruccion> b, LinkedList<Instruccion> l, LinkedList<Instruccion> c) {
        condicion=a;
        listaInstrucciones=b;
        listaElseIfInstrucciones = l;
        listaInsElse=c;
    }
    /**
     * Método que ejecuta la instrucción si..entonces, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts tabla de símbolos del ámbito padre de la sentencia.
     * @return Estra instrucción retorna nulo porque no produce ningún valor en 
     * su ejecución
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        if((Boolean)condicion.ejecutar(ts)){
            TablaDeSimbolos tablaLocal=new TablaDeSimbolos();
            tablaLocal.addAll(ts);
            for(Instruccion in: listaInstrucciones){
                in.ejecutar(tablaLocal);
            }
            return true;
        }else{
            boolean bandera = false;
            if(listaElseIfInstrucciones != null){
                for(Instruccion in: listaElseIfInstrucciones){
                    if((boolean)in.ejecutar(ts)){
                        bandera = true;
                        break;
                    }
                }
            }
            if(listaInsElse!=null && !bandera){
                TablaDeSimbolos tablaLocal=new TablaDeSimbolos();
                tablaLocal.addAll(ts);
                for(Instruccion in: listaInsElse){
                    in.ejecutar(tablaLocal);
                }            
            }
        }
        return false;
    }
}
