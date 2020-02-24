/*
 * Ejemplo desarrollado por Erick Navarro
 * Blog: e-navarro.blogspot.com
 * Septiembre - 2015
 */

package arbol;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase símbolo, que es un nodo de la tabla de símbolos, estos símbolos son 
 * variables con su valor, identificador y tipo, actualmente todas las variables 
 * son de tipo número, pero se colocó la variable tipo por si se quisiera ampliar
 * el lenguaje y agregar más tipos.
 * @author Erick
 */
public class Simbolo {
    private final Tipo tipo;
    private Object valor;    
    /**
     * Constructor de la clase Símbolo.
     * @param tipo tipo de la variable que se desea almacenar
     */
    public Simbolo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public Simbolo(Tipo tipo, LinkedList<Integer> nums) {
        this.tipo = tipo;
        int dimension = nums.size();
        if(dimension > 0)
        {
            LinkedList<Integer> n = new LinkedList<Integer>();
            n = (LinkedList)nums.clone();
            int num = n.getFirst();
            n.removeFirst();
            Simbolo[] arr = new Simbolo[num];
            for(int i=0; i<arr.length; i++)
            {
                arr[i] = new Simbolo(tipo, n);
            }
            this.valor = arr;
        }
    }

    /**
     * Método que devuelve el valor que almacena la variable.
     * @return Valor de la variable
     */
    public Object getValor() {
        return valor;
    }
    
    public Object getValor(LinkedList<Integer> i) {
        int dimension = i.size();
        if(dimension > 0)
        {
            int num = i.getFirst();
            i.removeFirst();
            Simbolo[] arr = (Simbolo[])valor;
            return arr[num].getValor(i);
        }
        else
        {
            return valor;
        }
    }
    /**
     * Método que asigna un nuevo valor a la variable.
     * @param v Nuevo valor para la variable.
     */
    void setValor(Object v, Operacion.Tipo_operacion t) {
        if(this.tipo==Tipo.INT && t == Operacion.Tipo_operacion.NUMERO ||
           this.tipo==Tipo.INT && t == Operacion.Tipo_operacion.SUMA ||
           this.tipo==Tipo.INT && t == Operacion.Tipo_operacion.RESTA ||
           this.tipo==Tipo.INT && t == Operacion.Tipo_operacion.MULTIPLICACION ||
           this.tipo==Tipo.INT && t == Operacion.Tipo_operacion.DIVISION ||
           this.tipo==Tipo.INT && t == Operacion.Tipo_operacion.NEGATIVO ||
           this.tipo==Tipo.INT && t == Operacion.Tipo_operacion.ARREGLO ||
           this.tipo==Tipo.INT && t == Operacion.Tipo_operacion.IDENTIFICADOR ||
           this.tipo==Tipo.STRING && t == Operacion.Tipo_operacion.CADENA ||
           this.tipo==Tipo.STRING && t == Operacion.Tipo_operacion.CONCATENACION ||
           this.tipo==Tipo.STRING && t == Operacion.Tipo_operacion.ARREGLO ||
           this.tipo==Tipo.STRING && t == Operacion.Tipo_operacion.IDENTIFICADOR ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.BOOL ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.AND ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.OR ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.NOT ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.IGUAL ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.DIFERENTE ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.MAYOR_QUE ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.MENOR_QUE ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.MAYOR_IGUAL ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.MENOR_IGUAL ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.IDENTIFICADOR ||
           this.tipo==Tipo.CHAR && t == Operacion.Tipo_operacion.IDENTIFICADOR ||
           this.tipo==Tipo.CHAR && t == Operacion.Tipo_operacion.CHAR)
        {
            valor = v;
  
        }
        else
        {
            System.out.println("Error No se puede asignar un valor " + this.tipo + " a una variable " + t);
        }
        
    }
    void setValor(Object v, LinkedList<Integer> i, Operacion.Tipo_operacion t) {
        if(this.tipo==Tipo.INT && t == Operacion.Tipo_operacion.NUMERO ||
           this.tipo==Tipo.INT && t == Operacion.Tipo_operacion.SUMA ||
           this.tipo==Tipo.INT && t == Operacion.Tipo_operacion.RESTA ||
           this.tipo==Tipo.INT && t == Operacion.Tipo_operacion.MULTIPLICACION ||
           this.tipo==Tipo.INT && t == Operacion.Tipo_operacion.DIVISION ||
           this.tipo==Tipo.INT && t == Operacion.Tipo_operacion.NEGATIVO ||
           this.tipo==Tipo.INT && t == Operacion.Tipo_operacion.ARREGLO ||
           this.tipo==Tipo.INT && t == Operacion.Tipo_operacion.IDENTIFICADOR ||
           this.tipo==Tipo.STRING && t == Operacion.Tipo_operacion.CADENA ||
           this.tipo==Tipo.STRING && t == Operacion.Tipo_operacion.CONCATENACION ||
           this.tipo==Tipo.STRING && t == Operacion.Tipo_operacion.ARREGLO ||
           this.tipo==Tipo.STRING && t == Operacion.Tipo_operacion.IDENTIFICADOR ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.BOOL ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.AND ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.OR ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.NOT ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.IGUAL ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.DIFERENTE ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.MAYOR_QUE ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.MENOR_QUE ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.MAYOR_IGUAL ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.MENOR_IGUAL ||
           this.tipo==Tipo.BOOL && t == Operacion.Tipo_operacion.IDENTIFICADOR ||
           this.tipo==Tipo.CHAR && t == Operacion.Tipo_operacion.IDENTIFICADOR ||
           this.tipo==Tipo.CHAR && t == Operacion.Tipo_operacion.CHAR)
        {
            int dimension = i.size();
            if(dimension > 0)
            {
                int num = i.getFirst();
                i.removeFirst();
                Simbolo[] arr = (Simbolo[])valor;
                arr[num].setValor(v, i, t);
            }
            else
            {
                setValor(v,t);
            }
            
        }
        else
        {
            System.out.println("Error No se puede asignar un valor " + this.tipo + " a una variable " + t);
        }
        
    }
    /**
     * Enumeración que lista todos los tipos de variable reconocidos en el lenguaje.
     */
    public static enum Tipo{
        INT,
        STRING,
        CHAR,
        BOOL,
        ARREGLO
    }
}
