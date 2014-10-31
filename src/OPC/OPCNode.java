package OPC;

import java.util.ArrayList;
import java.util.Vector;
import javafish.clients.opc.component.OpcItem;

/**
 *
 * @author Luiz
 */
public class OPCNode {
    //Se item for diferente de null, entao o No em questao eh folha.

    private OpcItem item = null;
    private ArrayList<OPCNode> filhos = new ArrayList<OPCNode>();
    private OPCNode pai;
    private String nome; //indica o nome do "branche" de grupos da arvore do servidor OPC.

    public OPCNode() {
        pai = null; //Raiz
        nome = "";
    }

    public OPCNode(String nome) {
        this.nome = nome;
    }

    public OPCNode(OPCNode pai, String nome) {
        this.pai = pai;
        this.nome = nome;
    }

    public OPCNode(OPCNode pai) {
        this.pai = pai;
    }

    /**
     * Se o Node tem um item diferente de null associado a ele, entao ele eh uma
     * folha da arvore.
     * @param pai Pai do Node
     * @param item Tag OPC.
     */
    public OPCNode(OPCNode pai, OpcItem item) {
        this.pai = pai;
        this.item = item;
        this.nome = getItemName();
    }

    public void adicionarFilho(OPCNode filho) {
        filhos.add(filho);
    }

    public ArrayList<OPCNode> getFilhos() {
        return filhos;
    }

    public OpcItem getItem() {
        return item;
    }

    public void setItem(OpcItem item) {
        this.item = item;
    }

    public OPCNode getPai() {
        return pai;
    }

    public void setPai(OPCNode pai) {
        this.pai = pai;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isFolha() {
        return item != null;
    }

    public boolean isRoot() {
        return this.pai == null;
    }

    /**
     *
     * @return Retorna todo o caminho percorrido na arvore desde a raiz ate o no
     * atual.
     */
    public String getCaminhoCompleto() {

        if (this.isRoot()) {
            return this.nome;
        }

        Vector<String> cam = new Vector<String>();
        OPCNode node = this;

        while (!node.isRoot()) {
            cam.add(node.getNome());
            node = node.getPai();
        }

        String caminho = new String();

        for (String x : cam) {
            caminho = x + "." + caminho;
        }


        int index = caminho.lastIndexOf(".");

        return index < 0 ? caminho : caminho.substring(0, index);
    }

    public String getItemName() {
        if (item == null) {
            return null;
        } else {
            String name = item.getItemName();
            name = name.split(";")[0];
//            name = name.split("\\.")[1];
            return name;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        OPCNode noObj = (OPCNode) obj;

        if (noObj.isFolha() && this.isFolha()) {
            if (noObj.getItem().equals(this.item)) {
                return true;
            } else {
                return false;
            }
        }

        return this.getNome().equals(noObj.getNome());
    }

    @Override
    public String toString() {
        if (isFolha()) {
            return getItemName();
//            return this.item.getItemName();
        }
        return this.nome;
    }
}
