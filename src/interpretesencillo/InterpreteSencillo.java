/*
 * Ejemplo desarrollado por Erick Navarro
 * Blog: e-navarro.blogspot.com
 * Septiembre - 2015
 */

package interpretesencillo;

import Interfaz.Ventana;
import arbol.Instruccion;
import arbol.TablaDeSimbolos;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.LinkedList;

/**
 * Clase principal de la aplicación
 * @author Erick
 */
public class InterpreteSencillo {

    /**
     * Método principal de la aplicación
     * @param args los argumentos de la línea de comando
     */
    public static void main(String[] args) {
        //interpretar("entrada.txt");
        Ventana v = new Ventana();
        v.setVisible(true);
    }
    
    /**
     * Método que setea el texto recibido del area de texto para ser interpretado.
     * @param texto texto que se va a interpretar
     */
    public void setTexto(String texto){
        interpretar(texto);
    }
    
    /**
     * Método que ejecuta las instrucciones que contiene.
     * @param cadena texto que se va a interpretar
     */
    private static void interpretar(String cadena) {
        analizadores.Sintactico pars;
        LinkedList<Instruccion> AST_arbolSintaxisAbstracta=null;
        try {
            pars=new analizadores.Sintactico(new analizadores.Lexico(new BufferedReader(new StringReader(cadena))));
            pars.parse();        
            AST_arbolSintaxisAbstracta=pars.getAST();
        } catch (Exception ex) {
            System.out.println("Error fatal en compilación de entrada.");
        } 
        ejecutarAST(AST_arbolSintaxisAbstracta);
    }
    /**
     * Recibe una lista de instrucciones y la ejecuta
     * @param ast lista de instrucciones
     */
    private static void ejecutarAST(LinkedList<Instruccion> ast) {
        if(ast==null){
            System.out.println("No es posible ejecutar las instrucciones porque\r\n"
                    + "el árbol no fue cargado de forma adecuada por la existencia\r\n"
                    + "de errores léxicos o sintácticos.");
            return;
        }
        //Se crea una tabla de símbolos global para ejecutar las instrucciones.
        TablaDeSimbolos ts=new TablaDeSimbolos();
        //Se ejecuta cada instruccion en el ast, es decir, cada instruccion de 
        //la lista principal de instrucciones.
        for(Instruccion ins:ast){
            //Si existe un error léxico o sintáctico en cierta instrucción esta
            //será inválida y se cargará como null, por lo tanto no deberá ejecutarse
            //es por esto que se hace esta validación.
            if(ins!=null)
                ins.ejecutar(ts);
        }
    }
}
