/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author Admin
 */
public class ProductDBContext extends DBContext{
    public ArrayList<Product> GetProducts(int pageindex, int pagesize){
        ArrayList<Product> pros = new ArrayList<>();
        try {
            String sql ="select MaSP,TenSP,DVT,NgaySX,HanSD,SoLuong,GiaBan,KeHang from \n" +
                "(select MaSP,TenSP,DVT,NgaySX,HanSD,SoLuong,GiaBan,KeHang,ROW_NUMBER()"
                    + " over (order by masp asc) as row_index FROM SanPham) tb\n" +
                "WHERE row_index >= (?-1)*? and row_index <= ?*?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Product p = new Product();
                p.setMasp(rs.getInt("masp"));
                p.setTensp(rs.getString("tensp"));
                p.setDVT(rs.getString("DVT"));
                p.setNgaySX(rs.getDate("NgaySX"));
                p.setHanSD(rs.getDate("HanSD"));
                p.setSoLuong(rs.getInt("SoLuong"));
                p.setGiaBan(rs.getInt("GiaBan"));
                p.setKeHang(rs.getInt("KeHang"));
                pros.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pros;
    }
    public int count()
    {
        try {
            String sql = "SELECT COUNT(*) as Total FROM SanPham";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
