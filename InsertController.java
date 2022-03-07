/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DanhMucDBController;

import Controller.BaseAuthenticationController;
import dal.DanhMucDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DanhMuc;

/**
 *
 * @author Admin
 */
public class InsertController extends BaseAuthenticationController {

    

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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("../view/danhmuc/insert.jsp").forward(request, response);
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String raw_MaLoaiSp = request.getParameter("MaLoaiSP");
        String loaisp = request.getParameter("LoaiSP");
        
        DanhMucDBContext db = new DanhMucDBContext();
        if (db.checkDupMaLoaiSP(raw_MaLoaiSp)) {
            response.getWriter().println("Nguồn loại sản này đã có sẵn");
        }else{
            String maLoaiSP = raw_MaLoaiSp;
            DanhMuc d = new DanhMuc();
            d.setMaLoaiSP(maLoaiSP);
            d.setLoaiSP(loaisp);
            db.insertDanhMucSP(d);
            response.sendRedirect("search");
        }
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
