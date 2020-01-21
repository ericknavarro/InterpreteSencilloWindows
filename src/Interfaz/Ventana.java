/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import interpretesencillo.InterpreteSencillo;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 *
 * @author iDavi
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        RSyntax();
        setTexto();
        this.setTitle("Interprete Sencillo");
        this.setLocationRelativeTo(null);
    }

    /**
     * Método que instancia el textarea y lo agrega a la interfaz grafica para
     * que el lenguaje tenga colores, se utilizo la libreria rsyntaxtextarea la cual
     * debe agregarse a las liberias del proyecto de netbeans con Add JAR/Folder;
     * el jar se encuentra en la carpeta lib del proyecto.
     */
    public final void RSyntax(){
        //Se instancia el text area 
        RSyntaxTextArea textArea = new RSyntaxTextArea(); 
        //Se agrega el tipo de letra y el tamanio 
        textArea.setFont(new Font("Monospaced",Font.PLAIN,20));
        textArea.setHighlightCurrentLine(false);
        
        //Agregamos el archivo color.java el cual contiene los tokens de nuestro lenguaje
        try {
            AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory)TokenMakerFactory.getDefaultInstance();
            atmf.putMapping("text/myLanguage", "Interfaz.Color");
            textArea.setSyntaxEditingStyle("text/myLanguage");
        } catch (Exception e) {
        }
        
        RTextScrollPane sp = new RTextScrollPane(textArea);
        sp.getGutter().setLineNumberColor(java.awt.Color.decode("#2AEB9D"));
        sp.getGutter().setLineNumberFont(new Font("Monospaced",Font.BOLD,20));
        sp.getGutter().setBorderColor(java.awt.Color.decode("#2AEB9D"));
        
        
        jPanel1.add(sp);
    
        //Se modifica el esquema de rsyntaxtextarea con los colores personalizados para nuestra gramatica. 
        SyntaxScheme esquema = textArea.getSyntaxScheme();
        esquema.getStyle(Token.RESERVED_WORD).foreground = java.awt.Color.GREEN;
        esquema.getStyle(Token.DATA_TYPE).foreground = java.awt.Color.decode("#3992EB");
        esquema.getStyle(Token.FUNCTION).foreground = java.awt.Color.decode("#FF5E00");
        esquema.getStyle(Token.COMMENT_MULTILINE).foreground = java.awt.Color.GRAY.darker();
        esquema.getStyle(Token.COMMENT_EOL).foreground = java.awt.Color.decode("#71B797");
        esquema.getStyle(Token.LITERAL_NUMBER_DECIMAL_INT).foreground = java.awt.Color.decode("#0077FF");
        esquema.getStyle(Token.LITERAL_STRING_DOUBLE_QUOTE).foreground = java.awt.Color.decode("#EB4B39");
        
        
        textArea.revalidate();
        
        
    }
    
    
    /**
     * Método que imprime en consola de la interfaz grafica se puede utilizar desde 
     * cualquier clase del proyecto ya que es estatico y se usa de la siguiente manera:
     * Ventana.ImprimirEnConsola("El String que se va a imprimir");
     * @param texto texto que se va a imprimir
     */
    public static void ImprimirEnConsola(String texto){
        try {
            Consola.append("~$. ");
            Consola.append(texto);
            Consola.append("\n");
        } catch (Exception e) {
        }
        
    }
    
    /**
     * Método que agrega el texto que se encuentra en el archivo entrada.txt al
     * area de texto, el archivo entrada.txt se encuentra en la carpeta del proyecto
     */
    
    public final void setTexto(){
        Component co = jPanel1;
        if ( co instanceof JPanel ) {
            //((JPanel) co).setBackground(Color.black);
            for (Component jc1 : ((JPanel) co).getComponents()) {
                if (jc1 instanceof JScrollPane) {
                    RSyntaxTextArea texto =  (RSyntaxTextArea) ((RTextScrollPane) jc1).getViewport().getView();
                    File f = new File("entrada.txt");
                    Archivo.Leer_Archivo arch = new Archivo.Leer_Archivo();
                    String cadena = arch.leer(f.getAbsolutePath());
                    texto.setText(cadena);
                }
            }
        }
    }
    
    /* 
        
        */
    /**
     * Este metodo obtiene el texto que esta en el area de texto  
     * @return cadena texto que esta en el textarea.
     */
    public String getTexto(){
        Component co = jPanel1;
        String cadena ="";
        if ( co instanceof JPanel ) {
            //((JPanel) co).setBackground(Color.black);
            for (Component jc1 : ((JPanel) co).getComponents()) {
                if (jc1 instanceof JScrollPane) {
                    RSyntaxTextArea texto =  (RSyntaxTextArea) ((RTextScrollPane) jc1).getViewport().getView();
                    cadena = texto.getText();
                }
            }
        }
        return cadena;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Consola = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.CardLayout());

        jButton1.setText("Interpretar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Consola.setBackground(new java.awt.Color(102, 102, 102));
        Consola.setColumns(20);
        Consola.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        Consola.setForeground(new java.awt.Color(102, 255, 102));
        Consola.setRows(5);
        jScrollPane2.setViewportView(Consola);

        jButton2.setText("Limpiar Consola");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * El boton de interpretar obtiene el texto que se encuentra en el area de texto
     * y lo envia para ser interpretado por el metodo interpretar en la clase InterpreteSencillo.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InterpreteSencillo i = new InterpreteSencillo();
        i.setTexto(getTexto());
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Consola.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea Consola;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
