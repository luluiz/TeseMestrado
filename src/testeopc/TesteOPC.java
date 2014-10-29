package testeopc;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafish.clients.opc.JEasyOpc;
import javafish.clients.opc.JOpc;
import javafish.clients.opc.component.*;
import javafish.clients.opc.exception.*;
import javafish.clients.opc.variant.Variant;

public class TesteOPC {

    public static void main(String[] args) throws InterruptedException, ComponentNotFoundException, SynchReadException {

        JOpc.coInitialize();
        JEasyOpc jopc = new JEasyOpc("localhost", "Smar.DfiOleServer.0", "JOPC_Cliente");

        OpcItem item1 = new OpcItem("AI_TANQUE1.OUT.VALUE", true, "");
        OpcItem item2 = new OpcItem("TENSAO.CT_VAL_1", true, "");

        OpcGroup group = new OpcGroup("MeuGrupo", true, 500, 0.0f);

        group.addItem(item1);
        group.addItem(item2);
        jopc.addGroup(group);

        try {
            jopc.connect();
            System.out.println("JOPC Conectado!");

        } catch (ConnectivityException e) {
            e.printStackTrace();
        }

        try {
            jopc.registerGroups();
        } catch (UnableAddGroupException ex) {
            Logger.getLogger(TesteOPC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnableAddItemException ex) {
            Logger.getLogger(TesteOPC.class.getName()).log(Level.SEVERE, null, ex);
        }

        OpcGroup response = jopc.synchReadGroup(group);
        String valor = response.getItems().get(0).toString();

        String[] array = valor.split(";");

        System.out.println(array[2].toString().trim() + "\n" + array[6].toString().trim());

        try {
            item2.setValue(new Variant(2.1));
            jopc.synchWriteItem(group, item2);
        } catch (SynchWriteException ex) {
            Logger.getLogger(TesteOPC.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        JOpc.coUninitialize();
    }
}
