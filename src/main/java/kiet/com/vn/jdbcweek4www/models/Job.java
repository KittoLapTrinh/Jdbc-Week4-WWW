package kiet.com.vn.jdbcweek4www.models;

import jakarta.persistence.*;

import java.io.Serializable;
import vn.edu.iuh.fit.labweek05www.models.Company;

@Entity
@Table(name= "job")
public class Job implements Serializable {
    @Id
    @Column(name = "job_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "job_desc", nullable = false)
    private String description;
    @Column(name = "job_name", nullable = false)
    private String name;

    @ManyToOne
    @Column(name = "company_id", columnDefinition = "company")
    private Company company;

    public Job(long id, String description, String name, Company company) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.company = company;
    }

    public Job() {
    }
}
