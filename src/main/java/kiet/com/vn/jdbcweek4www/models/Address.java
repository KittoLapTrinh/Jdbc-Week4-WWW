package kiet.com.vn.jdbcweek4www.models;

import jakarta.persistence.*;
import kiet.com.vn.jdbcweek4www.enums.Country;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @Column(name = "address_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "address_street", nullable = false)
    private String Street;
    @Column(name=  "address_city")
    private String city;

    @Column(name =  "address_country")
    private Country country;
    @Column(name=  "address_number")
    private String number;
    @Column(name=  "address_zip_code")
    private String zipcode;

    public Address() {

    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", Street='" + Street + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", number='" + number + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Address(long id, String street, String city, Country country, String number, String zipcode) {
        this.id = id;
        Street = street;
        this.city = city;
        this.country = country;
        this.number = number;
        this.zipcode = zipcode;
    }
}
