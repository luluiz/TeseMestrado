package OPC;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafish.clients.opc.JOpc;
import javafish.clients.opc.browser.JOpcBrowser;
import javafish.clients.opc.component.OpcGroup;
import javafish.clients.opc.component.OpcItem;
import javafish.clients.opc.exception.ComponentNotFoundException;
import javafish.clients.opc.exception.ConnectivityException;
import javafish.clients.opc.exception.HostException;
import javafish.clients.opc.exception.NotFoundServersException;
import javafish.clients.opc.exception.SynchReadException;
import javafish.clients.opc.exception.SynchWriteException;
import javafish.clients.opc.exception.UnableAddGroupException;
import javafish.clients.opc.exception.UnableAddItemException;
import javafish.clients.opc.exception.UnableRemoveGroupException;
import javafish.clients.opc.variant.Variant;

/**
 *
 * @author Luiz
 */
public class TesteClienteOPC {

    private JOpcBrowser browser;
    private JOpc servidorOPC;
    private String ip;
    private boolean conectado = false;
    private HandlerOPCTree handler;
    OpcGroup group = new OpcGroup("UDUGROUP", true, 100, 0.0f);
    double conversao = 4092;

    public TesteClienteOPC() {
        JOpcBrowser.coInitialize();
        JOpc.coInitialize();
        ip = null;
    }

    public TesteClienteOPC(String ip) {
        this(); //construtor padrao
        this.ip = ip;
    }

    /**
     * Obtem todos os servidor OPC existentes em um dado endereÃ§o IP.
     *
     * @param ip IP da maquina.
     * @return Retorna um vetor com o nome de todos os servidores OPC presentes
     * na maquina. Caso nenhum servidor seja encontrada eh retornado null;
     */
    public String[] getAllServers(String ip) {
        String[] retorno = null;
        try {
            retorno = JOpcBrowser.getOpcServers(ip);
        } catch (HostException | NotFoundServersException ex) {
            //ex.printStackTrace();
        } finally {
            return retorno;
        }
    }

    /**
     * Conecta a um dado servidor OPC. Se ja estiver conectado a algum servidor,
     * eh necessario primeiro que se desconecte do mesmo atraves do metodo
     * desconectar().
     *
     * @param ip IP do servidor.
     * @param servidor Nome do servidor OPC.
     */
    public void conectar(String ip, String servidor) {
        if (isConected()) {
            return;
        }
        String ipBackUp = this.ip;
        this.ip = ip;
        try {
            conectar(servidor);
        } catch (Exception ex) {
            //Se ocorrer algum problema, nao atualiza o IP do cliente.
            this.ip = ipBackUp;
            ex.printStackTrace();
        }
    }

    /**
     * Conecta a um dado servidor OPC. Se ja estiver conectado a algum servidor,
     * eh necessario primeiro que se desconecte do mesmo atraves do metodo
     * desconectar().
     *
     * @param servidor Nome do servidor OPC.
     */
    public void conectar(String servidor) {
        if (isConected()) {
            return;
        }

        try {
            //inicializar o servidorOPC e o browser
            browser = new JOpcBrowser(ip, servidor, "OPCBrowser1");
            servidorOPC = new JOpc(ip, servidor, "OPC1");

            browser.connect();
            servidorOPC.connect();
            conectado = true;

            servidorOPC.addGroup(group);
            servidorOPC.registerGroup(group);

            handler = new HandlerOPCTree(browser);
            handler.resetTree();

        } catch (ComponentNotFoundException | UnableAddGroupException | ConnectivityException ex) {
            Logger.getLogger(TesteClienteOPC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconectar() {
        JOpcBrowser.coUninitialize();
        JOpc.coUninitialize();

        conectado = false;

        handler.resetTree();
    }

    public boolean isConected() {
        return this.conectado;
    }

    /**
     * Monta uma arvore para armazenar todas as tags OPC contidas no servidor.
     *
     * @return Retorna a arvore montada.
     */
    public OPCTree getOPCTree() {

        if (handler.getTree() == null) {
            handler.populaArvore();
        }

        return handler.getTree();
    }

    /**
     * Lista todas as tags OPC cadastradas no servidor. Elimina repeticoes.
     *
     * @return Retornas todas as tags OPC.
     */
    public ArrayList<OpcItem> listarOPCItems() {
        OPCTree tree = getOPCTree();
        return tree.getOPCItensSemRepeticao();
    }

    /**
     * Lista o nome de todas as tags OPC cadastradas no servidor. Elimina
     * repeticoes.
     *
     * @return Retorna o nome de todas as tags OPC.
     */
    public ArrayList<String> getItemsName() {
        ArrayList<OpcItem> items = listarOPCItems();
        ArrayList<String> retorno = new ArrayList<String>();

        for (OpcItem item : items) {
            retorno.add(item.getItemName());
        }

        return retorno;
    }

    /**
     * Cadastra as variaveis OPC que serao monitoradas
     *
     * @param tagsOPC
     */
    public void cadastrarTags(ArrayList<OpcItem> tagsOPC) {
        try {
            servidorOPC.unregisterGroup(group);

            for (OpcItem tag : tagsOPC) {
                try {
                    group.addItem(tag);
                } catch (ComponentNotFoundException ex) {
                    Logger.getLogger(TesteClienteOPC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            servidorOPC.updateGroups();
            servidorOPC.registerGroups();

        } catch (UnableAddGroupException | UnableAddItemException | ComponentNotFoundException | UnableRemoveGroupException ex) {
            Logger.getLogger(TesteClienteOPC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Informa todas as tags OPC que foram cadastradas pelo cliente.
     *
     * @return Retorna o vetor de tags cadastradas.
     */
    public ArrayList<OpcItem> getTagsCadastradas() {
        return group.getItems();
    }

    /**
     * Remove do grupo uma tag previamente cadastrada.
     *
     * @param tag Tag a ser removida do grupo.
     */
    public void removerTag(OpcItem tag) {
        group.removeItem(tag);
    }

    public void removerAllTags() {
        for (OpcItem item : group.getItems()) {
            group.removeItem(item);
        }
        servidorOPC.updateGroups();
    }

    /**
     * Ler o valor de uma tag OPC.
     *
     * @param tag Tag a ser lida.
     * @return Retorna o valor atual da tag.
     */
    public synchronized double readTag(OpcItem tag) {
        try {
            synchronized (this) {
                try {
                    this.wait(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TesteClienteOPC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            OpcItem responseItem = servidorOPC.synchReadItem(group, tag);
            return (Double.parseDouble(responseItem.getValue().toString()) / conversao) * 100;

        } catch (ComponentNotFoundException | SynchReadException ex) {
            Logger.getLogger(TesteClienteOPC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1; //Erro de leitura
    }

    /**
     * Altera o valor atual de uma dada tag OPC.
     *
     * @param tag Tag a ser alterada
     * @param novoValor Novo valor que sera atribuido a tag OPC.
     */
    public void writeTag(OpcItem tag, double novoValor) {
        try {
            try {
//            synchronized (this) {
//                try {
//                    this.wait(100);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(ClienteOPC.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(TesteClienteOPC.class.getName()).log(Level.SEVERE, null, ex);
            }

            tag.setValue(new Variant(novoValor * conversao));
            servidorOPC.synchWriteItem(group, tag);

        } catch (ComponentNotFoundException | SynchWriteException ex) {
            Logger.getLogger(TesteClienteOPC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JOpc getServidorOPC() {
        return servidorOPC;
    }

    public static String getItemName(OpcItem tag) {
        if (tag == null) {
            return null;
        } else {
            String name = tag.getItemName();
            name = name.split(";")[0];
//            name = name.split("\\.")[1];
            return name;
        }
    }

    public ArrayList<OPCNode> getTagTONode(ArrayList<OpcItem> tags) {
        return handler.getTagTONode(tags);
    }

    public boolean isArvoreMontada() {
        return handler.getTree() != null;
    }
}
