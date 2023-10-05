package kiet.com.vn.jdbcweek4www.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.labweek05www.enums.SkillLevel;

@Entity
@Table(name = "jobSkill")
public class JobSkill {

    @Column(name = "more_infos", nullable = false)
    private String moreInfo;
    @Column(name = "skill_level")
    private SkillLevel skillLevel;

    @Id
    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "job")
    private Job job;

    @Id
    @ManyToOne
    @JoinColumn(name=  "skill_id", referencedColumnName = "skill")
    private Skill skill;

    public JobSkill(String moreInfo, SkillLevel skillLevel, Job job, Skill skill) {
        this.moreInfo = moreInfo;
        this.skillLevel = skillLevel;
        this.job = job;
        this.skill = skill;
    }

    public JobSkill() {
    }
}
