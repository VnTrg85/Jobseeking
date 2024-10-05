package jobseekingbe.api.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long Id;

    @Getter
    @Setter
    // 4 status : applied , saved , rejected , accepted
    private String Name;


    @JsonIgnore
    @OneToMany(mappedBy = "jobStatus")
    private List<UserJobApplied> jobs = new ArrayList<UserJobApplied>();
}