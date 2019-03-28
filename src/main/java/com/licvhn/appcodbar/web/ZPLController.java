/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.licvhn.appcodbar.web;

import com.licvhn.appcodbar.web.utilities.BeansCodBar;
import com.licvhn.appcodbar.web.utilities.ManagerZPLComand;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lizet
 */
@WebServlet(name = "ZPLController", urlPatterns = {"/zpl"})
public class ZPLController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            List<BeansCodBar> lista = new ArrayList<>();
            BeansCodBar beans1 = new BeansCodBar();
            beans1.setNombre("CAMISA MANGA LARGA");
            beans1.setPrecio("S/ 15.99");
            beans1.setCodigo(" 721557231234");
            BeansCodBar beans2 = new BeansCodBar();
            beans2.setNombre("LECHE GLORIA");
            beans2.setPrecio("S/ 5.80");
            beans2.setCodigo(" 721557231231");
            BeansCodBar beans3 = new BeansCodBar();
            beans3.setNombre("LECHE GLORIA AZUL");
            beans3.setPrecio("S/ 5.80");
            beans3.setCodigo(" 721557231234");
            lista.add(beans1);
            lista.add(beans2);
//            out.println(ManagerZPLComand.getComandosZPL("CODE_128",lista, "BODEGA JAMES", "2x1", 2));
        } catch (Exception e) {
            throw e;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
