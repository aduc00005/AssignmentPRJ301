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
import java.util.regex.Pattern;
import model.Account;
import model.DanhMuc;

/**
 *
 * @author Admin
 */
public class AccountDBContext extends DBContext{
    public Account getAccount(String username,String password){
        try {
            String sql = "SELECT username,password,firstName,lastName,email  FROM Account \n" +
                        "	WHERE username = ? AND password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1,username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                Account account = new Account();
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setFirstName(rs.getString("firstName"));
                account.setLastName(rs.getString("lastName"));
                account.setEmail(rs.getString("email"));
                return account;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int checkRole(String username, String url)
    {
        try {
            String sql = "SELECT COUNT(*) as Total \n" +
"                	FROM Account a INNER JOIN [Account Group] ag ON a.username = ag.username\n" +
"                					INNER JOIN [Group] g ON ag.gid = g.gid\n" +
"                					INNER JOIN [Group Feature] gf ON gf.gid = g.gid\n" +
"                					INNER JOIN Feature f ON f.fid = gf.fid\n" +
"                	WHERE a.username = ? AND f.url = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1,username);
            stm.setString(2, url);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                return rs.getInt("Total");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public String getPasswordByEmail(String email){
        try {
            String sql = "SELECT password FROM [Account] where email = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1,email);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                String password = rs.getString("password");
                return password;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Account> getAccount(){
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            String sql = "SELECT username,password,firstName,lastName,email  FROM Account";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Account account = new Account();
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setFirstName(rs.getString("firstName"));
                account.setLastName(rs.getString("lastName"));
                account.setEmail(rs.getString("email"));
                accounts.add(account);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accounts;
    }

    public boolean CheckEmail(String raw_email) {
        String emailPattern = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        if (!Pattern.matches(emailPattern, raw_email)) {
            return false;
        }
        if (raw_email==null|| raw_email.length()==0) {
            return false;
        }
        ArrayList<Account> accounts = getAccount();
        for (Account a : accounts) {
            if (a.getEmail().equalsIgnoreCase(raw_email)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkUsername(String raw_username) {
        if (raw_username==null||raw_username.length()==0) {
            return false;
        }
        ArrayList<Account> accounts = getAccount();
        for (Account a : accounts) {
            if (a.getUsername().equalsIgnoreCase(raw_username)) {
                return false;
            }
        }
        return true;
    }
    public void insertAccount(Account a){
        String sql ="INSERT INTO [Account]\n" +
                    "           ([username]\n" +
                    "           ,[password]\n" +
                    "           ,[firstName]\n" +
                    "           ,[lastName]\n" +
                    "           ,[email])\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, a.getUsername());
            stm.setString(2, a.getPassword());
            stm.setString(3, a.getFirstName());
            stm.setString(4, a.getLastName());
            stm.setString(5, a.getEmail());
            stm.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
}
