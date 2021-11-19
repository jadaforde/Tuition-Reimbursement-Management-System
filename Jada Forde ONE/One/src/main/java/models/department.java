package models;


import javax.persistence.*;

@Entity
@Table(name="department", schema = "public")
public class department {
    @Id
    @Column(name = "d_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int d_id;

    @Column(name="d_name")
    private String d_name;

    @ManyToOne
    @JoinTable(name="dh", joinColumns = @JoinColumn(name="d_id"),
            inverseJoinColumns = @JoinColumn(name="lead_id"))
    private employee lead;

    public department() {
    }

    public department(int d_id, String d_name) {
        this.d_id = d_id;
        this.d_name = d_name;
        this.lead = lead;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public employee getLead() {
        return lead;
    }

    public void setLead(employee lead) {
        this.lead = lead;
    }

    public String toString() {
        return "department{" +
                "d_id=" + d_id +
                ", d_name='" + d_name + '\'' +
                ", lead=" + lead +
                '}';
    }
}
