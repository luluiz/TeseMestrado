package IHM;

//import graficos.Controle_Grafico;
import OPC.ClienteOPC;
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
    private Timer t;
    private double i = 0.0;
    private ClienteOPC cliente;
    private ArrayList<OpcItem> lista = new ArrayList<>();
    private OpcItem nivelT1, predT1, tensaoBomba, falhasFiltradas, sinalEstimado, sinalReal, sinalCorrigido, tipoFalha;
    private double tagErroPred;

    public Tela_Inicial(ClienteOPC cliente) {
        initComponents();
        setLocationRelativeTo(null);
        this.cliente = cliente;
        setExtendedState(MAXIMIZED_BOTH);
        cadastrarMinhasTags2();
        inicializarGraficos();
        atualizarGrafico();
        atualizarDadosAbaConfig();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
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

        jTextField1.setEnabled(false);

        jTextField2.setEnabled(false);

        jTextField3.setEnabled(false);

        jTextField4.setEnabled(false);

        jTextField5.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout painel_monitorarLayout = new javax.swing.GroupLayout(painel_monitorar);
        painel_monitorar.setLayout(painel_monitorarLayout);
        painel_monitorarLayout.setHorizontalGroup(
            painel_monitorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_monitorarLayout.createSequentialGroup()
                .addGroup(painel_monitorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_monitorarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painel_barraT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(painel_dialTensao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painel_monitorarLayout.setVerticalGroup(
            painel_monitorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_monitorarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_monitorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel_dialTensao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painel_barraT1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
        atualizarGrafico();

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tagErroPred = cliente.readTag(nivelT1) - cliente.readTag(predT1);

                grafico_geral.addValores(cliente.readTag(nivelT1), cliente.readTag(predT1), cliente.readTag(sinalCorrigido), cliente.readTag(tensaoBomba), cliente.readTag(tipoFalha));
                grafico_predicao.addValores(cliente.readTag(tensaoBomba), cliente.readTag(nivelT1), cliente.readTag(predT1), tagErroPred);
                grafico_diagnostico.addValores(cliente.readTag(nivelT1), cliente.readTag(predT1), cliente.readTag(sinalReal), cliente.readTag(sinalEstimado), cliente.readTag(tipoFalha));
                grafico_correcao.addValores(cliente.readTag(falhasFiltradas), cliente.readTag(sinalCorrigido), cliente.readTag(nivelT1));

                atualizarGrafico();
            }
        };
        t = new Timer(500, action);
        t.start();
    }//GEN-LAST:event_botao_graficosActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        painel_config.setSize(painel_camadas.getSize());
        painel_monitorar.setSize(painel_camadas.getSize());
        painel_graficos.setSize(painel_camadas.getSize());
        atualizarGrafico();
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

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
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

    public void atualizarGrafico() {
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
            nivelT1 = new OpcItem("AI_TANQUE1.OUT.VALUE", true, "");
            predT1 = new OpcItem("ns1.OUT.VALUE", true, "");
            tensaoBomba = new OpcItem("TENSAO.CT_VAL_1", true, "");
            falhasFiltradas = new OpcItem("SOMADOR_A.OUT.VALUE", true, "");
            sinalEstimado = new OpcItem("SINAL_ESTIMADO.OUT.VALUE", true, "");
            sinalReal = new OpcItem("SINAL_REAL.OUT.VALUE", true, "");
            sinalCorrigido = new OpcItem("SOMADOR_B.OUT.VALUE", true, "");
            tipoFalha = new OpcItem("DIVISOR.OUT.VALUE", true, "");

            lista.add(nivelT1);
            lista.add(predT1);
            lista.add(tensaoBomba);
            lista.add(falhasFiltradas);
            lista.add(sinalEstimado);
            lista.add(sinalReal);
            lista.add(sinalCorrigido);
            lista.add(tipoFalha);

            cliente.cadastrarTags(lista);
            lista_tagsOPC.setListData(cliente.ListarTags());
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarMinhasTags()");
        }
    }

    public void cadastrarMinhasTags2() {
        try {
            nivelT1 = new OpcItem("Random.AI_TANQUE1.OUT.VALUE", true, "");
            predT1 = new OpcItem("Random.ns1.OUT.VALUE", true, "");
            tensaoBomba = new OpcItem("Random.TENSAO.CT_VAL_1", true, "");
            falhasFiltradas = new OpcItem("Random.SOMADOR_A.OUT.VALUE", true, "");
            sinalEstimado = new OpcItem("Random.SINAL_ESTIMADO.OUT.VALUE", true, "");
            sinalReal = new OpcItem("Random.SINAL_REAL.OUT.VALUE", true, "");
            sinalCorrigido = new OpcItem("Random.SOMADOR_B.OUT.VALUE", true, "");
            tipoFalha = new OpcItem("Random.DIVISOR.OUT.VALUE", true, "");

            lista.add(nivelT1);
            lista.add(predT1);
            lista.add(tensaoBomba);
            lista.add(falhasFiltradas);
            lista.add(sinalEstimado);
            lista.add(sinalReal);
            lista.add(sinalCorrigido);
            lista.add(tipoFalha);

            cliente.cadastrarTags(lista);
            lista_tagsOPC.setListData(cliente.ListarTags());
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarMinhasTags()");
        }
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
    private javax.swing.JButton botao_cadastrarNovaTag;
    private javax.swing.JButton botao_carregarArq;
    private javax.swing.JButton botao_config;
    private javax.swing.JButton botao_graficos;
    private javax.swing.JToggleButton botao_habilitarEdicao;
    private javax.swing.JButton botao_monitorar;
    public javax.swing.JTextField campo_enderecoArq;
    public javax.swing.JTextArea campo_pesos;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel label_clienteOPC;
    private javax.swing.JLabel label_hostOPC;
    private javax.swing.JLabel label_statusOPC;
    private javax.swing.JLabel label_svOPC;
    private javax.swing.JList lista_tagsOPC;
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
    private javax.swing.JPanel painel_monitorar;
    // End of variables declaration//GEN-END:variables
}
