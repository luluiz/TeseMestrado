package OPC;

import java.util.ArrayList;
import javafish.clients.opc.component.OpcItem;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Luiz
 */
public class OPCTree implements TreeModel {

    OPCNode root;

    public OPCTree(OPCNode root) {
        this.root = root;
    }

    public OPCTree() {
        this.root = new OPCNode();
    }

    /**
     * Realiza uma busca na arvore na procura pelas folhas da mesma.
     *
     * @return Retorna todas as folhas da arvore.
     */
    public ArrayList<OPCNode> getFolhas() {
        OPCNode elemento_retirado;
        ArrayList<OPCNode> folhas = new ArrayList<OPCNode>();
        ArrayList<OPCNode> fila = new ArrayList<OPCNode>();

        if (root == null) {
            return null;
        }
        if (root.getFilhos().isEmpty()) {
            folhas.add(root);
        }

        OPCNode atual = root;
        fila.add(atual);

        while (!fila.isEmpty()) {

            elemento_retirado = fila.remove(0);
            atual = elemento_retirado;

            for (OPCNode filhos : atual.getFilhos()) {
                if (!filhos.isFolha()) {
                    fila.add(filhos);
                } else {
                    folhas.add(filhos);
                }
            }
        }

        return folhas;
    }

    /**
     *
     * @return Retorna todos os OpcItems (folhas) guardados na arvore.
     */
    public ArrayList<OpcItem> getOPCItens() {
        ArrayList<OpcItem> retorno = new ArrayList<OpcItem>();

        ArrayList<OPCNode> folhas = getFolhas();

        for (OPCNode folha : folhas) {
            if (folha.isFolha()) {
                retorno.add(folha.getItem());
            }
        }

        return retorno;
    }

    /**
     *
     * @return Retorna todos os OpcItems (folhas) guardados na arvore sem
     * repeticoes.
     */
    public ArrayList<OpcItem> getOPCItensSemRepeticao() {
        ArrayList<OpcItem> retorno = new ArrayList<OpcItem>();

        ArrayList<OPCNode> folhas = getFolhas();

        for (OPCNode folha : folhas) {
            if (!retorno.contains(folha.getItem())) {
                retorno.add(folha.getItem());
            }
        }

        return retorno;
    }

    public ArrayList<String> getOPCItensNome() {
        ArrayList<String> retorno = new ArrayList<String>();

        ArrayList<OPCNode> folhas = getFolhas();

        for (OPCNode folha : folhas) {
            if (!retorno.contains(folha.getItemName())) {
                retorno.add(folha.getItemName());
            }
        }
        return retorno;
    }

    public ArrayList<OpcItem> getItemsFromTree(ArrayList<String> nomes) {
        ArrayList<OpcItem> items = getOPCItensSemRepeticao();
        ArrayList<OpcItem> retorno = new ArrayList<OpcItem>();

        for (OpcItem item : items) {
            if (nomes.contains(item.getItemName())) {
                retorno.add(item);
            }
        }

        return retorno;
    }

    public Object getRoot() {
        return root;
    }

    public Object getChild(Object parent, int index) {
        OPCNode pai = (OPCNode) parent;
        if (pai.getFilhos() != null) {
            return pai.getFilhos().get(index);
        } else {
            return null;
        }
    }

    public int getChildCount(Object parent) {
        OPCNode pai = (OPCNode) parent;
        return pai.getFilhos() == null ? 0 : pai.getFilhos().size();
    }

    public boolean isLeaf(Object node) {
        OPCNode no = (OPCNode) node;
        return no.isFolha();
    }

    public int getIndexOfChild(Object parent, Object child) {
        OPCNode pai = (OPCNode) parent;
        OPCNode filho = (OPCNode) child;

        return pai.getFilhos().indexOf(filho);
    }

    public void valueForPathChanged(TreePath path, Object newValue) {
    }

    public void addTreeModelListener(TreeModelListener l) {
    }

    public void removeTreeModelListener(TreeModelListener l) {
    }

}
