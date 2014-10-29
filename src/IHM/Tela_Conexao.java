package IHM;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafish.clients.opc.JEasyOpc;
import javafish.clients.opc.JOpc;
import javafish.clients.opc.component.OpcGroup;
import javafish.clients.opc.component.OpcItem;
import javafish.clients.opc.exception.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import testeopc.ClienteOPC;

/**
 *
 * @author Veyron-PC
 */
public class Tela_Conexao extends javax.swing.JFrame {

    private JEasyOpc jopc;
//    private ClienteOPC cliente = new ClienteOPC();
    JComboBox<String> lista = new JComboBox<String>();

    public Tela_Conexao() {
        initComponents();
        setLocationRelativeTo(null);
//        String[] s = cliente.getAllServers(host_campo.getText());
//        atualizarListaSV(s);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botao_conectar = new javax.swing.JButton();
        botao_cancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        campo_host = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campo_nomeCliente = new javax.swing.JTextField();
        lista_servidores = new javax.swing.JComboBox();
        botao_desconectar = new javax.swing.JButton();
        botao_atualizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OPC COM");

        botao_conectar.setText("Conectar");
        botao_conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_conectarActionPerformed(evt);
            }
        });

        botao_cancelar.setText("Cancelar");
        botao_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_cancelarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuração"));

        campo_host.setText("localhost");

        jLabel1.setText("Host:");

        jLabel2.setText("ID Servidor:");

        jLabel3.setText("Nome Cliente:");

        campo_nomeCliente.setText("JOPC");

        lista_servidores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Smar.DfiOleServer.0" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_nomeCliente)
                    .addComponent(campo_host)
                    .addComponent(lista_servidores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_host, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lista_servidores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botao_desconectar.setText("Desconectar");
        botao_desconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_desconectarActionPerformed(evt);
            }
        });

        botao_atualizar.setText("Atualizar");
        botao_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_atualizarActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botao_conectar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botao_desconectar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botao_atualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botao_cancelar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_cancelar)
                    .addComponent(botao_atualizar)
                    .addComponent(botao_conectar)
                    .addComponent(botao_desconectar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_conectarActionPerformed
        JOpc.coInitialize();
        jopc = new JEasyOpc(campo_host.getText(), lista_servidores.getSelectedItem().toString(), campo_nomeCliente.getText());

        try {
            jopc.connect();
            System.out.println("JOPC Conectado!");
            JOptionPane.showMessageDialog(rootPane, "Connected!", "", 1);
        } catch (ConnectivityException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error in connection.", "ERROR", 0);
        }
    }//GEN-LAST:event_botao_conectarActionPerformed

    private void botao_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_cancelarActionPerformed
        JOpc.coUninitialize();
        this.dispose();
    }//GEN-LAST:event_botao_cancelarActionPerformed

    private void botao_desconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_desconectarActionPerformed
        JOpc.coUninitialize();
        JOptionPane.showMessageDialog(rootPane, "Disconnected!", "", 1);

    }//GEN-LAST:event_botao_desconectarActionPerformed

    private void botao_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_atualizarActionPerformed
//            String[] s = cliente.getAllServers(host_campo.getText());
//            atualizarListaSV(s);        
    }//GEN-LAST:event_botao_atualizarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Conexao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Conexao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Conexao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Conexao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Tela_Conexao().setVisible(true);
            }
        });
    }

    public void atualizarListaSV(String[] s) {
        try {
            lista_servidores.removeAllItems();
            for (int i = 0; i < s.length; i++) {
                lista_servidores.addItem(s[i]);
            }
        } catch (Exception e) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_atualizar;
    private javax.swing.JButton botao_cancelar;
    private javax.swing.JButton botao_conectar;
    private javax.swing.JButton botao_desconectar;
    private javax.swing.JTextField campo_host;
    private javax.swing.JTextField campo_nomeCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox lista_servidores;
    // End of variables declaration//GEN-END:variables
}
//  BOTAO TESTAR
//        OpcItem item1 = new OpcItem("Tensao_AO.CHANNEL", true, "Tensao_AO.CHANNEL");
//        OpcGroup group = new OpcGroup("Group_2", true, 50, 0.0f);
//
//        group.addItem(item1);
//        jopc.addGroup(group);
//        try {
//            jopc.synchReadGroup(group);
//        } catch (ComponentNotFoundException ex) {
//            Logger.getLogger(telaInicial.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SynchReadException ex) {
//            Logger.getLogger(telaInicial.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("asd " + item1.getValue().toString());
