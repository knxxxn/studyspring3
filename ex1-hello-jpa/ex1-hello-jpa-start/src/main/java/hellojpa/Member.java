package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Member {
    @GeneratedValue
    @Id
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;

    //@Column(name = "TEAM_ID")
    //private String teamId;

    //private Integer age;
    //@Enumerated(EnumType.STRING)
    //private RoleType roleType;
    //@Temporal(TemporalType.TIMESTAMP)
    //private Date createdDate;
    //@Temporal(TemporalType.TIMESTAMP)
    //private Date lastModifiedDate;
    //@Lob
    //private String description;
    //public Member(){

    //}
    @ManyToOne
    @JoinColumn(name = "Team_ID")
    private Team team;
    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
