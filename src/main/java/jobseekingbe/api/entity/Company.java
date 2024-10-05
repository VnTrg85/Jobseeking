package jobseekingbe.api.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
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
    private Long id;

    @Getter
    @Setter
    @Column(name = "decription", length = 200000000)
    private String description;

    @Getter
    @Setter
    private String website;
    
    @Getter
    @Setter
    private String location;
    
    @Getter
    @Setter
    private String logo;
    
    @Getter
    @Setter
    private int companySize;
    
    @Getter
    @Setter
    private String[] industry;
    
    @OneToOne
    @JoinColumn(name ="UserId")
    private User userCompany;
    
    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Job> jobs = new ArrayList<Job>();
}
