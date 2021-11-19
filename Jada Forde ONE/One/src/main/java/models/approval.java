package models;

import javax.persistence.*;

@Entity
@Table(name= "approval", schema = "public")
public class approval {

    @Id
    @Column(name="app_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int app_id;

    @Column(name="BenCo")
    private boolean BenCo;

    @Column(name="superV")
    private boolean superV;

    @Column(name="departH")
    private boolean departH;


    public approval() {
    }

    public approval(int app_id, boolean benCo, boolean superV, boolean departH) {
        this.app_id = app_id;
        BenCo = benCo;
        this.superV = superV;
        this.departH = departH;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public boolean isBenCo() {
        return BenCo;
    }

    public void setBenCo(boolean benCo) {
        BenCo = benCo;
    }

    public boolean isSuperV() {
        return superV;
    }

    public void setSuperV(boolean superV) {
        this.superV = superV;
    }

    public boolean isDepartH() {
        return departH;
    }

    public void setDepartH(boolean departH) {
        this.departH = departH;
    }

    @Override
    public String toString() {
        return "approval{" +
                "app_id=" + app_id +
                ", BenCo=" + BenCo +
                ", superV=" + superV +
                ", departH=" + departH +
                ", testing"+
                '}';
    }
}
