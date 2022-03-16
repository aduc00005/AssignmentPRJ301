/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DanhMuc;
import model.NguonHang;
import model.Product;
import model.ProductForAdmin;
import org.jboss.classfilewriter.code.Opcode;

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
    public ArrayList<Product> getProductByDanhMuc(String LoaiSP){
        ArrayList<Product> pros = new ArrayList<>();
        try {
            String sql ="SELECT MaSP,TenSP,DVT,NgaySX,HanSD,SoLuong,GiaBan,KeHang,NgayNhap \n" +
                    "FROM DanhMuc as d inner join SanPham as s on d.MaLoaiSP=s.MaLoaiSP\n" ;
            if (!LoaiSP.equalsIgnoreCase("all")) {
                sql += "WHERE d.MaLoaiSP= ?";
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            if (!LoaiSP.equalsIgnoreCase("all")) {
                stm.setString(1, LoaiSP);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Product p = new Product();
                p.setMasp(rs.getInt("MaSP"));
                p.setTensp(rs.getString("TenSP"));
                p.setDVT(rs.getString("DVT"));
                p.setNgaySX(rs.getDate("NgaySX"));
                p.setHanSD(rs.getDate("HanSD"));
                p.setSoLuong(rs.getInt("SoLuong"));
                p.setGiaBan(rs.getInt("GiaBan"));
                p.setKeHang(rs.getInt("KeHang"));
                p.setNgayNhapKho(rs.getDate("NgayNhap"));
                pros.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pros;
    }
    
    public ArrayList<Product> getSanPham(){
        ArrayList<Product> pros = new ArrayList<>();
        try {
            String sql ="SELECT MaSP,TenSP,DVT,NgaySX,HanSD,SoLuong,GiaBan,KeHang,NgayNhap \n" +
                    "FROM DanhMuc as d inner join SanPham as s on d.MaLoaiSP=s.MaLoaiSP\n" ;
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Product p = new Product();
                p.setMasp(rs.getInt("MaSP"));
                p.setTensp(rs.getString("TenSP"));
                p.setDVT(rs.getString("DVT"));
                p.setNgaySX(rs.getDate("NgaySX"));
                p.setHanSD(rs.getDate("HanSD"));
                p.setSoLuong(rs.getInt("SoLuong"));
                p.setGiaBan(rs.getInt("GiaBan"));
                p.setKeHang(rs.getInt("KeHang"));
                p.setNgayNhapKho(rs.getDate("NgayNhap"));
                pros.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pros;
    }
    
    public ArrayList<Product> getSanPhamHaveMaxQuantity(){
        ArrayList<Product> pros = new ArrayList<>();
        try {
            String sql ="SELECT MaSP,TenSP,DVT,SoLuong,NgaySX,HanSD,KeHang,GiaBan,NgayNhap FROM SanPham\n" +
                        "	where SoLuong >= all (select SoLuong from SanPham)" ;
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Product p = new Product();
                p.setMasp(rs.getInt("MaSP"));
                p.setTensp(rs.getString("TenSP"));
                p.setDVT(rs.getString("DVT"));
                p.setNgaySX(rs.getDate("NgaySX"));
                p.setHanSD(rs.getDate("HanSD"));
                p.setSoLuong(rs.getInt("SoLuong"));
                p.setGiaBan(rs.getInt("GiaBan"));
                p.setKeHang(rs.getInt("KeHang"));
                p.setNgayNhapKho(rs.getDate("NgayNhap"));
                pros.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pros;
    }
    
    public ArrayList<Product> getSanPhamHaveLowQuantity(){
        ArrayList<Product> pros = new ArrayList<>();
        try {
            String sql ="SELECT MaSP,TenSP,DVT,SoLuong,NgaySX,HanSD,KeHang,GiaBan,NgayNhap FROM SanPham\n" +
                        "	where SoLuong <= 10" ;
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Product p = new Product();
                p.setMasp(rs.getInt("MaSP"));
                p.setTensp(rs.getString("TenSP"));
                p.setDVT(rs.getString("DVT"));
                p.setNgaySX(rs.getDate("NgaySX"));
                p.setHanSD(rs.getDate("HanSD"));
                p.setSoLuong(rs.getInt("SoLuong"));
                p.setGiaBan(rs.getInt("GiaBan"));
                p.setKeHang(rs.getInt("KeHang"));
                p.setNgayNhapKho(rs.getDate("NgayNhap"));
                pros.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pros;
    }
    public ArrayList<Product> getSanPhamHHSD(){
        ArrayList<Product> pros = new ArrayList<>();
        try {
            String sql ="SELECT MaSP,TenSP,DVT,SoLuong,NgaySX,HanSD,KeHang,GiaBan,NgayNhap FROM SanPham\n" +
                        "where HanSD < GETDATE()";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Product p = new Product();
                p.setMasp(rs.getInt("MaSP"));
                p.setTensp(rs.getString("TenSP"));
                p.setDVT(rs.getString("DVT"));
                p.setNgaySX(rs.getDate("NgaySX"));
                p.setHanSD(rs.getDate("HanSD"));
                p.setSoLuong(rs.getInt("SoLuong"));
                p.setGiaBan(rs.getInt("GiaBan"));
                p.setKeHang(rs.getInt("KeHang"));
                p.setNgayNhapKho(rs.getDate("NgayNhap"));
                pros.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pros;
    }
    
    public ArrayList<Product> getSanPhamTKLN(){
        ArrayList<Product> pros = new ArrayList<>();
        try {
            String sql ="SELECT MaSP,TenSP,DVT,SoLuong,NgaySX,HanSD,KeHang,GiaBan,NgayNhap FROM SanPham\n" +
                        "where NgayNhap <= (select MIN(NgayNhap) from SanPham)";    
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Product p = new Product();
                p.setMasp(rs.getInt("MaSP"));
                p.setTensp(rs.getString("TenSP"));
                p.setDVT(rs.getString("DVT"));
                p.setNgaySX(rs.getDate("NgaySX"));
                p.setHanSD(rs.getDate("HanSD"));
                p.setSoLuong(rs.getInt("SoLuong"));
                p.setGiaBan(rs.getInt("GiaBan"));
                p.setKeHang(rs.getInt("KeHang"));
                p.setNgayNhapKho(rs.getDate("NgayNhap"));
                pros.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pros;
    }
    
    public ProductForAdmin getProductByID(int masp){
        try {
            String sql ="SELECT MaSP,TenSP,DVT,NgaySX,HanSD,SoLuong,GiaBan,GiaNhap,KeHang,NgayNhap,n.MaNguonHang,n.TenCuaHang,n.DiaChi,n.NSDT,d.MaLoaiSP,d.LoaiSP \n" +
                            "FROM SanPham as s inner join DanhMuc as d on s.MaLoaiSP=d.MaLoaiSP\n" +
                            "join NguonHang as n on s.MaNguonHang=n.MaNguonHang\n" +
                        "	WHERE MaSP= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, masp);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {                
                ProductForAdmin p = new ProductForAdmin();
                p.setMasp(rs.getInt("MaSP"));
                p.setTensp(rs.getString("TenSP"));
                p.setDVT(rs.getString("DVT"));
                p.setNgaySX(rs.getDate("NgaySX"));
                p.setHanSD(rs.getDate("HanSD"));
                p.setSoLuong(rs.getInt("SoLuong"));
                p.setGiaNhap(rs.getInt("GiaNhap"));
                p.setGiaBan(rs.getInt("GiaBan"));
                p.setKeHang(rs.getInt("KeHang"));
                p.setNgayNhapKho(rs.getDate("NgayNhap"));
                NguonHang n = new NguonHang();
                n.setMaNguonHang(rs.getString("MaNguonHang"));
                n.setTenCuaHang(rs.getString("TenCuaHang"));
                n.setDiaChi(rs.getString("DiaChi"));
                n.setSDT(rs.getString("NSDT"));
                p.setNguon(n);
                DanhMuc d = new DanhMuc();
                d.setMaLoaiSP(rs.getString("MaLoaiSP"));
                d.setLoaiSP(rs.getString("LoaiSP"));
                p.setLoaiSp(d);
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //check Dupicate masp
    public boolean checkDupicateMasp(int masp){
        ArrayList<Product> pros = getSanPham();
        boolean check = false;
        for (Product p : pros) {
            if (p.getMasp()==masp) {
                return true;
            }
        }
        return false;
    }
    
    public void insertProduct(ProductForAdmin p)
    {
        String sql = "INSERT INTO [dbo].[SanPham]\n" +
                            "           ([MaSP]\n" +
                            "           ,[TenSP]\n" +
                            "           ,[DVT]\n" +
                            "           ,[NgaySX]\n" +
                            "           ,[HanSD]\n" +
                            "           ,[SoLuong]\n" +
                            "           ,[GiaNhap]\n" +
                            "           ,[GiaBan]\n" +
                            "           ,[KeHang]\n" +
                            "           ,[MaNguonHang]\n" +
                            "           ,[MaLoaiSP]\n"+
                            "           ,[NgayNhap])\n" +
                    " VALUES\n" +
                            "           (?\n" +
                            "           ,?\n" +
                            "           ,?\n" +
                            "           ,?\n" +
                            "           ,?\n" +
                            "           ,?\n" +
                            "           ,?\n" +
                            "           ,?\n" +
                            "           ,?\n" +
                            "           ,?\n" +
                            "           ,?\n" +
                            "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, p.getMasp());
            stm.setString(2, p.getTensp());
            stm.setString(3, p.getDVT());
            stm.setDate(4, p.getNgaySX());
            stm.setDate(5, p.getHanSD());
            stm.setInt(6,p.getSoLuong());
            stm.setInt(7,p.getGiaNhap());
            stm.setInt(8,p.getGiaBan());
            stm.setInt(9,p.getKeHang() );
            stm.setString(10,p.getNguon().getMaNguonHang());
            stm.setString(11, p.getLoaiSp().getMaLoaiSP());
            stm.setDate(12, p.getNgayNhapKho());
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

    public void deleteStudent(int id) {
        String sql = "DELETE FROM [dbo].[SanPham]\n" +
                        "WHERE MaSP=?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
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
    
    public void updateProduct(ProductForAdmin p)
    {
        String sql = "UPDATE [dbo].[SanPham]\n" +
                        "   SET "+
                        "      [TenSP] = ?\n" +
                        "      ,[DVT] = ?\n" +
                        "      ,[NgaySX] = ?\n" +
                        "      ,[HanSD] = ?\n" +
                        "      ,[SoLuong] = ?\n" +
                        "      ,[GiaNhap] = ?\n" +
                        "      ,[GiaBan] = ?\n" +
                        "      ,[KeHang] = ?\n" +
                        "      ,[MaNguonHang] = ?\n" +
                        "      ,[MaLoaiSP] = ?\n" +
                        "      ,[NgayNhap] = ?\n" +
                        " WHERE MaSP= ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, p.getTensp());
            stm.setString(2, p.getDVT());
            stm.setDate(3, p.getNgaySX());
            stm.setDate(4, p.getHanSD());
            stm.setInt(5, p.getSoLuong());
            stm.setInt(6, p.getGiaNhap());
            stm.setInt(7, p.getGiaBan());
            stm.setInt(8, p.getKeHang());
            stm.setString(9, p.getNguon().getMaNguonHang());
            stm.setString(10, p.getLoaiSp().getMaLoaiSP());
            stm.setDate(11, p.getNgayNhapKho());
            stm.setInt(12, p.getMasp());
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


    public boolean checkDate(String raw_NgaySX, String raw_HanSD,String raw_NgayNhap) {
        Date ngaySX=java.sql.Date.valueOf(raw_NgaySX);
        Date HSD = java.sql.Date.valueOf(raw_HanSD);
        Date NgayNhap = java.sql.Date.valueOf(raw_NgayNhap);
        long millis=System.currentTimeMillis();  
        java.sql.Date date = new java.sql.Date(millis);
        if (ngaySX.compareTo(HSD)<0&&HSD.compareTo(date)>=0
                &&NgayNhap.compareTo(date)<=0&&HSD.compareTo(NgayNhap)>=0
                && ngaySX.compareTo(NgayNhap)<=0) {
            return true;
        }else{
            return false;
        }
        
    }

    

}
