package OPC;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafish.clients.opc.browser.JOpcBrowser;
import javafish.clients.opc.component.OpcItem;
import javafish.clients.opc.exception.ConnectivityException;
import javafish.clients.opc.exception.UnableAddGroupException;
import javafish.clients.opc.exception.UnableAddItemException;
import javafish.clients.opc.exception.UnableBrowseBranchException;
import javafish.clients.opc.exception.UnableBrowseLeafException;
import javafish.clients.opc.exception.UnableIBrowseException;

/**
 *
 * @author Luiz
 */
public class HandlerOPCTree {

    private OPCTree tree;
    private JOpcBrowser browser;

    public HandlerOPCTree(JOpcBrowser browser) {
        this.browser = browser;
    }

    public void populaArvore() {
        OPCNode raiz = populaArvore(null);
        tree = new OPCTree(raiz);
    }

    private OPCNode populaArvore(OPCNode node) {
        if (node == null) {
            node = new OPCNode();
        }

        String caminho = node.getCaminhoCompleto();

        try {
            String[] branches = browser.getOpcBranch(caminho.toString());

            for (String branch : branches) {
                if (branch.equals("Read Error")) {
                    continue;
                }
                OPCNode no = new OPCNode(node, branch);
                node.adicionarFilho(no);
                populaArvore(no);
            }

        } catch (UnableBrowseBranchException ex) {
            try {
                if (!caminho.equals("Simulation Items.Read Error")) { //Erro muito estranho
                    String[] items = browser.getOpcItems(caminho.toString(), true);

                    for (String item : items) {
                        if (item.contains(":") && !item.contains("Time")) {
                            String[] itemAux = tratarArray(item);
                            for (String x : itemAux) {
                                OPCNode no = new OPCNode(node, new OpcItem(x, true, ""));
                                node.adicionarFilho(no);
                            }
                        } else {
                            OPCNode no = new OPCNode(node, new OpcItem(node.getNome() + "." + item, true, ""));
                            node.adicionarFilho(no);
                        }
                    }
                }

                return node;

            } catch (UnableBrowseLeafException | UnableIBrowseException | UnableAddGroupException | UnableAddItemException ex1) {
                ex1.printStackTrace();
            }
        } catch (UnableIBrowseException ex) {
            ex.printStackTrace();
        }

        return node;
    }

    private String[] tratarArray(String tag) {
        String[] item = tag.split(";");

        //Pegar o tamanho do vetor
        String[] elem1 = item[0].split("-");
        int index1 = Character.getNumericValue(elem1[0].trim().charAt(1));
        int index2 = Character.getNumericValue(elem1[1].trim().charAt(1));

        String[] retorno = new String[index2 - index1 + 1];

        //pegar o ultimo elemento
        String ultimo = item[item.length - 2];

        StringBuilder x = new StringBuilder(ultimo.substring(0, ultimo.length() - 1));

        for (int i = index1; i <= index2; i++) {
            retorno[i - index1] = x.toString() + i;
        }

        return retorno;

    }

    public OPCTree getTree() {
        return tree;
    }

    public ArrayList<OpcItem> getItemsFromTree(ArrayList<String> nomes) {
        return tree.getItemsFromTree(nomes);
    }

    public void resetTree() {
        this.tree = null;
    }

    public ArrayList<OPCNode> getTagTONode(ArrayList<OpcItem> tags) {
        ArrayList<OPCNode> retorno = new ArrayList<OPCNode>();

        for (OPCNode no : tree.getFolhas()) {
            for (OpcItem tag : tags) {
                if (no.getItem().equals(tag)) {
                    retorno.add(no);
                }
            }
        }

        return retorno;
    }

    public static void main(String[] args) {
        try {
            JOpcBrowser.coInitialize();
            JOpcBrowser browser = new JOpcBrowser("localhost", "Smar.DfiOleServer.0", "JOPC_Cliente");
            browser.connect();
            HandlerOPCTree handler = new HandlerOPCTree(browser);
            handler.populaArvore();
            JOpcBrowser.coUninitialize();
        } catch (ConnectivityException ex) {
            Logger.getLogger(HandlerOPCTree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
