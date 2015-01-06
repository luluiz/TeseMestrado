/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.util.ArrayList;

/**
 *
 * @author Veyron-PC
 */
public class NewClass {

    public static void main(String[] args) {
        ArrayList<String[][]> array = new ArrayList<String[][]>();
        String[][] s = new String[1][2];
        s[0][0] = "1";
        s[0][1] = "2";
        array.add(s);
        System.out.println(array.get(0).toString());
    }
}
