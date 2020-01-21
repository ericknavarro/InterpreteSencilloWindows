/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/**
 *
 * @author iDavi
 */
public class Leer_Archivo {
   
    FileReader fr=null;
    BufferedReader br = null;

    public String leer(String ruta){
        File archivo;
	try {
            String datos="";
            archivo = new File(ruta);
		          System.err.println(""+archivo.getAbsolutePath());	
            try {
		fr=new FileReader(archivo);
		br=new BufferedReader(fr);
		String linea;
		while ((linea = br.readLine())!= null) {
                    datos+= linea+ "\n";
		}
				 
            } catch (Exception e) {
                System.err.println("error");
            }
			
            return datos;
			
	} catch (Exception e) {
            System.err.println("error2");
	}
		
	finally{
            try {
		br.close();
            } catch (Exception e2) {
                System.err.println("error3");
            }
	}
	
        return null;
    }
}
