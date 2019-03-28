/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.licvhn.appcodbar.web.utilities;

import java.util.List;

/**
 *
 * @author James Carrillo
 */
public class ManagerZPLComand {

    public static String getComandosZPL(String type_code, String medida, int count_columns,
            List<BeansCodBar> list, String nameCompany) {
        StringBuilder sComandZPL = new StringBuilder();
        String[] nombresProducto = new String[3];
        String[] precios = new String[3];
        String[] codigosProducto = new String[3];
        //VALIDATION TYPE_CODE
        switch (type_code) {
            case "EAN_8":
                type_code = "^B8N";
                break;
            case "EAN_13":
                type_code = "^BEN";
                break;
            //case "CODE_128":
            default:
                type_code = "^BCN";
                break;
        }
        for (int i = 0; i < list.size(); i = i + count_columns) {
            nombresProducto[0] = list.get(i).getNombre();
            precios[0] = list.get(i).getPrecio();
            codigosProducto[0] = list.get(i).getCodigo();
            switch (count_columns) {
                case 2:
                    nombresProducto[1] = list.get(i + 1).getNombre();
                    precios[1] = list.get(i + 1).getPrecio();
                    codigosProducto[1] = list.get(i + 1).getCodigo();
                    break;
                case 3:
                    nombresProducto[1] = list.get(i + 1).getNombre();
                    precios[1] = list.get(i + 1).getPrecio();
                    codigosProducto[1] = list.get(i + 1).getCodigo();

                    nombresProducto[2] = list.get(i + 2).getNombre();
                    precios[2] = list.get(i + 2).getPrecio();
                    codigosProducto[2] = list.get(i + 2).getCodigo();
                    break;
            }
            sComandZPL.append(ManagerUM.getZpl(type_code, medida, count_columns, nameCompany, nombresProducto, precios, codigosProducto));
        }
        return sComandZPL.toString();
    }

}
