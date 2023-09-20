package bean;

import dao.KullaniciDao;
import entity.Kullanici;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author HUSAM
 */
@Named
@SessionScoped
public class SessionBean implements Serializable {

    private String email;
    private String pass;
    private Kullanici user;
    private KullaniciDao udao;

    public SessionBean() {
    }

    public String login() {
 this.user = this.getUdao().getUser(this.email, this.pass);
        if (this.user != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", this.user);
            return "/panel/panel?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage("EMail veya şifre hatalı", new FacesMessage("EMail veya şifre hatalı"));
            return "/index?faces-redirect=true";
        }
    }

   

    public Kullanici getUser() {
        if (this.user == null) {
            this.user = new Kullanici();
        }
        return user;
    }

    public void setUser(Kullanici user) {
        this.user = user;
    }

    public KullaniciDao getUdao() {
        if (this.udao == null) {
            this.udao = new KullaniciDao();
        }
        return udao;
    }

    public void setUdao(KullaniciDao udao) {
        this.udao = udao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
