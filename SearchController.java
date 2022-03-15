/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class SearchController extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        String text = request.getParameter("text").trim();
        if (text==null||text.length()==0) {
            response.sendRedirect("../index.html");
        }else{
            if (text.contains("san pham")||text.contains("sản phẩm")) {
                if (text.contains("danh sach")||text.contains("danh sách")) {
                    response.sendRedirect("../product/search");
                }
                if (text.contains("them")||text.contains("thêm")) {
                    response.sendRedirect("../product/insert");
                }
            }
            if (text.contains("nguon hang")||text.contains("nguồn hàng")||text.contains("nguon")||text.contains("nguồn")) {
                if (text.contains("danh sach")||text.contains("danh sách")) {
                    response.sendRedirect("../nguon/search");
                }
                if (text.contains("them")||text.contains("thêm")) {
                    response.sendRedirect("../nguon/insert");
                }
            }
            if (text.contains("loai san pham")||text.contains("loại sản phẩm")||text.contains("loai")||text.contains("loai")) {
                if (text.contains("danh sach")||text.contains("danh sách")||text.contains("các")||text.contains("cac")) {
                    response.sendRedirect("../loaisp/search");
                }
                if (text.contains("them")||text.contains("thêm")) {
                    response.sendRedirect("../loaisp/insert");
                }
            }
        }
        response.sendRedirect("../index.html");
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
