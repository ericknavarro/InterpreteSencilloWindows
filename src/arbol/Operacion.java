/*
 * Ejemplo desarrollado por Erick Navarro
 * Blog: e-navarro.blogspot.com
 * Septiembre - 2015
 */

package arbol;

import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una operación, ya sea aritmética o realacional
 * y que implementa la interfaz de instrucción, ya que estas operaciones pueden 
 * ejecutarse y al ejecutarse retornan un valor.
 * @author Erick
 */
public class Operacion implements Instruccion{
    /**
     * Enumeración del tipo de operación que puede ser ejecutada por esta clase.
     */
    public static enum Tipo_operacion{
        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION,
        NEGATIVO,
        NUMERO,
        IDENTIFICADOR,
        CADENA,
        CHAR,
        BOOL,
        MAYOR_QUE,
        MENOR_QUE,
        MAYOR_IGUAL,
        MENOR_IGUAL,
        IGUAL,
        DIFERENTE,
        AND,
        OR,
        NOT,
        CONCATENACION,
        ARREGLO
    }
    /**
     * Tipo de operación a ejecutar.
     */
    private Tipo_operacion tipo;
    /**
     * Operador izquierdo de la operación.
     */
    private Operacion operadorIzq;
    /**
     * Operador derecho de la operación.
     */
    private Operacion operadorDer;
    /**
     * Valor específico si se tratara de una literal, es decir un número o una 
     * cadena.
     */
    private Object valor;
    
    private LinkedList<Operacion> nums;
    /**
     * Constructor de la clase para operaciones binarias (con dos operadores), estas
     * operaciones son:
     * SUMA, RESTA, MULTIPLICACION, DIVISION, CONCATENACION, MAYOR_QUE, MENOR_QUE, IGUAL, MAYOR_IGUAL, MENOR_IGUAL, AND, OR, DIFERENTE
     * @param operadorIzq Operador izquierdo de la operación
     * @param operadorDer Opeardor derecho de la operación
     * @param tipo Tipo de la operación
     */
    public Operacion(Operacion operadorIzq, Operacion operadorDer, Tipo_operacion tipo) {
        this.tipo = tipo;
        this.operadorIzq = operadorIzq;
        this.operadorDer = operadorDer;
    }
    /**
     * Constructor para operaciones unarias (un operador), estas operaciones son:
     * NEGATIVO, NOT
     * @param operadorIzq Único operador de la operación
     * @param tipo Tipo de operación
     */
    public Operacion(Operacion operadorIzq, Tipo_operacion tipo) {
        this.tipo = tipo;
        this.operadorIzq = operadorIzq;
    }
    /**
     * Constructor para operaciones unarias (un operador), cuyo operador es 
     * específicamente una cadena, estas operaciones son:
     * IDENTIFICADOR, CADENA
     * @param a Cadena que representa la operación a realizar
     * @param tipo Tipo de operación
     */
    public Operacion(String a, Tipo_operacion tipo) {
        this.valor=a;
        this.tipo = tipo;
    }
    public Operacion(String a, LinkedList<Operacion> nums, Tipo_operacion tipo)
    {
        this.valor=a;
        this.nums=nums;
        this.tipo=tipo;
    }
    /**
     * Constructor para operaciones unarias (un operador), cuyo operador es 
     * específicamente una NUMERO, estas operaciones son:
     * NUMERO_ENTERO, NUMERO_DECIMAL
     * @param a Valor de tipo Double que representa la operación a realizar.
     */
    public Operacion(Double a) {
        this.valor=a;
        this.tipo = Tipo_operacion.NUMERO;
    }

    public String getValor(){
        return (String)valor;
    }
    
    public Tipo_operacion getTipo()
    {
        return this.tipo;
    }
        
    /**
     * Método que ejecuta la instrucción operación, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts tabla de símbolos del ámbito padre de la sentencia
     * @return Esta instrucción retorna el valor producido por la operación que se ejecutó
     */    
    
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        if(null== tipo){
            return null;
        }else switch (tipo) {
            case DIVISION:
                return (Double)operadorIzq.ejecutar(ts) / (Double)operadorDer.ejecutar(ts);
            case MULTIPLICACION:
                return (Double)operadorIzq.ejecutar(ts) * (Double)operadorDer.ejecutar(ts);
            case RESTA:
                return (Double)operadorIzq.ejecutar(ts) - (Double)operadorDer.ejecutar(ts);
            case SUMA:
                return (Double)operadorIzq.ejecutar(ts) + (Double)operadorDer.ejecutar(ts);
            case NEGATIVO:
                return (Double)operadorIzq.ejecutar(ts) * -1;
            case NOT:
                return !(Boolean)operadorIzq.ejecutar(ts);
            case NUMERO:
                return new Double(valor.toString());
            case IDENTIFICADOR:
                return ts.getValor(valor.toString());
            case CADENA:
                return valor.toString();
            case MAYOR_QUE:
                return ((Double)operadorIzq.ejecutar(ts)).doubleValue()>((Double)operadorDer.ejecutar(ts)).doubleValue();
            case MENOR_QUE:
                return ((Double)operadorIzq.ejecutar(ts)).doubleValue()<((Double)operadorDer.ejecutar(ts)).doubleValue();
                //((int)operadorIzq.ejecutar(ts))<((int)operadorDer.ejecutar(ts));
            case MENOR_IGUAL:
                return ((Double)operadorIzq.ejecutar(ts)).doubleValue()<=((Double)operadorDer.ejecutar(ts)).doubleValue();
            case MAYOR_IGUAL:
                return ((Double)operadorIzq.ejecutar(ts)).doubleValue()>=((Double)operadorDer.ejecutar(ts)).doubleValue();
            case IGUAL:
                return ((Double)operadorIzq.ejecutar(ts)).doubleValue()==((Double)operadorDer.ejecutar(ts)).doubleValue();
            case DIFERENTE:
                return ((Double)operadorIzq.ejecutar(ts)).doubleValue()!=((Double)operadorDer.ejecutar(ts)).doubleValue();
            case AND:
                return (Boolean)operadorIzq.ejecutar(ts) && (Boolean)operadorDer.ejecutar(ts);
            case OR:
                return (Boolean)operadorIzq.ejecutar(ts) || (Boolean)operadorDer.ejecutar(ts);
            case CONCATENACION:
                return operadorIzq.ejecutar(ts).toString() + operadorDer.ejecutar(ts).toString();
            case CHAR:
                return valor.toString();
            case ARREGLO:
                LinkedList<Integer> l = new LinkedList<Integer>();
                for(Operacion op : nums)
                {
                    double num = (double)op.ejecutar(ts);
                    int n = (int) num;
                    l.add(n);
                }
                return ts.getValor(valor.toString(),l);
            case BOOL:
                if(valor.toString().equals("true")){
                    return true;
                }
                else{
                    return false;
                }
            default:
                return null;
        }
    }    
}
