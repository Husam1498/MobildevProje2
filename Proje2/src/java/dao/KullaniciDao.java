package dao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Kullanici;
import util.DbConnection;
public class KullaniciDao extends DbConnection{
    
    public Kullanici getUser(String email, String pass) {
        Kullanici user = null;
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanıcı where email='" + email + "' and sifre='" + pass + "'");

            rs.next();
            
            user = new Kullanici(rs.getLong("id"), rs.getString("isimsoyisim"), rs.getString("telno"), rs.getString("email"),rs.getString("sifre") ,rs.getDate("created"), rs.getDate("updated"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
    public List<Kullanici> readList() {
        List<Kullanici> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanıcı");
            while(rs.next()){
                list.add(new Kullanici(rs.getLong("id"), rs.getString("isimsoyisim"), rs.getString("telno"), rs.getString("email"),rs.getString("sifre") ,rs.getDate("created"), rs.getDate("updated")));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public void create(Kullanici k) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into kullanıcı(isimsoyisim,telno,email,sifre) values ('" + k.getIsimsoyisim()+"','"+k.getTelno()+"','"+k.getEmail()+ "','"+k.getSifre()+"')") ;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(Kullanici k) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update kullanıcı set  isimsoyisim='" + k.getIsimsoyisim()+"', telno='"+k.getTelno()+"',email='"+k.getEmail()+ "',sifre='"+k.getSifre()+"'");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
       public void delete(Kullanici k) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from kullanıcı where id="+k.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
