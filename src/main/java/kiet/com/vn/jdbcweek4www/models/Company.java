package kiet.com.vn.jdbcweek4www.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "company")
public class Company implements Serializable {
    @Id
    @Column(name = "comp_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "about")
    private String about;
    @Column(name = "email")
    private String email;
    @Column(name = "comp_name", nullable = false)
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name= "web_url")
    private String webURL;

    @OneToMany(mappedBy = "address")
    private List<Address> listAddress;

    public Company(UUID id, String about, String email, String name, String phone, String webUrl, ArrayList<Address> listAddress) {
    }


    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", about='" + about + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", webURL='" + webURL + '\'' +
                ", listAddress=" + listAddress +
                '}';
    }

    public Company() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    public List<Address> getListAddress() {
        return listAddress;
    }

    public void setListAddress(List<Address> listAddress) {
        this.listAddress = listAddress;
    }

    public Company(long id, String about, String email, String name, String phone, String webURL, List<Address> listAddress) {
        this.id = id;
        this.about = about;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.webURL = webURL;
        this.listAddress = listAddress;
    }
}
