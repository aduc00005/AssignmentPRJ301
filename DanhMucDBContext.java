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
import model.DanhMuc;
import model.NguonHang;

/**
 *
 * @author Admin
 */
public class DanhMucDBContext extends DBContext{

    public ArrayList<DanhMuc> getLoaiSP(){
        ArrayList<DanhMuc> LoaiSP = new ArrayList<>();
        try {
            String sql = "SELECT MaLoaiSP,LoaiSP FROM DanhMuc";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                DanhMuc d = new DanhMuc();
                d.setMaLoaiSP(rs.getString("MaLoaiSP"));
                d.setLoaiSP(rs.getString("LoaiSP"));
                LoaiSP.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return LoaiSP;
    }
    public void insertDanhMucSP(DanhMuc d)
    {
        String sql ="INSERT INTO [DanhMuc]\n" +
                    "           ([MaLoaiSP]\n" +
                    "           ,[LoaiSP])\n" +
                    "VALUES\n" +
                    "           (?\n" +
                    "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, d.getMaLoaiSP());
            stm.setString(2, d.getLoaiSP());
            stm.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DanhMucDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DanhMucDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }

    public boolean checkDupMaLoaiSP(String raw_MaLoaiSp) {
        ArrayList<DanhMuc> list = getLoaiSP();
        for (DanhMuc d : list) {
            if (d.getMaLoaiSP().equalsIgnoreCase(raw_MaLoaiSp)) {
                return true;
            }
        }
        return false;
    }

    public DanhMuc getLoaiSPByID(String MaLoaiSP) {
        
        try {
            String sql = "SELECT MaLoaiSP,LoaiSP FROM DanhMuc Where MaLoaiSP=?";
            
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, MaLoaiSP);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                DanhMuc d = new DanhMuc();
                d.setMaLoaiSP(MaLoaiSP);
                d.setLoaiSP(rs.getString("LoaiSP"));
                return d;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void UpdateDanhMuc(DanhMuc l) {
        String sql = "UPDATE [DanhMuc]\n" +
                        "   SET [LoaiSP] = ?\n" +
                        " WHERE MaLoaiSP =?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, l.getLoaiSP());
            stm.setString(2, l.getMaLoaiSP());
            stm.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DanhMucDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DanhMucDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void deleteLoaiSP(String MaLoaiSP) {
        String sql = "DELETE FROM [DanhMuc]\n" +
                    "      WHERE MaLoaiSP=?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, MaLoaiSP);
            stm.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DanhMucDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DanhMucDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
