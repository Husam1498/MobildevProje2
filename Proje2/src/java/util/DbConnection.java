

package util;
import java.sql.Connection;
import java.sql.DriverManager;



public abstract class DbConnection {
    private Connection connect;

    public Connection getConnect() {
        if(this.connect==null){
            try{
                Class.forName("org.postgresql.Driver");
                this.connect=DriverManager.getConnection("jdbc:postgresql://localhost:5432/benimkulanicim","postgres","149847");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        return connect;
    }
    
}
