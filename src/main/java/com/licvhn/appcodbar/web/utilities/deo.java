/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.licvhn.appcodbar.web.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

/**
 *
 * @author James Carrillo
 */
public class deo {

    public static void main(String[] args) {
        List<BeansCodBar> lista = new ArrayList<>();
        BeansCodBar beans1 = new BeansCodBar();
        //beans1.setNombre("CAMISA MANGA LARGA");PR0000000003
        beans1.setNombre("NOMBRE DEL PRODUCTO 1");
        beans1.setPrecio("S/ 19.99");
        beans1.setCodigo("0000001");
        //beans1.setCodigo("PR12572183");
        BeansCodBar beans2 = new BeansCodBar();
        beans2.setNombre("NOMBRE DEL PRODUCTO 2");
        beans2.setPrecio("S/ 129.99");
        //beans2.setCodigo("PR1557231244");
        beans2.setCodigo("0000002");
        BeansCodBar beans3 = new BeansCodBar();
        beans3.setNombre("NOMBRE DEL PRODUCTO 3");
        beans3.setPrecio("S/ 21.99");
        beans3.setCodigo("0000003");
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans3);
        /*
        lista.add(beans2);
        
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
        lista.add(beans1);
        lista.add(beans2);
         */

        try {
            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
            //NUM MAXIMO DE CARACTERES 33 POR FILA EN 2X1

            //String s = ManagerZPLComand.getComandosZPL("CODE_128", "2x1", 2, lista, "RED SOLUCIONES SAC");
            //String s = ManagerZPLComand.getComandosZPL("EAN_13", "2x1", 2, lista, "RED SOLUCIONES SAC");
            //String s = ManagerZPLComand.getComandosZPL("CODE_128", "1.18x1.18", 3, lista, "FERRETERIA DON PABLITO");
            //String s = ManagerZPLComand.getComandosZPL("EAN_8", "1.18x1.18", 3, lista, "FERRETERIA DON PABLITO");
            //String s = ManagerZPLComand.getComandosZPL("EAN_13", "1.18x1.18", 3, lista, "FERRETERIA DON PABLITO");
            String s = ManagerZPLComand.getComandosZPL("CODE_128", "1.18x0.78", 3, lista, "RED SOLUCIONES SAC");
            //String s = ManagerZPLComand.getComandosZPL("EAN_13", "1.18x0.78", 3, lista, "RED SOLUCIONES SAC");
            //String s = ManagerZPLComand.getComandosZPL("EAN_8", "1.18x0.78", 3, lista, "RED SOLUCIONES SAC");
            System.out.println(s);

// convertimos el comando a bytes
            byte[] by = s.getBytes();
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            Doc doc = new SimpleDoc(by, flavor, null);

// creamos el printjob
            DocPrintJob job = printService.createPrintJob();

// imprimimos
            job.print(doc, null);
        } catch (PrintException ex) {
            Logger.getLogger(deo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String centrarTexto(String nombreEmpresa) {
        String cadena = "";//SUPUESTO TXT
        String linea = nombreEmpresa;
        boolean linealarga = false;
        boolean salto = false;
        int cantidadDigitosLineaTemp = 0;
        int tamañosiguientepalabra = 0;
        String cadenaTemp = "";//va a almacenar caracter por caracter hasta que complete la linea
        if (linea.length() > 33) {
            linealarga = true;
        }
        int iterador = 0;//iterador de los caracteres de cada linea
        for (int i = 0; i < linea.length(); i++) {
            //SI ES LINEA LARGA O GRANDE
            if (linealarga) {
                //VERIFICAMOS EL TAMAÑO DE LA SIGUIENTE PALABRA
                if (linea.substring(i, i + 1).equals(" ")) {
                    for (int j = i + 1; j < linea.length(); j++) {
                        tamañosiguientepalabra++;
                        if (linea.substring(j, j + 1).equals(" ")) {
                            break;
                        }
                    }
                }
                //VERIFICAMOS SI ALCANZA O NO LA SIGUIENTE PALABRA
                if (iterador + tamañosiguientepalabra < 33) {
                    cadenaTemp = cadenaTemp + linea.substring(i, i + 1);
                    iterador++;
                    cantidadDigitosLineaTemp++;
                    if (i == linea.length() - 1) {
                        salto = true;
                    }
                } else {
                    //ENTRA ACA SI NO ALCANZA Y DARA UN SALTO DE LINEA
                    cadenaTemp = cadenaTemp + "\n";
                    iterador = 0;
                    salto = true;
                }
                tamañosiguientepalabra = 0;
            } else {
                if (linea.substring(i, i + 1).equals(" ")) {
                    for (int j = i + 1; j < linea.length(); j++) {
                        tamañosiguientepalabra++;
                        if (linea.substring(j, j + 1).equals(" ")) {
                            break;
                        }
                    }
                }
                if (iterador + tamañosiguientepalabra < 33) {
                    cadenaTemp = cadenaTemp + linea.substring(i, i + 1);
                    iterador++;
                    cantidadDigitosLineaTemp++;
                    if (i == linea.length() - 1) {
                        salto = true;
                    }
                }

                tamañosiguientepalabra = 0;
            }
            //CENTRAR LA LINEA TEMPO            
            //solo si salto entrara a centrar
            if (salto) {
                String nuevaLineaTemp = "";
                int espaciosParaCentrar = (33 - cantidadDigitosLineaTemp) / 2;
                for (int j = 0; j < espaciosParaCentrar; j++) {
                    nuevaLineaTemp = nuevaLineaTemp + " ";
                }
                nuevaLineaTemp = nuevaLineaTemp + cadenaTemp;//sus espacios mas la cadtempo
                cadena = cadena + nuevaLineaTemp; //lo que tenia + nueva linea temp
                cantidadDigitosLineaTemp = 0;
                cadenaTemp = "";
            }
            salto = false;
        }
        return cadena;
    }

}
