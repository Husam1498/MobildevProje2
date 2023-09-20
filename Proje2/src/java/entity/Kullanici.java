package entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author HUSAM
 */
public class Kullanici implements Serializable {

    private Long id;
    private String isimsoyisim;
    private String telno;
    private String email;
    private String sifre;
    private Date created;
    private Date updated;

    public Kullanici() {
    }

    public Kullanici(Long id, String isimsoyisim, String telno, String email, String sifre, Date created, Date updated) {
        this.id = id;
        this.isimsoyisim = isimsoyisim;
        this.telno = telno;
        this.email = email;
        this.sifre = sifre;
        this.created = created;
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsimsoyisim() {
        return isimsoyisim;
    }

    public void setIsimsoyisim(String isimsoyisim) {
        this.isimsoyisim = isimsoyisim;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    
}
