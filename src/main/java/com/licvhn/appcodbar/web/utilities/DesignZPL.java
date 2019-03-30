/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.licvhn.appcodbar.web.utilities;

import java.util.Map;

/**
 *
 * @author James Carrillo
 */
public class DesignZPL {

    /*
        CODE 2 X 1
     */
    public static String getZPL_CODE_128__2x1(
            Map<String, String> parameters,
            Map<String, String> parameters_coordenadas,
            int cantColumnas, String nombresProducto[],
            String[] precios, String[] codigosProducto) {
        StringBuilder sZPL = new StringBuilder();
        sZPL.append("^XA \n");
        for (int i = 0; i < cantColumnas; i++) {
            //VALIDAMOS SI SUPERA LA CANTIDAD MAX X FILA
            sZPL.append("^FO ");
            sZPL.append(parameters_coordenadas.get("corx_empresa" + (i + 1)));
            sZPL.append(",");
            sZPL.append(parameters_coordenadas.get("cory_empresa" + (i + 1)));
            sZPL.append(" ^ADN ^FD");
            sZPL.append(centerTextEtiqueta(parameters.get("NOMBRE_EMPRESA"), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
            sZPL.append("^FS \n");
            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_empresa" + (i + 1))) + 25);
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_empresa" + (i + 1))) + 20);
            sZPL.append("^GB350,1,1^FS \n");
            //suma_coordenada_y += suma_coordenada_y; //por la linea
            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_producto" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))));
            sZPL.append(" ^ADN ^FD");
            sZPL.append(centerTextEtiqueta(nombresProducto[i], Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
            sZPL.append("^FS \n");

            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_precio" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_precio" + (i + 1))));
            sZPL.append(" ^ADN ^FD");
            sZPL.append(centerTextEtiqueta(precios[i], Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
            sZPL.append("^FS \n");

            //String code_ = "^BCN, ";
            //String code_ = "^B8N, ";
            sZPL.append("^BY2,2 ");
            sZPL.append(parameters.get("TYPE_CODE"));
            sZPL.append(",");
            sZPL.append(parameters.get("ALTO_CODBAR"));
            sZPL.append(",Y,N");
            sZPL.append(" \n");
            sZPL.append("^FO ");
            //VERIFICAMOS SI ES DE TIPO EAN8
            if (codigosProducto[i].trim().length() == 12) {
                sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))));
            } else {
                //cor x base = 10
                sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))) + (15 * (12 - codigosProducto[i].trim().length())));
            }
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_codigo" + (i + 1))));
            sZPL.append("^FD");
            sZPL.append(codigosProducto[i].trim());
            sZPL.append("^FS \n");
        }
        sZPL.append("^XZ");
        return sZPL.toString();
    }

    public static String getZPL_CODE_EAN_13__2x1(
            Map<String, String> parameters,
            Map<String, String> parameters_coordenadas,
            int cantColumnas, String nombresProducto[],
            String[] precios, String[] codigosProducto) {
        StringBuilder sZPL = new StringBuilder();
        sZPL.append("^XA \n");
        for (int i = 0; i < cantColumnas; i++) {
            //VALIDAMOS SI SUPERA LA CANTIDAD MAX X FILA
            sZPL.append("^FO ");
            sZPL.append(parameters_coordenadas.get("corx_empresa" + (i + 1)));
            sZPL.append(",");
            sZPL.append(parameters_coordenadas.get("cory_empresa" + (i + 1)));
            sZPL.append(" ^ADN ^FD");
            sZPL.append(centerTextEtiqueta(parameters.get("NOMBRE_EMPRESA"), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
            sZPL.append("^FS \n");
            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_empresa" + (i + 1))) + 25);
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_empresa" + (i + 1))) + 20);
            sZPL.append("^GB350,1,1^FS \n");
            //suma_coordenada_y += suma_coordenada_y; //por la linea
            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_producto" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))));
            sZPL.append(" ^ADN ^FD");
            sZPL.append(centerTextEtiqueta(nombresProducto[i], Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
            sZPL.append("^FS \n");

            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_precio" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_precio" + (i + 1))));
            sZPL.append(" ^ADN ^FD");
            sZPL.append(centerTextEtiqueta(precios[i], Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
            sZPL.append("^FS \n");

            //String code_ = "^BCN, ";
            //String code_ = "^B8N, ";
            sZPL.append("^BY3,2 ");
            sZPL.append(parameters.get("TYPE_CODE"));
            sZPL.append(",");
            sZPL.append(parameters.get("ALTO_CODBAR"));
            sZPL.append(",Y,N");
            sZPL.append(" \n");
            sZPL.append("^FO ");
            //VERIFICAMOS SI ES DE TIPO EAN8
            if (codigosProducto[i].trim().length() == 12) {
                sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))));
            } else {
                //cor x base = 10
                sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))) + (15 * (12 - codigosProducto[i].trim().length())));
            }
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_codigo" + (i + 1))));
            sZPL.append("^FD");
            sZPL.append(codigosProducto[i].trim());
            sZPL.append("^FS \n");
        }
        sZPL.append("^XZ");
        return sZPL.toString();
    }

    /*
        CODE 1.8 X 1.8
     */
    public static String getZPL_CODE_128__1_8x1_8(
            Map<String, String> parameters,
            Map<String, String> parameters_coordenadas,
            int cantColumnas, String nombresProducto[],
            String[] precios, String[] codigosProducto) {
        StringBuilder sZPL = new StringBuilder();
        sZPL.append("^XA \n");
        String[] palabras_temp;
        String row_temp;
        for (int i = 0; i < cantColumnas; i++) {
            //VALIDAMOS SI SUPERA LA CANTIDAD MAX X FILA
            int suma_coordenada_y = 0;
            //DOS FILAS EL NOMBRE DE LA EMPRESA, SIEMPRE Y CUANDO SEA EAN_8
            //VALIDAMOS QUE NO SUPERE EL MAXIMO DE 2 FILAS
            palabras_temp = parameters.get("NOMBRE_EMPRESA").trim().split(" ");
            //ITERAMOS LAS PALABRAS
            for (int j = 0; j < 2; j++) {
                row_temp = "";
                for (String palabra : palabras_temp) {
                    if (row_temp.length() + palabra.length() <= Integer.parseInt(parameters.get("TAM_MAX_FILA"))) {
                        row_temp += palabra + " ";
                    } else {
                        break;
                    }
                }
                //PRINT
                if (j == 0) {
                    sZPL.append("^FO ");
                    sZPL.append(parameters_coordenadas.get("corx_empresa" + (i + 1)));
                    sZPL.append(",");
                    sZPL.append(parameters_coordenadas.get("cory_empresa" + (i + 1)));
                    sZPL.append(" ^ADN ^FD");
                    sZPL.append(centerTextEtiqueta(row_temp.trim(), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                    sZPL.append("^FS \n");
                    suma_coordenada_y += 20;
                } else {
                    //verificamos que sea diferente de vacio
                    String new_string = parameters.get("NOMBRE_EMPRESA").trim().substring(row_temp.trim().length(), parameters.get("NOMBRE_EMPRESA").trim().length());
                    if (!new_string.equals("")) {
                        sZPL.append("^FO ");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_empresa" + (i + 1))));
                        sZPL.append(",");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_empresa" + (i + 1))) + 20);
                        sZPL.append(" ^ADN ^FD");
                        sZPL.append(centerTextEtiqueta(new_string, Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                        sZPL.append("^FS \n");
                    } else {
                        suma_coordenada_y -= 20;
                    }
                }
            }

            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_empresa" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_empresa" + (i + 1))) + suma_coordenada_y + 20);
            sZPL.append("^GB210,1,1^FS \n");

            if (nombresProducto[i].length() > Integer.parseInt(parameters.get("TAM_MAX_FILA"))) {
                //DOS FILAS EL NOMBRE DE LA EMPRESA, SIEMPRE Y CUANDO SEA EAN_8
                //VALIDAMOS QUE NO SUPERE EL MAXIMO DE 2 FILAS
                palabras_temp = nombresProducto[i].trim().split(" ");
                //ITERAMOS LAS PALABRAS
                for (int j = 0; j < 2; j++) {
                    row_temp = "";
                    for (String palabra : palabras_temp) {
                        if (row_temp.length() + palabra.length() <= Integer.parseInt(parameters.get("TAM_MAX_FILA"))) {
                            row_temp += palabra + " ";
                        } else {
                            break;
                        }
                    }
                    //PRINT
                    if (j == 0) {
                        sZPL.append("^FO ");
                        sZPL.append(parameters_coordenadas.get("corx_producto" + (i + 1)));
                        sZPL.append(",");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                        sZPL.append(" ^ADN ^FD");
                        sZPL.append(centerTextEtiqueta(row_temp.trim(), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                        sZPL.append("^FS \n");
                        suma_coordenada_y += 20;
                    } else {
                        sZPL.append("^FO ");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_producto" + (i + 1))));
                        sZPL.append(",");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                        sZPL.append(" ^ADN ^FD");
                        sZPL.append(centerTextEtiqueta(nombresProducto[i].trim().substring(row_temp.trim().length(), nombresProducto[i].trim().length()), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                        sZPL.append("^FS \n");
                    }
                }
            } else {
                sZPL.append("^FO ");
                sZPL.append(parameters_coordenadas.get("corx_producto" + (i + 1)));
                sZPL.append(",");
                sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                sZPL.append(" ^ADN ^FD");
                sZPL.append(centerTextEtiqueta(nombresProducto[i], Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                sZPL.append("^FS \n");
            }

            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_precio" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_precio" + (i + 1))) + suma_coordenada_y);
            sZPL.append(" ^ADN ^FD");
            sZPL.append(centerTextEtiqueta(precios[i], Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
            sZPL.append("^FS \n");

            sZPL.append("^BY1,2 ");
            sZPL.append(parameters.get("TYPE_CODE"));
            sZPL.append(",");
            sZPL.append(parameters.get("ALTO_CODBAR"));
            sZPL.append(",Y,N");
            sZPL.append(" \n");
            sZPL.append("^FO ");
            //CODE
            switch (codigosProducto[i].trim().length()) {
                case 12:
                    sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))) + 15);
                    break;
                case 11:
                    sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))) + 20);
                    break;
                case 10:
                    sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))) + 25);
                    break;
                default:
                    sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))) + (15 * (10 - codigosProducto[i].trim().length())));
                    break;
            }
            //sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_codigo" + (i + 1))));
            sZPL.append("^FD");
            sZPL.append(codigosProducto[i].trim());
            sZPL.append("^FS \n");
        }
        sZPL.append("^XZ");
        return sZPL.toString();
    }

    public static String getZPL_EAN_8__1_8x1_8(
            Map<String, String> parameters,
            Map<String, String> parameters_coordenadas,
            int cantColumnas, String nombresProducto[],
            String[] precios, String[] codigosProducto) {
        StringBuilder sZPL = new StringBuilder();
        sZPL.append("^XA \n");
        String[] palabras_temp;
        String row_temp;
        for (int i = 0; i < cantColumnas; i++) {
            //VALIDAMOS SI SUPERA LA CANTIDAD MAX X FILA
            int suma_coordenada_y = 0;
            //DOS FILAS EL NOMBRE DE LA EMPRESA, SIEMPRE Y CUANDO SEA EAN_8
            //VALIDAMOS QUE NO SUPERE EL MAXIMO DE 2 FILAS
            palabras_temp = parameters.get("NOMBRE_EMPRESA").trim().split(" ");
            //ITERAMOS LAS PALABRAS
            for (int j = 0; j < 2; j++) {
                row_temp = "";
                for (String palabra : palabras_temp) {
                    if (row_temp.length() + palabra.length() <= Integer.parseInt(parameters.get("TAM_MAX_FILA"))) {
                        row_temp += palabra + " ";
                    } else {
                        break;
                    }
                }
                //PRINT
                if (j == 0) {
                    sZPL.append("^FO ");
                    sZPL.append(parameters_coordenadas.get("corx_empresa" + (i + 1)));
                    sZPL.append(",");
                    sZPL.append(parameters_coordenadas.get("cory_empresa" + (i + 1)));
                    sZPL.append(" ^ADN ^FD");
                    sZPL.append(centerTextEtiqueta(row_temp.trim(), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                    sZPL.append("^FS \n");
                    suma_coordenada_y += 20;
                } else {
                    //verificamos que sea diferente de vacio
                    String new_string = parameters.get("NOMBRE_EMPRESA").trim().substring(row_temp.trim().length(), parameters.get("NOMBRE_EMPRESA").trim().length());
                    System.out.println(new_string);
                    if (!new_string.equals("")) {
                        sZPL.append("^FO ");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_empresa" + (i + 1))));
                        sZPL.append(",");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_empresa" + (i + 1))) + 20);
                        sZPL.append(" ^ADN ^FD");
                        sZPL.append(centerTextEtiqueta(new_string, Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                        sZPL.append("^FS \n");
                    } else {
                        suma_coordenada_y -= 20;
                    }
                }
            }

            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_empresa" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_empresa" + (i + 1))) + suma_coordenada_y + 20);
            sZPL.append("^GB210,1,1^FS \n");

            if (nombresProducto[i].length() > Integer.parseInt(parameters.get("TAM_MAX_FILA"))) {
                //DOS FILAS EL NOMBRE DE LA EMPRESA, SIEMPRE Y CUANDO SEA EAN_8
                //VALIDAMOS QUE NO SUPERE EL MAXIMO DE 2 FILAS
                palabras_temp = nombresProducto[i].trim().split(" ");
                //ITERAMOS LAS PALABRAS
                for (int j = 0; j < 2; j++) {
                    row_temp = "";
                    for (String palabra : palabras_temp) {
                        if (row_temp.length() + palabra.length() <= Integer.parseInt(parameters.get("TAM_MAX_FILA"))) {
                            row_temp += palabra + " ";
                        } else {
                            break;
                        }
                    }
                    //PRINT
                    if (j == 0) {
                        sZPL.append("^FO ");
                        sZPL.append(parameters_coordenadas.get("corx_producto" + (i + 1)));
                        sZPL.append(",");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                        sZPL.append(" ^ADN ^FD");
                        sZPL.append(centerTextEtiqueta(row_temp.trim(), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                        sZPL.append("^FS \n");
                        suma_coordenada_y += 20;
                    } else {
                        sZPL.append("^FO ");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_producto" + (i + 1))));
                        sZPL.append(",");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                        sZPL.append(" ^ADN ^FD");
                        sZPL.append(centerTextEtiqueta(nombresProducto[i].trim().substring(row_temp.trim().length(), nombresProducto[i].trim().length()), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                        sZPL.append("^FS \n");
                    }
                }
            } else {
                sZPL.append("^FO ");
                sZPL.append(parameters_coordenadas.get("corx_producto" + (i + 1)));
                sZPL.append(",");
                sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                sZPL.append(" ^ADN ^FD");
                sZPL.append(centerTextEtiqueta(nombresProducto[i], Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                sZPL.append("^FS \n");
            }

            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_precio" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_precio" + (i + 1))) + suma_coordenada_y);
            sZPL.append(" ^ADN ^FD");
            sZPL.append(centerTextEtiqueta(precios[i], Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
            sZPL.append("^FS \n");

            sZPL.append("^BY2,2 ");
            sZPL.append(parameters.get("TYPE_CODE"));
            sZPL.append(",");
            sZPL.append(parameters.get("ALTO_CODBAR"));
            sZPL.append(",Y,N");
            sZPL.append(" \n");
            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_codigo" + (i + 1))));
            sZPL.append("^FD");
            sZPL.append(codigosProducto[i].trim());
            sZPL.append("^FS \n");
        }
        sZPL.append("^XZ");
        return sZPL.toString();
    }

    public static String getZPL_EAN_13__1_8x1_8(
            Map<String, String> parameters,
            Map<String, String> parameters_coordenadas,
            int cantColumnas, String nombresProducto[],
            String[] precios, String[] codigosProducto) {
        StringBuilder sZPL = new StringBuilder();
        sZPL.append("^XA \n");
        String[] palabras_temp;
        String row_temp;
        for (int i = 0; i < cantColumnas; i++) {
            //VALIDAMOS SI SUPERA LA CANTIDAD MAX X FILA
            int suma_coordenada_y = 0;
            //DOS FILAS EL NOMBRE DE LA EMPRESA, SIEMPRE Y CUANDO SEA EAN_8
            //VALIDAMOS QUE NO SUPERE EL MAXIMO DE 2 FILAS
            palabras_temp = parameters.get("NOMBRE_EMPRESA").trim().split(" ");
            //ITERAMOS LAS PALABRAS
            for (int j = 0; j < 2; j++) {
                row_temp = "";
                for (String palabra : palabras_temp) {
                    if (row_temp.length() + palabra.length() <= Integer.parseInt(parameters.get("TAM_MAX_FILA"))) {
                        row_temp += palabra + " ";
                    } else {
                        break;
                    }
                }
                //PRINT
                if (j == 0) {
                    sZPL.append("^FO ");
                    sZPL.append(parameters_coordenadas.get("corx_empresa" + (i + 1)));
                    sZPL.append(",");
                    sZPL.append(parameters_coordenadas.get("cory_empresa" + (i + 1)));
                    sZPL.append(" ^ADN ^FD");
                    sZPL.append(centerTextEtiqueta(row_temp.trim(), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                    sZPL.append("^FS \n");
                    suma_coordenada_y += 20;
                } else {
                    //verificamos que sea diferente de vacio
                    String new_string = parameters.get("NOMBRE_EMPRESA").trim().substring(row_temp.trim().length(), parameters.get("NOMBRE_EMPRESA").trim().length());
                    System.out.println(new_string);
                    if (!new_string.equals("")) {
                        sZPL.append("^FO ");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_empresa" + (i + 1))));
                        sZPL.append(",");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_empresa" + (i + 1))) + 20);
                        sZPL.append(" ^ADN ^FD");
                        sZPL.append(centerTextEtiqueta(new_string, Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                        sZPL.append("^FS \n");
                    } else {
                        suma_coordenada_y -= 20;
                    }
                }
            }

            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_empresa" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_empresa" + (i + 1))) + suma_coordenada_y + 20);
            sZPL.append("^GB210,1,1^FS \n");

            if (nombresProducto[i].length() > Integer.parseInt(parameters.get("TAM_MAX_FILA"))) {
                //DOS FILAS EL NOMBRE DE LA EMPRESA, SIEMPRE Y CUANDO SEA EAN_8
                //VALIDAMOS QUE NO SUPERE EL MAXIMO DE 2 FILAS
                palabras_temp = nombresProducto[i].trim().split(" ");
                //ITERAMOS LAS PALABRAS
                for (int j = 0; j < 2; j++) {
                    row_temp = "";
                    for (String palabra : palabras_temp) {
                        if (row_temp.length() + palabra.length() <= Integer.parseInt(parameters.get("TAM_MAX_FILA"))) {
                            row_temp += palabra + " ";
                        } else {
                            break;
                        }
                    }
                    //PRINT
                    if (j == 0) {
                        sZPL.append("^FO ");
                        sZPL.append(parameters_coordenadas.get("corx_producto" + (i + 1)));
                        sZPL.append(",");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                        sZPL.append(" ^ADN ^FD");
                        sZPL.append(centerTextEtiqueta(row_temp.trim(), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                        sZPL.append("^FS \n");
                        suma_coordenada_y += 20;
                    } else {
                        sZPL.append("^FO ");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_producto" + (i + 1))));
                        sZPL.append(",");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                        sZPL.append(" ^ADN ^FD");
                        sZPL.append(centerTextEtiqueta(nombresProducto[i].trim().substring(row_temp.trim().length(), nombresProducto[i].trim().length()), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                        sZPL.append("^FS \n");
                    }
                }
            } else {
                sZPL.append("^FO ");
                sZPL.append(parameters_coordenadas.get("corx_producto" + (i + 1)));
                sZPL.append(",");
                sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                sZPL.append(" ^ADN ^FD");
                sZPL.append(centerTextEtiqueta(nombresProducto[i], Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                sZPL.append("^FS \n");
            }

            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_precio" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_precio" + (i + 1))) + suma_coordenada_y);
            sZPL.append(" ^ADN ^FD");
            sZPL.append(centerTextEtiqueta(precios[i], Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
            sZPL.append("^FS \n");

            sZPL.append("^BY2,2 ");
            sZPL.append(parameters.get("TYPE_CODE"));
            sZPL.append(",");
            sZPL.append(parameters.get("ALTO_CODBAR"));
            sZPL.append(",Y,N");
            sZPL.append(" \n");
            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_codigo" + (i + 1))));
            sZPL.append("^FD");
            sZPL.append(codigosProducto[i].trim());
            sZPL.append("^FS \n");
        }
        sZPL.append("^XZ");
        return sZPL.toString();
    }

    /*
        CODE 1.8 X 0.78
     */
    public static String getZPL_CODE_128__1_8x0_78(
            Map<String, String> parameters,
            Map<String, String> parameters_coordenadas,
            int cantColumnas, String nombresProducto[],
            String[] precios, String[] codigosProducto) {
        StringBuilder sZPL = new StringBuilder();
        sZPL.append("^XA \n");
        String[] palabras_temp;
        String row_temp;
        for (int i = 0; i < cantColumnas; i++) {
            //VALIDAMOS SI SUPERA LA CANTIDAD MAX X FILA
            int suma_coordenada_y = 0;
            if (nombresProducto[i].length() > Integer.parseInt(parameters.get("TAM_MAX_FILA"))) {
                //VALIDAMOS QUE NO SUPERE EL MAXIMO DE 2 FILAS
                palabras_temp = nombresProducto[i].trim().split(" ");
                //ITERAMOS LAS PALABRAS
                for (int j = 0; j < 2; j++) {
                    row_temp = "";
                    for (String palabra : palabras_temp) {
                        if (row_temp.length() + palabra.length() <= Integer.parseInt(parameters.get("TAM_MAX_FILA"))) {
                            row_temp += palabra + " ";
                        } else {
                            break;
                        }
                    }
                    //PRINT
                    if (j == 0) {
                        sZPL.append("^FO ");
                        sZPL.append(parameters_coordenadas.get("corx_producto" + (i + 1)));
                        sZPL.append(",");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                        sZPL.append(" ^ADN ^FD");
                        sZPL.append(centerTextEtiqueta(row_temp.trim(), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                        sZPL.append("^FS \n");
                        suma_coordenada_y += 20;
                    } else {
                        sZPL.append("^FO ");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_producto" + (i + 1))));
                        sZPL.append(",");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                        sZPL.append(" ^ADN ^FD");
                        sZPL.append(centerTextEtiqueta(nombresProducto[i].trim().substring(row_temp.trim().length(), nombresProducto[i].trim().length()), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                        sZPL.append("^FS \n");
                    }
                }
            } else {
                sZPL.append("^FO ");
                sZPL.append(parameters_coordenadas.get("corx_producto" + (i + 1)));
                sZPL.append(",");
                sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                sZPL.append(" ^ADN ^FD");
                sZPL.append(centerTextEtiqueta(nombresProducto[i], Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                sZPL.append("^FS \n");
            }

            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_precio" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_precio" + (i + 1))) + suma_coordenada_y);
            sZPL.append(" ^ADN ^FD");
            sZPL.append(centerTextEtiqueta(precios[i], Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
            sZPL.append("^FS \n");

            sZPL.append("^BY1,2 ");
            sZPL.append(parameters.get("TYPE_CODE"));
            sZPL.append(",");
            sZPL.append(parameters.get("ALTO_CODBAR"));
            sZPL.append(",Y,N");
            sZPL.append(" \n");
            sZPL.append("^FO ");
            //CODE
            switch (codigosProducto[i].trim().length()) {
                case 12:
                    sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))) + 15);
                    break;
                case 11:
                    sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))) + 20);
                    break;
                case 10:
                    sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))) + 25);
                    break;
                default:
                    sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))) + (15 * (10 - codigosProducto[i].trim().length())));
                    break;
            }
            //sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_codigo" + (i + 1))));
            sZPL.append("^FD");
            sZPL.append(codigosProducto[i].trim());
            sZPL.append("^FS \n");
        }
        sZPL.append("^XZ");
        return sZPL.toString();
    }

    public static String getZPL_EAN_8__1_8x0_78(
            Map<String, String> parameters,
            Map<String, String> parameters_coordenadas,
            int cantColumnas, String nombresProducto[],
            String[] precios, String[] codigosProducto) {
        StringBuilder sZPL = new StringBuilder();
        sZPL.append("^XA \n");
        String[] palabras_temp;
        String row_temp;
        for (int i = 0; i < cantColumnas; i++) {
            //VALIDAMOS SI SUPERA LA CANTIDAD MAX X FILA
            int suma_coordenada_y = 0;
            if (nombresProducto[i].length() > Integer.parseInt(parameters.get("TAM_MAX_FILA"))) {
                //DOS FILAS EL NOMBRE DE LA EMPRESA, SIEMPRE Y CUANDO SEA EAN_8
                //VALIDAMOS QUE NO SUPERE EL MAXIMO DE 2 FILAS
                palabras_temp = nombresProducto[i].trim().split(" ");
                //ITERAMOS LAS PALABRAS
                for (int j = 0; j < 2; j++) {
                    row_temp = "";
                    for (String palabra : palabras_temp) {
                        if (row_temp.length() + palabra.length() <= Integer.parseInt(parameters.get("TAM_MAX_FILA"))) {
                            row_temp += palabra + " ";
                        } else {
                            break;
                        }
                    }
                    //PRINT
                    if (j == 0) {
                        sZPL.append("^FO ");
                        sZPL.append(parameters_coordenadas.get("corx_producto" + (i + 1)));
                        sZPL.append(",");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                        sZPL.append(" ^ADN ^FD");
                        sZPL.append(centerTextEtiqueta(row_temp.trim(), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                        sZPL.append("^FS \n");
                        suma_coordenada_y += 20;
                    } else {
                        sZPL.append("^FO ");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_producto" + (i + 1))));
                        sZPL.append(",");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                        sZPL.append(" ^ADN ^FD");
                        sZPL.append(centerTextEtiqueta(nombresProducto[i].trim().substring(row_temp.trim().length(), nombresProducto[i].trim().length()), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                        sZPL.append("^FS \n");
                    }
                }
            } else {
                sZPL.append("^FO ");
                sZPL.append(parameters_coordenadas.get("corx_producto" + (i + 1)));
                sZPL.append(",");
                sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                sZPL.append(" ^ADN ^FD");
                sZPL.append(centerTextEtiqueta(nombresProducto[i], Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                sZPL.append("^FS \n");
            }

            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_precio" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_precio" + (i + 1))) + suma_coordenada_y);
            sZPL.append(" ^ADN ^FD");
            sZPL.append(centerTextEtiqueta(precios[i], Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
            sZPL.append("^FS \n");

            sZPL.append("^BY2,2 ");
            sZPL.append(parameters.get("TYPE_CODE"));
            sZPL.append(",");
            sZPL.append(parameters.get("ALTO_CODBAR"));
            sZPL.append(",Y,N");
            sZPL.append(" \n");
            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_codigo" + (i + 1))));
            sZPL.append("^FD");
            sZPL.append(codigosProducto[i].trim());
            sZPL.append("^FS \n");
        }
        sZPL.append("^XZ");
        return sZPL.toString();
    }

    public static String getZPL_EAN_13__1_8x0_78(
            Map<String, String> parameters,
            Map<String, String> parameters_coordenadas,
            int cantColumnas, String nombresProducto[],
            String[] precios, String[] codigosProducto) {
        StringBuilder sZPL = new StringBuilder();
        sZPL.append("^XA \n");
        String[] palabras_temp;
        String row_temp;
        for (int i = 0; i < cantColumnas; i++) {
            //VALIDAMOS SI SUPERA LA CANTIDAD MAX X FILA
            int suma_coordenada_y = 0;
            //VALIDAMOS QUE NO SUPERE EL MAXIMO DE 2 FILAS
            if (nombresProducto[i].length() > Integer.parseInt(parameters.get("TAM_MAX_FILA"))) {
                //DOS FILAS EL NOMBRE DE LA EMPRESA, SIEMPRE Y CUANDO SEA EAN_8
                //VALIDAMOS QUE NO SUPERE EL MAXIMO DE 2 FILAS
                palabras_temp = nombresProducto[i].trim().split(" ");
                //ITERAMOS LAS PALABRAS
                for (int j = 0; j < 2; j++) {
                    row_temp = "";
                    for (String palabra : palabras_temp) {
                        if (row_temp.length() + palabra.length() <= Integer.parseInt(parameters.get("TAM_MAX_FILA"))) {
                            row_temp += palabra + " ";
                        } else {
                            break;
                        }
                    }
                    //PRINT
                    if (j == 0) {
                        sZPL.append("^FO ");
                        sZPL.append(parameters_coordenadas.get("corx_producto" + (i + 1)));
                        sZPL.append(",");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                        sZPL.append(" ^ADN ^FD");
                        sZPL.append(centerTextEtiqueta(row_temp.trim(), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                        sZPL.append("^FS \n");
                        suma_coordenada_y += 20;
                    } else {
                        sZPL.append("^FO ");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_producto" + (i + 1))));
                        sZPL.append(",");
                        sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                        sZPL.append(" ^ADN ^FD");
                        sZPL.append(centerTextEtiqueta(nombresProducto[i].trim().substring(row_temp.trim().length(), nombresProducto[i].trim().length()), Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                        sZPL.append("^FS \n");
                    }
                }
            } else {
                sZPL.append("^FO ");
                sZPL.append(parameters_coordenadas.get("corx_producto" + (i + 1)));
                sZPL.append(",");
                sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_producto" + (i + 1))) + suma_coordenada_y);
                sZPL.append(" ^ADN ^FD");
                sZPL.append(centerTextEtiqueta(nombresProducto[i], Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
                sZPL.append("^FS \n");
            }

            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_precio" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_precio" + (i + 1))) + suma_coordenada_y);
            sZPL.append(" ^ADN ^FD");
            sZPL.append(centerTextEtiqueta(precios[i], Integer.parseInt(parameters.get("TAM_MAX_FILA"))));
            sZPL.append("^FS \n");

            sZPL.append("^BY2,2 ");
            sZPL.append(parameters.get("TYPE_CODE"));
            sZPL.append(",");
            sZPL.append(parameters.get("ALTO_CODBAR"));
            sZPL.append(",Y,N");
            sZPL.append(" \n");
            sZPL.append("^FO ");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("corx_codigo" + (i + 1))));
            sZPL.append(",");
            sZPL.append(Integer.parseInt(parameters_coordenadas.get("cory_codigo" + (i + 1))));
            sZPL.append("^FD");
            sZPL.append(codigosProducto[i].trim());
            sZPL.append("^FS \n");
        }
        sZPL.append("^XZ");
        return sZPL.toString();
    }

    private static String centerTextEtiqueta(String text, int tam_maximo_cadena) {
        StringBuilder sString = new StringBuilder();
        int cant_add = ((tam_maximo_cadena - text.length()) / 2);
        for (int i = 0; i < cant_add; i++) {
            sString.append(" ");
        }
        sString.append(text);
        for (int i = 0; i < cant_add; i++) {
            sString.append(" ");
        }
        return sString.toString();
    }
}
