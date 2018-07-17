/*
 * Ejemplo desarrollado por Erick Navarro
 * Blog: e-navarro.blogspot.com
 * Septiembre - 2015
 */

package arbol;

import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una instrucción mientras y que implementa
 * la interfaz de instrucción
 * @author Erick
 */
public class Mientras implements Instruccion{
    /**
     * Condición de la sentencia mientras.
     */
    private final Operacion condicion;
    /**
     * Lista de las instrucciones que deben ejecutarse si la condición se cumple.
     */
    private final LinkedList<Instruccion> listaInstrucciones;
    /**
     * Constructor de la clase Mientras
     * @param a condición que debe evaluarse para ejecutar el ciclo
     * @param b instrucciones que deben ejecutarse si la condición se cumpliera
     */
    public Mientras(Operacion a, LinkedList<Instruccion> b) {
        this.condicion=a;
        this.listaInstrucciones=b;
    }
    /**
     * Método que ejecuta la instrucción mientras, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts tabla de símbolos del ámbito padre de la sentencia
     * @return Esta instrucción retorna nulo porque no produce ningun valor
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        while((Boolean)condicion.ejecutar(ts)){
            TablaDeSimbolos tablaLocal=new TablaDeSimbolos();
            tablaLocal.addAll(ts);
            for(Instruccion ins:listaInstrucciones){
                ins.ejecutar(tablaLocal);
            }
        }
        return null;
    }   
}