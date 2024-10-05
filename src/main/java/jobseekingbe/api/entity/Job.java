
package jobseekingbe.api.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
