/*
 * Ejemplo desarrollado por Erick Navarro
 * Blog: e-navarro.blogspot.com
 * Septiembre - 2015
 */

package arbol;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Clase tabla de símbolos, que realiza todas las operaciones habituales de una 
 * tabla de símbolos, hereda de la clase lista enlazada porque básicamente la tabla
 * es una lista de símbolos.
 * @author Erick
 */
public class TablaDeSimbolos extends HashMap<String, Simbolo>{
    TablaDeSimbolos anterior;
    /**
     * Constructor de la clase que lo único que hace es llamar al constructor de 
     * la clase padre, es decir, el constructor de HashMap.
     */
    public TablaDeSimbolos() {
        super();
    }
    
    public TablaDeSimbolos(TablaDeSimbolos t)
    {
        super();
        anterior = t;
    }
    
    /**
     * Método que busca una variable en la tabla de símbolos y devuelve su valor.
     * @param id Identificador de la variable que quiere buscarse
     * @return Valor de la variable que se buscaba, si no existe se devuelve nulo
     */
    Object getValor(String id) {
        if(this.containsKey(id))
        {
            return this.get(id).getValor();
        }
        if(anterior != null)
        {
            return anterior.getValor(id);
        }
        System.out.println("La variable "+id+" no existe en este ámbito.");
        return "Desconocido";
    }
    Object getValor(String id, LinkedList<Integer> i) {
        if(this.containsKey(id))
        {
            int num = i.getFirst();
            i.removeFirst();
            Simbolo[] arr = (Simbolo[]) this.get(id).getValor();
            return arr[num].getValor(i);
        }
        if(anterior != null)
        {
            return anterior.getValor(id, i);
        }
        System.out.println("La variable "+id+" no existe en este ámbito.");
        return "Desconocido";
    }
    /**
     * Método que asigna un valor a una variable específica, si no la encuentra 
     * no realiza la asignación y despliega un mensaje de error.
     * @param id Identificador de la variable que quiere buscarse
     * @param valor Valor que quiere asignársele a la variable buscada
     */
    void setValor(String id, Object valor, Operacion.Tipo_operacion tipo) {
        if(this.containsKey(id))
        {
            this.get(id).setValor(valor, tipo);
            return;
        }
        if(anterior != null)
        {
            anterior.setValor(id, valor, tipo);
            return;
        }
        System.out.println("La variable "+id+" no existe en este ámbito, por lo "
                + "que no puede asignársele un valor.");
    }
    void setValor(String id, LinkedList<Integer> i, Object valor, Operacion.Tipo_operacion tipo) {
        if(this.containsKey(id))
        {
            int num = i.getFirst();
            i.removeFirst();
            Simbolo[] arr = (Simbolo[]) this.get(id).getValor();
            arr[num].setValor(valor, i, tipo);
            return;
        }
        if(anterior != null)
        {
            anterior.setValor(id, i, valor, tipo);
            return;
        }
        System.out.println("La variable "+id+" no existe en este ámbito, por lo "
                + "que no puede asignársele un valor.");
    }
}