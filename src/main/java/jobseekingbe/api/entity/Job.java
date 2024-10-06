package jobseekingbe.api.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Getter
    @Setter
    private String Title;
    
    @Getter
    @Setter
    @Lob
    @Column(name = "description", length = 2000000000)
    private String Description;
    
    @Getter
    @Setter
    private String Salary;
    
    @Getter
    @Setter
    private String Location;
    
    @Getter
    @Setter
    private Date dateCreated;


    @Getter
    @Setter
    private String[] SkillFields;

    @Getter
    @Setter
    private String status;
    @ManyToOne
    @JoinColumn(name = "JobTypeId")
    private JobType jobType;
    
    @ManyToOne
    @JoinColumn(name = "CompanyId")
    private Company company;


    @OneToMany
    @JoinColumn(name = "userJobAppliedId")
    private List<UserJobApplied> userJobApplied = new ArrayList<>();

}
