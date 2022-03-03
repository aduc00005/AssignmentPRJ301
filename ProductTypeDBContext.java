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
import model.ProductType;
import model.source;

/**
 *
 * @author Admin
 */
public class ProductTypeDBContext extends DBContext{
    public ArrayList<ProductType> getLoaiSP(){
        ArrayList<ProductType> LoaiSP = new ArrayList<>();
        try {
            String sql = "SELECT MaLoaiSP,LoaiSP FROM DanhMuc";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                ProductType d = new ProductType();
                d.setMaLoaiSP(rs.getString("MaLoaiSP"));
                d.setLoaiSP(rs.getString("LoaiSP"));
                LoaiSP.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return LoaiSP;
    }
    public void insertDanhMucSP(ProductType d)
    {
        String sql ="INSERT INTO [dbo].[DanhMuc]\n" +
                    "           ([MaLoaiSP]\n" +
                    "           ,[LoaiSP])\n" +
                    "VALUES\n" +
                    "           (?\n" +
                    "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, d.getMaLoaiSP());
            stm.setString(2, d.getMaLoaiSP());
            stm.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(ProductTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
}
