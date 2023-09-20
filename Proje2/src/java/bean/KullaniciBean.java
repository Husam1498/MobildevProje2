package bean;

import dao.KullaniciDao;
import entity.Kullanici;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped

public class KullaniciBean implements Serializable {

    private Kullanici entity;
    private KullaniciDao dao;
    private List<Kullanici> list;

    public void clearForm(){
        this.entity=new Kullanici();
    }
    public void create(){
        this.getDao().create(entity);
        this.entity=new Kullanici();//içini boşaltık
    }
    public void update(){
        this.getDao().update(entity);
        this.entity=new Kullanici();//içini boşaltık
    }
    public void delete(){
        this.getDao().delete(entity);
        this.entity=new Kullanici();//içini boşaltık
    }
    public Kullanici getEntity() {
        if (this.entity == null) {
            this.entity = new Kullanici();
        }
        return entity;
    }

    public void setEntity(Kullanici entity) {
        this.entity = entity;
    }

    public KullaniciDao getDao() {
        if (this.dao == null) {
            this.dao = new KullaniciDao();
        }
        return dao;
    }

    public void setDao(KullaniciDao dao) {
        this.dao = dao;
    }

    public List<Kullanici> getList() {
        this.list = this.getDao().readList();
        return list;
    }

    public void setList(List<Kullanici> list) {
        this.list = list;
    }

}
