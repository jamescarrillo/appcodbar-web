/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.licvhn.appcodbar.web.utilities;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author James Carrillo
 */
public class ManagerUM {

    public static String getZpl(String type_code, String medida, int count_columns, String nombreEmpresa,
            String[] nameProducts, String[] prices, String[] codeProducts) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("NOMBRE_EMPRESA", nombreEmpresa);
        parameters.put("TYPE_CODE", type_code);        
        String zpl = "";
        switch (medida) {
            //PARAMETROS PULGADAS | ancho x alto
            case "1.18x0.78":
                //30 x 20 mm
                parameters.put("ALTO_CODBAR", "50");
                switch (type_code) {
                    case "^BCN":
                        parameters.put("TAM_MAX_FILA", "18");
                        zpl = DesignZPL.getZPL_CODE_128__1_8x0_78(parameters, getParametersCoordenadas1_18x0_78(), count_columns, nameProducts, prices, codeProducts);
                        break;
                    case "^BEN":
                        parameters.put("TAM_MAX_FILA", "18");
                        zpl = DesignZPL.getZPL_EAN_13__1_8x0_78(parameters, getParametersCoordenadas1_18x0_78_EAN_13(), count_columns, nameProducts, prices, codeProducts);
                        break;
                    default:
                        parameters.put("TAM_MAX_FILA", "18");
                        zpl = DesignZPL.getZPL_EAN_8__1_8x0_78(parameters, getParametersCoordenadas1_18x0_78(), count_columns, nameProducts, prices, codeProducts);
                        break;
                }
                break;
            case "2x1":
                //50.8 X 25.4 mm
                parameters.put("ALTO_CODBAR", "65");
                switch (type_code) {
                    case "^BCN":
                        parameters.put("TAM_MAX_FILA", "32");
                        zpl = DesignZPL.getZPL_CODE_128__2x1(parameters, getParametersCoordenadas2x1(), count_columns, nameProducts, prices, codeProducts);
                        break;
                    default:
                        parameters.put("TAM_MAX_FILA", "32");
                        zpl = DesignZPL.getZPL_CODE_EAN_13__2x1(parameters, getParametersCoordenadas2x1(), count_columns, nameProducts, prices, codeProducts);
                        break;
                }
                break;
            case "1.18x1.18":
                //30 x 30 mm
                switch (type_code) {
                    case "^BCN":
                        parameters.put("TAM_MAX_FILA", "18");
                        parameters.put("ALTO_CODBAR", "60");
                        zpl = DesignZPL.getZPL_CODE_128__1_8x1_8(parameters, getParametersCoordenadas1_18x1_18(), count_columns, nameProducts, prices, codeProducts);
                        break;
                    case "^BEN":
                        parameters.put("TAM_MAX_FILA", "18");
                        parameters.put("ALTO_CODBAR", "60");
                        zpl = DesignZPL.getZPL_EAN_13__1_8x1_8(parameters, getParametersCoordenadas1_18x1_18_EAN_13(), count_columns, nameProducts, prices, codeProducts);
                        break;
                    default:
                        parameters.put("TAM_MAX_FILA", "18");
                        parameters.put("ALTO_CODBAR", "60");
                        zpl = DesignZPL.getZPL_EAN_8__1_8x1_8(parameters, getParametersCoordenadas1_18x1_18(), count_columns, nameProducts, prices, codeProducts);
                        break;
                }
                break;

        }
        return zpl;
    }

    private static Map<String, String> getParametersCoordenadas2x1() {
        Map<String, String> parameters_coordenadas = new HashMap<>();
        parameters_coordenadas.put("corx_empresa1", "0");
        parameters_coordenadas.put("cory_empresa1", "25");
        parameters_coordenadas.put("corx_producto1", "0");
        parameters_coordenadas.put("cory_producto1", "55");
        parameters_coordenadas.put("corx_precio1", "0");
        parameters_coordenadas.put("cory_precio1", "75");

        parameters_coordenadas.put("corx_codigo1", "20");
        parameters_coordenadas.put("cory_codigo1", "100");

        parameters_coordenadas.put("corx_empresa2", "410");
        parameters_coordenadas.put("cory_empresa2", "25");
        parameters_coordenadas.put("corx_producto2", "430");
        parameters_coordenadas.put("cory_producto2", "55");
        parameters_coordenadas.put("corx_precio2", "430");
        parameters_coordenadas.put("cory_precio2", "75");

        parameters_coordenadas.put("corx_codigo2", "440");
        parameters_coordenadas.put("cory_codigo2", "100");
        return parameters_coordenadas;
    }

    private static Map<String, String> getParametersCoordenadas1_18x1_18() {
        Map<String, String> parameters_coordenadas = new HashMap<>();
        parameters_coordenadas.put("corx_empresa1", "25");
        parameters_coordenadas.put("cory_empresa1", "25");
        parameters_coordenadas.put("corx_producto1", "25");
        parameters_coordenadas.put("cory_producto1", "60");
        parameters_coordenadas.put("corx_precio1", "25");
        parameters_coordenadas.put("cory_precio1", "80");

        parameters_coordenadas.put("corx_codigo1", "60");
        parameters_coordenadas.put("cory_codigo1", "145");

        parameters_coordenadas.put("corx_empresa2", "290");
        parameters_coordenadas.put("cory_empresa2", "25");
        parameters_coordenadas.put("corx_producto2", "290");
        parameters_coordenadas.put("cory_producto2", "60");
        parameters_coordenadas.put("corx_precio2", "290");
        parameters_coordenadas.put("cory_precio2", "80");

        parameters_coordenadas.put("corx_codigo2", "330");
        parameters_coordenadas.put("cory_codigo2", "145");

        parameters_coordenadas.put("corx_empresa3", "560");
        parameters_coordenadas.put("cory_empresa3", "25");
        parameters_coordenadas.put("corx_producto3", "560");
        parameters_coordenadas.put("cory_producto3", "60");
        parameters_coordenadas.put("corx_precio3", "560");
        parameters_coordenadas.put("cory_precio3", "80");

        parameters_coordenadas.put("corx_codigo3", "590");
        parameters_coordenadas.put("cory_codigo3", "145");
        return parameters_coordenadas;
    }

    private static Map<String, String> getParametersCoordenadas1_18x1_18_EAN_13() {
        Map<String, String> parameters_coordenadas = new HashMap<>();
        parameters_coordenadas.put("corx_empresa1", "25");
        parameters_coordenadas.put("cory_empresa1", "25");
        parameters_coordenadas.put("corx_producto1", "25");
        parameters_coordenadas.put("cory_producto1", "60");
        parameters_coordenadas.put("corx_precio1", "25");
        parameters_coordenadas.put("cory_precio1", "80");

        parameters_coordenadas.put("corx_codigo1", "40");
        parameters_coordenadas.put("cory_codigo1", "145");

        parameters_coordenadas.put("corx_empresa2", "290");
        parameters_coordenadas.put("cory_empresa2", "25");
        parameters_coordenadas.put("corx_producto2", "290");
        parameters_coordenadas.put("cory_producto2", "60");
        parameters_coordenadas.put("corx_precio2", "290");
        parameters_coordenadas.put("cory_precio2", "80");

        parameters_coordenadas.put("corx_codigo2", "310");
        parameters_coordenadas.put("cory_codigo2", "145");

        parameters_coordenadas.put("corx_empresa3", "560");
        parameters_coordenadas.put("cory_empresa3", "25");
        parameters_coordenadas.put("corx_producto3", "560");
        parameters_coordenadas.put("cory_producto3", "60");
        parameters_coordenadas.put("corx_precio3", "560");
        parameters_coordenadas.put("cory_precio3", "80");

        parameters_coordenadas.put("corx_codigo3", "570");
        parameters_coordenadas.put("cory_codigo3", "145");
        return parameters_coordenadas;
    }

    private static Map<String, String> getParametersCoordenadas1_18x0_78() {
        Map<String, String> parameters_coordenadas = new HashMap<>();
        //parameters_coordenadas.put("corx_empresa1", "25");
        //parameters_coordenadas.put("cory_empresa1", "25");
        parameters_coordenadas.put("corx_producto1", "25");
        parameters_coordenadas.put("cory_producto1", "20");
        parameters_coordenadas.put("corx_precio1", "25");
        parameters_coordenadas.put("cory_precio1", "40");

        parameters_coordenadas.put("corx_codigo1", "60");
        parameters_coordenadas.put("cory_codigo1", "80");

        //parameters_coordenadas.put("corx_empresa2", "290");
        //parameters_coordenadas.put("cory_empresa2", "25");
        parameters_coordenadas.put("corx_producto2", "290");
        parameters_coordenadas.put("cory_producto2", "20");
        parameters_coordenadas.put("corx_precio2", "290");
        parameters_coordenadas.put("cory_precio2", "40");

        parameters_coordenadas.put("corx_codigo2", "330");
        parameters_coordenadas.put("cory_codigo2", "80");

        //parameters_coordenadas.put("corx_empresa3", "560");
        //parameters_coordenadas.put("cory_empresa3", "25");
        parameters_coordenadas.put("corx_producto3", "560");
        parameters_coordenadas.put("cory_producto3", "20");
        parameters_coordenadas.put("corx_precio3", "560");
        parameters_coordenadas.put("cory_precio3", "40");

        parameters_coordenadas.put("corx_codigo3", "590");
        parameters_coordenadas.put("cory_codigo3", "80");
        return parameters_coordenadas;
    }

    private static Map<String, String> getParametersCoordenadas1_18x0_78_EAN_13() {
        Map<String, String> parameters_coordenadas = new HashMap<>();
        //parameters_coordenadas.put("corx_empresa1", "25");
        //parameters_coordenadas.put("cory_empresa1", "25");
        parameters_coordenadas.put("corx_producto1", "25");
        parameters_coordenadas.put("cory_producto1", "20");
        parameters_coordenadas.put("corx_precio1", "25");
        parameters_coordenadas.put("cory_precio1", "40");

        parameters_coordenadas.put("corx_codigo1", "40");
        parameters_coordenadas.put("cory_codigo1", "80");

        //parameters_coordenadas.put("corx_empresa2", "290");
        //parameters_coordenadas.put("cory_empresa2", "25");
        parameters_coordenadas.put("corx_producto2", "290");
        parameters_coordenadas.put("cory_producto2", "20");
        parameters_coordenadas.put("corx_precio2", "290");
        parameters_coordenadas.put("cory_precio2", "40");

        parameters_coordenadas.put("corx_codigo2", "310");
        parameters_coordenadas.put("cory_codigo2", "80");

        //parameters_coordenadas.put("corx_empresa3", "560");
        //parameters_coordenadas.put("cory_empresa3", "25");
        parameters_coordenadas.put("corx_producto3", "560");
        parameters_coordenadas.put("cory_producto3", "20");
        parameters_coordenadas.put("corx_precio3", "560");
        parameters_coordenadas.put("cory_precio3", "40");

        parameters_coordenadas.put("corx_codigo3", "570");
        parameters_coordenadas.put("cory_codigo3", "80");
        return parameters_coordenadas;
    }

}
