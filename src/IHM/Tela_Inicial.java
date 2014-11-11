package IHM;

//import graficos.Controle_Grafico;
import OPC.ClienteOPC;
import SimularFalhas.SimularFalhas;
import graficos.Grafico_Geral;
import graficos.Controle_Grafico_Dial;
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
    private Controle_Grafico_Dial graficoDial;
    private SimularFalhas simularFalhas = new SimularFalhas();
    private Timer t, t2;
    private double i = 0.0;
    private ClienteOPC cliente;
    private ArrayList<OpcItem> lista = new ArrayList<>();
    private OpcItem nivelT1_OPC, predT1_OPC, tensaoBomba_OPC, falhasFiltradas_OPC, sinalEstimado_OPC, sinalReal_OPC, sinalCorrigido_OPC, tipoFalha_OPC, EntComFalhasStatus_OPC, EntComFalhas_OPC;
    private double nivelT1, predT1, tensaoBomba, sinalCorrigido, sinalEstimado, sinalReal, tipoFalha, entComFalhas, entComFalhasStatus, falhasFiltradas;
    private double tagErroPred;
    private ClienteOPC clienteSim = new ClienteOPC();
    private boolean flag = false;

    public Tela_Inicial(ClienteOPC cliente) {
        initComponents();
        setLocationRelativeTo(null);
        this.cliente = cliente;
        setExtendedState(MAXIMIZED_BOTH);
        cadastrarMinhasTags();
        inicializarGraficos();
        setPropriedadesDoGrafico();
        atualizarDadosAbaConfig();
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
        painel_AbaPredicao = new javax.swing.JPanel();
        painel_AbaDiag = new javax.swing.JPanel();
        painel_AbaCorrecao = new javax.swing.JPanel();
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
        painel_RNA = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        campo_enderecoArq = new javax.swing.JTextField();
        botao_carregarArq = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        campo_pesos = new javax.swing.JTextArea();
        botao_habilitarEdicao = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        painel_monitorar = new javax.swing.JPanel();
        painel_barraT1 = new javax.swing.JPanel();
        barra_T1 = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
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
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Inicial");
        setMinimumSize(new java.awt.Dimension(640, 400));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        painel_inicial.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToolBar1.setBorder(null);
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

        javax.swing.GroupLayout painel_AbaGeralLayout = new javax.swing.GroupLayout(painel_AbaGeral);
        painel_AbaGeral.setLayout(painel_AbaGeralLayout);
        painel_AbaGeralLayout.setHorizontalGroup(
            painel_AbaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );
        painel_AbaGeralLayout.setVerticalGroup(
            painel_AbaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        painelAba_Graficos.addTab("Geral", painel_AbaGeral);

        javax.swing.GroupLayout painel_AbaPredicaoLayout = new javax.swing.GroupLayout(painel_AbaPredicao);
        painel_AbaPredicao.setLayout(painel_AbaPredicaoLayout);
        painel_AbaPredicaoLayout.setHorizontalGroup(
            painel_AbaPredicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );
        painel_AbaPredicaoLayout.setVerticalGroup(
            painel_AbaPredicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        painelAba_Graficos.addTab("Predição do Nível do Tanque", painel_AbaPredicao);

        javax.swing.GroupLayout painel_AbaDiagLayout = new javax.swing.GroupLayout(painel_AbaDiag);
        painel_AbaDiag.setLayout(painel_AbaDiagLayout);
        painel_AbaDiagLayout.setHorizontalGroup(
            painel_AbaDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );
        painel_AbaDiagLayout.setVerticalGroup(
            painel_AbaDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        painelAba_Graficos.addTab("Detecção e Diagnóstico de Falhas", painel_AbaDiag);

        javax.swing.GroupLayout painel_AbaCorrecaoLayout = new javax.swing.GroupLayout(painel_AbaCorrecao);
        painel_AbaCorrecao.setLayout(painel_AbaCorrecaoLayout);
        painel_AbaCorrecaoLayout.setHorizontalGroup(
            painel_AbaCorrecaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );
        painel_AbaCorrecaoLayout.setVerticalGroup(
            painel_AbaCorrecaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addGroup(painel_ComOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(jLabel20)
                    .addComponent(botao_cadastrarNovaTag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(label_clienteOPC)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botao_cadastrarNovaTag)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addGap(0, 281, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_RNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botao_habilitarEdicao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botao_carregarArq, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelAba_config.addTab("Preditor Neural", painel_RNA);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
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

        painel_monitorar.setBorder(javax.swing.BorderFactory.createTitledBorder("Monitorar"));

        painel_barraT1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        barra_T1.setBackground(new java.awt.Color(255, 255, 255));
        barra_T1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        barra_T1.setForeground(new java.awt.Color(0, 153, 255));
        barra_T1.setMaximum(30);
        barra_T1.setOrientation(1);
        barra_T1.setValue(20);
        barra_T1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        barra_T1.setBorderPainted(false);
        barra_T1.setRequestFocusEnabled(false);
        barra_T1.setString("55%");
        barra_T1.setStringPainted(true);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Tanque 1");

        jLabel10.setText("30 cm");

        jLabel11.setText("0 cm");

        jLabel12.setText("15 cm");

        jLabel13.setText("Nível (cm):");

        javax.swing.GroupLayout painel_barraT1Layout = new javax.swing.GroupLayout(painel_barraT1);
        painel_barraT1.setLayout(painel_barraT1Layout);
        painel_barraT1Layout.setHorizontalGroup(
            painel_barraT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_barraT1Layout.createSequentialGroup()
                .addGroup(painel_barraT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_barraT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painel_barraT1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel11))
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_barraT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(barra_T1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
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
                .addComponent(jLabel13)
                .addContainerGap())
        );

        painel_dialTensao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout painel_dialTensaoLayout = new javax.swing.GroupLayout(painel_dialTensao);
        painel_dialTensao.setLayout(painel_dialTensaoLayout);
        painel_dialTensaoLayout.setHorizontalGroup(
            painel_dialTensaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
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

        campo_nivelT1.setEnabled(false);

        campo_predT1.setEnabled(false);

        campo_diag.setEnabled(false);

        campo_tipoFalha.setEnabled(false);

        campo_nivelCorrigido.setEnabled(false);

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

        campo_tensao.setEnabled(false);

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
                .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painel_monitorLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campo_nivelCorrigido, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                    .addGroup(painel_monitorLayout.createSequentialGroup()
                        .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campo_predT1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(campo_diag, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_tipoFalha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_nivelT1)
                            .addComponent(campo_tensao))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)))
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
                            .addComponent(jLabel26)))
                    .addGroup(painel_monitorLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(220, Short.MAX_VALUE))
        );
        painel_monitorarLayout.setVerticalGroup(
            painel_monitorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_monitorarLayout.createSequentialGroup()
                .addComponent(painel_monitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painel_monitorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel_barraT1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painel_dialTensao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        painel_camadas.add(painel_monitorar);
        painel_monitorar.setBounds(0, 0, 554, 448);

        javax.swing.GroupLayout painel_inicialLayout = new javax.swing.GroupLayout(painel_inicial);
        painel_inicial.setLayout(painel_inicialLayout);
        painel_inicialLayout.setHorizontalGroup(
            painel_inicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_inicialLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painel_camadas, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );
        painel_inicialLayout.setVerticalGroup(
            painel_inicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
            .addGroup(painel_inicialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_camadas)
                .addContainerGap())
        );

        jMenu1.setText("Arquivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenuBar1.add(jMenu2);

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

    private void botao_graficosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_graficosActionPerformed
        painel_config.setVisible(false);
        painel_monitorar.setVisible(false);
        painel_graficos.setVisible(true);
        painel_monitorar.setVisible(false);
        //inicializarGrafico();
        setPropriedadesDoGrafico();

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leituraTagsOPC();

                grafico_geral.addValores(nivelT1, predT1, sinalCorrigido, tensaoBomba, tipoFalha);
                grafico_predicao.addValores(tensaoBomba, nivelT1, predT1, tagErroPred);
                grafico_diagnostico.addValores(nivelT1, predT1, sinalReal, sinalEstimado, tipoFalha);
                grafico_correcao.addValores(falhasFiltradas, sinalCorrigido, nivelT1);

                setPropriedadesDoGrafico();
                atualizarCamposGraficosAbaMonitorar();
            }
        };
        t = new Timer(100, action);
        t.start();
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
            t2 = new Timer(1000, action);
            t2.start();
//            new Thread(tSimulacao).start();
            flag = true;
        } else {
            botao_simularFalhas.setText("Simular Falhas");
            System.out.println(simularFalhas.tipoSemFalha(nivelT1));
            t2.stop();
            // Valor 128 = MODE_BLK em OOS
            clienteSim.writeTag(EntComFalhasStatus_OPC, 128);

        }
    }//GEN-LAST:event_botao_simularFalhasActionPerformed

    public void inicializarGraficos() {
        grafico_geral = new Grafico_Geral("Principais Sinais do Sistema", painel_AbaGeral.getWidth(), painel_AbaGeral.getHeight());
        grafico_predicao = new Grafico_Predicao("Gráficos da Predição do Nível do Tanque", painel_AbaPredicao.getWidth(), painel_AbaPredicao.getHeight());
        grafico_diagnostico = new Grafico_Diagnostico("Gráficos da Detector e Diagnosticador de Falhas", painel_AbaDiag.getWidth(), painel_AbaDiag.getHeight());
        grafico_correcao = new Grafico_Correcao("Gráficos de Correção de Falhas", painel_AbaCorrecao.getWidth(), painel_AbaCorrecao.getHeight());
        graficoDial = new Controle_Grafico_Dial("Bomba", painel_dialTensao.getWidth(), painel_dialTensao.getHeight());

        grafico_geral.pack();
        painel_AbaGeral.add(grafico_geral.getContentPane());

        grafico_predicao.pack();
        painel_AbaPredicao.add(grafico_predicao.getContentPane());

        grafico_diagnostico.pack();
        painel_AbaDiag.add(grafico_diagnostico.getContentPane());

        grafico_correcao.pack();
        painel_AbaCorrecao.add(grafico_correcao.getContentPane());

        graficoDial.pack();
        painel_dialTensao.add(graficoDial.getContentPane());
    }

    public void setPropriedadesDoGrafico() {
        grafico_geral.setSize(painel_AbaGeral.getSize());
        grafico_geral.repaint();

        grafico_predicao.setSize(painel_AbaPredicao.getSize());
        grafico_predicao.repaint();

        grafico_diagnostico.setSize(painel_AbaDiag.getSize());
        grafico_diagnostico.repaint();

        grafico_correcao.setSize(painel_AbaCorrecao.getSize());
        grafico_correcao.repaint();

        graficoDial.setSize(painel_dialTensao.getSize());
        graficoDial.repaint();
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
        nivelT1 = cliente.readTag(nivelT1_OPC);
        predT1 = cliente.readTag(predT1_OPC);
        tensaoBomba = cliente.readTag(tensaoBomba_OPC);
        sinalCorrigido = cliente.readTag(sinalCorrigido_OPC);
        sinalEstimado = cliente.readTag(sinalEstimado_OPC);
        sinalReal = cliente.readTag(sinalReal_OPC);
        tipoFalha = cliente.readTag(tipoFalha_OPC);
        entComFalhas = cliente.readTag(EntComFalhas_OPC);
        entComFalhasStatus = cliente.readTag(EntComFalhasStatus_OPC);
        falhasFiltradas = cliente.readTag(falhasFiltradas_OPC);
        tagErroPred = cliente.readTag(nivelT1_OPC) - cliente.readTag(predT1_OPC);
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

    public void atualizarCamposGraficosAbaMonitorar() {
        campo_tensao.setText(String.valueOf(tensaoBomba));
        campo_nivelT1.setText(String.valueOf(nivelT1));
        campo_nivelCorrigido.setText(String.valueOf(sinalCorrigido));
    }

    public void tipoFalha() {
        if (lista_tipoFalha.getSelectedItem() == "Falha Zero") {
//            System.out.println(simularFalhas.tipoZero());
            clienteSim.writeTag(EntComFalhas_OPC, simularFalhas.tipoZero());
        } else if (lista_tipoFalha.getSelectedItem() == "Falha Fundo de Escala") {
//            System.out.println(simularFalhas.tipoFundoEscala());
            clienteSim.writeTag(EntComFalhas_OPC, simularFalhas.tipoFundoEscala());
        } else if (lista_tipoFalha.getSelectedItem() == "Falha de Deriva") {
//            System.out.println(simularFalhas.tipoDeriva(cliente.readTag(nivelT1_OPC)));
            clienteSim.writeTag(EntComFalhas_OPC, simularFalhas.tipoDeriva(nivelT1));
        } else if (lista_tipoFalha.getSelectedItem() == "Sem Falha") {
//            System.out.println(simularFalhas.tipoSemFalha(cliente.readTag(nivelT1_OPC)));
            clienteSim.writeTag(EntComFalhas_OPC, simularFalhas.tipoSemFalha(nivelT1));
        } else if (lista_tipoFalha.getSelectedItem() == "Falhas em Sequência") {
//            System.out.println(simularFalhas.tipoFalhasEmSequencia(cliente.readTag(nivelT1_OPC)));
            clienteSim.writeTag(EntComFalhas_OPC, simularFalhas.tipoFalhasEmSequencia(nivelT1));
        }
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
    private javax.swing.JTextField campo_nivelCorrigido;
    private javax.swing.JTextField campo_nivelT1;
    public javax.swing.JTextArea campo_pesos;
    private javax.swing.JTextField campo_predT1;
    private javax.swing.JTextField campo_tensao;
    private javax.swing.JTextField campo_tensaoEscrita;
    private javax.swing.JTextField campo_tipoFalha;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel label_clienteOPC;
    private javax.swing.JLabel label_hostOPC;
    private javax.swing.JLabel label_statusOPC;
    private javax.swing.JLabel label_svOPC;
    private javax.swing.JList lista_tagsOPC;
    private javax.swing.JComboBox lista_tipoFalha;
    private javax.swing.JTabbedPane painelAba_Graficos;
    private javax.swing.JTabbedPane painelAba_config;
    private javax.swing.JPanel painel_AbaCorrecao;
    private javax.swing.JPanel painel_AbaDiag;
    private javax.swing.JPanel painel_AbaGeral;
    private javax.swing.JPanel painel_AbaPredicao;
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
