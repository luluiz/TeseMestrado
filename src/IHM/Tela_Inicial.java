package IHM;

import Agentes.Agente_de_Decisao;
import Agentes.Agente_de_Diagnostico;
import Agentes.Agente_de_Correcao;
import Agentes.Agente_de_Predicao;
import Agentes.Ambiente;
import OPC.ClienteOPC;
import SimularFalhas.SimularFalhas;
import graficos.Grafico_Geral;
import graficos.Grafico_Dial;
import graficos.Grafico_Correcao;
import graficos.Grafico_Diagnostico;
import graficos.Grafico_Predicao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafish.clients.opc.component.OpcItem;
import javax.swing.Timer;

/**
 *
 * @author Luiz
 */
public class Tela_Inicial extends javax.swing.JFrame {

    private Grafico_Geral grafico_geral;
    private Grafico_Correcao grafico_correcao;
    private Grafico_Diagnostico grafico_diagnostico;
    private Grafico_Predicao grafico_predicao;
    private Grafico_Dial grafico_dial;
    private final SimularFalhas simularFalhas = new SimularFalhas();
    private Timer threadGrafico, threadEscritaOPC;
    private final double i = 0.0;
    private final ClienteOPC cliente;
    private final ClienteOPC clienteSim = new ClienteOPC();
    private final ArrayList<OpcItem> lista = new ArrayList<>();
    private OpcItem nivelT1_OPC, predT1_OPC, tensaoBomba_OPC, falhasFiltradas_OPC, sinalEstimado_OPC, sinalReal_OPC, sinalCorrigido_OPC, tipoFalha_OPC, EntComFalhasStatus_OPC, EntComFalhas_OPC;
    private double nivelT1, predT1, tensaoBomba, sinalCorrigido, sinalEstimado, sinalReal, tipoFalha, entComFalhas, entComFalhasStatus, falhasFiltradas, sinalComFalhasNivelT1, erroPredT1;
    private boolean flag = false, flagEntComFalha = false;
    private final Ambiente ambiente = new Ambiente();
    private Agentes.Agente_de_Decisao agDecisao = new Agente_de_Decisao();
    private final Agentes.Agente_de_Diagnostico agDiagnostico = new Agente_de_Diagnostico();
    private final Agentes.Agente_de_Correcao agExecucao = new Agente_de_Correcao();
    private final Agentes.Agente_de_Predicao agPredicao = new Agente_de_Predicao();

    public Tela_Inicial(ClienteOPC cliente) {
        initComponents();
        this.cliente = cliente;
        //setExtendedState(MAXIMIZED_HORIZ);
        setSize(1366, 720);
        setLocationRelativeTo(null);
        cadastrarMinhasTags();
        inicializarGraficos();
        setPropriedadesDoGrafico();
        atualizarDadosAbaConfig();
        principal();
        botao_graficosActionPerformed(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_inicial = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        botao_graficos = new javax.swing.JButton();
        botao_config = new javax.swing.JButton();
        botao_monitorar = new javax.swing.JButton();
        painel_camadas = new javax.swing.JLayeredPane();
        painel_graficos = new javax.swing.JPanel();
        painelAba_Graficos = new javax.swing.JTabbedPane();
        painel_AbaGeral = new javax.swing.JPanel();
        painel_AbaGeral2 = new javax.swing.JPanel();
        painel_AbaGeral3 = new javax.swing.JScrollPane();
        painel_AbaGeral4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        campo_nivelT1geral = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        campo_predT1geral = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        campo_sinalCorrigidogeral = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        campo_tensaoBombaGeral = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        campo_tipoFalhaGeral = new javax.swing.JTextField();
        painel_AbaPredicao = new javax.swing.JPanel();
        painel_AbaPredicao2 = new javax.swing.JPanel();
        painel_AbaPredicao3 = new javax.swing.JScrollPane();
        painel_AbaPredicao4 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        campo_tensaoBombaPredicao = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        campo_nivelT1Predicao = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        campo_predT1Predicao = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel39 = new javax.swing.JLabel();
        campo_erroPredicaoPredicao = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        painel_AbaDiag = new javax.swing.JPanel();
        painel_AbaDiag2 = new javax.swing.JPanel();
        painel_AbaDiag3 = new javax.swing.JScrollPane();
        painel_AbaDiag4 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        campo_nivelT1Diag = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        campo_predT1Diag = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        campo_sinalRealDiag = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel44 = new javax.swing.JLabel();
        campo_sinalEstimadoDiag = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel45 = new javax.swing.JLabel();
        campo_tipoFalhaDiag = new javax.swing.JTextField();
        painel_AbaCorrecao = new javax.swing.JPanel();
        painel_AbaCorrecao2 = new javax.swing.JPanel();
        painel_AbaCorrecao3 = new javax.swing.JScrollPane();
        painel_AbaCorrecao4 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        campo_falhasFiltradasCorrecao = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        campo_sinalCorrigidoCorrecao = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel49 = new javax.swing.JLabel();
        campo_sinalComFalhasCorrecao = new javax.swing.JTextField();
        painel_config = new javax.swing.JPanel();
        painelAba_config = new javax.swing.JTabbedPane();
        painel_ComOPC = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label_statusOPC = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label_hostOPC = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        label_svOPC = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label_clienteOPC = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista_tagsOPC = new javax.swing.JList();
        jLabel20 = new javax.swing.JLabel();
        botao_cadastrarNovaTag = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        painel_RNA = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        campo_enderecoArq = new javax.swing.JTextField();
        botao_carregarArq = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        campo_pesos = new javax.swing.JTextArea();
        botao_habilitarEdicao = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        painel_monitorar = new javax.swing.JPanel();
        painel_barraT1 = new javax.swing.JPanel();
        barra_T1 = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        label_nivelT1 = new javax.swing.JLabel();
        painel_dialTensao = new javax.swing.JPanel();
        painel_monitor = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        campo_nivelT1 = new javax.swing.JTextField();
        campo_predT1 = new javax.swing.JTextField();
        campo_diag = new javax.swing.JTextField();
        campo_tipoFalha = new javax.swing.JTextField();
        campo_nivelCorrigido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campo_tensaoEscrita = new javax.swing.JTextField();
        botao_aplicarTensao = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        lista_tipoFalha = new javax.swing.JComboBox();
        botao_simularFalhas = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        campo_tensao = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menu_painelGraficos = new javax.swing.JMenuItem();
        menu_painelConfig = new javax.swing.JMenuItem();
        menu_painelMonitorar = new javax.swing.JMenuItem();
        menu_avancarTab = new javax.swing.JMenuItem();
        menu_voltarTab = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Inicial");
        setMinimumSize(new java.awt.Dimension(640, 400));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(" "));
        jToolBar1.setFloatable(false);
        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        botao_graficos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botao_graficos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/chart3.png"))); // NOI18N
        botao_graficos.setText("Gráficos");
        botao_graficos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botao_graficos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botao_graficos.setFocusPainted(false);
        botao_graficos.setFocusable(false);
        botao_graficos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botao_graficos.setMaximumSize(new java.awt.Dimension(80, 65));
        botao_graficos.setMinimumSize(new java.awt.Dimension(80, 65));
        botao_graficos.setPreferredSize(new java.awt.Dimension(80, 65));
        botao_graficos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botao_graficos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_graficosActionPerformed(evt);
            }
        });
        jToolBar1.add(botao_graficos);

        botao_config.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botao_config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/set1.png"))); // NOI18N
        botao_config.setText("Config.");
        botao_config.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botao_config.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botao_config.setFocusable(false);
        botao_config.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botao_config.setMaximumSize(new java.awt.Dimension(80, 65));
        botao_config.setMinimumSize(new java.awt.Dimension(80, 65));
        botao_config.setPreferredSize(new java.awt.Dimension(80, 65));
        botao_config.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botao_config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_configActionPerformed(evt);
            }
        });
        jToolBar1.add(botao_config);

        botao_monitorar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botao_monitorar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/monitor1.png"))); // NOI18N
        botao_monitorar.setText("Monitorar");
        botao_monitorar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botao_monitorar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botao_monitorar.setFocusable(false);
        botao_monitorar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botao_monitorar.setMaximumSize(new java.awt.Dimension(80, 65));
        botao_monitorar.setMinimumSize(new java.awt.Dimension(80, 65));
        botao_monitorar.setPreferredSize(new java.awt.Dimension(80, 65));
        botao_monitorar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botao_monitorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_monitorarActionPerformed(evt);
            }
        });
        jToolBar1.add(botao_monitorar);

        painel_graficos.setBorder(javax.swing.BorderFactory.createTitledBorder("Gráficos"));

        javax.swing.GroupLayout painel_AbaGeral2Layout = new javax.swing.GroupLayout(painel_AbaGeral2);
        painel_AbaGeral2.setLayout(painel_AbaGeral2Layout);
        painel_AbaGeral2Layout.setHorizontalGroup(
            painel_AbaGeral2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        painel_AbaGeral2Layout.setVerticalGroup(
            painel_AbaGeral2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        painel_AbaGeral3.setBorder(javax.swing.BorderFactory.createTitledBorder("Monitoramento"));

        painel_AbaGeral4.setPreferredSize(new java.awt.Dimension(185, 150));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("NÍVEL DO TANQUE 1:");

        campo_nivelT1geral.setEditable(false);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("PREDIÇÃO DO TANQUE 1:");

        campo_predT1geral.setEditable(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("SINAL CORRIGIDO:");

        campo_sinalCorrigidogeral.setEditable(false);

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("TENSÃO DA BOMBA:");

        campo_tensaoBombaGeral.setEditable(false);

        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("TIPO DE FALHA:");

        campo_tipoFalhaGeral.setEditable(false);

        javax.swing.GroupLayout painel_AbaGeral4Layout = new javax.swing.GroupLayout(painel_AbaGeral4);
        painel_AbaGeral4.setLayout(painel_AbaGeral4Layout);
        painel_AbaGeral4Layout.setHorizontalGroup(
            painel_AbaGeral4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_AbaGeral4Layout.createSequentialGroup()
                .addGroup(painel_AbaGeral4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campo_nivelT1geral, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(campo_predT1geral, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_sinalCorrigidogeral, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_tensaoBombaGeral, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_tipoFalhaGeral, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 5, Short.MAX_VALUE))
        );
        painel_AbaGeral4Layout.setVerticalGroup(
            painel_AbaGeral4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_AbaGeral4Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_nivelT1geral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_predT1geral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_sinalCorrigidogeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_tensaoBombaGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_tipoFalhaGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 84, Short.MAX_VALUE))
        );

        painel_AbaGeral3.setViewportView(painel_AbaGeral4);

        javax.swing.GroupLayout painel_AbaGeralLayout = new javax.swing.GroupLayout(painel_AbaGeral);
        painel_AbaGeral.setLayout(painel_AbaGeralLayout);
        painel_AbaGeralLayout.setHorizontalGroup(
            painel_AbaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_AbaGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_AbaGeral2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(painel_AbaGeral3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painel_AbaGeralLayout.setVerticalGroup(
            painel_AbaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_AbaGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_AbaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painel_AbaGeral3)
                    .addComponent(painel_AbaGeral2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        painelAba_Graficos.addTab("Geral", painel_AbaGeral);

        javax.swing.GroupLayout painel_AbaPredicao2Layout = new javax.swing.GroupLayout(painel_AbaPredicao2);
        painel_AbaPredicao2.setLayout(painel_AbaPredicao2Layout);
        painel_AbaPredicao2Layout.setHorizontalGroup(
            painel_AbaPredicao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );
        painel_AbaPredicao2Layout.setVerticalGroup(
            painel_AbaPredicao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        painel_AbaPredicao3.setBorder(javax.swing.BorderFactory.createTitledBorder("Monitoramento"));

        painel_AbaPredicao4.setPreferredSize(new java.awt.Dimension(185, 150));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("TENSAO DA BOMBA:");

        campo_tensaoBombaPredicao.setEditable(false);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("NÍVEL DO TANQUE 1:");

        campo_nivelT1Predicao.setEditable(false);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("PREDIÇÃO DO TANQUE 1:");

        campo_predT1Predicao.setEditable(false);

        jSeparator7.setForeground(new java.awt.Color(102, 102, 102));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("ERRO DE PREDIÇÃO DO TANQUE 1:");

        campo_erroPredicaoPredicao.setEditable(false);

        jSeparator8.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout painel_AbaPredicao4Layout = new javax.swing.GroupLayout(painel_AbaPredicao4);
        painel_AbaPredicao4.setLayout(painel_AbaPredicao4Layout);
        painel_AbaPredicao4Layout.setHorizontalGroup(
            painel_AbaPredicao4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_AbaPredicao4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campo_tensaoBombaPredicao, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addComponent(campo_nivelT1Predicao, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(campo_predT1Predicao, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(campo_erroPredicaoPredicao, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING))
            .addComponent(jLabel39)
        );
        painel_AbaPredicao4Layout.setVerticalGroup(
            painel_AbaPredicao4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_AbaPredicao4Layout.createSequentialGroup()
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_tensaoBombaPredicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_nivelT1Predicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_predT1Predicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_erroPredicaoPredicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 130, Short.MAX_VALUE))
        );

        painel_AbaPredicao3.setViewportView(painel_AbaPredicao4);

        javax.swing.GroupLayout painel_AbaPredicaoLayout = new javax.swing.GroupLayout(painel_AbaPredicao);
        painel_AbaPredicao.setLayout(painel_AbaPredicaoLayout);
        painel_AbaPredicaoLayout.setHorizontalGroup(
            painel_AbaPredicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_AbaPredicaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_AbaPredicao2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painel_AbaPredicao3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painel_AbaPredicaoLayout.setVerticalGroup(
            painel_AbaPredicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_AbaPredicaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_AbaPredicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel_AbaPredicao3)
                    .addComponent(painel_AbaPredicao2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        painelAba_Graficos.addTab("Predição do Nível do Tanque", painel_AbaPredicao);

        javax.swing.GroupLayout painel_AbaDiag2Layout = new javax.swing.GroupLayout(painel_AbaDiag2);
        painel_AbaDiag2.setLayout(painel_AbaDiag2Layout);
        painel_AbaDiag2Layout.setHorizontalGroup(
            painel_AbaDiag2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );
        painel_AbaDiag2Layout.setVerticalGroup(
            painel_AbaDiag2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        painel_AbaDiag3.setBorder(javax.swing.BorderFactory.createTitledBorder("Monitoramento"));

        painel_AbaDiag4.setPreferredSize(new java.awt.Dimension(185, 150));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("NÍVEL DO TANQUE 1:");

        campo_nivelT1Diag.setEditable(false);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("PREDIÇÃO DO TANQUE 1:");

        campo_predT1Diag.setEditable(false);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("SINAL REAL:");

        campo_sinalRealDiag.setEditable(false);

        jSeparator9.setForeground(new java.awt.Color(102, 102, 102));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("SINAL ESTIMADO:");

        campo_sinalEstimadoDiag.setEditable(false);

        jSeparator10.setForeground(new java.awt.Color(102, 102, 102));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("TIPO DE FALHA:");

        campo_tipoFalhaDiag.setEditable(false);

        javax.swing.GroupLayout painel_AbaDiag4Layout = new javax.swing.GroupLayout(painel_AbaDiag4);
        painel_AbaDiag4.setLayout(painel_AbaDiag4Layout);
        painel_AbaDiag4Layout.setHorizontalGroup(
            painel_AbaDiag4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_AbaDiag4Layout.createSequentialGroup()
                .addGroup(painel_AbaDiag4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_AbaDiag4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campo_nivelT1Diag, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(campo_predT1Diag, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(campo_sinalRealDiag, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(campo_tipoFalhaDiag, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(campo_sinalEstimadoDiag, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 5, Short.MAX_VALUE))
        );
        painel_AbaDiag4Layout.setVerticalGroup(
            painel_AbaDiag4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_AbaDiag4Layout.createSequentialGroup()
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_nivelT1Diag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_predT1Diag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_sinalRealDiag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_sinalEstimadoDiag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_tipoFalhaDiag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 94, Short.MAX_VALUE))
        );

        painel_AbaDiag3.setViewportView(painel_AbaDiag4);

        javax.swing.GroupLayout painel_AbaDiagLayout = new javax.swing.GroupLayout(painel_AbaDiag);
        painel_AbaDiag.setLayout(painel_AbaDiagLayout);
        painel_AbaDiagLayout.setHorizontalGroup(
            painel_AbaDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_AbaDiagLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_AbaDiag2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painel_AbaDiag3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painel_AbaDiagLayout.setVerticalGroup(
            painel_AbaDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_AbaDiagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_AbaDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel_AbaDiag3, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addComponent(painel_AbaDiag2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        painelAba_Graficos.addTab("Detecção e Diagnóstico de Falhas", painel_AbaDiag);

        javax.swing.GroupLayout painel_AbaCorrecao2Layout = new javax.swing.GroupLayout(painel_AbaCorrecao2);
        painel_AbaCorrecao2.setLayout(painel_AbaCorrecao2Layout);
        painel_AbaCorrecao2Layout.setHorizontalGroup(
            painel_AbaCorrecao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );
        painel_AbaCorrecao2Layout.setVerticalGroup(
            painel_AbaCorrecao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        painel_AbaCorrecao3.setBorder(javax.swing.BorderFactory.createTitledBorder("Monitoramento"));

        painel_AbaCorrecao4.setPreferredSize(new java.awt.Dimension(185, 150));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("FALHAS FILTRADAS:");

        campo_falhasFiltradasCorrecao.setEditable(false);

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("SINAL CORRIGIDO:");

        campo_sinalCorrigidoCorrecao.setEditable(false);

        jSeparator11.setForeground(new java.awt.Color(102, 102, 102));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("SINAL COM FALHAS (NÍVEL T1):");

        campo_sinalComFalhasCorrecao.setEditable(false);

        javax.swing.GroupLayout painel_AbaCorrecao4Layout = new javax.swing.GroupLayout(painel_AbaCorrecao4);
        painel_AbaCorrecao4.setLayout(painel_AbaCorrecao4Layout);
        painel_AbaCorrecao4Layout.setHorizontalGroup(
            painel_AbaCorrecao4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_AbaCorrecao4Layout.createSequentialGroup()
                .addGroup(painel_AbaCorrecao4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(campo_falhasFiltradasCorrecao, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_sinalCorrigidoCorrecao, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_sinalComFalhasCorrecao, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 5, Short.MAX_VALUE))
        );
        painel_AbaCorrecao4Layout.setVerticalGroup(
            painel_AbaCorrecao4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_AbaCorrecao4Layout.createSequentialGroup()
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_falhasFiltradasCorrecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_sinalCorrigidoCorrecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_sinalComFalhasCorrecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 202, Short.MAX_VALUE))
        );

        painel_AbaCorrecao3.setViewportView(painel_AbaCorrecao4);

        javax.swing.GroupLayout painel_AbaCorrecaoLayout = new javax.swing.GroupLayout(painel_AbaCorrecao);
        painel_AbaCorrecao.setLayout(painel_AbaCorrecaoLayout);
        painel_AbaCorrecaoLayout.setHorizontalGroup(
            painel_AbaCorrecaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_AbaCorrecaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_AbaCorrecao2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painel_AbaCorrecao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painel_AbaCorrecaoLayout.setVerticalGroup(
            painel_AbaCorrecaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_AbaCorrecaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_AbaCorrecaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel_AbaCorrecao3, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addComponent(painel_AbaCorrecao2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        painelAba_Graficos.addTab("Correção de Falhas", painel_AbaCorrecao);

        javax.swing.GroupLayout painel_graficosLayout = new javax.swing.GroupLayout(painel_graficos);
        painel_graficos.setLayout(painel_graficosLayout);
        painel_graficosLayout.setHorizontalGroup(
            painel_graficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelAba_Graficos, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        painel_graficosLayout.setVerticalGroup(
            painel_graficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelAba_Graficos)
        );

        painel_camadas.add(painel_graficos);
        painel_graficos.setBounds(0, 0, 554, 448);

        painel_config.setBorder(javax.swing.BorderFactory.createTitledBorder("Configurações"));

        jLabel1.setText("Status: ");

        label_statusOPC.setText("Desconectado.");

        jLabel3.setText("Host:");

        label_hostOPC.setText("127.0.0.1");

        jLabel5.setText("ID do Servidor:");

        label_svOPC.setText("Smar.DfiOleServer.0");

        jLabel7.setText("Nome do Cliente:");

        label_clienteOPC.setText("JOPC");

        jScrollPane2.setViewportView(lista_tagsOPC);

        jLabel20.setText("Lista de Tags Cadastradas:");

        botao_cadastrarNovaTag.setText("Cadastrar Nova Tag");

        jButton2.setText("Remover Tag");

        javax.swing.GroupLayout painel_ComOPCLayout = new javax.swing.GroupLayout(painel_ComOPC);
        painel_ComOPC.setLayout(painel_ComOPCLayout);
        painel_ComOPCLayout.setHorizontalGroup(
            painel_ComOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_ComOPCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_ComOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_ComOPCLayout.createSequentialGroup()
                        .addGroup(painel_ComOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_ComOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_svOPC)
                            .addComponent(label_clienteOPC)))
                    .addGroup(painel_ComOPCLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(painel_ComOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_ComOPCLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_hostOPC))
                            .addGroup(painel_ComOPCLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_statusOPC)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addGroup(painel_ComOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addGroup(painel_ComOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addComponent(botao_cadastrarNovaTag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_ComOPCLayout.setVerticalGroup(
            painel_ComOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_ComOPCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_ComOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(label_statusOPC)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_ComOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_ComOPCLayout.createSequentialGroup()
                        .addGroup(painel_ComOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(label_hostOPC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painel_ComOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(label_svOPC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painel_ComOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(label_clienteOPC))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botao_cadastrarNovaTag)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        painelAba_config.addTab("Comunicação OPC", painel_ComOPC);

        jLabel19.setText("Arquivo:");

        botao_carregarArq.setText("Carregar Arq.");
        botao_carregarArq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_carregarArqActionPerformed(evt);
            }
        });

        campo_pesos.setEditable(false);
        campo_pesos.setColumns(20);
        campo_pesos.setRows(5);
        campo_pesos.setText("iw1\n0,341939391531353\t-0,0247656994222039\t0,107817470468523\t0,00240528273180347\n1,16354745102972\t0,118631740026663\t-2,59925261939883\t0,225139232235336\n-1,52705080580280\t0,689315704940408\t-1,37872487554911\t-0,997800719396453\niw2\n-0,673737804389528\t-0,348359862168781\n4,14017711011266\t-0,481324980922179\n-1,09809160012461\t-1,84942483395229\nlw\n-1,79055357417891\t0,0925067539015195\t0,0206326255919392\nb1\n-0,192495122189390\n-1,90962260655991\n-1,78210621418057\nb2\n-0,246676903660668");
        campo_pesos.setEnabled(false);
        jScrollPane1.setViewportView(campo_pesos);

        botao_habilitarEdicao.setText("Habilitar Edição");
        botao_habilitarEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_habilitarEdicaoActionPerformed(evt);
            }
        });

        jButton1.setText("Aplicar via OPC");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("----------INSTRUÇÕES----------\n\nArquitetura da RNA de modelo NARX:\n2-3-1 com 2 atrasos em cada entrada.\n\nNomear os neurônios e funções de ativação da seguinte forma:\nNeurônios da camada oculta: n11, n12, n21, n22, n31, n32.\nFunções de ativação: FUNÇÃO_DE_ATIVAÇÃO_1 e FUNÇÃO_DE_ATIVAÇÃO_2.\nNeurônios da camada de saída: ns1.");
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout painel_RNALayout = new javax.swing.GroupLayout(painel_RNA);
        painel_RNA.setLayout(painel_RNALayout);
        painel_RNALayout.setHorizontalGroup(
            painel_RNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_RNALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_RNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_RNALayout.createSequentialGroup()
                        .addGroup(painel_RNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_RNALayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campo_enderecoArq))
                            .addGroup(painel_RNALayout.createSequentialGroup()
                                .addGap(0, 277, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_RNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botao_habilitarEdicao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botao_carregarArq, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        painel_RNALayout.setVerticalGroup(
            painel_RNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_RNALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_RNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(campo_enderecoArq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_carregarArq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_RNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_habilitarEdicao)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelAba_config.addTab("Preditor Neural", painel_RNA);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        painelAba_config.addTab("Classificador Fuzzy", jPanel4);

        javax.swing.GroupLayout painel_configLayout = new javax.swing.GroupLayout(painel_config);
        painel_config.setLayout(painel_configLayout);
        painel_configLayout.setHorizontalGroup(
            painel_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_configLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelAba_config)
                .addContainerGap())
        );
        painel_configLayout.setVerticalGroup(
            painel_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_configLayout.createSequentialGroup()
                .addComponent(painelAba_config)
                .addContainerGap())
        );

        painel_camadas.add(painel_config);
        painel_config.setBounds(0, 0, 554, 448);

        painel_monitorar.setBorder(javax.swing.BorderFactory.createTitledBorder("Monitoramento em Tempo-Real"));

        barra_T1.setBackground(new java.awt.Color(255, 255, 255));
        barra_T1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        barra_T1.setForeground(new java.awt.Color(0, 153, 255));
        barra_T1.setMaximum(30);
        barra_T1.setOrientation(1);
        barra_T1.setToolTipText("");
        barra_T1.setValue(20);
        barra_T1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        barra_T1.setBorderPainted(false);
        barra_T1.setString("");
        barra_T1.setStringPainted(true);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Tanque 1");

        jLabel10.setText("30 cm");

        jLabel11.setText("0 cm");

        jLabel12.setText("15 cm");

        label_nivelT1.setText("Nível (cm):");

        javax.swing.GroupLayout painel_barraT1Layout = new javax.swing.GroupLayout(painel_barraT1);
        painel_barraT1.setLayout(painel_barraT1Layout);
        painel_barraT1Layout.setHorizontalGroup(
            painel_barraT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_barraT1Layout.createSequentialGroup()
                .addGroup(painel_barraT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painel_barraT1Layout.createSequentialGroup()
                        .addGroup(painel_barraT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_barraT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(painel_barraT1Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel11))
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_barraT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label_nivelT1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(barra_T1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        painel_barraT1Layout.setVerticalGroup(
            painel_barraT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_barraT1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_barraT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barra_T1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painel_barraT1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_nivelT1)
                .addContainerGap())
        );

        painel_dialTensao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout painel_dialTensaoLayout = new javax.swing.GroupLayout(painel_dialTensao);
        painel_dialTensao.setLayout(painel_dialTensaoLayout);
        painel_dialTensaoLayout.setHorizontalGroup(
            painel_dialTensaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );
        painel_dialTensaoLayout.setVerticalGroup(
            painel_dialTensaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );

        painel_monitor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Nível T1:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Predição T1:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Diagnóstico:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Tipo de Falha:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Nível Corrigido:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        campo_nivelT1.setEditable(false);
        campo_nivelT1.setDragEnabled(true);

        campo_predT1.setEditable(false);
        campo_predT1.setDragEnabled(true);

        campo_diag.setEditable(false);
        campo_diag.setDragEnabled(true);

        campo_tipoFalha.setEditable(false);
        campo_tipoFalha.setDragEnabled(true);

        campo_nivelCorrigido.setEditable(false);
        campo_nivelCorrigido.setDragEnabled(true);

        jLabel2.setText("Tensão da Bomba:");

        botao_aplicarTensao.setText("Aplicar Tensão");
        botao_aplicarTensao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_aplicarTensaoActionPerformed(evt);
            }
        });

        jLabel6.setText("Tipo de Falha:");

        lista_tipoFalha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Falha Zero", "Falha Fundo de Escala", "Falha de Deriva", "Sem Falha", "Falhas em Sequência" }));

        botao_simularFalhas.setText("Simular Falhas");
        botao_simularFalhas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_simularFalhasActionPerformed(evt);
            }
        });

        jLabel8.setText("V ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Simulação de Falhas");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Tensão Escrita na Bomba");

        campo_tensao.setEditable(false);
        campo_tensao.setDragEnabled(true);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Tensão:");

        jLabel23.setText("V ");

        jLabel24.setText("cm");

        jLabel25.setText("cm");

        jLabel26.setText("cm");

        javax.swing.GroupLayout painel_monitorLayout = new javax.swing.GroupLayout(painel_monitor);
        painel_monitor.setLayout(painel_monitorLayout);
        painel_monitorLayout.setHorizontalGroup(
            painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_monitorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_monitorLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lista_tipoFalha, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_monitorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_monitorLayout.createSequentialGroup()
                        .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(botao_simularFalhas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botao_aplicarTensao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel_monitorLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campo_tensaoEscrita, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(campo_predT1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_diag, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_tipoFalha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_nivelT1)
                    .addComponent(campo_tensao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_nivelCorrigido, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addContainerGap())
        );
        painel_monitorLayout.setVerticalGroup(
            painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_monitorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painel_monitorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(campo_tensao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(campo_nivelT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(12, 12, 12)
                        .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(campo_predT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(campo_diag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(campo_tipoFalha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(campo_nivelCorrigido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(15, 15, 15))
                    .addGroup(painel_monitorLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campo_tensaoEscrita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botao_aplicarTensao)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lista_tipoFalha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botao_simularFalhas))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );

        javax.swing.GroupLayout painel_monitorarLayout = new javax.swing.GroupLayout(painel_monitorar);
        painel_monitorar.setLayout(painel_monitorarLayout);
        painel_monitorarLayout.setHorizontalGroup(
            painel_monitorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_monitorarLayout.createSequentialGroup()
                .addGroup(painel_monitorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_monitorarLayout.createSequentialGroup()
                        .addComponent(painel_barraT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(painel_dialTensao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(painel_monitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        painel_monitorarLayout.setVerticalGroup(
            painel_monitorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_monitorarLayout.createSequentialGroup()
                .addComponent(painel_monitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painel_monitorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painel_dialTensao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painel_barraT1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, Short.MAX_VALUE)))
        );

        painel_camadas.add(painel_monitorar);
        painel_monitorar.setBounds(0, 0, 554, 448);

        javax.swing.GroupLayout painel_inicialLayout = new javax.swing.GroupLayout(painel_inicial);
        painel_inicial.setLayout(painel_inicialLayout);
        painel_inicialLayout.setHorizontalGroup(
            painel_inicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_inicialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painel_camadas, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                .addContainerGap())
        );
        painel_inicialLayout.setVerticalGroup(
            painel_inicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_inicialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_inicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painel_camadas, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu1.setText("Sistema");

        jMenuItem3.setText("Parar Simulação de Falhas");
        jMenu1.add(jMenuItem3);

        jMenu4.setText("Simular Falhas");

        jMenuItem5.setText("Falha Zero");
        jMenu4.add(jMenuItem5);

        jMenuItem6.setText("Falha Fundo de Escala");
        jMenu4.add(jMenuItem6);

        jMenuItem7.setText("Falha Deriva");
        jMenu4.add(jMenuItem7);

        jMenuItem2.setText("Sem Falha");
        jMenu4.add(jMenuItem2);

        jMenuItem8.setText("Falhas em Sequência");
        jMenu4.add(jMenuItem8);

        jMenu1.add(jMenu4);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setText("Sair");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Visualizar");

        menu_painelGraficos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.ALT_MASK));
        menu_painelGraficos.setText("Painel Gráficos");
        menu_painelGraficos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_painelGraficosActionPerformed(evt);
            }
        });
        jMenu2.add(menu_painelGraficos);

        menu_painelConfig.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_MASK));
        menu_painelConfig.setText("Painel de Configurações");
        menu_painelConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_painelConfigActionPerformed(evt);
            }
        });
        jMenu2.add(menu_painelConfig);

        menu_painelMonitorar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.ALT_MASK));
        menu_painelMonitorar.setText("Painel Manitorar");
        menu_painelMonitorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_painelMonitorarActionPerformed(evt);
            }
        });
        jMenu2.add(menu_painelMonitorar);

        menu_avancarTab.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.ALT_MASK));
        menu_avancarTab.setText("Avançar Tab");
        menu_avancarTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_avancarTabActionPerformed(evt);
            }
        });
        jMenu2.add(menu_avancarTab);

        menu_voltarTab.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        menu_voltarTab.setText("Voltar Tab");
        menu_voltarTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_voltarTabActionPerformed(evt);
            }
        });
        jMenu2.add(menu_voltarTab);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ajuda");

        jMenuItem1.setText("Sobre");
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_inicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_inicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void principal() {
        ActionListener actionGrafico = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leituraTagsOPC();

                ambiente.setNivelT1(nivelT1);
                ambiente.setPredT1(predT1);
                ambiente.setSinalCorrigido(sinalCorrigido);
                ambiente.setTensaoBomba(tensaoBomba);
                ambiente.setTipoFalha(tipoFalha);
                agDecisao = new Agente_de_Decisao(tensaoBomba, nivelT1, predT1, sinalCorrigido, tipoFalha);

                if (agDecisao.isFlagFalha()) {
                    sinalCorrigido = 0;
                    sinalComFalhasNivelT1 = 0;
                    falhasFiltradas = 0;
                }

                if (tipoFalha < 1) {
                    tipoFalha = 3;
                }

                grafico_geral.addValores(nivelT1, predT1, sinalCorrigido, tensaoBomba, tipoFalha);
                grafico_predicao.addValores(tensaoBomba, nivelT1, predT1, erroPredT1);
                grafico_diagnostico.addValores(nivelT1, predT1, sinalReal, sinalEstimado, tipoFalha);
                grafico_correcao.addValores(falhasFiltradas, sinalCorrigido, sinalComFalhasNivelT1);

                setPropriedadesDoGrafico();
                atualizarCamposMonitoramentoAbaMonitorar();
                atualizarCamposGraficos();
            }
        };
        threadGrafico = new Timer(100, actionGrafico);
        threadGrafico.start();
    }


    private void botao_graficosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_graficosActionPerformed
        painel_config.setVisible(false);
        painel_monitorar.setVisible(false);
        painel_graficos.setVisible(true);
        painel_monitorar.setVisible(false);
        //inicializarGrafico();
        setPropriedadesDoGrafico();
    }//GEN-LAST:event_botao_graficosActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        painel_config.setSize(painel_camadas.getSize());
        painel_monitorar.setSize(painel_camadas.getSize());
        painel_graficos.setSize(painel_camadas.getSize());
        setPropriedadesDoGrafico();
    }//GEN-LAST:event_formComponentResized

    private void botao_configActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_configActionPerformed
        painel_config.setVisible(true);
        painel_monitorar.setVisible(false);
        painel_graficos.setVisible(false);
        painel_monitorar.setVisible(false);

    }//GEN-LAST:event_botao_configActionPerformed

    private void botao_monitorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_monitorarActionPerformed
        painel_config.setVisible(false);
        painel_monitorar.setVisible(false);
        painel_graficos.setVisible(false);
        painel_monitorar.setVisible(true);
        campo_tensaoEscrita.setText(String.valueOf(tensaoBomba));

    }//GEN-LAST:event_botao_monitorarActionPerformed

    private void botao_carregarArqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_carregarArqActionPerformed
        new Tela_AbrirArquivo(this).setVisible(true);
    }//GEN-LAST:event_botao_carregarArqActionPerformed

    private void botao_habilitarEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_habilitarEdicaoActionPerformed
        if (botao_habilitarEdicao.isSelected()) {
            botao_habilitarEdicao.setText("Bloquear Edição");
            campo_pesos.setEditable(true);
            campo_pesos.setEnabled(true);
        } else {
            botao_habilitarEdicao.setText("Habilitar Edição");
            campo_pesos.setEditable(false);
            campo_pesos.setEnabled(false);
        }
    }//GEN-LAST:event_botao_habilitarEdicaoActionPerformed

    private void botao_aplicarTensaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_aplicarTensaoActionPerformed
        cliente.writeTag(tensaoBomba_OPC, Double.parseDouble(campo_tensaoEscrita.getText()));
    }//GEN-LAST:event_botao_aplicarTensaoActionPerformed

    // Falha Zero, Falha Fundo de Escala, Falha de Deriva, Sem Falha
    private void botao_simularFalhasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_simularFalhasActionPerformed
        if (botao_simularFalhas.isSelected()) {
            botao_simularFalhas.setText("PARAR Simulação de Falhas");
            if (!flag) { // primeira vez que entra?
                clienteSim.conectar(cliente.getIp(), cliente.getServidor(), "ClienteSimulacao");
                clienteSim.cadastrarTags(lista);
            }

            // Valor 8 = MODE_BLK em AUTO
            clienteSim.writeTag(EntComFalhasStatus_OPC, 8);
            ActionListener action = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tipoFalha();
                }
            };
            threadEscritaOPC = new Timer(1250, action);
            threadEscritaOPC.start();
//            new Thread(tSimulacao).start();
            flag = true;
            flagEntComFalha = true;
        } else {
            botao_simularFalhas.setText("Simular Falhas");
            System.out.println(simularFalhas.tipoSemFalha(nivelT1));
            threadEscritaOPC.stop();
            // Valor 128 = MODE_BLK em OOS
            clienteSim.writeTag(EntComFalhasStatus_OPC, 128);
            flagEntComFalha = false;
        }
    }//GEN-LAST:event_botao_simularFalhasActionPerformed

    private void menu_painelGraficosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_painelGraficosActionPerformed
        botao_graficosActionPerformed(evt);
    }//GEN-LAST:event_menu_painelGraficosActionPerformed

    private void menu_painelConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_painelConfigActionPerformed
        botao_configActionPerformed(evt);
    }//GEN-LAST:event_menu_painelConfigActionPerformed

    private void menu_painelMonitorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_painelMonitorarActionPerformed
        botao_monitorarActionPerformed(evt);
    }//GEN-LAST:event_menu_painelMonitorarActionPerformed

    private void menu_avancarTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_avancarTabActionPerformed
        int tabAtual = painelAba_Graficos.getSelectedIndex();
        int nTab = painelAba_Graficos.getTabCount();

        if (tabAtual == nTab - 1) {
            painelAba_Graficos.setSelectedIndex(0);
        } else {
            painelAba_Graficos.setSelectedIndex(tabAtual + 1);
        }
    }//GEN-LAST:event_menu_avancarTabActionPerformed

    private void menu_voltarTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_voltarTabActionPerformed
        int tabAtual = painelAba_Graficos.getSelectedIndex();
        int nTab = painelAba_Graficos.getTabCount();

        if (tabAtual == 0) {
            painelAba_Graficos.setSelectedIndex(nTab - 1);
        } else {
            painelAba_Graficos.setSelectedIndex(tabAtual - 1);
        }
    }//GEN-LAST:event_menu_voltarTabActionPerformed

    public void inicializarGraficos() {
        grafico_geral = new Grafico_Geral("Principais Sinais do Sistema", painel_AbaGeral2.getWidth(), painel_AbaGeral2.getHeight());
        grafico_predicao = new Grafico_Predicao("Gráficos da Predição do Nível do Tanque", painel_AbaPredicao2.getWidth(), painel_AbaPredicao2.getHeight());
        grafico_diagnostico = new Grafico_Diagnostico("Gráficos da Detector e Diagnosticador de Falhas", painel_AbaDiag2.getWidth(), painel_AbaDiag2.getHeight());
        grafico_correcao = new Grafico_Correcao("Gráficos de Correção de Falhas", painel_AbaCorrecao2.getWidth(), painel_AbaCorrecao2.getHeight());
        grafico_dial = new Grafico_Dial("Bomba", painel_dialTensao.getWidth(), painel_dialTensao.getHeight());

        grafico_geral.pack();
        painel_AbaGeral2.add(grafico_geral.getContentPane());

        grafico_predicao.pack();
        painel_AbaPredicao2.add(grafico_predicao.getContentPane());

        grafico_diagnostico.pack();
        painel_AbaDiag2.add(grafico_diagnostico.getContentPane());

        grafico_correcao.pack();
        painel_AbaCorrecao2.add(grafico_correcao.getContentPane());

        grafico_dial.pack();
        painel_dialTensao.add(grafico_dial.getContentPane());
    }

    public void setPropriedadesDoGrafico() {
        grafico_geral.setSize(painel_AbaGeral2.getSize());
        grafico_geral.repaint();

        grafico_predicao.setSize(painel_AbaPredicao2.getSize());
        grafico_predicao.repaint();

        grafico_diagnostico.setSize(painel_AbaDiag2.getSize());
        grafico_diagnostico.repaint();

        grafico_correcao.setSize(painel_AbaCorrecao2.getSize());
        grafico_correcao.repaint();
    }

    public void cadastrarMinhasTags() {
        try {
            nivelT1_OPC = new OpcItem("AI_TANQUE1.OUT.VALUE", true, "");
            predT1_OPC = new OpcItem("ns1.OUT.VALUE", true, "");
            tensaoBomba_OPC = new OpcItem("TENSAO.CT_VAL_1", true, "");
            falhasFiltradas_OPC = new OpcItem("SOMADOR_A.OUT.VALUE", true, "");
            sinalEstimado_OPC = new OpcItem("SINAL_ESTIMADO.OUT.VALUE", true, "");
            sinalReal_OPC = new OpcItem("SINAL_REAL.OUT.VALUE", true, "");
            sinalCorrigido_OPC = new OpcItem("SOMADOR_B.OUT.VALUE", true, "");
            tipoFalha_OPC = new OpcItem("DIVISOR.OUT.VALUE", true, "");
            EntComFalhas_OPC = new OpcItem("Entrada_com_Falhas.CT_VAL_1", true, "");
            EntComFalhasStatus_OPC = new OpcItem("Entrada_com_Falhas.MODE_BLK.TARGET", true, "");

            lista.add(nivelT1_OPC);
            lista.add(predT1_OPC);
            lista.add(tensaoBomba_OPC);
            lista.add(falhasFiltradas_OPC);
            lista.add(sinalEstimado_OPC);
            lista.add(sinalReal_OPC);
            lista.add(sinalCorrigido_OPC);
            lista.add(tipoFalha_OPC);
            lista.add(EntComFalhas_OPC);
            lista.add(EntComFalhasStatus_OPC);

            cliente.cadastrarTags(lista);
            lista_tagsOPC.setListData(cliente.ListarTags());
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarMinhasTags()");
        }
    }

    public void cadastrarMinhasTags2() {
        try {
            nivelT1_OPC = new OpcItem("Random.AI_TANQUE1.OUT.VALUE", true, "");
            predT1_OPC = new OpcItem("Random.ns1.OUT.VALUE", true, "");
            tensaoBomba_OPC = new OpcItem("Random.TENSAO.CT_VAL_1", true, "");
            falhasFiltradas_OPC = new OpcItem("Random.SOMADOR_A.OUT.VALUE", true, "");
            sinalEstimado_OPC = new OpcItem("Random.SINAL_ESTIMADO.OUT.VALUE", true, "");
            sinalReal_OPC = new OpcItem("Random.SINAL_REAL.OUT.VALUE", true, "");
            sinalCorrigido_OPC = new OpcItem("Random.SOMADOR_B.OUT.VALUE", true, "");
            tipoFalha_OPC = new OpcItem("Random.DIVISOR.OUT.VALUE", true, "");
            EntComFalhas_OPC = new OpcItem("Random.Entrada_com_Falhas.OUT_1.VALUE", true, "");
            EntComFalhasStatus_OPC = new OpcItem("Random.Entrada_com_Falhas.MODE_BLK.TARGET", true, "");

            lista.add(nivelT1_OPC);
            lista.add(predT1_OPC);
            lista.add(tensaoBomba_OPC);
            lista.add(falhasFiltradas_OPC);
            lista.add(sinalEstimado_OPC);
            lista.add(sinalReal_OPC);
            lista.add(sinalCorrigido_OPC);
            lista.add(tipoFalha_OPC);
            lista.add(EntComFalhas_OPC);
            lista.add(EntComFalhasStatus_OPC);

            cliente.cadastrarTags(lista);
            lista_tagsOPC.setListData(cliente.ListarTags());
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarMinhasTags()");
        }
    }

    public void leituraTagsOPC() {
        if (!flagEntComFalha) {
            nivelT1 = cliente.readTag(nivelT1_OPC);
        } else {
            nivelT1 = cliente.readTag(EntComFalhas_OPC);
            sinalComFalhasNivelT1 = nivelT1;
        }
        predT1 = cliente.readTag(predT1_OPC);
        tensaoBomba = cliente.readTag(tensaoBomba_OPC);
        sinalCorrigido = cliente.readTag(sinalCorrigido_OPC);
        sinalEstimado = cliente.readTag(sinalEstimado_OPC);
        sinalReal = cliente.readTag(sinalReal_OPC);
        tipoFalha = cliente.readTag(tipoFalha_OPC);
        entComFalhas = cliente.readTag(EntComFalhas_OPC);
        entComFalhasStatus = cliente.readTag(EntComFalhasStatus_OPC);
        falhasFiltradas = cliente.readTag(falhasFiltradas_OPC);
        erroPredT1 = cliente.readTag(nivelT1_OPC) - cliente.readTag(predT1_OPC);
    }

    public void atualizarDadosAbaConfig() {
        if (cliente.isConected()) {
            label_statusOPC.setText("Conectado");
        } else {
            label_statusOPC.setText("Desconectado");
            label_statusOPC.setForeground(Color.RED);
        }
        label_hostOPC.setText(cliente.getIp());
        label_svOPC.setText(cliente.getServidor());
        label_clienteOPC.setText(cliente.getNomeCliente());
    }

    public void atualizarCamposMonitoramentoAbaMonitorar() {
        campo_tensao.setText(String.valueOf(roundValue(tensaoBomba, 2, 0)));
        campo_nivelT1.setText(String.valueOf(roundValue(nivelT1, 2, 0)));
        campo_nivelCorrigido.setText(String.valueOf(roundValue(sinalCorrigido, 2, 0)));
        campo_predT1.setText(String.valueOf(roundValue(predT1, 2, 0)));
        campo_tipoFalha.setText(String.valueOf(roundValue(tipoFalha, 2, 0)));
        barra_T1.setValue((int) Math.round(nivelT1));
        barra_T1.setString(String.valueOf(Math.round((nivelT1 * 100) / 30)));
        label_nivelT1.setText("Nivel Tanque 1: " + Math.round(nivelT1) + " cm");
        grafico_dial.setValorDial(tensaoBomba);
    }

    public void atualizarCamposGraficos() {
        //  ABA GERAL
        campo_nivelT1geral.setText(String.valueOf(roundValue(nivelT1, 2, 0)) + " cm");
        campo_predT1geral.setText(String.valueOf(roundValue(predT1, 2, 0)) + " cm");
        campo_sinalCorrigidogeral.setText(String.valueOf(roundValue(sinalCorrigido, 2, 0)) + " cm");
        campo_tensaoBombaGeral.setText(String.valueOf(roundValue(tensaoBomba, 2, 0)) + " V");
        campo_tipoFalhaGeral.setText(String.valueOf(roundValue(tipoFalha, 2, 0)));

        // ABA PREDIÇÃO
        campo_tensaoBombaPredicao.setText(String.valueOf(roundValue(tensaoBomba, 2, 0)) + " V");
        campo_nivelT1Predicao.setText(String.valueOf(roundValue(nivelT1, 2, 0)) + " cm");
        campo_predT1Predicao.setText(String.valueOf(roundValue(predT1, 2, 0)) + " cm");
        campo_erroPredicaoPredicao.setText(String.valueOf(roundValue(erroPredT1, 2, 0)) + " cm");

        // ABA DIAGNOSTICO
        campo_nivelT1Diag.setText(String.valueOf(roundValue(nivelT1, 2, 0)) + " cm");
        campo_predT1Diag.setText(String.valueOf(roundValue(predT1, 2, 0)) + " cm");
        campo_sinalRealDiag.setText(String.valueOf(roundValue(sinalReal, 2, 0)) + " cm");
        campo_sinalEstimadoDiag.setText(String.valueOf(roundValue(sinalEstimado, 2, 0)) + " cm");
        campo_tipoFalhaDiag.setText(String.valueOf(roundValue(tipoFalha, 2, 0)));

        // ABA CORREÇÃO
        campo_falhasFiltradasCorrecao.setText(String.valueOf(roundValue(falhasFiltradas, 2, 0)) + " cm");
        campo_sinalCorrigidoCorrecao.setText(String.valueOf(roundValue(sinalCorrigido, 0, 0)) + " cm");
        campo_sinalComFalhasCorrecao.setText(String.valueOf(roundValue(sinalComFalhasNivelT1, 2, 0)) + " cm");
    }

    public void tipoFalha() {
        if (lista_tipoFalha.getSelectedItem() == "Falha Zero") {
            clienteSim.writeTag(EntComFalhas_OPC, simularFalhas.tipoZero());
        } else if (lista_tipoFalha.getSelectedItem() == "Falha Fundo de Escala") {
            clienteSim.writeTag(EntComFalhas_OPC, simularFalhas.tipoFundoEscala());
        } else if (lista_tipoFalha.getSelectedItem() == "Falha de Deriva") {
            clienteSim.writeTag(EntComFalhas_OPC, simularFalhas.tipoDeriva(cliente.readTag(nivelT1_OPC)));
        } else if (lista_tipoFalha.getSelectedItem() == "Sem Falha") {
            clienteSim.writeTag(EntComFalhas_OPC, simularFalhas.tipoSemFalha(cliente.readTag(nivelT1_OPC)));
        } else if (lista_tipoFalha.getSelectedItem() == "Falhas em Sequência") {
            clienteSim.writeTag(EntComFalhas_OPC, simularFalhas.tipoFalhasEmSequencia(cliente.readTag(nivelT1_OPC)));
        }
    }

    public double roundValue(double valor, int casas, int ceilOrFloor) {
        double arredondado = valor;
        arredondado *= (Math.pow(10, casas));
        if (ceilOrFloor == 0) {
            arredondado = Math.ceil(arredondado);
        } else {
            arredondado = Math.floor(arredondado);
        }
        arredondado /= (Math.pow(10, casas));
        return arredondado;
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
    //            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (InstantiationException ex) {
    //            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (IllegalAccessException ex) {
    //            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        }
    //        java.awt.EventQueue.invokeLater(new Runnable() {
    //
    //            public void run() {
    //                new Tela_Inicial().setVisible(true);
    //            }
    //        });
    //    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra_T1;
    private javax.swing.JButton botao_aplicarTensao;
    private javax.swing.JButton botao_cadastrarNovaTag;
    private javax.swing.JButton botao_carregarArq;
    private javax.swing.JButton botao_config;
    private javax.swing.JButton botao_graficos;
    private javax.swing.JToggleButton botao_habilitarEdicao;
    private javax.swing.JButton botao_monitorar;
    private javax.swing.JToggleButton botao_simularFalhas;
    private javax.swing.JTextField campo_diag;
    public javax.swing.JTextField campo_enderecoArq;
    private javax.swing.JTextField campo_erroPredicaoPredicao;
    private javax.swing.JTextField campo_falhasFiltradasCorrecao;
    private javax.swing.JTextField campo_nivelCorrigido;
    private javax.swing.JTextField campo_nivelT1;
    private javax.swing.JTextField campo_nivelT1Diag;
    private javax.swing.JTextField campo_nivelT1Predicao;
    private javax.swing.JTextField campo_nivelT1geral;
    public javax.swing.JTextArea campo_pesos;
    private javax.swing.JTextField campo_predT1;
    private javax.swing.JTextField campo_predT1Diag;
    private javax.swing.JTextField campo_predT1Predicao;
    private javax.swing.JTextField campo_predT1geral;
    private javax.swing.JTextField campo_sinalComFalhasCorrecao;
    private javax.swing.JTextField campo_sinalCorrigidoCorrecao;
    private javax.swing.JTextField campo_sinalCorrigidogeral;
    private javax.swing.JTextField campo_sinalEstimadoDiag;
    private javax.swing.JTextField campo_sinalRealDiag;
    private javax.swing.JTextField campo_tensao;
    private javax.swing.JTextField campo_tensaoBombaGeral;
    private javax.swing.JTextField campo_tensaoBombaPredicao;
    private javax.swing.JTextField campo_tensaoEscrita;
    private javax.swing.JTextField campo_tipoFalha;
    private javax.swing.JTextField campo_tipoFalhaDiag;
    private javax.swing.JTextField campo_tipoFalhaGeral;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel label_clienteOPC;
    private javax.swing.JLabel label_hostOPC;
    private javax.swing.JLabel label_nivelT1;
    private javax.swing.JLabel label_statusOPC;
    private javax.swing.JLabel label_svOPC;
    private javax.swing.JList lista_tagsOPC;
    private javax.swing.JComboBox lista_tipoFalha;
    private javax.swing.JMenuItem menu_avancarTab;
    private javax.swing.JMenuItem menu_painelConfig;
    private javax.swing.JMenuItem menu_painelGraficos;
    private javax.swing.JMenuItem menu_painelMonitorar;
    private javax.swing.JMenuItem menu_voltarTab;
    private javax.swing.JTabbedPane painelAba_Graficos;
    private javax.swing.JTabbedPane painelAba_config;
    private javax.swing.JPanel painel_AbaCorrecao;
    private javax.swing.JPanel painel_AbaCorrecao2;
    private javax.swing.JScrollPane painel_AbaCorrecao3;
    private javax.swing.JPanel painel_AbaCorrecao4;
    private javax.swing.JPanel painel_AbaDiag;
    private javax.swing.JPanel painel_AbaDiag2;
    private javax.swing.JScrollPane painel_AbaDiag3;
    private javax.swing.JPanel painel_AbaDiag4;
    private javax.swing.JPanel painel_AbaGeral;
    private javax.swing.JPanel painel_AbaGeral2;
    private javax.swing.JScrollPane painel_AbaGeral3;
    private javax.swing.JPanel painel_AbaGeral4;
    private javax.swing.JPanel painel_AbaPredicao;
    private javax.swing.JPanel painel_AbaPredicao2;
    private javax.swing.JScrollPane painel_AbaPredicao3;
    private javax.swing.JPanel painel_AbaPredicao4;
    private javax.swing.JPanel painel_ComOPC;
    private javax.swing.JPanel painel_RNA;
    private javax.swing.JPanel painel_barraT1;
    private javax.swing.JLayeredPane painel_camadas;
    private javax.swing.JPanel painel_config;
    private javax.swing.JPanel painel_dialTensao;
    private javax.swing.JPanel painel_graficos;
    private javax.swing.JPanel painel_inicial;
    private javax.swing.JPanel painel_monitor;
    private javax.swing.JPanel painel_monitorar;
    // End of variables declaration//GEN-END:variables
}
