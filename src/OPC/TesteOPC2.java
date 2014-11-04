package OPC;

import java.util.ArrayList;
import javafish.clients.opc.component.OpcGroup;
import javafish.clients.opc.component.OpcItem;

/**
 *
 * @author Veyron-PC
 */
public class TesteOPC2 {

    public static void main(String[] args) {
        ClienteOPC cliente = new ClienteOPC("localhost");
        OpcItem item;
        cliente.conectar("Smar.DfiOleServer.0");

        OpcItem nivelT1 = new OpcItem("AI_TANQUE1.OUT.VALUE", true, "");
        OpcItem predT1 = new OpcItem("ns1.OUT.VALUE", true, "");
        OpcItem tensaoBomba = new OpcItem("TENSAO.CT_VAL_1", true, "");
        OpcItem falhasFiltradas = new OpcItem("SOMADOR_A.OUT.VALUE", true, "");
        OpcItem sinalEstimado = new OpcItem("SINAL_ESTIMADO.OUT.VALUE", true, "");
        OpcItem sinalReal = new OpcItem("SINAL_REAL.OUT.VALUE", true, "");
        OpcItem sinalCorrigido = new OpcItem("SOMADOR_B.OUT.VALUE", true, "");
        OpcItem tipoFalha = new OpcItem("DIVISOR.OUT.VALUE", true, "");

        ArrayList<OpcItem> lista = new ArrayList<>();
        lista.add(nivelT1);
        lista.add(predT1);
        lista.add(tensaoBomba);
        lista.add(falhasFiltradas);
        lista.add(sinalEstimado);
        lista.add(sinalReal);
        lista.add(sinalCorrigido);
        lista.add(tipoFalha);

        cliente.cadastrarTags(lista);

        double x = cliente.readTag(nivelT1);
        System.out.println(x);

        cliente.writeTag(tensaoBomba, 0);

        for (int i = 0; i < cliente.ListarTags().length; i++) {
            System.out.println(cliente.ListarTags()[i]);
        }

        cliente.desconectar();
    }
}
