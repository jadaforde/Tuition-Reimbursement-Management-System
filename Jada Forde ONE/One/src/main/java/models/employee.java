package models;

import javax.persistence.*;

@Entity
@Table( name= "employee", schema = "public")
public class employee {
    @Id
    @Column(name = "e_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int e_id;

    @Column(name= "username")
    private String username;

    @Column(name= "password")
    private String password;

    @Column(name = "benCo")
    private Boolean benCo;

    @Column(name = "name")
    private String name;


    @Column(name="super_id")
    private Integer super_id;


    @Column(name="d_id")
    private int d_id;


    public employee() {
    }

    public employee(int e_id, String username, String password, Boolean benCo, String name, int super_id, int d_id) {
        this.e_id = e_id;
        this.username = username;
        this.password = password;
        this.benCo = benCo;
        this.name = name;
        this.super_id = super_id;
        this.d_id = d_id;

    }


    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getBenCo() {
        return benCo;
    }

    public void setBenCo(Boolean benCo) {
        this.benCo = benCo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSuper_id() {
        return super_id;
    }

    public void setSuper_id(int super_Id) {
        this.super_id = super_id;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }


    @Override

    public String toString() {
        return "employee{" +
                "e_id=" + e_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", benCo=" + benCo +
                ", name='" + name + '\'' +
                ", super_id=" + super_id +
                ", d_id=" + d_id +
                  '}';
    }
}


