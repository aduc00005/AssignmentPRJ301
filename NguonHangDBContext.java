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
import model.NguonHang;

/**
 *
 * @author Admin
 */
public class NguonHangDBContext extends DBContext{
    public ArrayList<NguonHang> getNguon(){
        ArrayList<NguonHang> nguon = new ArrayList<>();
        try {
            String sql = "SELECT MaNguonHang,TenCuaHang,DiaChi,NSDT FROM NguonHang";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                NguonHang n = new NguonHang();
                n.setMaNguonHang(rs.getString("MaNguonHang"));
                n.setTenCuaHang(rs.getString("TenCuaHang"));
                n.setDiaChi(rs.getString("DiaChi"));
                n.setSDT(rs.getString("NSDT"));
                nguon.add(n);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NguonHangDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nguon;
    }
    public NguonHang getNguonByID(String MaNguonHang){
        NguonHang n = new NguonHang();
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
            Logger.getLogger(NguonHangDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void insertNguonHang(NguonHang n)
    {
        String sql ="INSERT INTO [NguonHang]\n" +
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
            Logger.getLogger(NguonHangDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NguonHangDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NguonHangDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void UpdateNguon(NguonHang n){
        String sql = "UPDATE [NguonHang]\n" +
                    "   SET " +
                    "      [TenCuaHang] = ?\n" +
                    "      ,[DiaChi] = ?\n" +
                    "      ,[NSDT] = ?\n" +
                    " WHERE MaNguonHang=?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, n.getTenCuaHang());
            stm.setString(2, n.getDiaChi());
            stm.setString(3, n.getSDT());
            stm.setString(4, n.getMaNguonHang());
            stm.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void deleteSource(String id) {
        String sql = "DELETE FROM [NguonHang] \n" +
                        "      WHERE MaNguonHang = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(NguonHangDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NguonHangDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NguonHangDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public boolean CheckDupMaNguon(String MaNH){
        ArrayList<NguonHang> nguon = getNguon();
        for (NguonHang n : nguon) {
            if (n.getMaNguonHang().equalsIgnoreCase(MaNH)) {
                return true;
            }
        }
        return false;
    }
}
