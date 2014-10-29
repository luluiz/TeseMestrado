/*//
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeopc;

import java.util.ArrayList;
import javafish.clients.opc.component.OpcGroup;
import javafish.clients.opc.component.OpcItem;
import javafish.clients.opc.exception.ComponentNotFoundException;
import javafish.clients.opc.exception.SynchReadException;

/**
 *
 * @author Veyron-PC
 */
public class TesteOPC2 {

    public static void main(String[] args) throws InterruptedException, ComponentNotFoundException, SynchReadException {
        ClienteOPC cliente = new ClienteOPC("localhost");
        
        //OpcItem item1 = new OpcItem("AI_TANQUE1.OUT.VALUE", true, "");
        //OpcItem item2 = new OpcItem("TENSAO.CT_VAL_1", true, "");
//
//        OpcGroup group = new OpcGroup("MeuGrupo", true, 500, 0.0f);
//
//        group.addItem(item1);
//        group.addItem(item2);
 //       ArrayList<OpcItem> listTags = null;
//        listTags.addAll();
//        listTags.add(item2);
        //cliente.cadastrarTags(listTags);

        //cliente.conectar("localhost", "Smar.DfiOleServer.0");
        
        String[] s = cliente.getAllServers("localhost");
        System.out.println("Servidores: " + s[0]);
        
        //ArrayList<OpcItem> tags = new ArrayList<OpcItem>();
//        tags.add(item1);
  //      tags.add(item2);

    //    cliente.cadastrarTags(tags);

      //  ArrayList<OpcItem> tagsCadastradas = cliente.getTagsCadastradas();
        //cliente.writeTag(item2, 4.0);
      //  ArrayList<String> x = cliente.getItemsName();
     //   System.out.println(tagsCadastradas);
        //System.out.println(x.get(0));
    }
}
