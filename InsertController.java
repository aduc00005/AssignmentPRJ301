/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product.Controller;

import dal.DanhMucDBContext;
import dal.NguonHangDBContext;
import dal.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DanhMuc;
import model.NguonHang;
import model.ProductForAdmin;

/**
 *
 * @author Admin
 */
public class InsertController extends HttpServlet {

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
        
        DanhMucDBContext DB = new DanhMucDBContext();
        ArrayList<DanhMuc> list = DB.getLoaiSP();
        request.setAttribute("LoaiSP", list);
        NguonHangDBContext NguonDB = new NguonHangDBContext();
        ArrayList<NguonHang> NHList = NguonDB.getNguon();
        request.setAttribute("Nguon", NHList);
        request.getRequestDispatcher("../view/product/insert.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String raw_masp = request.getParameter("masp");
        String raw_tensp = request.getParameter("tensp");
        String raw_DVT = request.getParameter("DVT");
        String raw_NgaySX = request.getParameter("NgaySX");
        String raw_HanSD = request.getParameter("HanSD");
        String raw_SoLuong = request.getParameter("SoLuong");
        String raw_GiaNhap = request.getParameter("GiaNhap");
        String raw_GiaBan = request.getParameter("GiaBan");
        String raw_KeHang = request.getParameter("KeHang");
        // Nguon Hang
        String raw_MaNguon = (request.getParameter("maNH").equalsIgnoreCase("orther"))? request.getParameter("maNHM") : request.getParameter("maNH");
                 
        // Neu la nguon hang moi
        String raw_TenCuaHang = null;
        String raw_DiaChi = null;
        String raw_SDT = null;

        if (request.getParameter("maNH").equalsIgnoreCase("orther")) {

            raw_TenCuaHang = request.getParameter("TenCuaHang");
            raw_DiaChi = request.getParameter("DiaChi");
            raw_SDT = request.getParameter("sdt");

        }
        //Loai sp
        String raw_MaLoaiSP = (request.getParameter("maloaisp").equalsIgnoreCase("orther"))? request.getParameter("MaLoaiSPM") : request.getParameter("maloaisp");
                
        //neu  la loai sp moi
        String raw_LoaiSP = null;
        if (request.getParameter("maloaisp").equalsIgnoreCase("orther")) {

            raw_LoaiSP = request.getParameter("LoaiSP");

        }

        ProductDBContext db = new ProductDBContext();

        int masp = Integer.parseInt(raw_masp);
        //check dupicate masp
        if (db.checkDupicateMasp(masp)) {
            response.getWriter().println("Product have ID: " + masp + " is existed in store!");
        } else {
            String tensp = raw_tensp;
            String DVT = raw_DVT;
            Date NgaySX = Date.valueOf(raw_NgaySX);
            Date HanSD = Date.valueOf(raw_HanSD);
            int SoLuong = Integer.parseInt(raw_SoLuong);
            int GiaNhap = Integer.parseInt(raw_GiaNhap);
            int GiaBan = Integer.parseInt(raw_GiaBan);
            int KeHang = Integer.parseInt(raw_KeHang);
            String MaLoaiSP = raw_MaLoaiSP;
            String MaNH = raw_MaNguon;

            DanhMuc d = new DanhMuc();
            String LoaiSPMoi = null;
            if (request.getParameter("maloaisp").equalsIgnoreCase("orther")) {
                String maLoaiSPMoi = request.getParameter("MaLoaiSPM");
                LoaiSPMoi = raw_LoaiSP;
                d.setMaLoaiSP(maLoaiSPMoi);
                d.setLoaiSP(LoaiSPMoi);
                DanhMucDBContext DanhMucDB = new DanhMucDBContext();
                DanhMucDB.insertDanhMucSP(d);
            }
            d.setMaLoaiSP(MaLoaiSP);

            
            NguonHang n = new NguonHang();
            // Neu la nguon hang moi
            String TenCuaHang = null;
            String DiaChi = null;
            String SDT = null;
            if (request.getParameter("maNH").equalsIgnoreCase("orther")) {
                String MaNguonHangMoi = request.getParameter("maNHM");
                TenCuaHang = raw_TenCuaHang;
                DiaChi = raw_DiaChi;
                SDT = raw_SDT;
                n.setMaNguonHang(MaNguonHangMoi);
                n.setTenCuaHang(TenCuaHang);
                n.setDiaChi(DiaChi);
                n.setSDT(SDT);
                NguonHangDBContext NguonDB = new NguonHangDBContext();
                NguonDB.insertNguonHang(n);
                
            }
            n.setMaNguonHang(MaNH);
            

            // set product to insert
            ProductForAdmin p = new ProductForAdmin();
            p.setMasp(masp);
            p.setTensp(tensp);
            p.setDVT(DVT);
            p.setNgaySX(NgaySX);
            p.setHanSD(HanSD);
            p.setSoLuong(SoLuong);
            p.setGiaNhap(GiaNhap);
            p.setGiaBan(GiaBan);
            p.setKeHang(KeHang);
            p.setLoaiSp(d);
            p.setNguon(n);

            db.insertProduct(p);

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
