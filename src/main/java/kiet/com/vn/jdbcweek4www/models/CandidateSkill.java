package kiet.com.vn.jdbcweek4www.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.labweek05www.enums.SkillLevel;
import vn.edu.iuh.fit.labweek05www.models.Skill;

@Entity
@Table(name = "candidate_skill")
public class CandidateSkill {
    @Column(name=  "more_infos", nullable = false)
    private String moreInfo;
    @Column(name = "skill_level")
    private SkillLevel skillLevel;

    @Id
    @ManyToOne
    @JoinColumn(name = "skill", referencedColumnName = "skill_id")
    private Skill skill;

    @Id
    @ManyToOne
    @JoinColumn(name= "candidate", referencedColumnName = " can_id")
    private Candidate candidate;

    public CandidateSkill() {
    }

    public CandidateSkill(String moreInfo, SkillLevel skillLevel, Skill skill, Candidate candidate) {
        this.moreInfo = moreInfo;
        this.skillLevel = skillLevel;
        this.skill = skill;
        this.candidate = candidate;
    }
}
