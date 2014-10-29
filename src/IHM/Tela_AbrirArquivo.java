package IHM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Luiz
 */
public class Tela_AbrirArquivo extends javax.swing.JFrame {

    private String endereco;
    private Tela_Inicial telaInicial;

    public Tela_AbrirArquivo(Tela_Inicial telaInicial) {
        initComponents();
        setLocationRelativeTo(null);
        this.telaInicial = telaInicial;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooser = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Abrir Arquivo");

        chooser.setCurrentDirectory(new java.io.File("C:\\Users\\Luiz\\Dropbox\\BolsaLulu\\Mestrado\\Projeto\\Software\\OPC_COM"));
        chooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooserActionPerformed
        if (chooser.APPROVE_SELECTION.equals(evt.getActionCommand())) {
            chooser.accept(chooser.getSelectedFile());
            telaInicial.campo_pesos.setText("");
            try {
                processarArquivo(chooser.getSelectedFile());
                telaInicial.campo_enderecoArq.setText(endereco);
                this.dispose();
            } catch (FileNotFoundException ex) {
                System.out.println("ERRO AO CARREGAR ARQUIVO" + ex);
            } catch (IOException ex) {
                Logger.getLogger(Tela_AbrirArquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (JFileChooser.CANCEL_SELECTION.equals(evt.getActionCommand())) {
            this.dispose();
        }

    }//GEN-LAST:event_chooserActionPerformed

    public void processarArquivo(File arquivo) throws FileNotFoundException, IOException {
        System.out.println("PROCESSAR");
        endereco = arquivo.getAbsolutePath();
        
        FileReader arq = new FileReader(arquivo);
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = "";
        
        while (linha != null) {
            linha = lerArq.readLine();
            telaInicial.campo_pesos.append(linha);
            telaInicial.campo_pesos.append("\n");
        }
    }

    public String getEndereco() {
        return endereco;
    }

//    public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Tela_AbrirArquivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Tela_AbrirArquivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Tela_AbrirArquivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Tela_AbrirArquivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Tela_AbrirArquivo().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser chooser;
    // End of variables declaration//GEN-END:variables
}
