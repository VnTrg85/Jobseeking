package jobseekingbe.api.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Getter
    @Setter
    private String Desc;

    @Getter
    @Setter
    private String Website;
    
    @Getter
    @Setter
    private String Location;
    
    @Getter
    @Setter
    private String Logo;
    
    @Getter
    @Setter
    private int CompanySize;
    
    @Getter
    @Setter
    private String[] Industry;
    
    @OneToOne
    @JoinColumn(name ="UserId")
    private User userCompany;
    
    @OneToMany(mappedBy = "company")
    private List<Job> jobs = new ArrayList<Job>();
}
