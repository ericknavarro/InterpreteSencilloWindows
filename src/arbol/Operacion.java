/*
 * Ejemplo desarrollado por Erick Navarro
 * Blog: e-navarro.blogspot.com
 * Septiembre - 2015
 */

package arbol;

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
        MAYOR_QUE,
        MENOR_QUE,
        CONCATENACION
    }
    /**
     * Tipo de operación a ejecutar.
     */
    private final Tipo_operacion tipo;
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
    /**
     * Constructor de la clase para operaciones binarias (con dos operadores), estas
     * operaciones son:
     * SUMA, RESTA, MULTIPLICACION, DIVISION, CONCATENACION, MAYOR_QUE, MENOR_QUE
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
     * NEGATIVO
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
        
    /**
     * Método que ejecuta la instrucción operación, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts tabla de símbolos del ámbito padre de la sentencia
     * @return Esta instrucción retorna el valor producido por la operación que se ejecutó
     */    
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        if(tipo== Tipo_operacion.DIVISION){
            return (Double)operadorIzq.ejecutar(ts) / (Double)operadorDer.ejecutar(ts);
        }else if(tipo== Tipo_operacion.MULTIPLICACION){
            return (Double)operadorIzq.ejecutar(ts) * (Double)operadorDer.ejecutar(ts);
        }else if(tipo== Tipo_operacion.RESTA){
            return (Double)operadorIzq.ejecutar(ts) - (Double)operadorDer.ejecutar(ts);
        }else if(tipo== Tipo_operacion.SUMA){
            return (Double)operadorIzq.ejecutar(ts) + (Double)operadorDer.ejecutar(ts);
        }else if(tipo== Tipo_operacion.NEGATIVO){
            return (Double)operadorIzq.ejecutar(ts) * -1;
        }else if(tipo== Tipo_operacion.NUMERO){
            return new Double(valor.toString());
        }else if(tipo== Tipo_operacion.IDENTIFICADOR){
            return ts.getValor(valor.toString());
        }else if(tipo== Tipo_operacion.CADENA){
            return valor.toString();
        }else if(tipo== Tipo_operacion.MAYOR_QUE){
            return ((Double)operadorIzq.ejecutar(ts)).doubleValue()>((Double)operadorDer.ejecutar(ts)).doubleValue();
        }else if(tipo== Tipo_operacion.MENOR_QUE){
            return ((Double)operadorIzq.ejecutar(ts)).doubleValue()<((Double)operadorDer.ejecutar(ts)).doubleValue();
        }else if(tipo== Tipo_operacion.CONCATENACION){
            return operadorIzq.ejecutar(ts).toString()+operadorDer.ejecutar(ts).toString();
        }else{
            return null;
        }
    }    
}
