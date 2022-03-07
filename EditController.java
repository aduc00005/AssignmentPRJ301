/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DanhMucDBController;

import Controller.BaseAuthenticationController;
import dal.DanhMucDBContext;
import dal.NguonHangDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DanhMuc;
import model.NguonHang;

/**
 *
 * @author Admin
 */
public class EditController extends BaseAuthenticationController {

    

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
        
        String MaLoaiSP = request.getParameter("id");
        DanhMucDBContext db = new DanhMucDBContext();
        DanhMuc loaisp = db.getLoaiSPByID(MaLoaiSP);
        request.setAttribute("loaisp", loaisp);
        request.getRequestDispatcher("../view/danhmuc/edit.jsp").forward(request, response);
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
        
        String maloaiSP = request.getParameter("maloaisp");
        String loaiSP = request.getParameter("loaisp");
        
        DanhMuc l = new DanhMuc();
        l.setMaLoaiSP(maloaiSP);
        l.setLoaiSP(loaiSP);
        DanhMucDBContext db = new DanhMucDBContext();
        db.UpdateDanhMuc(l);
        response.sendRedirect("search");
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
