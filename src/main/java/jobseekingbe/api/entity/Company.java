package jobseekingbe.api.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    private String Description;
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
    private Integer CompanySize;
    
    @Getter
    @Setter
    private String[] Industry;
    
    @OneToOne
    @JoinColumn(name ="UserId")
    private User userCompany;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private Collection<Job> jobs;
}
