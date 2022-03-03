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
import model.source;

/**
 *
 * @author Admin
 */
public class SourceDBContext extends DBContext{
    public ArrayList<source> getNguon(){
        ArrayList<source> nguon = new ArrayList<>();
        try {
            String sql = "SELECT MaNguonHang,TenCuaHang,DiaChi,NSDT FROM NguonHang";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                source n = new source();
                n.setMaNguonHang(rs.getString("MaNguonHang"));
                n.setTenCuaHang(rs.getString("TenCuaHang"));
                n.setDiaChi(rs.getString("DiaChi"));
                n.setSDT(rs.getString("NSDT"));
                nguon.add(n);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SourceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nguon;
    }
    public source getNguonByID(String MaNguonHang){
        source n = new source();
        try {
            String sql = "SELECT MaNguonHang,TenCuaHang,DiaChi,NSDT FROM NguonHang\n"
                        + "WHERE MaNguonHang = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, MaNguonHang);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                n.setMaNguonHang(rs.getString("MaNguonHang"));
                n.setTenCuaHang(rs.getString("TenCuaHang"));
                n.setDiaChi(rs.getString("DiaChi"));
                n.setSDT(rs.getString("NSDT"));
                return n;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SourceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void insertNguonHang(source n)
    {
        String sql ="INSERT INTO [dbo].[NguonHang]\n" +
                    "           ([MaNguonHang]\n" +
                    "           ,[TenCuaHang]\n" +
                    "           ,[DiaChi]\n" +
                    "           ,[NSDT])\n" +
                    "VALUES\n" +
                    "           (?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, n.getMaNguonHang());
            stm.setString(2, n.getTenCuaHang());
            stm.setString(3, n.getDiaChi());
            stm.setString(4, n.getSDT());
            stm.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(SourceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SourceDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SourceDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void UpdateNguon(String maNguonHang){
        
    }
}
