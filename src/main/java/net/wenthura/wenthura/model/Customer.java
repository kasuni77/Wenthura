package net.wenthura.wenthura.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "customer") //create a table

public class Customer {
    private long id;
    private String Cname;
    private String Cemail;
    private String Cnic;
    private String Cphone;
    private String Caddress;
    private String Cpassword;

    public Customer(long id, String cname, String cemail, String cnic, String cphone, String caddress, String cpassword) {
        this.id = id;
        Cname = cname;
        Cemail = cemail;
        Cnic = cnic;
        Cphone = cphone;
        Caddress = caddress;
        Cpassword = cpassword;
    }

    public Customer() {

    }

    @Id
    @Column(name = "c_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "c_name", nullable = false)
    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }
    @Column(name = "c_email", nullable = false)
    public String getCemail() {
        return Cemail;
    }

    public void setCemail(String cemail) {
        Cemail = cemail;
    }
    @Column(name = "c_nic", nullable = false)
    public String getCnic() {
        return Cnic;
    }

    public void setCnic(String cnic) {
        Cnic = cnic;
    }
    @Column(name = "c_phone", nullable = false)
    public String getCphone() {
        return Cphone;
    }

    public void setCphone(String cphone) {
        Cphone = cphone;
    }
    @Column(name = "c_address", nullable = false)
    public String getCaddress() {
        return Caddress;
    }

    public void setCaddress(String caddress) {
        Caddress = caddress;
    }
    @Column(name = "c_password", nullable = false)
    public String getCpassword() {
        return Cpassword;
    }

    public void setCpassword(String cpassword) {
        Cpassword = cpassword;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", Cname='" + Cname + '\'' +
                ", Cemail='" + Cemail + '\'' +
                ", Cnic='" + Cnic + '\'' +
                ", Cphone='" + Cphone + '\'' +
                ", Caddress='" + Caddress + '\'' +
                ", Cpassword='" + Cpassword + '\'' +
                '}';
    }
}




