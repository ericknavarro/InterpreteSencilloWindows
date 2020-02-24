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
public class DeclaracionAsignacion implements Instruccion{
    private final LinkedList<String> id;
    Simbolo.Tipo tipo;
    private final Operacion valor;
    
    public DeclaracionAsignacion(LinkedList<String> a, String b, Operacion c)
    {
        id = a;
        switch(b)
        {
            case "int":
                this.tipo = Simbolo.Tipo.INT;
                break;
            case "string":
                this.tipo = Simbolo.Tipo.STRING;
                break;
            case "bool":
                this.tipo = Simbolo.Tipo.BOOL;
                break;
            case "char":
                this.tipo = Simbolo.Tipo.CHAR;
                break;
            default:
                System.out.println("Error interno, tipo de dato erroneo.");
                break;
        }
        valor = c;
    }
    
    @Override
    public Object ejecutar(TablaDeSimbolos ts)
    {
        for(String ids : id)
        {
            ts.put(ids,new Simbolo(tipo));
            ts.setValor(ids,valor.ejecutar(ts), valor.getTipo());
        }
        return null;
    }
}
