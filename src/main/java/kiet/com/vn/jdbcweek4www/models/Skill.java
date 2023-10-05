package kiet.com.vn.jdbcweek4www.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.labweek05www.enums.SkillType;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @Column(name= "skill_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "skill_description", nullable = false)
    private String skillDescription;
    @Column(name= "skill_name", nullable = false)
    private String skillName;
    @Column(name = "type")
    private SkillType type;

    public Skill(long id, String skillDescription, String skillName, SkillType type) {
        this.id = id;
        this.skillDescription = skillDescription;
        this.skillName = skillName;
        this.type = type;
    }

    public Skill() {
    }
}
